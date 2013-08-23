<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>内部新闻回复</title>
</head>
<body>

    <div class="class_title">内部新闻回复</div>
    
    <form  name="example" action="<s:url value='/admin/news'/>" method="post" enctype="multipart/form-data">
        <table class="info">
            <thead>
                <tr>
                    <th class="two_col_head"><s:text name="section"></s:text></th>
                    <th><s:text name="info"></s:text></th>
                </tr>
            </thead>
            
            <tbody>
                <tr class="odd">
                    <td>回复标题</td>
                    <td><s:property value="revert.title"/>
                    </td>
                </tr>
                <tr>
                <td>附件</td>
                <td>
                    <a href="<s:url value='%{revert.filepath}'/>" target="_blank">${revert.attachmentFileName}</a>
                </td>
            </tr>
                <tr class="even">
                    <td colspan="2">回复内容</td>
                </tr>
            </tbody>
            
        </table>
            <div class="editor">
                     <s:property value="revert.content"  escape="false"/>
            </div>
           <div class="rowb">
            <div class="row_left">
                <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
            </div>
            <div class="clear"></div>
        </div>
    </form>
    
</body>
</html>