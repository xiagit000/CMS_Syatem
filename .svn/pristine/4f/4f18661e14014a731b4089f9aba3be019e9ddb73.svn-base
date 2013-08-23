<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title><s:text name="register"/>-${application.systemName }</title>
<link href="<s:url value='/templates/%{#request.template}/static/css/zhuce.css'/>" rel="stylesheet" type="text/css" />
<script src="<s:url value='/javascript/jlib/core-min.js'/>" type="text/javascript"></script>
<script type="text/javascript" src="<s:url value='/javascript/jlib/units/vf.js'/>"></script>
<script src="<s:url value='/javascript/rules.js'/>" type="text/javascript"></script>
<script src="<s:url value='/javascript/login.js'/>" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	//绑定验证规则
	addRule("#name",	"#nameVmsg",	"(bt)(char)(lenb[5,16])(unique[<s:url value='/user/register/try/checkName'/>,name,Y])",		"(<s:text name='mustFill'/>)(<s:text name='illegalChar'/>)(<s:text name='errorLength'/>)(<s:text name='usernameExist'/>)");			
	addRule("#pass",	"#passVmsg",	"(bt)(len[6,10])",				"(<s:text name='mustFill'/>)(<s:text name='errorLength'/>)");			
	addRule("#repass",	"#repassVmsg",	"(bt)(equal[pass])",					"(<s:text name='mustFill'/>)(<s:text name='errorRepeatPassword'/>)");			
	addRule("#email",	"#emailVmsg",	"(bt)(email)(unique[<s:url value='/user/register/try/checkEmail'/>,email,Y])",					"(<s:text name='mustFill'/>)(<s:text name='errorEmail'/>)(<s:text name='emailExist'/>)");			
});
</script>
</head>
<body>
	
	<!--头部-->
    <div class="head">
		<h1>
        	<a target="_top" href="<s:url value='/'/>">${application.systemName }</a> 
        </h1> 
	</div>
	<div class="contant">
    <!--注册信息-->
    	<div class="title">
    		<h4><s:text name="fillRegisterForm"/></h4>
    	</div>
    	<form action="<s:url value='/user/register'/>" method="post" name="reg" onsubmit="return vform(this);" class="main">
        	
            	<ul>
        			<li> <div class="input">
        				<label> <s:text name="username"></s:text><s:text name="chineseColon"/></label>
        				<input type="text" id="name" name="username" class="w200"/>
        				<span id="nameVmsg" class="vmsg"></span>
						<span class="vhint"><span>&#42;</span><s:text name="usernameLimit"/></span>
        			</div></li>
    				<li><div class="input">
    					<label><s:text name="password"></s:text><s:text name="chineseColon"/></label>
    					<input type="password" id="pass" name="password" class="w200"/>
    					<span id="passVmsg" class="vmsg"></span>
						<span class="vhint"><span>&#42;</span><s:text name="passwordLimit"/></span>
    				</div></li>
        			<li><div class="input">
        				<label><s:text name="repeatPassword"></s:text><s:text name="chineseColon"/></label>
        				<input type="password" id="repass" name="repeatPassword" class="w200"/>
        				<span id="repassVmsg" class="vmsg"></span>
						<span class="vhint"><span>&#42;</span></span>
        			</div></li>
    				<li><div class="input">
    					<label><s:text name="email"></s:text><s:text name="chineseColon"/></label>
    					<input type="text" id="email" name="email"  class="w200"/>
    					<span id="emailVmsg" class="vmsg"></span>
						<span class="vhint"><span>&#42;</span></span>
    				</div></li>
        			<li><div class="input">
        			<label><s:text name="verifycode"></s:text><s:text name="chineseColon"/></label>
        			<input type="text" name="verifyCode" class="w100"/>
        			<a href="#" title="<s:text name='clickToChangeVerifyCode'/>">
        			<img alt="<s:text name='verifycode'/>" src="<s:url value='/user/code'/>" class="vfcode"
        				 onclick="exchange('<s:url value="/user/code"/>')" id="pic"/>
        			</a></div></li>
            	</ul>
            
            <div class="button">
        	<input type="submit" name="submit"  id="subBtn" disabled="disabled" value="<s:text name='register'/>" class="buttona" />
        	<input type="reset" name="submit2" value="<s:text name='reset'/>" class="buttona" />
            </div>
    	</form>
    </div>
    <!--版权信息-->
    <div class="footer">
    	<s:text name="registerCopyRight"/>
    </div>
</body>
</html>
