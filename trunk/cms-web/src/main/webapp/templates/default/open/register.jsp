<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title><s:text name="reg_title"/>--${application.systemName }</title>
<link href="<s:url value='/templates/%{#request.template}/static/css/home.css'/>" rel="stylesheet" type="text/css" />
<link href="<s:url value='/templates/%{#request.template}/static/css/reg.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value='/javascript/jlib/core-min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/nav.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/reg.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/jlib/units/vf.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/rules.js'/>"></script>
<link rel="alternate" type="application/rss+xml" href="<s:url value='/feed/news'/>" title="${application.systemName}"/>
<s:include value="/res/plugins/calendar.jsp"></s:include>
</head>
<body>
<div id="waper">
<s:include value="head.jsp"></s:include>

<%-- main --%>
<div id="main">
	<form name="regForm" action="<s:url value='/open/register'/>" method="post" enctype="multipart/form-data" onsubmit="return vform(this);">
		<h3 class="form_title0"><s:text name="reg_title" /></h3>
		<!-- message -->
		<ul class="vmsg_ul">
			<li id="schoolInfo_schoolName_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_specialty_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_enrollmentTime_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_name_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_sex_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_identityNumber_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_birthDate_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_politicalAffiliation_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_ethnic_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_schoolOfGraduation_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_raduationNumber_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_homeAddress_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_zipCode_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_takeCare_Vmsg" class="vmsg"></li>
			<li id="period_Vmsg" class="vmsg"></li>
			<li id="unit_Vmsg" class="vmsg"></li>
			<li id="career_Vmsg" class="vmsg"></li>
			<li id="familyMembers_Vmsg" class="vmsg"></li>
			<li id="studyType_Vmsg" class="vmsg"></li>
			<li id="studyLevel_Vmsg" class="vmsg"></li>
			<li id="schoolInfo_notes_Vmsg" class="vmsg"></li>
		</ul>
		
		<div id="title_top">
			<s:text name="reg_schoolName" /> <input type="text" name="schoolInfo.schoolName" id="schoolInfo_schoolName" class="txt"/><span class="vhint"><span>&#42;</span></span>
			<s:text name="reg_specialty" /> <input type="text" name="schoolInfo.specialty" id="schoolInfo_specialty" class="txt"/><span class="vhint"><span>&#42;</span></span>
			<s:text name="reg_enrollmentTime" /> <input type="text" name="schoolInfo.enrollmentTime" id="schoolInfo_enrollmentTime" class="txt" readonly="readonly" onclick="WdatePicker({el:this.id})" /><span class="vhint"><span>&#42;</span></span>
		</div>
		<h4 class="form_title"><s:text name="reg_personalinfo" /></h4>
		<div id="base_infor">
			<label for="schoolInfo_name"><s:text name="reg_name" /></label><input class="txt" type="text" name="schoolInfo.name" id="schoolInfo_name" />
			<label for="schoolInfo_sex"><s:text name="reg_sex" /></label>
				<s:iterator value="sexs" var="sex">
					<input type="radio" name="schoolInfo.sex" value="${sex }" />
					<s:if test="#sex.name == 'MAN'"><s:text name="man" /></s:if>
					<s:if test="#sex.name == 'WOMAN'"><s:text name="woman" /></s:if>
				</s:iterator><br/>
			<label for="schoolInfo_identityNumber"><s:text name="reg_identityNumber" /></label><input class="txt" type="text" name="schoolInfo.identityNumber" id="schoolInfo_identityNumber" />
			<label for="schoolInfo_birthDate"><s:text name="reg_birthDate" /></label>
			<input type="hidden" name="schoolInfo.birthDate" id="schoolInfo_birthDate" />
			<%	request.setAttribute("currentYear",Calendar.getInstance().get(Calendar.YEAR)) ;	%>
			<select id="selYear">
				<option value=""><s:text name="reg_default_sel" /></option>
				<s:iterator begin="#request.currentYear" end="1900" step="-1" var="selYear">
				<option value="${selYear }">${selYear}</option>
				</s:iterator>
			</select><s:text name="reg_sel_year" />
			<select id="selMonth">
				<option value=""><s:text name="reg_default_sel" /></option>
				<s:iterator begin="1" end="12" var="selMonth">
				<option value="${selMonth }">${selMonth}</option>
				</s:iterator>
			</select><s:text name="reg_sel_month" />
			<br/>
			<label for="schoolInfo_politicalAffiliation"><s:text name="reg_politicalAffiliation" /></label><input class="txt" type="text" name="schoolInfo.politicalAffiliation" id="schoolInfo_politicalAffiliation" />
			<label><s:text name="reg_culturalLevel" /></label>
			<input type="radio" name="schoolInfo.culturalLevel" id="schoolInfo_culturalLevel_1" value="<s:text name='reg_highschool' />" />
			<s:text name='reg_highschool' />
			<input type="radio" name="schoolInfo.culturalLevel" id="schoolInfo_culturalLevel_2" value="<s:text name='reg_juniorCollege' />" />
			<s:text name='reg_juniorCollege' />
			<br/>
			<label for="schoolInfo_ethnic"><s:text name="reg_ethnic" /></label><input class="txt" type="text" name="schoolInfo.ethnic" id="schoolInfo_ethnic" /><br/>
			<label for="schoolInfo_schoolOfGraduation"><s:text name="reg_schoolOfGraduation" /></label><input class="txt" type="text" name="schoolInfo.schoolOfGraduation" id="schoolInfo_schoolOfGraduation" />
			<label for="schoolInfo_raduationNumber"><s:text name="reg_raduationNumber" /></label><input class="txt" type="text" name="schoolInfo.raduationNumber" id="schoolInfo_raduationNumber" /><br/>
			<label for="schoolInfo_homeAddress"><s:text name="reg_homeAddress" /></label><input class="txt" type="text" name="schoolInfo.homeAddress" id="schoolInfo_homeAddress" /><br/>
			<label for="schoolInfo_phone"><s:text name="reg_phone" /></label><input class="txt" type="text" name="schoolInfo.phone" id="schoolInfo_phone" />
			<label for="schoolInfo_zipCode"><s:text name="reg_zipCode" /></label><input class="txt" type="text" name="schoolInfo.zipCode" id="schoolInfo_zipCode" /><br/>
			<label for="schoolInfo_takeCare"><s:text name="reg_takeCare" /></label><input class="txt" type="text" name="schoolInfo.takeCare" id="schoolInfo_takeCare" />
		</div>
		<h4 class="form_title"><s:text name="reg_personal_resume" /></h4>    
		<div id="base_infor">
			<div class="form_list">
				<p><s:text name="reg_upload_photo" /></p>
				<input type="file" name="image" id="file"/>
			</div>
			<div class="form_list base_children">
				<label for="issue_start_date[0]"><s:text name="reg_from" /></label><input nocache="1" onchange="changePeriod(this)" id="issue_start_date[0]" size="10" type="text" value="" readonly="readonly" onclick="WdatePicker({el:this.id})"/><img onclick="WdatePicker({el:$(this).prev().attr('id')})" alt="Calendar" class="calendar-trigger" id="issue_start_date_trigger[0]" src="<s:url value='/templates/%{#request.template}/static/img/calendar.png'/>" />
				<label for="issue_end_date[0]"><s:text name="reg_to" /></label><input nocache="1" onchange="changePeriod(this)" id="issue_end_date[0]" size="10" type="text" value="" readonly="readonly" onclick="WdatePicker({el:this.id})" /><img onclick="WdatePicker({el:$(this).prev().attr('id')})" alt="Calendar" class="calendar-trigger" id="issue_end_date_trigger[0]" src="<s:url value='/templates/%{#request.template}/static/img/calendar.png'/>" /><br/>
				<label for="experiences[0]_unit"><s:text name="reg_unit" /></label><input class="txt" type="text" name="experiences[0].unit" id="experiences[0]_unit" />
				<label for="experiences[0]_career"><s:text name="reg_career" /></label><input class="txt" type="text" name="experiences[0].career" id="experiences[0]_career" /> 
				<input name="experiences[0].period" type="hidden" />
				<div class="jiaobiao">
					<input class="add" type="button" name="button" alt="<s:text name="add" />" onclick="addClick(this);" /> 
					<input class="delt" type="button" name="button" alt="<s:text name="delete" />" onclick="deleteClick(this);" />
				</div>
			</div> 
		</div>
                     
		<h4 class="form_title"><s:text name="reg_family_members" /></h4>
		<div id="base_infor">  
			<div class="form_list base_children">  
	            <label for="familyMembers[0]_name"><s:text name="reg_family_name" /></label><input nocache="1" class="txt" type="text" name="familyMembers[0].name" id="familyMembers[0]_name" />
	            <label for="familyMembers[0]_appellation"><s:text name="reg_family_appellation" /></label><input nocache="1" class="txt" type="text" name="familyMembers[0].appellation" id="familyMembers[0]_appellation" /><br/>
	            <label for="familyMembers[0]_workUnit"><s:text name="reg_family_workUnit" /></label><input nocache="1" class="txt" type="text" name="familyMembers[0].workUnit" id="familyMembers[0]_workUnit" />
	            <label for="familyMembers[0]_position"><s:text name="reg_family_position" /></label><input nocache="1" class="txt" type="text" name="familyMembers[0].position" id="familyMembers[0]_position" /> 
				<div class="jiaobiao">
					<input class="add" type="button" name="button" alt="<s:text name="add" />" onclick="addClick(this);" /> 
					<input class="delt" type="button" name="button" alt="<s:text name="delete" />" onclick="deleteClick(this);" />
	            </div> 
			</div>
		</div>
		
		<h4 class="form_title"><s:text name="reg_study_info" /></h4>   
		<div id="base_infor">
			<div class="form_p">
				<span class="form_guid"><s:text name="reg_study_type" /></span> 
				<s:iterator value="studyTypes" var="st" status="status">
					<label for="studyType${status.index }">
					<s:if test="#st.name == 'CORRESPONDENCE'"><s:text name="reg_st_correspondence" /></s:if>
					<s:if test="#st.name == 'AMATEUR'"><s:text name="reg_st_amateur" /></s:if>
					</label>
					<input id="studyType${status.index }" type="radio" name="studyType" value="${st }" />
				</s:iterator>
			</div>
	        <div class="form_p">
		        <span class="form_guid"><s:text name="reg_study_level" /></span>
		        <s:iterator value="studyLevels" var="sl" status="st">
		        	<label for="studyLevel${st.index }">
					<s:if test="#sl.name == 'HIGH_TO_COLLEGE'"><s:text name="reg_sl_high_to_college" /></s:if>
					<s:if test="#sl.name == 'COLLEGE_TO_UNIVERSITY'"><s:text name="reg_sl_college_to_university" /></s:if>
					</label>
					<input id="studyLevel${st.index }" type="radio" name="studyLevel" value="${sl }" />
			</s:iterator>
	        </div>
		</div>
		<h4 class="form_title"><s:text name="reg_notes" /></h4>   
		<div id="base_infor">
			<textarea name="schoolInfo.notes" id="schoolInfo_notes" cols="112" rows="6"></textarea>
		</div>
              
		<p id="btn" class="line clearfix">
			<input type="hidden" id="regPreview" name="regPreview" value="false"/>
			<button type="submit" class="sumbit" onclick="return doSub();"></button>
			<button type="reset" class="reset"></button>
			<button type="button" class="pre" onclick="return previewSub();"></button>
<!--			<button type="button" class="pre"></button>-->
		</p>
	</form>  
</div>
<s:include value="foot.jsp"></s:include>
</div>
</body>
</html>