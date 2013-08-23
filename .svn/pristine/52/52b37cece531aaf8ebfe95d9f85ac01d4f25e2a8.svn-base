<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>${keyword}&nbsp;&nbsp;-&nbsp;&nbsp;<s:text name="mainTitle"/><s:text name="search"/></title>
<s:include value="resources.jsp"></s:include>
</head>
<body>
<div id="waper">
	<s:include value="head.jsp"></s:include>
	<div id="main" class="clearfix">
		<div class="liebiao_left">
		   	<p class="position">您所在的位置：
		   	<span><s:text name="search"/></span>
		   	<span class="guid"></span>
		   	<span>${keyword}</span></p>
		<div id="neirong" class="clearfix">
			<div class="search_massage">
				<div class="open_nodata">
					<s:text name="illagalSearch">
						<s:param>${keyword}</s:param>
					</s:text>
				</div>
			</div>
          </div>
		</div>
        <s:include value="latest-news.jsp"></s:include>
       </div>
    <s:include value="friendly-link.jsp"></s:include>
	<s:include value="foot.jsp"></s:include>
</div>
</body>
</html>