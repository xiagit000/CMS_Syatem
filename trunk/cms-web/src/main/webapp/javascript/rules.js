
/**************************************************************************************************************************

配置说明

1. 通过 vf.add() 方法增加配置规则,可按模块划分到不同的配置文件。

2. 规则格式为

	{
		"form":
		[
			["ele",		"vele",		"rule",		"msg",		"event",	"nocache"],		//ele
			["ele2",	"vele",		"rule",		"msg",		"event",	"nocache"],		//ele2
			["ele3",	"vele",		"rule",		"msg",		"event",	"nocache"]		//ele3
		],

	}

	form: 表单的标识,可以是name,id,class

	ele:	验证元素的标识
	vele:	验证信息的显示元素标识,可为空,默认为"idVmsg",如果"idVmsg"不存在,则系统自动添加
	rule:	验证规则,同原来一样
	msg:	验证失败提示信息
	event:	[可选] 指定验证触发的事件,默认为"blur,change", 可选"keyup,keydown,click......"
	nocache:[可选] 指定验证缓存项,0代表缓存1为不缓存,默认为0
	

3. 规则的继承,避免类似表单的重复定义


	{
		"form":
		[
			["ele",		"vele",		"rule",		"msg",		"event",	"nocache"],		//ele
			["ele2",	"vele",		"rule",		"msg",		"event",	"nocache"],		//ele2
			["ele3",	"vele",		"rule",		"msg",		"event",	"nocache"]		//ele3
		],

		"form2:form":
		[
			["ele"],	//移除ele规则
			["ele2",	"vele",		"rule",		"msg",		"event",	"nocache"],		//重写ele2规则
			["ele4",	"vele",		"rule",		"msg",		"event",	"nocache"]		//新增ele4规则
		]
	}

	以上为两个表单的验证配置,form和form2

	form2继承了form的配置,写法为 form2:form, 可继承多个表单配置: form2:a,b,c


**************************************************************************************************************************/







