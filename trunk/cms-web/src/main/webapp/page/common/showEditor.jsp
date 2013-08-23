<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%-- <script type="text/javascript" charset="utf-8" src="<s:url value='/javascript/kindeditor.js'/>"></script> --%>
<link rel="stylesheet" href="<s:url value='/javascript/kindeditor/themes/default/default.css'/>" />
<link rel="stylesheet" href="<s:url value='/javascript/kindeditor/plugins/code/prettify.css'/>" />
<script charset="utf-8" src="<s:url value='/javascript/kindeditor/kindeditor-min.js'/>"></script>
<script charset="utf-8" src="<s:url value='/javascript/kindeditor/lang/zh_CN.js'/>"></script>
<script charset="utf-8" src="<s:url value='/javascript/kindeditor/plugins/code/prettify.js'/>"></script>

<script>
    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('textarea[name="content"]', {
        	cssPath : '<s:url value='/javascript/kindeditor/plugins/code/prettify.css'/>',
        	allowFileManager : true,
        	allowFileUpload : false,
        	allowMediaUpload : false,
            allowFlashUpload : false,
            fillDescAfterUploadImage : true,
        	contextPath: '<s:url value="/"/>',
        	uploadJson: '<s:url value="/image-upload"/>',
            fileManagerJson: '<s:url value="/image-manage"/>'
        });
    });
</script>

<%-- <script type="text/javascript">
    //初始化显示编辑器
    KE.show({
        id : 'content1',
        allowFileManager : true,
        cssPath : '<s:url value="/res/css/editor_index.css"/>',
        contextPath: '<s:url value="/"/>',
        imageUploadJson: '<s:url value="/image-upload"/>',
        fileManagerJson: '<s:url value="/image-manage"/>'
    });
</script> --%>