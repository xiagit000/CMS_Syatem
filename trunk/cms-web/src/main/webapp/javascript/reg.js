/**
 * @author Luobin.chen
 * For register.jsp
 */

$(function() {
	loadBirthday();
	$("#selYear").change(loadBirthday);
	$("#selMonth").change(loadBirthday);
});

$(function(){
	addRule("#schoolInfo_schoolName",				"#schoolInfo_schoolName_Vmsg",			"bt",					"学校名称不能为空");
	addRule("#schoolInfo_specialty",				"#schoolInfo_specialty_Vmsg",			"bt",					"专业名称不能为空");
	addRule("#schoolInfo_enrollmentTime",			"#schoolInfo_enrollmentTime_Vmsg",		"bt",					"入学时间不能为空");
	addRule("#schoolInfo_name",						"#schoolInfo_name_Vmsg",				"(bt)(len[1,5])",		"(姓名不能为空)(姓名长度不能超过5个字符)");
	addRule("input:radio[name=schoolInfo.sex]",		"#schoolInfo_sex_Vmsg",					"(bt)",					"(必须选择性别)");
	addRule("#schoolInfo_identityNumber",			"#schoolInfo_identityNumber_Vmsg",		"(bt)({IDCheck})",		"(身份证号码不能为空)(身份证号码有误)");
	addRule("#schoolInfo_birthDate",				"#schoolInfo_birthDate_Vmsg",		"(bt)({birthDateCheck})",	"(出生年月不能为空)(必须选择出生年月)");
	addRule("#schoolInfo_politicalAffiliation",		"#schoolInfo_politicalAffiliation_Vmsg",	"(bt)(len[1,8])",				"(政治面貌不能为空)(政治面貌字数不能超过8个字符)");
	addRule("input:radio[name=schoolInfo.culturalLevel]",		"#schoolInfo_culturalLevel_Vmsg",		"(bt)",		"(必须选择已有文化程度)");
	addRule("#schoolInfo_ethnic",		"#schoolInfo_ethnic_Vmsg",		"(bt)",		"(民族不能为空)");
	addRule("#schoolInfo_schoolOfGraduation",		"#schoolInfo_schoolOfGraduation_Vmsg",		"(bt)",		"(毕业学校不能为空)");
	addRule("#schoolInfo_raduationNumber",		"#schoolInfo_raduationNumber_Vmsg",		"(bt)(char)(len[21,21])",		"(毕业证号码不能为空)(毕业证号码只能是英文或者数字)(毕业证号码必须是21位)");
	addRule("#schoolInfo_homeAddress",		"#schoolInfo_homeAddress_Vmsg",		"(bt)",		"(家庭住址不能为空)");
	addRule("#schoolInfo_phone",		"#schoolInfo_phone_Vmsg",		"(bt)",		"(电弧号码不能为空)"); // 暂时不做电话号码格式验证
	addRule("#schoolInfo_zipCode",		"#schoolInfo_zipCode_Vmsg",		"(bt)(zip)",		"(邮编不能为空)(邮编格式有误)");
	addRule("#schoolInfo_takeCare",		"#schoolInfo_takeCare_Vmsg",		"(bt)",		"(录取照顾不能为空,没有请填“无”)");
	addRule("input[id^=issue_]",		"#period_Vmsg",		"({checkStartEnd})",		"(请完整的填写本人简历项的起止年月)");
	addRule("input:text[id$=_unit]",		"#unit_Vmsg",		"({checkUnit})",		"(请填写本人简历项的所在单位)");
	addRule("input:text[id$=_career]",		"#career_Vmsg",		"({checkCareer})",		"(请填写本人简历项的职业)");
	addRule("input:text[id^=familyMembers]",		"#familyMembers_Vmsg",		"({checkFamilyMembers})",		"(家庭成员信息不完整)");
	addRule("input:radio[name=studyType]",		"#studyType_Vmsg",		"(bt)",		"(必须选择学习形式)");
	addRule("input:radio[name=studyLevel]",		"#studyLevel_Vmsg",		"(bt)",		"(必须选择报读层次)");
	addRule("#schoolInfo_notes",		"#schoolInfo_notes_Vmsg",		"(bt)",		"(备注不能为空，没有请填“无”)");
});

function checkFamilyMembers(value, opt)
{
	return validateExperience(/\S+/, "input:text[id^=familyMembers]");
}

