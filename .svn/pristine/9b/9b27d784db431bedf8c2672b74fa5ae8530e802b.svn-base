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
<script type="text/javascript">
setTimeout("history.go(-1)",2000);
</script>
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
    		<h4><s:text name="operationTip"/></h4>
    	</div>
    	<div class="main">
			<form action="<s:url value='/user/find-password'/>" method="post">
			<fieldset>
			<legend><s:text name="noRight"/></legend>
			<div id="todo">
				<a href="#" onclick="history.go(-1);"><s:text name="ifback"/></a>
			</div>
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