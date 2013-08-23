/**
 * @author lin.sun
 */

(function($){

	//以下为内置验证方法
	/**
	 * 判断是value是否包含在opt中
	 * @param {Object} value
	 * @param {Object} opt
	 */
	function include(value,opt){
		for(var i=0;i<opt.length;i++){
			if(value==opt[i])					
				return true;
		}
		return false;
	}

	/**
	 * 验证长度是否合适
	 * @param {Object} value
	 * @param {Object} opt
	 */
	function len(value,opt){
		return value.length >= parseInt(opt[0]) && value.length <= parseInt(opt[1]);
	}
	
	/**
	 * 验证长度是否合适,汉字算两个
	 * @param {Object} value
	 * @param {Object} opt
	 */
	function lenb(value,opt){
		var length = value.replace(/[^\x00-\xff]/g,"xx").length;  
		return length >= parseInt(opt[0]) && length <= parseInt(opt[1]);
	}	

	/**
	 * 扩展名验证
	 * @param {Object} value
	 * @param {Object} opt
	 */
	function ext(value,opt){
		for(var i=0;i<opt.length;i++){
			var len = opt[i].length+1;
			if(value.substr(value.length-len,len).toUpperCase()=="."+opt[i].toUpperCase())
				return true;
		}
		return false;
	}

	/**
	 * 验证两上元素的值是否相等
	 * @param opt[1] 被比较元素的ID
	 */
	function equal(value,opt){
		return $("#" + opt[0]).val() == value;
	}
	
	/**
	 * 验证是否等于某个值
	 * @param {Object} value
	 * @param {Object} opt 可值多个值
	 */
	function eq(value,opt){
		for(var i=0;i<opt.length;i++){
			if(value==opt[i])
				return true;
		}
		return false;
	}

	/**
	 * 日期验证
	 * @param {Object} value
	 * @param {Object} opt
	 * opt[0] 日期模式,默认yyyy-mm-dd
	 */
	function _date(value,opt){
		var pattern = (opt[0]||'yyyy-mm-dd').replace(/[\/\?\*\$\^]/ig,function(a){
			return '\\' + a;
		});
		var p = '/^' + pattern.replace(/[ymd]/ig,'\\d') + '$/';
		if(!value.match(eval(p))){
			return false;
		}
		return true;
	}
	
	/**
	 * 验证checkbox勾选的个数
	 * @param opt[0] 最少值
	 * @param opt[1] 最大值
	 */
	function checkbox(value,opt){
		if($(this.E).attr("type")!="checkbox")return false;
		var name = $(this.E).attr("name");
		if(name){
			var rs = $("[name="+ name +"]:checked").length;
			return rs >= parseInt(opt[0]) && rs <= parseInt(opt[1]);
		}else{
			return false;
		}		
	}
	
	/**
	 * 网络唯一性验证
	 * @param opt[0] 提交地址
	 * @param opt[1] 参数名称
	 */
	function unique(value,opt){
		var result = $.ajax({
			ifModified: true,
			url: opt[0],
			type: "get",
			async: false,
			data: opt[1] + "=" + value 
		}).responseText;		
		return result==opt[2];
	}
	
	/**
	 * 前置验证,隐藏
	 */
	function hide(e){
		return !$(e).is(":visible");
	}
	
	/**
	 * 前置验证,可见
	 */
	function show(e){
		return $(e).is(":visible");
	}
	
	/**
	 * 前置验证,有效
	 */
	function enabled(e){
		return $(e).is(":enabled");
	}	
	
	/**
	 * 验证对象
	 * 
	 * 多组验证规则时用括号分隔
	 * 
	 */
 	$.VF = {
		
		//默认规则
		rules : {
			'bt'		:	/\S+/,
			'email'	:	/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
			'phone' 	:	/^[\d|-]{5,23}$/,
			'fax' 	:	/^[\d|-]{5,23}$/,
			'postcode':	/^\d{6}$/,
			'mobile' 	:	/^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/,
			'url' 	:	/^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
			'ipport'	:	/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9]):\d{1,6}$/,
			'ip'		:	/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/,
			'currency':	/^\d+(\.\d+)?$/,
			'number' 	:	/^\d+$/,
			'zip' 	:	/^[1-9]\d{5}$/,
			'qq' 		:	/^[1-9]\d{4,8}$/,
			'int'		:	/^[-\+]?\d+$/,
			'double' 	:	/^[-\+]?\d+(\.\d+)?$/,
			'eng' 	:	/^[A-Za-z]+$/,
			'char'	:	/^[\w]+$/,
			'chn' 	:	/^[\u0391-\uFFE5]+$/,
			'nochn' 	:	/^^[\u0391-\uFFE5]+$/,
			'in'	:	include,
			'len'	:	len,
			'lenb'	:	lenb,			
			'equal'	:	equal,
			'eq'	:	eq,
			'date'	:	_date,
			'ext'	:	ext,
			'unique':	unique,
			'checkbox':	checkbox
		},
		
		//前置验证规则
		prevRules : {
			'hide'	:	hide,
			'show'	:	show,
			'enabled':	enabled
		},

		// 当前验证对象
		E : null,
		
		/**
		 * 执行验证函数
		 * @param {function} fun 参数函数
		 */
		ExecValidFun : function(fun,value,opt){
			this.tempValidFun = fun;
			return this.tempValidFun(value,opt);
		},

		/**
		 * 验证整个表单
		 * @param {form} form
		 * @param {s} 是否安静模式,默认true
		 * @return 成功true 失败false
		 */
 		ValidForm : function(form,s){
 			var r = true;
			var es = [];
 			var eles = $(form).find("[rule]");
			for(var i=0; i<eles.length; i++){
				if(!this.ValidElement(eles[i],arguments.length == 1 ? true : s)){
					r = false;
					es.push({ele:eles[i],bool:false});
				}else{
					es.push({ele:eles[i],bool:true});
				}
			}
			//返回前的扩展处理
			this.ValidFormAfter(es);
			return r;
 		},

		/**
		 * 校验一个表单元素的输入情况
		 * @param {element} e
		 * @param {bool} s 安静模式,验证,但不执行扩展操作
		 * @return 成功true 失败false
		 */
 		ValidElement : function(e,s){
			this.E = e;		//保存当前元素
			if (!this.PrevValid(e, s)) { //前置验证
				var bool = ck = true;
			}else {
				//rrule是经前置验证后处理过的rule
				var rule = $(e).attr("rrule");
				var name = $(e).attr("name");
				if (e.tagName == "INPUT") {
					//input对象
					switch (e.type) {
						case "text":
						case "file":
						case "password":
						case "hidden":
							if(e.value==$(e).attr("lastValue") && $(e).attr("nocache")!="1"){	//读取缓存
								var ck= $(e).attr("lastExp");
							}else{
								var ck = this.Valids(e.value.replace(/(^\s*)|(\s*$)/g, ""), rule);
							}
							break;
						case "checkbox":
							var ck = this.ValidCheckbox(e, rule);
							break;
						case "radio":
							var ck = this.ValidRadio(e, rule);
							break;
					}
				}
				else 
					if (e.tagName == "SELECT" || e.tagName == "TEXTAREA") {
						//select or textarea对象
						var ck = this.Valids(e.value.replace(/(^\s*)|(\s*$)/g, ""), rule);
					}
					else {
						//非表单元对象的验证
						var ck = this.Valids(e, rule);
					}
				bool = eval(ck);
			}
			//将验证结果存入当前元素
			this.BindResult(e,ck);
			//返回前的一些扩展处理
			if(!s)this.ValidEleAfter(e,bool);
			return bool;
		},

		/**
		 * 前置验证
		 * @param {element} e
		 * @param {bool} s 安静模式,验证,但不执行扩展操作
		 * @return 成功true 失败false
		 */
		PrevValid:function(e,s){
			var rule = $(e).attr("rule");
			var name = $(e).attr("name");
			$(e).attr("rrule",rule.replace(/<\w+?>/ig,""));
			if(rs = rule.match(/<\w+?(?=>)/ig)){
				for(var i=0;i<rs.length;i++){
					rs[i] = rs[i].replace("<","");
					if(this.prevRules[rs[i]](e)){
						return true;
					}
				}
				return false;
			}else{
				return true;
			}
		},

		/**
		 * 绑定验证结果到验证元素上
		 * @param ele e 当前元素
		 * @param string ck 验证表达式
		 */		
		BindResult:function(e,ck){
			bool = eval(ck);
			$(e).attr("vd",bool?1:0);
			//缓存text型数据验证结果			
			switch (e.type) {
				case "text":
				case "file":
				case "password":
				case "hidden":
					$(e).attr({
						"lastValue":	e.value,
						"lastExp":		ck
					});
					break;
			}
			if(bool)return;
			//取出靠前的一个错误的提示信息
			var msg = $(e).attr("vmsg");
			var m = msg.match(/\(.*?\)/g);
			if (s = ck.match(/\(.*?\)/g)) {
				for (var i = 0; i < s.length; i++) {
					if (!eval(s[i])) {
						if (m && m.length >= i) {
							msg = m[i].substr(1,m[i].length-2);
						}
						break;
					}
				}
			}
			$(e).attr("emsg", msg);
		},
		
		/**
		 * 单元素验证后的处理
		 * @param {Object} e
		 * @param {Object} bool
		 */
		ValidEleAfter : function(e,bool){
			if (!bool) {
				if($(e).attr("vmsg"))
					alert($(e).attr("vmsg"));
			}
		},

		/**
		 * 表单验证后的处理
		 * @param {array} eles
		 */
		ValidFormAfter : function(eles){
			var err = [];
			for(var i=0;i<eles.length;i++){
				if(!eles[i].bool){
					err.push((err.length+1)+": "+$(eles[i].ele).attr("vmsg"));
				}
				this.ValidEleAfter(eles[i].ele,eles[i].bool);
			}
			if(err.length>0){
				var str = "表单中有"+ err.length +"项未通过验证                    \n\n";
				str += err.join("\n\n");
				//alert(str);
			}
		},
		
		/**
		 * 验证radio对象
		 * @param {element} e Radio对象
		 * @param {string} rule 规则
		 * @return 成功true 失败false
		 */
		ValidRadio : function(e,rule){
			var name = $(e).attr("name");
			if(name){
				var rs = $("[name="+ name +"]:checked");
				if(rs.length == 0){
					//未选择
					return this.Valids("", rule);
				}else{
					//判断选择的值
					return this.Valids(rs.val(), rule);
				}
			}else{
				return this.Valids(e.value, rule);				
			}
		},

		/**
		 * 验证Checkbox对象
		 * @param {element} e
		 * @param {string} rule
		 */
		ValidCheckbox : function(e,rule){
			var name = $(e).attr("name");
			if(name){
				var rs = $("[name="+ name +"]");
				if(rs.length == 1){
					//单checkbox
					return this.Valids((e.checked?e.value:""), rule);
				}else{
					//组checkobx
					var values = [];
					rs.filter(":checked").each(function(i,e){
						values.push(e.value);
					});
					return this.Valids(values[0]?values:"", rule);
				}
			}else{
				//单checkbox
				return this.Valids((e.checked?e.value:""),rule);
			}
		},

		/**
		 * 验证一组规则
		 * @param string value 验证值
		 * @param array rule 规则组
		 * @param bool 决定是否返回布尔值,否则返回表达式 
		 * @return 成功true 失败false
		 */
		Valids : function(value,rule,bool){
			//取得解析后的规则
			var pr = this.ParseRule(rule);
			var exp = pr.expresion;
			for(var i=0;i<pr.rules.length;i++){
				var g = this.Valid(value,pr.rules[i])?"true":"false";
				exp = exp.replace(i,g);
			}
			exp = exp.replace(/\)\(/ig,")&&(");
			return bool ? eval(exp) : exp;
		},

		/**
		 * 根据规则字符串校验一个值
		 * @param string value 待验证值
		 * @param array rule 规则字符串
		 * @return 验证成功true 失败false
		 */
 		Valid : function(value,rule){
			//获取验证附加项
			var opt = this.GetOpts(rule);
			//过滤掉[.*]附加项
			rule = rule.replace(/\[.*\]/g,"");
			//{.*}模式
			if(rule.match(/^\{(.*)\}$/)){
				var fun = RegExp.$1;
				//{/.*}正则验证
				if(rule.match(/^\{(\/.*)\}/)){
					return this.ValidExec(value,eval(RegExp.$1),opt);
				}else{
					//函数验证
					return this.ValidExec(value,eval(fun),opt);			
				}
			}else{
				//预设规则验证
				if(this.rules[rule])
					return this.ValidExec(value,this.rules[rule],opt);	
				else{
					//alert("未知验证方法: "+rule+"     ");
					return false;
				}
			}
 		},
		
		/**
		 * 取规则的参数
		 */		
		GetOpts : function(rule){
			var opts = rule.match(/\[(.*)\]/) ? RegExp.$1.split(",") : [];
			for(var i=0;i<opts.length;i++){
				if(opts[i].match(/^%(.*)%$/)){	//可执行代码
					opts[i] = eval(RegExp.$1);
				}				
			}
			return opts;
		},
		
		/**
		 * 根据规则验证值
		 * @param string value 预验证值
		 * @param [reg,str,fun] rule 验证方式
		 * @param array opt 验证选项
		 * @return 验证成功true 失败false
		 */
		ValidExec : function(value,rule,opt){
			if(value==undefined){
				value = "undefined";
			}
			if(typeof(value)=='string')
				return this.ValidString(value,rule,opt);
			switch(value.constructor){
				case String:
					return this.ValidString(value,rule,opt);
					break;	
				case Array:
					return this.ValidArray(value,rule,opt);
					break;
				default:
					return this.ValidOther(value,rule,opt);
					break;
			}
		},

		/**
		 * 验证字符型数据
		 * @param string value 预验证值
		 * @param [reg,str,fun] rule 验证方式
		 * @param array opt 验证选项
		 * @return 验证成功true 失败false
		 */
		ValidString : function(value,rule,opt){
			switch(rule.constructor){
				case String:
					return value.match(rule)?true:false;
					break;
				case RegExp:
					return value.match(rule)?true:false;
					break;
				case Function:
					return this.ExecValidFun(rule,value,opt);
					break;
			}
		},

		/**
		 * 验证数组型数据
		 * 验证原则:用指定的规则遍历数据
		 * @param string value 预验证值
		 * @param [reg,str,fun] rule 验证方式
		 * @param array opt 验证选项
		 * @return 验证成功true 失败false
		 */
		ValidArray : function(value,rule,opt){
			for(var i=0;i<value.length;i++){
				switch(rule.constructor){
					case String:
						if(!value[i].match(rule))
							return false;
						break;
					case RegExp:
						if(!value[i].match(rule))
							return false;
						break;
					case Function:
						//针对如checkbox,radio类的对象
						if(!this.ExecValidFun(rule,value[i],opt))
							return false;
						break;
				}
			}
			return true;
		},
	
		/**
		 * 验证其它类型数据
		 * 主要用于对一方法,对任一对象的验证
		 * @param string value 预验证值
		 * @param [reg,str,fun] rule 验证方式
		 * @param array opt 验证选项
		 * @return 验证成功true 失败false
		 */
		ValidOther : function(value,rule,opt){
			switch(rule.constructor){
				case Function:
					return this.ExecValidFun(rule,value,opt);
					break;
			}
		},	
		
		/**
		 * 解析规则表达式
		 * @param string rule 表达式字符串
		 * @return {}.expresion处理后的表达式模式
		 *         {}.rules分解后的运算单元
		 */
		ParseRule : function(rule){
			var result = {expresion:null,rules:[]};
			//编码{}结构单元
			rule = rule.replace(/{(.*?)}(?=[\)\|=&])/g,function(m,r){
				return m.replace(r,escape(r));
			});
			//编码[]结构单元
			rule = rule.replace(/\[(.*?)\]/g,function(m,r){
				return m.replace(r,escape(r));
			});
			//统一[与或]标识符
			rule = rule.replace(/&&|\|\|/g,function(m){
				return m.replace(/^./,"");
			});
			//提取运算单元
			var rules = rule.split(/[!\(\)=\|&]/g);
			var x= (rules[0]=="") ? "1" : 0;
			if(rules[0]==""){
				rules = $.grep(rules,function(e,i){
					return e!="";
				});
			}
			for (var i = 0; i < rules.length; i++) {
				result.rules.push(unescape(rules[i]));
				rule = rule.replace(rules[i],i);
			}
			//设置表达式,并还原[与或]标识符
			result.expresion = rule.replace(/&|\|/g,function(m){
				return m+m;
			});
			return result;
		}		
 	}
 })(jQuery);
 






 
 
 
