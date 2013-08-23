<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache"/>
<title><s:text name="fileTooBig"/></title>
</head>
<body id="tipBody">
<script type="text/javascript">
setTimeout("history.go(-1)",2000);
</script>
<div class="class_title">
	<h4><s:text name="operationTip"/></h4>
</div>
<div class="opertionTip">
	<s:text name="fileTooBig"/>,<s:text name="fileJumpInfo"/>
</div>
</body>
</html>
