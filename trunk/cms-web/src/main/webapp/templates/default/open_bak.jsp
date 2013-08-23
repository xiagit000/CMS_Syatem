<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title>${application.systemName }</title>
<s:include value="open/resources.jsp"></s:include>
</head>
<body>
<div id="waper">
	<s:include value="open/head.jsp"></s:include>
        <div id="main" class="clearfix">
        	<div id="col_left" class="clearfix">
            	<%-- 第一区块 --%>
            	<div class="news">
                	<p class="title">${blocks[0].name } <span><a href="<s:url value='/open/menu/%{blocks[0].node.id}'/>">更多 &hellip;</a></span></p>
                    <ul>
                    	<s:iterator value="entrysMap[blocks[0].id]" id="entry" status="st0">
                    	<li><a href="<s:url value='%{url(#entry)}'/>">${entry.title }</a></li>
                    	</s:iterator>
                    </ul>
                </div>
                
            </div>
            <div id="col_middle" class="clearfix">
            	<div class="main_view">
                    <div class="window">
                        <div class="image_reel clearfix">
                        	<s:iterator value="picNews" var="pn">
                        	<s:set name="palt" value="%{image.description!=null?image.description:''}"></s:set>
	                            <a href="<s:url value='%{url(#entry)}'/>">
	                            	<img src="<s:url value='%{image.iconImg}'/>" alt="${palt}"/>
	                            </a>
                        	</s:iterator>
                        </div>
                    </div>
                    <div class="paging clearfix">
                    	<s:iterator value="picNews" var="pn" status="status">
	                        <a href="<s:url value='%{url(#entry)}'/>" rel="${status.index+1}">${status.index+1}</a>
                    	</s:iterator>
                    </div>
                </div>
            </div>
            <div id="col_right" class="clearfix">
            	<div class="login">
                	<p class="center">用户登录</p>
                	<s:if test="currentUser == null">
                	<div id="tabs2" class="clearfix">
                    	
                        <ul>
                            <li class="home"><a href="#" ><span>学员</span></a></li>
                            <li><a href="#" ><span>教师</span></a></li>
                            <li><a href="#" ><span>管理员</span></a></li>
                            
                        </ul>
                    </div>
                    <fieldset id="log">
                    	<form action="<s:url value='/user/login'/>" method="post">
                    		<input type="hidden" name="noVerifyCode" value="true" /> 
                            <p class="line">
                                <label for="name">用户名</label>
                                <input type="text" name="username" class="w150" id="username"/>
                            </p>
                            <p class="line">
                                <label for="password">密&nbsp;&nbsp;  码</label>
                                <input type="password" name="password" class="w150" />
                            </p>
                            <p id="btn" class="line clearfix">
                            	<button type="submit" class="btn1"></button>
                            	<button type="reset" class="btn2"></button>
                                                     
                            </p>
                      </form>
                    </fieldset>
	                   <p class="help"> <a  href="#">帮助找回密码？</a></p>
                	</s:if>
                	<s:else>
                		<div id="welcome">
                			<span>${currentUser.username}<s:text name="welcome"></s:text></span>
                			<ul>
                				<li><a href="<s:url value='/admin/manage'/>"><s:text name="backManage"/>&gt;&gt;</a></li>
                				<li><a href="<s:url value='/user/logout'/>"><s:text name="logout"/>&gt;&gt;</a></li>
                			</ul>
                		</div>
                	</s:else>
                </div>
            </div>
        </div>
        <div id="ad" class="clearfix">
        	<div class="ad_main_view">
                    <div class="ad_window">
                        <div class="ad_image_reel">
                            <a href="#"><img src="<s:url value='/templates/%{#request.template}/static/img/ad.jpg'/>" alt="" /></a>
                         
                       </div>
                    </div>
                    <div class="ad_paging">
                        <a href="#" rel="1">1</a>
                     
                       
                    </div>
                </div>
        </div>
        <div id="main" class="clearfix">
        	<div id="down_left">
        		<%-- 第二区块 --%>
            	<div class="news">
            		<p class="title">${blocks[1].name } <span><a href="<s:url value='/open/menu/%{blocks[1].node.id}'/>">更多 &hellip;</a></span></p>
                    <ul>
                    	<s:iterator value="entrysMap[blocks[1].id]" id="entry" status="st1">
                    	<li><a href="<s:url value='%{url(#entry)}'/>">${entry.title }</a></li>
                    	</s:iterator>
                    </ul>
                </div>
                
            </div>
            <div id="down_middle">
            	<%-- 第三区块 --%>
            	<div id="zhaosheng" class="clearfix">
                	<p class="zhengce2"><a href="<s:url value='/open/menu/%{blocks[2].node.id}'/>" title="${blocks[2].name }">${blocks[2].name }</a></p> 
                	<ul>
                    	<s:iterator value="entrysMap[blocks[2].id]" id="entry" status="st2">
                    	<li><a href="<s:url value='%{url(#entry)}'/>">${entry.title }</a></li>
                    	</s:iterator>
                    </ul>
                </div>
                <%-- 第四区块 --%>
                <div id="zhaosheng" class="clearfix">
                	<p class="jianzhang2"><a href="<s:url value='/open/menu/%{blocks[3].node.id}'/>" title="${blocks[3].name }">${blocks[3].name }</a></p> 
                	<ul>
                    	<s:iterator value="entrysMap[blocks[3].id]" id="entry" status="st3">
                    	<li><a href="<s:url value='%{url(#entry)}'/>">${entry.title }</a></li>
                    	</s:iterator>
                    </ul>
                </div>
            </div>
            <div id="down_right">
            	<%-- 第五区块 --%>
            	<div class="notice">
                	<p class="title2">
                    	${blocks[4].name }
                    </p>
                	<ul>
                    	<s:iterator value="entrysMap[blocks[4].id]" id="entry" status="st4">
                    	<li><a href="<s:url value='%{url(#entry)}'/>">${entry.title }</a></li>
                    	</s:iterator>
                    </ul>
                    <p class="more"><a href="<s:url value='/open/menu/%{blocks[4].node.id}'/>">更多 &hellip;</a></p>
                </div>
            </div>
        </div>
        <div id="main" class="clearfix">
        	<div id="last_left">
        		<%-- 第六区块 --%>
                <div class="zhuanye">
                    <p class="title4">${blocks[5].name }<span><a href="<s:url value='/open/menu/%{blocks[5].node.id}'/>">更多 &hellip;</a></span></p>
                    <ul>
                    	<s:iterator value="entrysMap[blocks[5].id]" id="entry" status="st5">
                    	<li><a href="<s:url value='%{url(#entry)}'/>">${entry.title }</a></li>
                    	</s:iterator>
                    </ul>
                    
                </div>
            </div>
        	<div id="last_right">
        		
        		
            </div>
        </div>
        
        <s:include value="open/friendly-link.jsp"></s:include>
         
         
        <s:include value="open/foot.jsp"></s:include>
    </div>
</body>
</html>