// 以上为验证的核心单元

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 上下为验证应用的扩展











//定义名称空间
var vf = {};

//规则配置
vf.rules = {};

//增加规则配置
vf.add = function(rules){
	$.extend(vf.rules, rules);
}

/**
 * 验证初始化
 * 1.根据当前面页的form标识,取得对应的验证规则配置(form.name -> form.id -> form.class)。
 * 2.获取验证规则配置
 */

vf.init = function(){

	$.VF.ValidEleAfter = vf.veAfter;

	$.VF.ValidFormAfter = function(){}

	$("form").each(function(i,e){
		var rs = vf.getRulesByName($(e).attr('name'));
		if(!rs.length){
			rs = vf.getRulesByName($(e).attr('id'));
			if(!rs.length){
				rs = vf.getRulesByName($(e).attr('class'));
			}
		}
		
		$(e).bind("submit",function(i,f){
			return $.VF.ValidForm(f,false);
		});
		
		return vf.bind(e,rs);
	});
}

/**
 * 元素验证处理
 * e 所验证元素
 * ck 验证是否成功
 */
vf.veAfter = function(e,ck){
	var vel = $(e).attr("vele");
	if(!vel){
		var defId = e.id+"Vmsg";
		if(!$("#"+defId).length){
			var defId = "vf" + parseInt(Math.random()*100000);
			$(e).after("<span class='vmsg' id='"+ defId +"'></span>");		
		}
		vel = "#" + defId;
		$(e).attr("vele",vel);
	}
	if(ck){
		$(vel).html("").hide();
	}else{
		$(vel).html($(e).attr("emsg")).show();
	}
}


