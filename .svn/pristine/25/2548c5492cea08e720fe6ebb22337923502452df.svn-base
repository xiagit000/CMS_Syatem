<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="%{typename}"/><s:text name="list"/></title>
</head>
<body>
<script type="text/javascript" >
function deleteCheck(){
	if($("[type=checkbox]:checked").length==0){
		alert("<s:text name='atLeastOne'><s:param><s:text name='dataType'/></s:param></s:text>");
	}else{
		if(confirm('<s:text name="sureToDelete"/>'))
			document.mainForm.submit();
	}
}
</script>
<div class="class_title">
<s:text name="%{typename}"/><s:text name="list"/>
</div>
<form action="<s:url value='%{action}/selected/delete'/>" name="mainForm">
<table class="list">
	<thead>
		<tr class="w300">
			<th class="number"><s:text name="orderNumber"/></th>
			<th><s:text name="name"/></th>
			<th class="position"><s:text name="position"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="4">
					<div class="row_left">
						<input type="button" class="btn bw2" value="<s:text name='add'/>" onclick="go('<s:url value="%{action}"/>/new');"/>
					</div>
					<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="types.size != 0">
		<s:iterator value="types" id="type" status="status">
			<tr class="${status.odd ? 'odd':'even'}">
				<td class="center">
					${status.index+1}
				</td>
				<td class="left">
					<s:property value="#type.name"/>
				</td>
				<td><input type="text" value="${type.position}" disabled="disabled"/></td>
				<td>
					<a href="<s:url value='%{action}/%{#type.id}/edit'/>">
						<s:text name="edit"/></a>&nbsp;&nbsp;
					<a href="<s:url value='%{action}/%{#type.id}/delete'/>"
						 onclick="return delConfirm();">
						<s:text name="delete"></s:text></a>&nbsp;&nbsp;
					<a href="<s:url value='%{action}/%{#type.id}/shiftUp'/>">
						<s:text name="shiftUp"/></a>&nbsp;&nbsp;
					<a href="<s:url value='%{action}/%{#type.id}/shiftDown'/>">
						<s:text name="shiftDown"/></a>
				</td>
			</tr>
		</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="4" class="center"><s:text name="nodata"/></td>
			</tr>
		</s:else>
	</tbody>
</table>
</form>
</body>
</html>