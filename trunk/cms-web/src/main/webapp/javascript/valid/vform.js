
/* extend begin */

(function($){
	$.extend({
		// Unique id
		UniqueID_NUM : 0,
	
		UniqueID : function(){
			$.UniqueID_NUM ++;
			return "jQueryUid_" + $.UniqueID_NUM;
		}

	}); // End for $.extend 

	// 重构$.fn.par
	// 功能：搜索符合表达式e的的父级元素
	$.fn.par = function(e){
		if(this.length==0){
			this.length = 0;
			return this;
		}
		var g = this[0];
		var p = $(g).parent(e);
		while(p.length != 1){
			g = g.parentNode;
			if(g.tagName=="HTML"){
				this.length = 0;
				return this;
			}
			p = $(g).parent(e);
		}
		return p;
	}
})(jQuery);


//方法：在input上加rule和vmsg


$(function(){
	$.VF.ValidEleAfter = function(e,ck){
		if(ck){
			$($(e).attr("vele")).html("").hide();
		}else{
			$($(e).attr("vele")).html($(e).attr("emsg")).show();
		}
	}
	$.VF.ValidFormAfter = function(eles){
	
	}
	$("[type=reset]").click(function(){
		window["tempEle"] = this;
		setTimeout('setSubmitBtn(window["tempEle"])',50);		
	});
	//设置 disabled的submit按钮的title
	$("form").find("[type=submit]:disabled").attr({
		"title": "表单未填写完整或含有填写错误的输入项！"
	});	
	setTimeout(function(){
		$("form").each(function(i,e){
			if($(e).find("[vmsg]").length){
				setSubmitBtn(e);
			}
		});
		
		
	},300);
});

//开始验证
function vform(f){
	return $.VF.ValidForm(f);
}
	
/** 
 * 动态增加验证条件
 * ele:条件选择,rule:验证规则,vmsg:消息
 */
function addRule(ele,vele,rule,vmsg){
	if ($(ele).attr("rule")) { //已有
		var r = $(ele).attr("rule");
		var vm = $(ele).attr("vmsg");
		if(!r.match(/^\(.*\)$/))r = "(" + r +")";
		if (rule.match(/^\(.*\)$/)) {
			r  += rule;
			vm += vmsg;
		}else{
			r += "(" + rule + ")";
			vm += "(" + vmsg + ")";				
		}
		$(ele).attr({
			"rule":r,
			"vmsg":vm
		});
	}else{
		$(ele).attr({
			"rule":rule,
			"vmsg":vmsg,
			"vele":vele
		});
		$(ele).blur(function(){
			ValidEle(this);
		}).change(function(){
			ValidEle(this);
		}).keyup(function(){
			ValidEle(this);
		}).click(function(){
			ValidEle(this);
		});
	}
}	

//验证一个元素
//验时200毫秒,避免频繁验证
function ValidEle(ele){
	window["validEle"] = ele;
	clearInterval(window["validTimer"]);
	window["validTimer"] = setTimeout("$.VF.ValidElement(window['validEle']);setSubmitBtn(window['validEle'])",100);
}


//控制表单中的submit按钮
function setSubmitBtn(ele){
 var form = $(ele).is("form")? ele : $(ele).par("form")[0];
 if($.VF.ValidForm(form)){
  $(form).find("[type=submit]").attr({
   "disabled": false,
   "title": ""
  }); 
 }else{
  $(form).find("[type=submit]").attr({
   "disabled": true,
   "title": "表单未填写完整或含有填写错误的输入项！"
  });
 } 
}
	

	