function checkCareer(value, opt)
{
	return validateExperience(/\S+/, "input:text[id$=_career]");
}

function validateExperience(reg, path) {
	var _reg = reg; 
	var flag = true;
	$(path).each(function(i,e)
	{
		if (!_reg.test(e.value)) 
		{
			flag = false;
		}
	});
	return flag;
}

function checkUnit(value, opt)
{
	return validateExperience(/\S+/, "input:text[id$=_unit]");
}

function checkStartEnd(value, opt) {
	return validateExperience(/\S+/, "input[id^=issue_]");
}

function birthDateCheck(value, opt) {
	var bReg = /\d{4}年\d{1,2}月/;
	return bReg.test(value);
} 

function previewSub() {
	$("#regPreview").val("true");
	$("form[name=regForm]").attr("target","_blank");
	$("form[name=regForm]").submit();
	return false;
}

function doSub() {
	$("#regPreview").val("false");
	$("form[name=regForm]").removeAttr("target");
	return true;
}


function loadBirthday() {
	var b_year = $("#selYear").val();
	var b_month = $("#selMonth").val();
	$("#schoolInfo_birthDate").val(b_year + "年" + b_month + "月");
	$("#schoolInfo_birthDate").blur();
}

function IDCheck(value, obj) {
	var idReg = /(\d{6})((((([0-9]{2}(([2468][048])|([02468][48])|([13579][26])))|((([02468][048])|([13579][26]))(00)))(02)(([0][1-9])|([1-2][0-9])))|((([0-9]{2}([02468][1235679])|([13579][01345789]))|((([02468][1235679])|([13579][01345789]))(00)))(02)(([0][1-9])|([1][0-9])|([2][0-8])))|(([0-9]{4})(((([0](1|3|5|7|8))|(10|12))(([0][1-9])|([1-2][0-9])|30|31))|(((([0](4|6|9))|11))(([0][1-9])|([1-2][0-9])|30))))))(\d{3})([\d|X])/i;
	return idReg.test(value);
} 

function changePeriod(obj) {
	var start = "start:'" + $('input[id^=issue_start_date]').val() + "'";
	var end = "end:'" + $('input[id^=issue_end_date]').val() + "'";
	var period = "{" + start + "," + end + "}";
	$(obj).parent("div").find("input[name$=period]").val(period);
}

function addClick(obj) {
	var base_div = $(obj).parent("div").parent("div").parent("div");
	var form_list = $(obj).parent("div").parent("div");
	form_list.clone(true).insertAfter(form_list).find("input").val("");
	base_div.children(".base_children").each(function(i,e) {
		$(e).find("[for]").each(function(){
			var _for = $(this).attr("for");
			_for = _for.replace(/\[\d+\]/ig,'[' + i + ']');
			$(this).attr("for",_for);
		});
		$(e).find("[name]").each(function(){
			var _name = $(this).attr("name");
			_name = _name.replace(/\[\d+\]/ig,'[' + i + ']');
			$(this).attr("name",_name);
		});
		$(e).find("[id]").each(function(){
			var _id = $(this).attr("id");
			_id = _id.replace(/\[\d+\]/ig,'[' + i + ']');
			$(this).attr("id",_id);
		});
	});
//	$("input:text[id^=issue_]").change();
}


function deleteClick(obj) {
	var base_div = $(obj).parent("div").parent("div").parent("div");
	var size = base_div.children(".base_children").size();
	var form_list = $(obj).parent("div").parent("div");
	if (size > 1) { 
		form_list.remove(); 
		base_div.children(".base_children").each(function(i,e) {
			$(e).find("[for]").each(function(){
				var _for = $(this).attr("for");
				_for = _for.replace(/\[\d+\]/ig,'[' + i + ']');
				$(this).attr("for",_for);
			});
			$(e).find("[name]").each(function(){
				var _name = $(this).attr("name");
				_name = _name.replace(/\[\d+\]/ig,'[' + i + ']');
				$(this).attr("name",_name);
			});
			$(e).find("[id]").each(function(){
				var _id = $(this).attr("id");
				_id = _id.replace(/\[\d+\]/ig,'[' + i + ']');
				$(this).attr("id",_id);
			});
		});
//		$("input:text[id^=issue_]").change();
//		setTimeout('$("input:text[id$=unit]").change();',300);
//		setTimeout('$("input:text[id$=career]").change();',300*2);
		
	}
}