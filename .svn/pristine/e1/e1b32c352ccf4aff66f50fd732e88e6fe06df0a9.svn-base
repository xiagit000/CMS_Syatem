<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="keywords" content="${entry.keyword}"/>
<meta name="description" content="${entry.description}" />
<title>${description.name}</title>
<s:include value="resources.jsp"></s:include>
</head>
<body>
<div id="waper">
	<s:include value="head.jsp"></s:include>
	<div id="main" class="clearfix">
		<div class="liebiao_leftsingle">
           	<p class="position" >
           		<span class="guid"></span><span>${description.name}</span>
			</p>
            <div id="neirong" class="clearfix">
               <h3  class="margin28">${description.name}</h3>
               <h5 class="margin12">
			   </h5>
               <div class="zhengwen" >
               <s:property value="description.description" escape="false"/>
               </div>
			</div>
		</div>
            
	</div>
	<s:include value="friendly-link.jsp"></s:include>
	<s:include value="foot.jsp"></s:include>
</div>
</body>
</html>