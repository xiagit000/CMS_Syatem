<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>查看投诉</title>
</head>
<body>

<div class="class_title">查看投诉</div>
<table class="info">
    <thead>
        <tr>
            <th class="two_col_head"><s:text name="section"></s:text></th>
            <th><s:text name="info"></s:text></th>
        </tr>
    </thead>
    <tbody>
        <tr class="odd">
            <td>被投诉公司</td>
            <td><s:property value="complaint.company"/></td>
        </tr>
        <tr class="even">
            <td>投诉人</td>
            <td><s:property value="complaint.person"/></td>
        </tr>
        <tr class="odd">
            <td>联系方式</td>
            <td><s:property value="complaint.contact"/></td>
        </tr>
        <tr class="even">
            <td>投诉时间</td>
            <td><s:date name="complaint.createTime" format="yyyy年MM月dd日 E"/></td>
        </tr>
        <tr class="odd">
            <td>投诉内容</td>
            <td><s:property value="complaint.content"/></td>
        </tr>
    </tbody>
    <tfoot>
        <tr class="toolbar">
            <td colspan="2">
                <div class="row_left">
                    <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
                </div>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
</table>
</body>
</html>