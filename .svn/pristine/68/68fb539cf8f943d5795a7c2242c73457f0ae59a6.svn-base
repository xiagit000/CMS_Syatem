<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="friendlyLink"/><s:text name="list"/></title>
</head>
<body>
<script type="text/javascript" >
function deleteCheck(){
	if($("[type=checkbox]:checked").length==0){
		alert("<s:text name='atLeastOne'><s:param><s:text name='friendlyLink'/></s:param></s:text>");
	}else{
		if(confirm('<s:text name="sureToDelete"/>'))
			document.mainForm.submit();
	}
}
function sort(typeId){
	var sort_href = '<s:url value="/admin/info/friendly-link"/>'+"?typeId=" + typeId;
	go(sort_href);
}
</script>
<div class="class_title">
<s:text name="friendlyLink"/><s:text name="list"/>
</div>
<form action="<s:url value='/admin/info/friendly-link/selected/delete'/>" name="mainForm">
<s:if test="types != null && !types.empty">
<s:select list="types" listKey="id" listValue="name" name="typeId" theme="simple" value="defaultType.id" onchange="sort(this.value)"></s:select>
</s:if>
<table class="list">
	<thead>
		<tr class="w300">
			<th class="number"><s:text name="orderNumber"/></th>
			<th><s:text name="name"/></th>
			<th><s:text name="link"></s:text></th>
			<th><s:text name="linkImage"></s:text></th>
			<th class="position"><s:text name="position"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="6">
				<div class="row_left"></div>
				<div class="row_left">
					<s:if test="types == null || types.empty">
						<input class="btn bw8" onclick="go('<s:url value="/admin/info/friendly-link-type/new"/>')"
					 value="<s:text name='addFriendlyType'/>" type="button"/>
					</s:if>
					<s:else>
						<input class="btn bw2" onclick="go('<s:url value="/admin/info/friendly-link/new"/>')"
						 value="<s:text name='add'/>" type="button"/>
					</s:else>
				</div>
				<s:if test="links.size != 0">
					<div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
				</s:if>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="links.size != 0">
		<s:iterator value="links" var="l" status="status">
			<tr class="${status.odd ? 'odd':'even'}">
				<td>
					${status.index+1}
				</td>
				<td class="left">
					<s:property value="name"/>
				</td>
				<td class="left"><a href="<s:property value='link'/>" target="_blank"><s:property value='link'/></a></td>
				<td>
					<s:if test="image != null">
						<a href="<s:url value='%{image.path}'/>" target="_blank" title="<s:text name='clickToSeeBigImg'/>">
							<img src="<s:url value='%{image.iconImg}'/>" alt="link img" />
						</a>
					</s:if>
					<s:else>
						<s:text name="noImage"></s:text>
					</s:else>
				</td>
				<td><input type="text" value="<s:property value='position'/>" disabled="disabled"/></td>
				<td>
					<a href="<s:url value='/admin/info/friendly-link/%{id}/edit'/>">
						<s:text name="edit"/></a>&nbsp;&nbsp;
					<a href="<s:url value='/admin/info/friendly-link/%{id}/delete'/>"
						 onclick="return delConfirm();">
						<s:text name="delete"></s:text></a>&nbsp;&nbsp;
					<a href="<s:url value='/admin/info/friendly-link/%{id}/shiftUp'/>">
						<s:text name="shiftUp"/></a>&nbsp;&nbsp;
					<a href="<s:url value='/admin/info/friendly-link/%{id}/shiftDown'/>">
						<s:text name="shiftDown"/></a>
				</td>
			</tr>
		</s:iterator>
		</s:if>
		<s:else>
			<tr>
				<td colspan="6" class="center"><s:text name="nodata"/></td>
			</tr>
		</s:else>
	</tbody>
</table>
</form>
</body>
</html>