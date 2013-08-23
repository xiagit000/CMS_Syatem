<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="applicationLog"/></title>
</head>
<body>
<div class="class_title">
<s:text name="applicationLog"/>
</div>
<table class="list">
	<thead>
		<tr class="w300">
			<th class="number"><s:text name="orderNumber"></s:text></th>
			<th class="dateline"><s:text name="createTime"></s:text></th>
			<th><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
				<td colspan="3">
					<div class="row_left">
					</div>
					<div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
				</td>
			</tr>
	</tfoot>
	<tbody>
			<s:iterator value="logs" var="log" status="status">
				<tr>
					<td class="left">${status.index+1}</td>
					<td><s:date name="createTime"/></td>
					<td class="left">${username}&nbsp;
						<s:text name="%{operation}">
							<s:param>${targetIdentifier}</s:param>
						</s:text>
					</td>
			</tr>
			</s:iterator>
	</tbody>
</table>
</body>
</html>