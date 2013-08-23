<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title>湖北省证券业协会</title>
<link href="<s:url value="/templates/default/static/css/tt.css"/>" rel="stylesheet" type="text/css"/>
<script src="<s:url value="/templates/default/static/js/common.js"/>" type="text/javascript" language="javascript"></script>
<script src="<s:url value="/templates/default/static/js/curvycorners.js"/>" type="text/javascript" language="javascript"></script>
<script src="<s:url value="/templates/default/static/js/jquery-1.3.2.min.js"/>" type="text/javascript" language="javascript"></script>

</head>
<body>
<div id="wraper">
    
    <s:include value="../open/head.jsp" />
    
    <div id="main" class="clearfix">

        <div id="right_down">
            <div id="location">
                <a href="<s:url value='/'/>">首页</a>
                <span>&gt;&gt;</span><span> 全文检索 <a style="color:red">${keyword}</a></span><br/>
            </div>
            <div id="list">
	            <s:if test="entrys.size == 0">
	                    <div class="open_nodata">
	                        <s:text name="nodata"></s:text>
	                    </div>
	            </s:if>
	            <s:else>
	                
		                <ul>
		                <s:iterator value="entrys" var="e">
		                    <li>
		                        <a class="search_left" href="<s:url value='%{url(#e)}'/>" target="_blank">
		                            <s:property value="%{highlight(title)}" escape="false"/></a>
		                        <span>[ <s:date name="publishedDate" format="yyyy-MM-dd"/> ]</span>
		                    </li>
		                </s:iterator>
		                </ul>
	                
	            </s:else>
            </div>
            <s:if test="entrys.size != 0">
             <div id="page">
                <ul class="pagelist">
                        <s:include value="/res/plugins/page.jsp"></s:include>
                </ul>
            </div>
            </s:if>
            
        </div>
    </div>

    <s:include value="foot.jsp" />
</div>

</body>
</html>