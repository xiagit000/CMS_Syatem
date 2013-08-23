<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>查看结果/编辑选项</title>
</head>
<body>

<div class="class_title">查看结果/编辑选项</div>
<span>投票标题：<s:property value="vote.title"/></span><br>
<span>投票说明：<s:property value="vote.content"/></span>
<table class="list">
    <thead>
        <tr class="w300">
            <th class="number"><s:text name="orderNumber"/></th>
            <th>投票项</th>
            <th>结果</th>
            <th>是否其他</th>
            <th class="operation"><s:text name="operation"></s:text></th>
        </tr>
    </thead>
    <tfoot>
        <tr class="toolbar">
            <td colspan="5">
                <div class="row_left"></div>
                <div class="row_left">
                <s:if test="sizeLimit">
                </s:if>
                <s:else>
                    <input class="btn bw3" onclick="go('<s:url value="/admin/vote/%{vote.id}/ticketNew"/>')" 
                       value="增加项" type="button" />
                </s:else>
                    <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>" />
                </div>
                <s:if test="tickets.size != 0">
                    <div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
                </s:if>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
        <tbody>
        <s:if test="tickets.size != 0">
	        <s:iterator value="tickets" var="entry" status="status">
	            <tr class="${status.odd ? 'odd':'even'}">
	                <td>
	                    ${status.index+1}
	                </td>
	                <td class="left">
	                    <s:property value="title"/>
	                </td>
	                <td class="left">
	                    <s:property value="voteCount"/>
	                </td>
	                <td class="left">
	                    <s:if test="other">是</s:if>
	                    <s:else>否</s:else>
	                </td>
	                <td>
	                    <s:if test="other">
	                        <a href="<s:url value='/admin/ticket/%{id}/cancelOhter'/>">取消其他</a> 
	                    </s:if>
	                    <s:else>
	                        <a href="<s:url value='/admin/ticket/%{id}/otherSet'/>">设为其他</a> 
	                    </s:else>
	                    <a href="<s:url value='/admin/ticket/%{id}/delete'/>" onclick="return delConfirm();">删除</a>
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