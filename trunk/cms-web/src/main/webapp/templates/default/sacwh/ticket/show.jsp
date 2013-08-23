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
    
    <s:include value="../../open/head.jsp" />
          
    
    <div id="main" class="clearfix">

        <div id="right_down">
            <div id="location">
                <a href="<s:url value='/'/>">首页</a>
                <span>&gt;&gt;</span><span> <a href="<s:url value='/ticket'/>">投票列表</a></span>
                <span>&gt;&gt;</span><span> 投票详情</span><br/>
                
            </div>
            <div id="list2">
                <ul>
	                <li><span class="votetitle"> 投票标题：</span><span class="votetitle"><s:property value="vote.title"/></span></li>
	                <li><span class="votetitle"> 投票说明：</span><span class="votetitle"><s:property value="vote.content"/></span></li>
                </ul>
                <table>
                    <tr style="font-weight:bold;background:#DEF5FB;">
	                    <td width="70%" align="center">投票选项</td>
	                    <td width="30%" align="center">投票结果</td>
	                    <!-- <td width="40%" align="center">百分比</td> -->
	                </tr>
	               <s:if test="tickets.size != 0">
			            <s:iterator value="tickets" var="entry" status="status">
			            <tr>
                            <td><s:property value="title"/></td>
                            <td align="center"><font style="color:red;padding-right:5px;">
                                <s:property value="voteCount"/></font>票</td>
                        </tr>
			            </s:iterator>
	               </s:if>
	            </table>
            </div>
            
            <s:if test="tickets.size != 0">
             <div id="page">
                <ul class="pagelist">
                        <s:include value="/res/plugins/page.jsp"></s:include>
                </ul>
            </div>
            </s:if>
            
        </div>

</div>


<s:include value="open/foot.jsp" />
</div>
        
</body>
</html>
