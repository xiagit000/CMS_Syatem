<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s"%>
  <div id="liebiao_right">
            	
   	<div class="article">
       	<p class="title0">
           	最新文章
           </p>
       	<ul>
       		<s:iterator value="latestNews" var = "ln" status="status">
            	<li class="${application.highlight? (hot?'hot':'normal') : ('normal') }">
            	<a href="<s:url value='%{url(#ln)}'/>">${ln.title}</a>
            	<s:if test="#application.highlight && hot">
	            	<img src="<s:url value='/templates/%{#request.template}/static/img/new.gif'/>" alt="new"/>
            	</s:if>
            	</li>
       		</s:iterator>
        </ul>
           
       </div>
       <%-- 网上报名、在线考试 --%>
		<s:include value="link-right.jsp"></s:include>
   </div>