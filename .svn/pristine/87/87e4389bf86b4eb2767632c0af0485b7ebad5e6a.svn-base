<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title><s:text name="reg_title"/>--${application.systemName }</title>
<link href="<s:url value='/templates/%{#request.template}/static/css/home.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value='/javascript/jlib/core-min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/nav.js'/>"></script>
<link rel="alternate" type="application/rss+xml" href="<s:url value='/feed/news'/>" title="${application.systemName}"/>
<script type="text/javascript">
//<![CDATA[
$(function() {
	$("input[id$=hidden_period]").each(function() {
		var value = $(this).val();
		if (value != null) {
			eval("period =" + value);
			var show = "从" + period.start + "至" +	period.end;
			$(this).prev().html(show);
		}
	});
});
//]]>
</script>
<style media="print">
<!--
.Noprint{display:none;}
-->
</style>
</head>
<body>
<div id="waper">
<div class="Noprint">
<s:include value="head.jsp"></s:include>
</div>

<%-- main --%>
 <div id="main">
		<h3><s:text name="reg_title" /></h3>
		<div id="title_top">
			<s:text name="reg_schoolName" />: <input type="text" readonly="readonly" class="txt" value="${schoolInfo.schoolName }" /> 
			<s:text name="reg_specialty" />: <input type="text" readonly="readonly" class="txt" value="${schoolInfo.specialty }"/> 
			<s:text name="reg_enrollmentTime" />: <input type="text" readonly="readonly" class="txt" value="${schoolInfo.enrollmentTime }"/>
		</div>
		<table id="biaoge">
			<tr>
				<td rowspan="7" class="title_biao"><s:text name="reg_personalinfo" /></td>
				<td><s:text name="reg_name" /></td>
				<td><s:text name="reg_sex" /></td>
				<td><s:text name="reg_identityNumber" /></td>
				<td><s:text name="reg_birthDate" /></td>
				<td><s:text name="reg_politicalAffiliation" /></td>
			</tr>
			<tr>
				<td>${schoolInfo.name }　</td>
				<td>${schoolInfo.sex eq 'MAN' ? '男' : (schoolInfo.sex eq 'WOMAN' ? '女' : '' ) }　</td>
				<td>${schoolInfo.identityNumber}　</td>
				<td>${schoolInfo.birthDate }　</td>
				<td>${schoolInfo.politicalAffiliation }　</td>
		
			</tr>
			<tr>
				<td><s:text name="reg_culturalLevel" /></td>
				<td><s:text name="reg_ethnic" /></td>
				<td><s:text name="reg_schoolOfGraduation" /></td>
				<td colspan="2"><s:text name="reg_raduationNumber" /></td>
			</tr>
			<tr>
				<td>${schoolInfo.culturalLevel }　</td>
				<td>${schoolInfo.ethnic }　</td>
				<td>${schoolInfo.schoolOfGraduation }　</td>
				<td colspan="2">${schoolInfo.raduationNumber }　</td>
			</tr>
		
			<tr>
				<td colspan="2"><s:text name="reg_homeAddress" /></td>
				<td colspan="2"><s:text name="reg_phone" /></td>
				<td><s:text name="reg_zipCode" /></td>
			</tr>
			<tr>
				<td colspan="2">${schoolInfo.homeAddress }　</td>
				<td colspan="2">${schoolInfo.phone }　</td>
				<td>${schoolInfo.zipCode }　</td>
			</tr>
			<tr>
				<td><s:text name="reg_takeCare" /></td>
				<td colspan="4">${schoolInfo.takeCare }　</td>
			</tr>
		</table>
		<table id="biaoge">
			<tr>
				<td rowspan="<s:property value="%{experiences.size < 6 ? 6 + 1 : experiences.size + 1}"/>" class="title_biao"><s:text name="reg_personal_resume2" /></td>
				<td class="o_c_time"><s:text name="reg_period" /></td>
				<td class="biaoge_danwei"><s:text name="reg_unit" /></td>
				<td class="biaoge_zhiye"><s:text name="reg_career" /></td>
				<td rowspan="7" colspan="2" class="biaoge_photo">
					<s:if test="imageObj!=null">
						<img src="<s:url value='%{imageObj.iconImg}'/>" alt="<s:text name="reg_recent_photo" />"/>
					</s:if>
					<s:else>
						<img id="head" alt="<s:text name='portaint'/>" src="<s:url value='/templates/%{#request.template}/static/images/NoName.jpg'/>"/>
					</s:else>
				</td>
			</tr>
			<s:iterator value="experiences" var="ex" status="st">
			<tr>
				<td>
					<span id="experiences[${st.index }]_show_eriod" >　</span>
					<input id="experiences[${st.index }]_hidden_period" type="hidden" readonly="readonly" value="${ex.period }"/>
				</td>
				<td>${ex.unit }　</td>
				<td>${ex.career }　</td>
			</tr>
			</s:iterator>
			<s:if test="experiences.size < 6" >
			<s:iterator begin="1" end="6-experiences.size">
			<tr>
				<td>　</td>
				<td> 　</td>
				<td>　</td>
			</tr>
			</s:iterator>
			</s:if>
		</table>
		<table id="biaoge">
			<tr>
				<td rowspan="<s:property value="%{familyMembers.size < 4 ? 4 + 1 : familyMembers.size + 1}"/>" class="title_biao"><s:text name="reg_family_members" /></td>
			    <td><s:text name="reg_family_name" /></td>
			    <td><s:text name="reg_family_appellation" /></td>
			    <td colspan="2"><s:text name="reg_family_workUnit" /></td>
			    <td><s:text name="reg_family_position" /></td>
			</tr>
			<s:iterator value="familyMembers" var="fm" status="st">
			<tr>
				<td>${fm.name }</td>
			    <td>${fm.appellation }</td>
			    <td colspan="2">${fm.workUnit }</td>
			    <td>${fm.position }</td>
			</tr>
			</s:iterator>
			<s:if test="familyMembers.size < 4" >
			<s:iterator begin="1" end="4-familyMembers.size">
			<tr>
				<td>　</td>
			    <td>　</td>
			    <td colspan="2">　</td>
			    <td>　</td>
			</tr>
			</s:iterator>
			</s:if>
		</table>
	    <table id="biaoge">
			<tr>
				<td rowspan="3" class="title_biao"><s:text name="reg_study_info" /></td>
			    <td colspan="2"><s:text name="reg_study_type" /></td>
			    <td  colspan="2"><s:text name="reg_study_level" /></td>
			</tr>
			<tr>
			    <td  colspan="2" >
			    	<s:if test="studyType.name == 'CORRESPONDENCE'">
						<s:text name="reg_st_correspondence" />
					</s:if>
					<s:if test="studyType.name == 'AMATEUR'">
						<s:text name="reg_st_amateur" />
					</s:if>
			    </td>
			    <td  colspan="2" >
			    	<s:if test="studyLevel.name == 'HIGH_TO_COLLEGE'">
						<s:text name="reg_sl_high_to_college" />
					</s:if>
					<s:if test="studyLevel.name == 'COLLEGE_TO_UNIVERSITY'">
						<s:text name="reg_sl_college_to_university" />
					</s:if>
			    </td>
			</tr>
	     </table>
		<table id="biaoge">
	        <tr>
	            <td  class="title_biao"><s:text name="reg_notes" /></td>
	            <td  colspan="6" >
	            	<textarea  name=comment rows=3 cols=110% readonly="readonly">${schoolInfo.notes }</textarea>
	            </td>
	        </tr>
	    </table>
		<div class="btn_biaoge">
			<input class="print Noprint" type="button" alt="<s:text name="reg_print" />" onclick="window.print();"/>
			<%-- <input class="pre" type="button" alt="预览"/> --%>
		</div>
            
    </div>
        
<div class="Noprint">
<s:include value="foot.jsp"></s:include>
</div>
</div>
</body>
</html>