$( function() {
	
	//绑定验证规则
    addRule("#company",    "#companyVmsg",    "(bt)(lenb[0,80])",     "(公司名称必填)(公司名称长度不能超过40)"); 
    addRule("#percent",	"#percentVmsg",	"(bt)(double)",	"(百分比必填)(百分比必须是整数或小数)");
    addRule("#totalAmount",	"#totalAmountVmsg",	"(bt)(double)",	"(金额总数必填)(金额总数必须是整数或小数)");
    addRule("#orderBy",	"#orderByVmsg",	"(bt)(int)",	"(排序值必填)(排序值必须是整数)");
    addRule("#dealTime",	"#dealTimeVmsg",	"(bt)",	"(交易时间必填)");
});