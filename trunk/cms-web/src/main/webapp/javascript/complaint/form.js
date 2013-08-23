$( function() {
	
	//绑定验证规则
    addRule("#company",    "#companyVmsg",    "(bt)(lenb[0,40])", "(被投诉人及单位必填)(被投诉人及单位长度不能超过20)"); 
    addRule("#person",	"#personVmsg",	"(bt)",	"(投诉人必填)");
    addRule("#contact",	"#contactVmsg",	"(bt)",	"(联系方式必填)");
    addRule("#content",	"#contentVmsg",	"(bt)",	"(投诉内容必填)");
    
});