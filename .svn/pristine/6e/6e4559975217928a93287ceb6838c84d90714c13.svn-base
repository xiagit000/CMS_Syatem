function checkNull(){
	for(var i=0;i<arguments.length;i++){
		var value = $('#'+arguments[i]).val();
		var name = $('#'+arguments[i]).attr("title");
		if(value == null || value.length == 0){
			alert(name + "不能为空！");
			return false;
		}else{
			var ml = $('#'+arguments[i]).attr("maxlength");
			if(ml == undefined)
				ml = $('#'+arguments[i]).attr("cols");
			if(ml != undefined && ml != null && value.length > ml){
				alert(name + "不能超过"+ml+"字！");
				return false;
			}
		}
	}
	return true;
}

function checkOnLine(online){
	if(!online){
		alert('文明上网，登录评论！');
		return false;
	}else{
		var content = $("#content1").val();
		if(content == null || content.trim().length < 15){
			alert("评论至少要有15个字！");
			return false;
		}
	}
	return true;
}

function checkCommend(online){
	if(!online){
		alert('文明上网，登录推荐评论！');
		return false;
	}else
		return true;
}

function checkAttention(online){
	if(!online){
		alert('请先登录，然后关注这条新闻！');
		return false;
	}else
		return true;
}

function vote(link,id){
	$.post(link,function(num) {
		/*var value = $("#"+id).text();
		if(value.match(/(\d+)/g)){
			var n = parseInt(RegExp.$1)+1;
			$("#"+id).html("推荐（"+n+"）");
			$("#"+id).attr("disabled","disabled");
		}*/
		$("#"+id).html("推荐（"+num+"）");
		$("#"+id).attr("href","javascript:alert('您已经投过票了！')");
	});
}