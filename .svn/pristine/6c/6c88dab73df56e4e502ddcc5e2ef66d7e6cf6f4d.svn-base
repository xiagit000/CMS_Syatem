<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>投诉列表</title>
</head>
<body>
<div class="class_title">投诉列表</div>
<table class="list">
    <thead>
        <tr class="w300">
            <th class="number"><s:text name="orderNumber"/></th>
            <th>被投诉公司</th>
            <th>投诉人</th>
            <th>联系方式</th>
            <th>投诉时间</th>
            <th class="operation"><s:text name="operation"></s:text></th>
        </tr>
    </thead>
		<tfoot>
			<s:if test="complaints.size != 0">
				<tr class="toolbar">
					<td colspan="6">
						<div class="row_right">
							<s:include value="../../common/page.jsp"></s:include>
						</div>
						<div class="clear"></div>
					</td>
				</tr>
			</s:if>
		</tfoot>
		<tbody>
        <s:if test="complaints.size != 0">
        <s:iterator value="complaints" var="entry" status="status">
            <tr class="${status.odd ? 'odd':'even'}">
                <td>
                    ${status.index+1}
                </td>
                <td class="left">
                    <s:property value="company"/>
                </td>
                <td class="left">
                    <s:property value="person"/>
                </td>
                <td class="left">
                    <s:property value="contact"/>
                </td>
                <td class="left">
                    <s:date name="createTime" format="yyyy年MM月dd日 E"/>
                </td>
                <td>
                    <a href="<s:url value='/admin/complaint/%{id}/show'/>" ><s:text name="view"></s:text></a> 
                    <a href="<s:url value='/admin/complaint/%{id}/delete'/>" onclick="return delConfirm();">
                        <s:text name="delete"></s:text></a>
                </td>
            </tr>
        </s:iterator>
        </s:if>
        <s:else>
            <tr>
                <td colspan="7" class="center"><s:text name="nodata"/></td>
            </tr>
        </s:else>
    </tbody>
</table>
</body>
</html>