<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="mainTitle"></s:text></title>
</head>
<body>
<div class="index_block">
	<h3><s:text name="latestNews"/></h3>
	<ul class="ulList1" >
		<s:iterator value="latestNews" var="ln">
			<li><a href="<s:url value='/open/entry/%{id}'/>" target="_blank">
				<span><s:date name="#ln.timeline" format="[yyyy-MM-dd]"/></span>
				${ln.title}</a>
			<s:if test="#application.highlight && hot">
	            	<img src="<s:url value='/res/images/new.gif'/>" alt="new"/>
            	</s:if>
			</li>
		</s:iterator>
	</ul>
</div>
</body>
</html>