<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>node show -- ${node.id}</title>
</head>
<body>
<p>
	<label>name:</label>${node.name}
</p>
<p>
	<label>position:</label>
	${node.position}
</p>
<p>
	<label>display:</label>
	<s:if test="node.display">
		<input type="checkbox" checked="checked"></input>
	</s:if>
	<s:else>
		<input type="checkbox"></input>
	</s:else>
</p>
</body>
</html>