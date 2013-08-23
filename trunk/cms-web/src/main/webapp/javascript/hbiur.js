

//设置全局nlcab namespace
window.nlcab = new Object();
var isPrototype = (window.location.toString().indexOf("prototype")!=-1);

//判断IE6
var isIE6 = window.XMLHttpRequest?false:true;

/**
 * 初始加载
 */
$(function(){
	imgInit();
	//调试:在页面的标题上双击启用调试功能
	$(".class_title").dblclick(function(e){
		if(e.shiftKey){
			$("[type=hidden]").each(function(){
				var name = this.name;
				$("<input type='text'/>").attr({
					"name":this.name,
					"id":this.id
				}).css({
					"border":"solid 1px #f90"
				}).val(this.value).insertAfter(this);
				$(this).remove();
			});
			$(":hidden").show();
		}
		if(window["debugTimer"])clearInterval(window["debugTimer"]);
		window["debugTimer"] = setInterval("tempShowNameId();",1500);	//在title上显示表单的name与id
	});
});

//全选
function selAll(name,typ){
	switch(typ){
		case 1:	//全选
			$("[name="+ name +"]").attr("checked",true);
			break
		case 2: //取消 
			$("[name="+ name +"]").attr("checked",false);
			break;
		case 3: //反选
			$("[name="+ name +"]").each(function(){
				if($(this).attr("checked")){
					$(this).attr("checked",false);
				}else{
					$(this).attr("checked",true);
				}
			});
			break;
		default: //取值
			var data = [];
			$("[name="+ name +"]").filter(":checked").each(function(){
				data.push(this.value);
			});
			return data;
	}
}

function disable(obj,btn){
	var disabled = (obj != null && obj.checked) ? 'disabled':'';
	for(var i=2;i<arguments.length;i++){
		$('#'+arguments[i]).val('');
		$('#'+arguments[i]).attr('disabled',disabled);
	}
	if(!obj.checked){
		$('#'+btn).attr('disabled','disabled');
	}
}

//跳转
function go(url){
	var e = document.createElement("a"); 
    e.href = url; 
    document.body.appendChild(e); 
    e.click();
}

//返回
function back(){
	window.history.go(-1);
}

//刷新
function reload(){
	window.location.reload();
}

//刷新
function reload2(){
	window.location = window.location;
}

//刷新
function reload3(){
	var url = window.location.toString();
	url += url.indexOf("?")==-1 ? "?":"&";
	url += "uuid="+Math.random();
	window.location = url;
}

//刪除確認
function delConfirm(){
	return confirm("确定要删除吗？");
}

//恢復確認
function renewConfirm(){
	return confirm("确定恢复吗？");
}

//關閉確認
function closeConfirm(){
	return confirm("确定关闭吗？");
}

//通過確認
function agreeConfirm(){
	return confirm("確定通过吗？");
}

//不通過確認
function disagreeConfirm(){
	return confirm("确定不通过吗？");
}

//移出確認
function moveoutConfirm(){
	return confirm("确定要移出吗？");
}

//提交確認
function commitConfirm(){
	return confirm("确定要提交吗？");
}

//同步確認
function syncConfirm(){
	return confirm("确定同步该数据吗？");	
}

//撤消確認
function cancelConfirm(){
	return confirm("确定要撤销吗？");	
}

//確認
function rankConfirm(){
	return confirm("确定要定级吗？");
}

//激活確認
function enableConfirm(){
	return confirm("确定要激活吗？");
}

//冻结確認
function disableConfirm(){
	return confirm("确定要冻结吗？");
}

//激活確認
function publishConfirm(){
	return confirm("确定要发布吗？");
}

//激活確認
function unpublishConfirm(){
	return confirm("确定要取消发布吗？");
}

//激活確認
function processConfirm(){
	return confirm("确定已处理吗？");
}
/**
 * 删除选择对象
 * @param string name checkbox 名称
 * @param string url 要提交到的网址
 * @param string param 以此名称提示参数,默认参数名为id
 */
function delSel(name,url,param){
	if (typeof(name) == "object") {
		var sel = name;
	}else {
		var sel = selAll(name);
	}
	if(sel == ""){
		alert("请选择要删除的对象！");
	}else{
		if(delConfirm()){
			doSel(name,url,param);
		}
	}
}

/**
 * 对选择的对象进行操作
 * 向url以param参数名提交选中的值
 */
function doSel(name,url,param,check){
	if (typeof(name) == "object") {
		var sel = name;
	}else {
		var sel = selAll(name);
	}
	if (sel == "") {
		return alert("请选择要操作的对象！");
	}
	var p = param || name;
	var pstr = "";
	var parr = [];	//收集参数值
	for(var i=0;i<sel.length;i++){
		pstr += p + "=" + sel[i] + "&";
		parr.push(sel[i]);
	}
	if(check){
		if(!check({name:name,url:url,param:param,pstr:pstr,parr:parr}))return;
	}	
	if(url.indexOf("?")==-1){
		window.location = url + "?"+pstr;
	}else{
		window.location = url + "&"+pstr;
	}
}

/**
 * 提交表单
 */
