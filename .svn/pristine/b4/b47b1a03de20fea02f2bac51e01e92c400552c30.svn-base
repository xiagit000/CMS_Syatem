<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
<s:text name="user"></s:text><s:text name="list"></s:text>
</title>
</head>
<body>
<div class="class_title">
<s:text name="user"></s:text><s:text name="list"></s:text>
</div>
<table class="list">
	<thead>
		<tr>
			<th class="number"><s:text name="orderNumber"></s:text></th>
			<th class="username"><s:text name="username"></s:text></th>
			<th><s:text name="email"></s:text></th>
			<th style="width: 15%;"><s:text name="userLevel"></s:text></th>
			<th class="baseunit"><s:text name="status"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	
	<tbody>
		<s:if test="users.size == 0">
			<tr>
				<td colspan="6" class="center"><s:text name="nodata"></s:text></td>
			</tr>
		</s:if>
		<s:else>
			<s:iterator value="users" id="u" status="status">
				<tr class="${status.odd ? 'odd':'even'}">
					<td>${status.index + 1}</td>
					<td class="left"><s:property value="#u.username"/></td>
					<td class="left"><s:property value="#u.email"/></td>
					<td class="left"><s:text name="%{#u.userRight}"/></td>
					<s:if test="#u.activated">
						<td class="red"><s:text name="hasActivated"></s:text></td>
					</s:if>
					<s:else>
						<td><s:text name="notActivated"></s:text></td>
					</s:else>
					<td>
						<a href="<s:url value='/admin/user/manage/'/>${u.id}"><s:text name="view"></s:text></a>&nbsp;&nbsp;
						<s:if test="currentUser.userRight.right >= #u.userRight.right">
							<s:if test="#u.activated">
								<a href="<s:url value='/admin/user/manage/'/>${u.id}/freeze" 
								    onclick="return disableConfirm();"><s:text name="freeze"></s:text></a>
							</s:if>
							<s:else>
								<a href="<s:url value='/admin/user/manage/'/>${u.id}/activate" 
								    onclick="return enableConfirm();"><s:text name="activate"></s:text></a>
							</s:else>&nbsp;&nbsp;
							<a href="<s:url value='/admin/user/manage/'/>${u.id}/edit">编辑</a>&nbsp;&nbsp;
							<a href="<s:url value='/admin/user/manage/%{#u.id}/resetPassword'/>">重设密码</a>&nbsp;&nbsp;
						</s:if>
                        <s:if test="currentUser.userRight.right == 999">
                          <a href="<s:url value='/admin/user/manage/%{#u.id}'/>?_method=delete" 
                              onclick="return delConfirm();"><s:text name="delete"></s:text></a>
                        </s:if>
					</td>
				</tr>
			</s:iterator>
		</s:else>
	</tbody>
	
	<tfoot>
        <tr class="toolbar">
            <td colspan="6">
                <div class="row_left">
                    <input type="button" value="<s:text name='add'/>" onclick="go('<s:url value="/admin/user/manage/new"/>')" class="btn bw2" />
                </div>
                <div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
</table>
</body>
</html>