/**
 * 表单绑定规则
 */

vf.bind = function(form,rules){

	$(rules).each(function(i,e){
		var ele = $(form).find(e[0]).attr({
			"rule":		e[2],
			"vele":		e[1],
			"vmsg":		e[3],
			"nocache":	e[5] ? 1 : 0
		});
		//触发事件
		var t = (e[4] ? e[4] : "blur,change").split(",");
		$(t).each(function(i,e){
			$(ele).bind(e,function(){
				vf.valid(ele[0]);
			});
		});
	});
}

/**
 * 验证单位元素
 */

vf.valid = function(ele){
	$.VF.ValidElement(ele);
}

/**
 * 验证表单
 */

function vform(f){
	return $.VF.ValidForm(f,false);
}

/**
 * 从配置数据里获取指定名称的规则数据
 * 包括继承关系的处理,产生新的规则配置
 * @Return []
 */

vf.getRulesByName = function(name){
	//独立配置
	if(vf.rules[name]){		
		return vf.rules[name];
	}

	//处理继承关系数据
	var rule = null;
	for(rule in vf.rules){
		var rs = rule.split(/[:\,]/);
		if(rs.length > 1 && rs[0] == name){
			var r = [];
			for(var i = rs.length -1; i>0; i--){
				r = vf.merge(r,vf.getRulesByName(rs[i]));
			}
			return vf.merge(r,vf.rules[rule]);
		}
	}
	return [];
}

/**
 * 合并两个规则数组,以实现继承机制
 * rules2 覆盖 rules1 已存在项
 */
vf.merge = function(rules1,rules2){
	var r1 = $.grep(rules1, function(r){
		return !getRule(r[0]);
	});
	var r2 = $.grep(rules2, function(r){
		return r.length > 1;
	});
	return $.merge(r1,r2);

	function getRule(mark){
		for(var i=0;i<rules2.length;i++){
			if(rules2[i][0] == mark){
				return rules2;
			}
		}
		return false;
	}
}


//startup

$(function(){

	vf.init();

});









