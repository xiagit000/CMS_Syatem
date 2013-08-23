<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<div class="banner">
    </div>
    <div class="menu">
    	<ul>
        	<li><a href="<s:url value='/open'/>"><s:text name='homepage'/></a></li>
            <li><a href="<s:url value='/open/news/p1'/>">${titleOne}</a></li>
            <li><a href="<s:url value='/open/news/p2'/>">${titleTwo}</a></li>
            <li><a href="<s:url value='/open/news/p3'/>">${titleThree}</a></li>
            <li><a href="<s:url value='/open/news/p4'/>">${titleFour}</a></li>
            <li><a href="<s:url value='/open/news/p5'/>">${titleFive}</a></li>
            <li><a href="<s:url value='/open/news/p6'/>">${titleSix}</a></li>
            <li><a href="<s:url value='/open/news/p7'/>">${titleSeven}</a></li>
        </ul>
    </div>
    <div class="login">
			<div class="userLogin">
				<s:if test="currentUser == null">
	        	<form action="<s:url value='/user/login'/>" method="post">
	        	<s:hidden name="noVerifyCode" value="true"></s:hidden>
	        	<label for="username"><s:text name="username"/><s:text name="chineseColon"/></label>
	        		<input type="text" id="username" name="username" class="w100"/>
	            <label for="password"><s:text name="password"/><s:text name="chineseColon"/></label>
	            	<input type="password" id="password" name="password" class="w100"/>
	            <button class="denglu" type="submit"></button>
	            	<button class="zhuce" type="button" onclick="window.location='<s:url value='/user/register'/>'"></button>
	        	</form>
				</s:if>
				<s:else>
					${currentUser.username}<span><s:text name="welcome"/></span>
					<s:if test="#session.right.right >= 777">
						<a href="<s:url value='/admin/manage'/>"><s:text name="systemCenter"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
					</s:if>
        			<a href="<s:url value='/personal/info'/>"><s:text name="personalCenter"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
        			<a href="<s:url value='/user/logout'/>?_target=home"><s:text name="exitLogin"/></a>
				</s:else>
        	</div>
        	<div class="search">
        		<form action="<s:url value='/open/search'/>" method="post">
	        	   <label for="keyword"><s:text name="instationSearch"/></label>
		           <input type="text" id="keyword" name="keyword" value="<s:text name='keyword'/>"
		            onclick="this.value=''" class="ipt w200"/>
		           &nbsp;&nbsp;
		           <button class="sousuo" type="submit"></button>
        		</form>
        	</div>
    </div>
    <div class="ad_a">
    </div>