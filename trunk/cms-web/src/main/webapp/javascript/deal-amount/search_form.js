

$( function() {
	//绑定验证规则
    addRule("#company",    "#companyVmsg",    "(lenb[0,40])",     "(公司名称长度不能超过20)"); 
    addRule("#dealState",	"#dealStateVmsg",	"(bt)",	"(排序值必填)");
    
});
self.setInterval("isSearch()", 100);
function isSearch(){
	$('#company').focus();
	if($('#company').val()!="" || $('#dealTime').val()!=""){
		$('#dealState').attr('value',1);
		}else if($('#company').val()=="" && $('#dealTime').val()==""){
			$('#dealState').attr('value',"");
		}

}; 