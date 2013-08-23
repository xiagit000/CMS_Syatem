<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" charset="utf-8" src="<s:url value='/javascript/kindeditor.js'/>"></script>
<script type="text/javascript">
    //初始化显示编辑器
    KE.show({
        id : 'content1',
        allowFileManager : true,
        cssPath : '<s:url value="/styles/editor_index.css"/>',
        imageUploadJson: '<s:url value="/image"/>',
        fileManagerJson: '<s:url value="/image-manage"/>'
    });
</script>