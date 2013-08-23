
//全选
function checkAll(){
	$("input[name='chk_list']").attr("checked",true);
}

//全不选
function unCheckAll(){
	$("input[name='chk_list']").attr("checked",false);
}

//反选
function checkInverse(){
	$("input[name='chk_list']").each(function () {  
        $(this).attr("checked", !$(this).attr("checked"));  
    });
}

function multiDelete(){
	//获取用户选择的条目
	var chk_list=0;
	$("input[name='chk_list']").each(function () {  
        if($(this).attr("checked")==true){
        	chk_list++;
        }  
    });
	
	//判断用户是否把最后一页的信息全部删除
	var isDeleteLastAll=currentPage==totalPages && totalRows-(totalPages-1)*pageSize==chk_list;
	if(isDeleteLastAll){
	  $("#page").attr("value",currentPage);
	  document.dealForm.action="/cms-web/admin/deal-amount/all/multiDelete";
	}else{
		document.dealForm.action="/cms-web/admin/deal-amount/all/multiDelete";
	}
	
	//没有选择就不提交表单
	if(chk_list!=0){
	    document.dealForm.submit();
	}
}
