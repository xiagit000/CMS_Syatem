<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:text name="mainTitle"></s:text></title>
</head>
<body>
<div class="class_title">
<s:text name="comment"></s:text><s:text name="list"></s:text>
</div>
<table class="list">
	<thead>
		<tr>
			<th class="number"><s:text name="orderNumber"></s:text></th>
			<th class="username"><s:text name="author"></s:text></th>
			<th><s:text name="comment"></s:text></th>
			<th class="dateline"><s:text name="commentTime"></s:text></th>
			<th class="baseunit"><s:text name="vote"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="6">
				<div class="row_right">
					<s:include value="../../common/page.jsp"></s:include>
				</div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<s:if test="comments.size == 0">
			<tr>
				<td colspan="6" class="center"><s:text name="nodata"></s:text></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="comments" id="c" status="s">
				<tr class="${s.odd ? 'odd' : 'even'}">
					<td>${s.index + 1}</td>
					<td>${c.user.username}</td>
					<td class="left">
						<s:property value="#c.content" escape="false"/></td>
					<td><s:date name="#c.addTime"/></td>
					<td>${c.vote}</td>
					<td><a href="${c.id}?_method=delete" onclick="return delConfirm();"><s:text name="delete"/></a>
					</td>
				</tr>
			</s:iterator>
		</s:else>
	</tbody>
</table>
</body>
</html>