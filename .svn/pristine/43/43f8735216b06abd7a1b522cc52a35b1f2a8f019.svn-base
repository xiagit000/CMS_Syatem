<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>内部新闻回复列表</title>
</head>
<body>
<div class="class_title">内部新闻回复列表</div>
<table class="list">
    <thead>
        <tr class="w300">
            <th class="number"><s:text name="orderNumber"/></th>
            <th>回复标题</th>
            <th>回复用户</th>
            <th>回复时间</th>
            <th class="operation"><s:text name="operation"></s:text></th>
        </tr>
    </thead>
       <s:if test="reverts.size != 0">
			<tfoot>
	        <tr class="toolbar">
	            <td colspan="5">
	                <div class="row_left">
                <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
            </div>
	                    <div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
	                <div class="clear"></div>
	            </td>
	        </tr>
	        </tfoot>
      </s:if>
		<tbody>
        <s:if test="reverts.size != 0">
        <s:iterator value="reverts" var="entry" status="status">
            <tr class="${status.odd ? 'odd':'even'}">
                <td>
                    ${status.count}
                </td>
                <td class="left">
                    <s:property value="title"/>
                </td>
                <td class="left">
                    <s:property value="revertUser.username"/>
                </td>
                <td class="left">
                    <s:date name="createTime" format="yyyy年MM月dd日 E"/>
                </td>
                <td><%-- <a href="<s:url value='/admin/revert/%{id}/edit'/>" >编辑</a>&nbsp;&nbsp; --%>
                       <a href="<s:url value='/admin/revert/%{id}?_method=delete'/>" onclick="return delConfirm();"><s:text name="delete"></s:text></a>
                       <a href="<s:url value='/admin/revert/%{id}/show'/>" >查看回复内容</a>
                </td>
            </tr>
        </s:iterator>
        </s:if>
        <s:else>
            <tr>
                <td colspan="5" class="center"><s:text name="nodata"/></td>
            </tr>
        </s:else>
    </tbody>
</table>
</body>
</html>