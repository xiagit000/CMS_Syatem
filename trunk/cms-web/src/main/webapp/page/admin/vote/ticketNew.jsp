<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>新增投票项</title>
</head>
<body>

    <script src="<s:url value='/javascript/vote/ticket.form.js'/>" type="text/javascript"></script>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>

    <div class="class_title">新增投票项</div>
    
    <form action="<s:url value='/admin/ticket'/>" method="post" >
        <input type="hidden" name="voteId" value="${vote.id}"/>
        <table class="info">
            <thead>
                <tr>
                    <th class="two_col_head"><s:text name="section"></s:text></th>
                    <th><s:text name="info"></s:text></th>
                </tr>
            </thead>
            
            <tbody>
                <tr class="even">
                    <td>投票项名称</td>
                    <td>
	                    <input name="ticket.title" class="w300" id="title" type="text"/>
	                    <span id="titleVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
                    </td>
                </tr>
                <tr class="odd">
                    <td>是否其他</td>
                    <td>
	                    <input type="radio" name="ticket.other" id="other" value="true"/>是 &nbsp; &nbsp;
	                    <input type="radio" name="ticket.other" id="other" value="false" checked="checked"/>否
                    </td>
                </tr>
            </tbody>
            
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
            
        </table>
    </form>
    
</body>
</html>