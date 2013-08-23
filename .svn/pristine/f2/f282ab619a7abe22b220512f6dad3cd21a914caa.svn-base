<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="roleList"/></title>
</head>
<body>
<script type="text/javascript" >
function deleteCheck(){
	if($("[type=checkbox]:checked").length==0){
		alert("<s:text name='atLeastOne'><s:param><s:text name='role'/></s:param></s:text>");
	}else{
		if(confirm('<s:text name="sureToDelete"/>'))
			document.mainForm.submit();
	}
}
</script>
<div class="class_title"><s:text name="roleList"/></div>
<form action="<s:url value='/admin/role/selected/delete'/>" name="mainForm">
<table class="list">
	<thead>
		<tr class="w300">
			<th class="select"><s:text name="select"/></th>
			<th><s:text name="name"/></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="3">
					<div class="row_left">
						<input type="button" class="btn bw2" value="<s:text name='add'/>" onclick="go('<s:url value='/admin/role/new'/>');"/>
						<!--<s:if test="roles.size != 0">
						<input type="button" class="btn bw2" value="<s:text name='checkall'/>"
							 onclick="selAll('selectType',1)" />
						<input type="button" class="btn bw2" value="<s:text name='invert'/>"
							 onclick="selAll('selectType',3)" />
						<input type="button" class="btn bw2" value="<s:text name='cancle'/>"
							 onclick="selAll('selectType',2)" />
						<input type="button" class="btn w140" onclick="deleteCheck();"
							 value="<s:text name='deleteSelected'><s:param><s:text name='role'/></s:param></s:text>"/>
						 </s:if>
					--></div>
					<s:if test="roles.size != 0">
					<div class="row_right"><s:include value="../common/page.jsp"></s:include></div>
					</s:if>
					<div class="clear"></div>
				
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="roles.size != 0">
		<s:iterator value="roles" var="r" status="status">
			<tr class="${status.odd ? 'odd':'even'}">
				<td class="center">
					${status.index + 1}
				</td>
				<td class="left">
					${name}
				</td>
				<td>
					<a href="<s:url value='/admin/role/%{id}/edit'/>"><s:text name="edit"/></a>
					&nbsp;&nbsp;
					<a href="<s:url value='/admin/role/%{id}?_method=delete'/>" onclick="return delConfirm();"><s:text name="delete"/></a>
				</td>
			</tr>
		</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="3" class="center"><s:text name="nodata"/></td>
			</tr>
		</s:else>
	</tbody>
</table>
</form>
</body>
</html>