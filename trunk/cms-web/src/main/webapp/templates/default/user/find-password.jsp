<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title>${application.systemName }</title>
<link href="<s:url value='/templates/%{#request.template}/static/css/zhuce.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<!--头部-->
    <!--头部-->
    <div class="head">
    	<h2><a target="_top" href="<s:url value='/open'/>">
		</a></h2>
	</div>
	<div class="contant">
    <!--注册信息-->
    	<div class="title">
    		<h4><s:text name="forgetPassword"/></h4>
    	</div>
    	<div class="main">
			<form action="<s:url value='/user/find-password'/>" method="post">
			<fieldset>
			<legend><s:text name="findPassword"/></legend>
			<ul>
        		<li><div class="input">
        			<label><s:text name="username"/></label>
        			<input type="text" id="name" name="username"/>
        		</div></li>
        		<li><div class="input">
        			<label><s:text name="email"/></label>
        			<input type="text" id="email" name="email"/>
        		</div></li>
        		<li><div class="button">
	        		<input type="submit" value="<s:text name='submit'/>"/>
        		</div></li>
        	</ul>
			</fieldset>
			</form>
    		<!-- 登录表单 End -->
        </div>
    </div>
    <!--版权信息-->
    <div class="footer">
    	<s:text name="registerCopyRight"/>
    </div>
</body>
</html>