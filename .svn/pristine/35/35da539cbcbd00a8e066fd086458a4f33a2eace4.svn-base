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
<!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js">
</script>-->

<div id="wraper">
    
    <s:include value="../open/head.jsp" />
    
    <div id="main" class="clearfix">
    <div id="location">
        <a href="<s:url value="/open"/>">首页</a> <span>&gt;&gt;</span> <span><s:iterator
                value="parentMenus" id="pm">
                <s:if test="#pm.link">
                    <a href="${pm.address}">${pm.name}</a>
                    <span class="guid"></span>
                    <span>&gt;&gt;</span>
                </s:if>
                <s:else>
                    <a href="<s:url value='/open/menu/%{#pm.nodeId}'/>">${pm.name}</a>
                    <span class="guid"></span>
                    <span>&gt;&gt;</span>
                </s:else>
            </s:iterator> <span>${menu.name}</span></span>

    </div>
            
            <div id="list2">
                <h2>${entry.title}</h2>
                <h5>本文章未回复会员名单</h5>
                    <table>
                        <tr style="font-weight:bold;background:#DEF5FB;">
                            <td width="5%">序号</td>
                            <td width="20%">姓名</td>
                            <td width="50%">单位</td>
                            <td width="25%">联系方式</td>
                            <!-- <td width="40%" align="center">百分比</td> -->
                        </tr>
                        <s:iterator value="users" var="entry" status="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${username}</td>
                            <td>${appendix}</td>
                            <td>${phone}</td>
                        </tr>
                        </s:iterator>
                        <tr>
                            <td colspan="4" align="right"><s:include value="/res/plugins/page.jsp"></s:include></td>
                        </tr>                       
                    </table>
                
            </div>
            
    </div>
</div>



<s:include value="foot.jsp" />
</div>
        
</body>
</html>