function doSubmit(form,url,check){
	if (typeof(form) == "string") {
		form = $("#" + form + ",[name=" + form + "]");
		if (form.length == 0) {
			return alert("提交失败，未找到Form对象");
		}
		form = form[0];
	}
	else {//object
		if (form.tagName != "FORM") {
			form = $(form).par("form")[0];
		}
	}
	if(check){
		if(!check(form))return;
	}
	$(form).find("[multiple]").find("option").attr("selected",true);
	form.action = url==-1?form.action:url;
	form.submit();	
}

/**
 * 以项目根目录为基础取资源完整地址
 * 例: 取images下的book.gif地址
 * getFullPath("images/book.gif");
 */
function getFullPath(path){
	return $.Jlib.jpath+"../../"+path;
}

/**
 * 给URL增加参数
 * @param param　参数可为string或名值对
 */
function addParam(url,param){
	url = url.replace(/#.*$/,"");
	url = url.replace(/&*$/,"");	
	url += url.indexOf("?")==-1 ? "?" : "&";
	if(typeof(param)=="string"){
		url += param;
	}else{
		for(key in param){
			url += key + "=" + param[key] + "&";
		}
	}
	url = url.replace(/&*$/,"");	
	return url;
}

/**
 * 导入javascript文件夹下的js文件
 */
function importJs(){
	var files = arguments;
	for(var i=0;i<files.length;i++){
		document.write("<script src='"+ getFullPath("javascript/"+files[i]) +"' type='text/javascript'></s"+"cript>");	
	}
}

/**
 * dump 
 * 调试用
 */
function dump(arr,level) {
	var dumped_text = "";
	if(!level) level = 0;
	//The padding given at the beginning of the line.
	var level_padding = "";
	for(var j=0;j<level+1;j++) level_padding += "    ";
	if(typeof(arr) == 'object') { //Array/Hashes/Objects 
		for(var item in arr) {
			var value = arr[item];
			if(typeof(value) == 'object') { //If it is an array,
				dumped_text += level_padding + "'" + item + "' :\n";
				dumped_text += dump(value,level+1);
			} else {
				dumped_text += level_padding + "'" + item + "' => \"" + value + "\"\n";
			}
		}
	} else { //Stings/Chars/Numbers etc.
		dumped_text = "===>"+arr+"<===("+typeof(arr)+")";
	}
	return dumped_text;
}

// for in obj
function eachObj(obj){
	var str = "";
	for(a in obj){
		str += (a + " = " + obj[a] + "\n");
	}
	return str;
}

// 在title中显示所有表单对象name,id
// 用于调试
function tempShowNameId(){
	$(":input").each(function(){
		$(this).attr("title", "name:  " + $(this).attr("name") + "  \nid:  " + $(this).attr("id"));
	});
}

/**
 * 显示一个对话框
 * @param mixed e 参数
 * {
 * 	title:标题
 *  width:宽度
 *  height:高度
 *  html:要显示的内容
 *  url:要调用的地址
 * }
 * @return 返回一个对话框象
 */
function dlg(e){
	return new Dialog(e);
}



String.prototype.trim=function(){
        return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.ltrim=function(){
        return this.replace(/(^\s*)/g,"");
}
String.prototype.rtrim=function(){
        return this.replace(/(\s*$)/g,"");
}
String.prototype.Trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.LTrim = function(){
	return this.replace(/(^\s*)/g, "");
}
String.prototype.RTrim = function(){
	return this.replace(/(\s*$)/g, "");
} 

function ImgShow(evt){
	var imgTag=(window.event)?event.srcElement:evt.target;
	var imgPath=imgTag.src.replace("a.jpg",".jpg");//取得弹出的大图url
	var tagTop=Math.max(document.documentElement.scrollTop,document.body.scrollTop);
	var tag=document.createElement("div");
		tag.style.cssText="width:100%;height:"+Math.max(document.body.clientHeight,document.body.offsetHeight)+"px;position:absolute;background:white;top:0;filter: Alpha(Opacity=80);Opacity:0.8;";
		tag.ondblclick=function(){var clsOK=confirm("确定要取消图片显示吗？"); if(clsOK){closes();}};
	var tagImg=document.createElement("div");
		tagImg.style.cssText="font:12px /18px verdana;overflow:auto;text-align:center;position:absolute;width:200px;border:5px solid gray;background:gray;color:white;left:"+(parseInt(document.body.offsetWidth)/2-100)+"px;top:"+(document.documentElement.clientHeight/3+tagTop)+"px;"
		tagImg.innerHTML="<div style='padding:10px;background:#cccccc;border:1px solid white'><img src='http://bbs.blueidea.com/attachment.php?aid=91156&noupdate=yes' /><br /><br /><b style='color:#999999;font-weight:normal'>Image loading...</b><br /></div>";
	var closeTag=document.createElement("div");
		closeTag.style.cssText="display:none;position:absolute;left:10px;top:10px;background:red;border:1px solid white;yellow:white;filter:Alpha(Opacity=50);Opacity:0.5;cursor:pointer;";
		closeTag.innerHTML="<b> 关闭 </b>";
		closeTag.onclick=closes;
	document.body.appendChild(tag);
	document.body.appendChild(tagImg);
	var img=new Image();
		img.src=imgPath;
		img.style.cssText="border:1px solid #cccccc;filter: Alpha(Opacity=0);Opacity:0;";
		tagImg.oncontextmenu=function(){var clsOK=confirm("确定要取消图片显示吗？"); if(clsOK){closes();};return false};
	var barShow,imgTime;
	img.complete?ImgOK():img.onload=ImgOK;
	function ImgOK(){
		var Stop1=false,Stop2=false,temp=0;
		var tx=tagImg.offsetWidth,ty=tagImg.offsetHeight;
		var ix=img.width,iy=img.height;
		var sx=document.documentElement.clientWidth,sy=Math.min(document.documentElement.clientHeight,document.body.clientHeight/*opera*/);
		var xx=ix>sx?sx-50:ix+4,yy=iy>sy?sy-50:iy+3;
		var maxTime=setInterval(function(){
				temp+=35;
			if((tx+temp)<xx){
				tagImg.style.width=(tx+temp)+"px";
				tagImg.style.left=(sx-(tx+temp))/2+"px";
			}else{
				Stop1=true;
				tagImg.style.width=xx+"px";
				tagImg.style.left=(sx-xx)/2+"px";
			}
			if((ty+temp)<yy){
				tagImg.style.height=(ty+temp)+"px";
				tagImg.style.top=(tagTop+((sy-(ty+temp))/2))+"px";
			}else{
				Stop2=true;
				tagImg.style.height=yy+"px";
				tagImg.style.top=(tagTop+((sy-yy)/2))+"px";
			}
			if(Stop1&&Stop2){
				clearInterval(maxTime);
				tagImg.appendChild(img);
				temp=0;
				imgOPacity();
			}
		},1);
		function imgOPacity(){
			temp+=10;
			img.style.filter="alpha(opacity="+temp+")";
			img.style.opacity=temp/100;
			imgTime=setTimeout(imgOPacity,1)
			if(temp>100) clearTimeout(imgTime);
		}
		tagImg.innerHTML="";
		tagImg.appendChild(closeTag);
		if(ix>xx||iy>yy){
			img.alt="左键拖动，双击放大缩小";
			img.ondblclick=function (){
				if(tagImg.offsetWidth<img.offsetWidth||tagImg.offsetHeight<img.offsetHeight){
					img.style.width="auto";
					img.style.height="100%";
					img.alt="双击可以放大";
					img.onmousedown=null;
					closeTag.style.top="10px";
					closeTag.style.left="10px";
					tagImg.style.overflow="visible";
					tagImg.style.width=img.offsetWidth+"px";
					tagImg.style.left=((sx-img.offsetWidth)/2)+"px";
				}else{
					img.style.width=ix+"px";
					img.style.height=iy+"px";
					img.alt="双击可以缩小";
					img.onmousedown=dragDown;
					tagImg.style.overflow="auto";
					tagImg.style.width=xx+"px";
					tagImg.style.left=((sx-xx)/2)+"px";
				}
			}
			img.onmousedown=dragDown;
			tagImg.onmousemove=barHidden;
			tagImg.onmouseout=moveStop;
			document.onmouseup=moveStop;
		}else{
			tagImg.style.overflow="visible";
			tagImg.onmousemove=barHidden;
		}
	}
	function dragDown(a){
		img.style.cursor="pointer";
		var evts=a||window.event;
		var onx=evts.clientX,ony=evts.clientY;
		var sox=tagImg.scrollLeft,soy=tagImg.scrollTop;
		var sow=img.width+2-tagImg.clientWidth,soh=img.height+2-tagImg.clientHeight;
		var xxleft,yytop;
		document.onmousemove=function(e){
			var evt=e||window.event;
			xxleft=sox-(evt.clientX-onx)<0?"0":sox-(evt.clientX-onx)>sow?sow:sox-(evt.clientX-onx);
			yytop=soy-(evt.clientY-ony)<0?"0":soy-(evt.clientY-ony)>soh?soh:soy-(evt.clientY-ony);
			tagImg.scrollTop=yytop;
			tagImg.scrollLeft=xxleft;
			closeTag.style.top=(yytop+10)+"px";
			closeTag.style.left=(xxleft+10)+"px";
			return false;
		}
		return false;
	}
	function barHidden(){
		clearTimeout(barShow);
		if(closeTag.style.display=="none")closeTag.style.display="block";
		barShow=setTimeout(function(){closeTag.style.display="none";},2000);
	}
	function closes(){
		document.body.removeChild(tag);
		document.body.removeChild(tagImg);
		clearTimeout(barShow);
		clearTimeout(imgTime);
		document.onmouseup=null;
		tag=img=tagImg=closeTag=null;
	}
	function moveStop(){
		document.onmousemove=null;
		tagImg.onmousemove=barHidden;
		img.style.cursor="default";
	}
}

function imgInit(){
	var imgList=document.getElementsByName("popImage");
	for(var i in imgList){
		imgList[i].onclick=ImgShow;
	}
}