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
<link href="<s:url value='/templates/%{#request.template}/static/css/login.css'/>" rel="stylesheet" type="text/css" />
<script src="<s:url value='/javascript/jlib/core-min.js'/>" type="text/javascript"></script>
<script src="<s:url value='/javascript/login.js'/>" type="text/javascript"></script>
</head>
<body>
	<div class="contant">
    	<form class="login" action="<s:url value='/user/login'/>" method="post">
    		<input type="hidden" name="continue" value="${continueURL}"/>
        	<ul>
            	<li><s:text name="username"/>: <input type="text" name="username" class="w150" id="username"/></li>
                <li><s:text name="password"/>: <input type="password" name="password" class="w150" /></li>
                <li><s:text name="verifycode"/>: <input type="text" name="verifyCode" class="w80"/>
                <a href="#" title="<s:text name='clickToChangeVerifyCode'/>">
                	<img alt="<s:text name='verifycode'/>" src="<s:url value='/user/code'/>" class="vfcode" onclick="exchange('<s:url value="/user/code"/>')" id="pic"/>
                </a></li>
                <li class="${failLogin}"><span class="vhint"><s:text name="wrongLogin"/></span></li>
                <li class="${errorCode}"><span class="vhint"><s:text name="errorCode"/></span></li>
                <li class="${notValidate}"><span class="vhint">
                	<a href="mailto:admin@hbiur.gov.cn"><s:text name="notValidate"/></a></span></li>
            </ul>
			<div class="button">
				<input type="submit" value="<s:text name='login'/>" class="btn" /> <input type="reset" value="<s:text name='reset'/>" class="btn" />
			</div>
			<div class="button">
				<a href="<s:url value='/user/find-password'/>" class="wlink"
				 title="<s:text name='selfFindPasswordBack'/>"><s:text name="forgetPassword"/></a>
				 <a href="<s:url value='/user/register'/>" class="wlink"><s:text name="notRegister"/></a>
			</div>
      	</form>
	   	<div class="footer"><!--
	 	<s:text name="loginCopyRight"/>
	 	--></div>
	</div>
</body>
</html>