vf.add({


	"my_info":	//管理个人资料 
	[
		["#phone",		"#phoneVmsg",			"(bt)(phone)",					"(必填)(电话号码错误)"],
		["#email",		"#emailVmsg",			"(bt)(email)",					"(必填)(邮件地址错误)"],
		["#address",	"#addressVmsg",			"(bt)(len[1,85])",				"(必填)(地址长度错误)"],
		["#appendix",	"#appendixVmsg",		"(bt)(len[1,85])",				"(必填)(备注长度错误)"],
		["#file",		"#fileVmsg",			"(!bt|ext[jpg,bmp,png])",		"(格式错误)"]
	],

	"my_password":	//更改登录密码 
	[
		["#pass",		"#passVmsg",		"(bt)(len[6,10])",					"(必填)(长度错误)"],
		["#newPass",	"#newPassVmsg",		"(bt)(len[6,10])",					"(必填)(长度错误)"],
		["#newRePass",	"#reNewPassVmsg",	"(bt)(equal[newPass])",				"(必填)(两次密码输入不一致)"]
	],
	
	"system_manage":	//系统设置 
	[
		["#baseInfo_hostName",				"#hostNameVmsg",		"(url)",		"主机名称不合法"],
		["#hightlightInfo_highlightDays",	"#highlightDaysVmsg",	"(number)",		"格式错误"],
		["#attachmentInfo_attachmentSize",	"#attachmentSizeVmsg",	"(number)",		"格式错误"]
	],
	
	"manager_new":	//首页设置-增加区块 
	[
		["#nodeSize",		"#nodeSizeVmsg",		"(bt)(number)",		"(必填)(格式错误)"]
	],
	
	"manager_edit":	//首页设置-编辑区块 
	[
		["#nodeSize",		"#nodeSizeVmsg",		"(bt)(number)",		"(必填)(格式错误)"]
	],
	
	"node_edit":	//栏目管理-编辑栏目
	[
		["#name",	"#nameVmsg",	"(bt)",		"(必填)"]
	],
	
	"node_new":	//栏目管理-增加栏目
	[
		["#name",	"#nameVmsg",	"(bt)",		"(必填)"]
	],
	
	"description_edit":	//说明性栏目列表-编辑新闻
	[
		["#name",	"#des_name_Vmsg",	"(bt)(len[1,10])",											"(必填)(长度错误)"],
		["#alias",	"#des_alias_Vmsg",	"(bt)(char)(len[1,10])({checkAlias[update,about]})",		"(必填)(格式错误)(长度错误)(已存在)"]
	],
	
	"description_new":	//说明性栏目列表-新增新闻
	[
		["#name",	"#des_name_Vmsg",	"(bt)(len[1,10])",								"(必填)(长度错误)"],
		["#alias",	"#des_alias_Vmsg",	"(bt)(char)(len[1,10])({checkAlias[new]})",		"(必填)(格式错误)(长度错误)(已存在)"]
	],
	
	"example":	//新闻管理-根导航-增加新闻
	[
		["#file",		"#fileVmsg",		"(!bt|ext[jpg,jpeg,bmp,png])",		"(格式错误)"],
		["#summary",	"#summaryVmsg",		"(len[0,300])",						"(长度错误)"],
		["#title",		"#titleVmsg",		"(bt)",								"(必填)"]
	],
		
	"friendly_edit":	//管理友情链接-友情链接列表-编辑友情链接
	[
		["#name",	"#nameVmsg",	"(bt)",		"(必填)"],
		["#href",	"#hrefVmsg",	"(bt)",		"(必填)"]
	],
	
	"friendly_new":	//管理友情链接-友情链接列表-新增友情链接
	[
		["#name",	"#nameVmsg",	"(bt)",		"(必填)"],
		["#href",	"#hrefVmsg",	"(bt)",		"(必填)"]
	],
	
	"user_manager_new":	//用户管理-用户列表-新增用户
	[
		["#name",		"#nameVmsg",		"(bt)(char)(lenb[5,16])(unique[/cms-web/user/register/try/checkName,name,Y])",		"(必填)(含有非法字符)(长度错误)(用户名已被占用)"],
		["#pass",		"#passVmsg",		"<enabled>(bt)(len[6,10])",															"(必填)(长度错误)"],
		["#repass",		"#repassVmsg",		"<enabled>(bt)(equal[pass])",														"(必填)(两次密码输入不一致)"],
		["#phone",		"#phoneVmsg",		"(bt)(phone)",																		"(必填)(电话号码错误)"],
		["#email",		"#emailVmsg",		"(bt)(email)(unique[/cms-web/user/register/try/checkEmail,email,Y])", 				"(必填)(邮件地址错误)(邮件地址已被占用)"],
		["#address",	"#addressVmsg",		"(bt)(len[1,85])",																	"(必填)(地址长度错误)"],
		["#appendix",	"#appendixVmsg",	"(bt)(len[1,85])",																	"(必填)(备注长度错误)"]
	],
	
	"idap_edit":	//***************
	[
		["#host",	"#hostVmsg",	"(bt)",				"(必填)"],
		["#port",	"#portVmsg",	"(bt)",				"(必填)"],
		["#admin",	"#adminVmsg",	"(bt)",				"(必填)"],
		["#password",	"#passwordVmsg",	"(bt)",		"(必填)"],
		["#baseDN",	"#baseDNVmsg",	"(bt)", 			"(必填)"],
		["#loginName",	"#loginNameVmsg",	"(bt)",		"(必填)"]
	],
	
	"user_manager_changepassword":	//***************
	[
		["#pass",	"#passVmsg",	"(bt)(len[6,10])",							"(必填)(长度错误)"],
		["#newPass",	"#newPassVmsg",	"(bt)(len[6,10])",						"(必填)(长度错误)"],
		["#newRePass",	"#reNewPassVmsg",	"(bt)(equal[newPass])",				"(必填)(两次密码输入不一致)"]
	],
	
	"user_manager_edit":	//***************
	[
		["#phone",	"#phoneVmsg",	"(bt)(phone)",							"(必填)(电话号码错误)"],
		["#email",	"#emailVmsg",	"(bt)(email)",							"(必填)(邮件地址错误)"],
		["#address",	"#addressVmsg",	"(bt)(len[1,85])",					"(必填)(地址长度错误)"],
		["#appendix",	"#appendixVmsg",	"(bt)(len[1,85])",				"(必填)(备注长度错误)"]
	],
	
	"datatype_edit":	//***************
	[
		["#typeName",	"#nameVmsg",	"(bt)",				"(必填)"]
	],
	
	"datatype_new":	//***************
	[
		["#typeName",	"#nameVmsg",	"(bt)",				"(必填)"]
	],
	
	"application_setting":	//***************
	[
		["#url",	"#urlVmsg",		"(bt)(url)",			"(必填)(网址错误)"]
	],



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	"__":
	[
		["#unitName",		"",			"bt",		"必填"]
	]

});


