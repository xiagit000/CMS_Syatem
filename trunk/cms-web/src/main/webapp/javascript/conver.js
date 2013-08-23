/**
 * 文件转换相关脚本
 * 2009.1.16
 * lin.sun
 */
 
 $(function(){
 	$("[type=file]").keydown(function(){
 		return false;
 	});
  	$("[type=file]").mousedown(function(e){
  		if(e.button==2){
			this.blur();
  			return false;
  		}
 	});
 });
  
//增加上传文件
function addFile(btn){
	//var newtr = $("#filetr").clone(true).removeAttr("id").insertBefore($(btn).par("tr"));
	var newP = $("#filep").clone(true).removeAttr("id").insertAfter($(".files").find("p:last"));
	newP.find("font").html("").attr("fileErr","0").before("<input type='button' class='btn bw2' onclick=\"$(this).par('p').remove();\" value='移除' />");
	newP.find("[type=file]").val("");
}

//验证文件类型
function fileType(obj,type){
	switch(type){
		case 0:
		   var regex = /\.[iso]|[txt]$/i;
		   break;
		case 1:
		   var regex = /\.xls$/i;
		   break;
	    case 2:
	       var regex = /\.doc$/i;
	       break;
	    case 3:
	       var regex = /\.mdb$/i;
	       break;
	    case 4:
	       var regex = /\.pdf$/i;
	       break;
	    case 5:
		   var regex = /\.xml$/i;
		   break;
	    case 6:
	    	var regex = /\.*$/i;
	    	break;
	}
	if(!obj.value.match(regex)){
		$(obj).par("tr").find("font").html('文件類型錯誤').attr("fileErr","1");
	}else{
		$(obj).par("tr").find("font").html('').attr("fileErr","0");
	};
	
	if($("[fileErr=1]").length>0){
		$("#uploadbtn").attr("disabled",true);
	}else{
		$("#uploadbtn").attr("disabled",false);
	}
	var g = $("[type=file]");
	for(var i=0;i<g.length;i++){
		if(g[i].value=="")return;
	}
	addFile($('#addBtn')[0]);
}

//异步取单位
function getUnit(){
	url = "user!getUnits.action";
	$("#unit").find("[dy=1]").remove();
	$.post(url,{province:$("#province").val()},function (data){
		if(data=="")return;
		var names = data.split(",");
		for(e in names){
			var s = names[e].split(":");
			$("#unit").append("<option dy=1 value='"+ s[0] +"'>"+ s[1] +"</option>");
		}
	});
}

//验证单位选择
function checkUnit(){
	//var stat = ($("#unit").val()!=-1) ? "" : "disabled"; 
	//$("#uploadbtn").attr("disabled",stat);
}


//表单验证
function checkForm(){
	if($("[fileErr=1]").length>0){
		alert("部分文件类型错误");
		return false;
	}
	if($("#unit").length == 1){
		if($("#unit").val()==-1){
			alert("请选择单位");
			return false;
		}
	}
	return true;	
}