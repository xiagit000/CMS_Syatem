<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
	<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><decorator:title default=""/>--<s:text name="mainTitle"/></title>
<script type="text/javascript" src="<s:url value='/javascript/jlib/core-min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/hbiur.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/jlib/units/vf.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/rules.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/paging.js'/>"></script>
<script type="text/javascript" src="<s:url value='/javascript/conver.js'/>"></script>
<link href="<s:url value='/res/css/base.css'/>" rel="stylesheet" type="text/css"/>
<link href="<s:url value='/res/css/manage.css'/>" rel="stylesheet" type="text/css"/>
<!--[if IE 6]>
    <link href="<s:url value='/res/css/ie6hack.css'/>" rel="stylesheet" type="text/css"/>
<![endif]--> 
<!--[if IE 7]>
    <link href="<s:url value='/res/css/ie7hack.css'/>" rel="stylesheet" type="text/css"/>
<![endif]--> 
</head>
<body>
<s:include value="flashMsg.jsp"></s:include>
<div id="wrap">
		<div id="head" class="clearfix">
    		<div id="logo">
        		<h1><a href="<s:url value='/admin/manage'/>" title="<s:text name='mainTitle'/>"><s:text name="cms"/></a></h1>
        	</div>
        	<div id="tips">
        		<p>
        			<s:property value="%{currentUser.username}"/>
        			<s:text name="welcome"/>
        			<a href="<s:url value='/admin/manage'/>" class="name"><s:text name="backManage"/></a>
        			<a href="<s:url value='/'/>" class="name"><s:text name="backHome"/></a>
        			<a href="<s:url value='/user/logout'/>" class="name"><s:text name="logout"/></a>
        		</p>
        	</div>
    	</div>
    	<div id="main" class="clearfix">	
    		<s:include value="menu.jsp"></s:include>
        	<div id="course">
        		<decorator:body/>
        	</div>
    	</div>
	</div>
    
    <div id="footer">
    	<p><s:text name="normalCopyRight"/></p>
    </div>
</body>
</html>