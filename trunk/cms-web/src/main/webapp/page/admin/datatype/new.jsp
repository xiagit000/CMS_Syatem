<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="add"/><s:text name="%{typename}"/></title>
</head>
<body>
<script type="text/javascript">
$(function(){
	//addRule("#typeName",	"#nameVmsg",	"(bt)",		"(<s:text name='mustFill'/>)");
});
</script>
<div class="class_title">
<s:text name="add"/><s:text name="%{typename}"/>
</div>
<form id="datatype_new" action="<s:url value='%{action}'/>" method="post">
<table class="info">
	<thead>
		<tr>
			<th class="two_col_head">
				<s:text name="section"></s:text>
			</th>
			<th>
				<s:text name="info"></s:text>
			</th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="2">
				<div class="row_left">
					<input class="btn bw2" type="submit" value="<s:text name='ok'/>" />
					<input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
				</div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<tr>
			<td>
				<label for="typeName"><s:text name="name"/></label>
			</td>
			<td>
				<input class="w250" type="text" name="typeName" id="typeName"
					 value="${currentType.name}" maxlength="7"/>
				<span id="nameVmsg" class="vmsg"></span>
				<span class="vhint">
					<span>&#42;</span><s:text name="%{typename}"/><s:text name="maxLength"><s:param>7</s:param></s:text></span>
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>