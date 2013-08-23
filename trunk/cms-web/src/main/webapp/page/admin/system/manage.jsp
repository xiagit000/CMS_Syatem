<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
<s:text name="applicationSettings"></s:text>
</title>
</head>
<body>
<% request.setAttribute("colspan","5"); %>
<script type="text/javascript">
//<![CDATA[
$(function(){
	//addRule("#baseInfo_hostName",	"#hostNameVmsg",	"(url)",	"<s:text name='system_hostname_error' />");
	//addRule("#hightlightInfo_highlightDays",	"#highlightDaysVmsg",	"(number)",	"<s:text name='errorFormat'/>");
	//addRule("#attachmentInfo_attachmentSize",	"#attachmentSizeVmsg",	"(number)",	"<s:text name='errorFormat'/>");
	$("input").blur();
});           
           
//]]>
</script>
<div class="class_title">
<s:text name="applicationSettings"></s:text>
</div>
<form id="system_manage" name="systemForm" method="post" action="<s:url value="/admin/system/manage/info/update" />">
<table class="info">
	<thead>
		<tr>
			<th class="two_col_head"><s:text name="section"></s:text></th>
			<th><s:text name="info"></s:text></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><s:text name="system_name" /></td>
			<td><input type="text" class="w500" name="baseInfo.systemName" value="${baseInfo.systemName }"/></td>
		</tr>
		<tr>
			<td><s:text name="system_keyword" /></td>
			<td><input type="text" class="w500" name="baseInfo.keyWord" value="${baseInfo.keyWord }"/></td>
		</tr>
		<tr>
			<td><s:text name="system_description" /></td>
			<td><textarea class="w500 h100" name="baseInfo.description" >${baseInfo.description }</textarea></td>
		</tr>
		<tr>
			<td><s:text name="system_copyright" /></td>
			<td><textarea class="w500 h100" name="baseInfo.copyRight" >${baseInfo.copyRight }</textarea></td>
		</tr>
		<tr>
			<td><s:text name="system_hostname" /></td>
			<td>
				<input id="baseInfo_hostName" type="text" class="w250" name="baseInfo.hostName" value="${baseInfo.hostName }"/>
				<span id="hostNameVmsg" class="vmsg"></span><span class="vhint"><s:text name="system_hostname_note" /></span>
			</td>
		</tr>
		<tr>
			<td><s:text name="system_highlight" /></td>
			<td>
				<label><input type="radio" name="hightlightInfo.highlight" value="true" <s:if test="hightlightInfo.highlight">checked="checked"</s:if> /> 是  </label>
				<label><input type="radio" name="hightlightInfo.highlight" value="false" <s:if test="!hightlightInfo.highlight">checked="checked"</s:if> /> 否 </label>
				<span id="highlightVmsg" class="vmsg"></span><span class="vhint"><s:text name="system_highlight_note" /></span>
			</td>
		</tr>
		<tr>
			<td><s:text name="system_highlightdays" /></td>
			<td><input id="hightlightInfo_highlightDays" type="text" class="w250" name="hightlightInfo.highlightDays" value="${hightlightInfo.highlightDays }"/>
			<span id="highlightDaysVmsg" class="vmsg"></span><span class="vhint"><s:text name="day" /></span></td>
		</tr>
		<tr>
			<td><s:text name="system_allowattachment" /></td>
			<td>
				<label><input type="radio" name="attachmentInfo.allowAttachment" value="true" <s:if test="attachmentInfo.allowAttachment">checked="checked"</s:if> /> 是  </label>
				<label><input type="radio" name="attachmentInfo.allowAttachment" value="false" <s:if test="!attachmentInfo.allowAttachment">checked="checked"</s:if> /> 否 </label>
			</td>
		</tr>
		<tr>
			<td><s:text name="system_attachmentsize" /></td>
			<td>
				<input id="attachmentInfo_attachmentSize" type="text" class="w250" name="attachmentInfo.attachmentSize" value="${attachmentInfo.attachmentSize }"/>
				<span id="attachmentSizeVmsg" class="vmsg"></span><span class="vhint"><s:text name="system_attachmentsize_note" /></span>
			</td>
		</tr>
		<tr>
			<td><s:text name="system_attachmenttype" /></td>
			<td>
				<input id="attachmentInfo_attachmentType" type="text" class="w250" name="attachmentInfo.attachmentType" value="${attachmentInfo.attachmentType }"/>
				<span id="attachmentTypeVmsg" class="vmsg"></span><span class="vhint"><s:text name="system_attachmenttype_note" /></span>
			</td>
		</tr>
		<tr>
			<td><s:text name="system_attachmentextension" /></td>
			<td>
				<input id="attachmentInfo_attachmentExtension" type="text" class="w250" name="attachmentInfo.attachmentExtension" value="${attachmentInfo.attachmentExtension}"/>
				<span id="attachmentExtensionVmsg" class="vmsg"></span><span class="vhint"><s:text name="system_attachmentextension_note" /></span>
			</td>
		</tr>
		<tr>
			<td><s:text name="system_urlPattern" /></td>
			<td>
				<input id="urlPattern" type="text" class="w450" name="urlPattern" value="${urlPattern }"/>
				<span class="vhint">
					<s:text name="system_urlPattern_note" >
						<s:param>news/%{news_year}/%{news_month}/%{news_id}</s:param>
						<s:param>%{news_year}, %{news_month}, %{news_day}, %{news_id}</s:param>
						<s:param>%{news_id}</s:param>
					</s:text>
				</span>
			</td>
		</tr>
		<s:if test="commentEnabled">
			<tr>
				<td><s:text name="system_allowcomment" /></td>
				<td>
					<label><input type="radio" name="allowComment" value="true" <s:if test="allowComment">checked="checked"</s:if> /> <s:text name="yes" />  </label>
					<label><input type="radio" name="allowComment" value="false" <s:if test="!allowComment">checked="checked"</s:if> /> <s:text name="no" /> </label>
				</td>
			</tr>
		</s:if>
		<s:if test="ldapEnabled">
			<tr>
				<td><s:text name="system_allowLDAP" /></td>
				<td>
					<label><input type="radio" name="allowLDAP" value="true" <s:if test="allowLDAP">checked="checked"</s:if> /> <s:text name="yes" />  </label>
					<label><input type="radio" name="allowLDAP" value="false" <s:if test="!allowLDAP">checked="checked"</s:if> /> <s:text name="no" /> </label>
				</td>
			</tr>
		</s:if>
	</tbody>
</table>
<div class="rowb">
	<div class="row_left"><input class="btn bw2" type="submit" name="button" value="<s:text name='save'/>" /></div>
	<div class="clear"></div>
</div>
</form>
</body>
</html>