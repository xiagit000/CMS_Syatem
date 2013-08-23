<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="keywords" content="${entry.keyword}"/>
<meta name="description" content="${entry.description}" />
<title>${entry.title}</title>
<script src="<s:url value="/templates/default/static/js/jquery-1.8.0.min.js"/>" type="text/javascript"></script>
<link href="<s:url value="/templates/default/static/css/tt.css"/>" rel="stylesheet" type="text/css"/>
<%-- <script src="<s:url value="/templates/default/static/js/common.js"/>" type="text/javascript"></script>
<script src="<s:url value="/templates/default/static/js/curvycorners.js"/>" type="text/javascript" ></script> --%>
<script type="text/javascript" src="<s:url value="/templates/default/static/js/iepngfix_tilebg.js"/>"></script>

<%-- <s:include value="resources.jsp"></s:include> --%>
<script type="text/javascript">
$(document).ready(
	function(){
		$.get('<s:url value='/open/entry/%{entry.id}/hits'/>',function(data){
			$("#hits").html('点击次数：'+data+'次');
		})
	}
);
</script>
</head>

<body>
<!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js">
</script>-->

<div id="wraper">
    <s:include value="../open/head.jsp"></s:include>
    
    <div id="main" class="clearfix">
        <div id="location">
            <a href="<s:url value="/open"/>">首页</a>
            <span>&gt;&gt;</span>
            <span>
	            <s:iterator value="parentMenus" id="pm">
		            <s:if test="#pm.link">
		               <s:if test="menu.nodeId == 63 ">
                           <a href="<s:url value='/association'/>">${pm.name}</a><span class="guid"></span>
                           <span>&gt;&gt;</span>
                        </s:if>
                        <s:else>
                            <a href="${pm.address}">${pm.name}</a><span class="guid"></span>
                            <span>&gt;&gt;</span>
                         </s:else>
	                </s:if>
	                <s:else>
                        <a href="<s:url value='/open/menu/%{#pm.nodeId}'/>">${pm.name}</a><span class="guid"></span>
                        <span>&gt;&gt;</span>
                    </s:else>
                </s:iterator>
                <span><a href="<s:url value='/open/menu/%{menu.nodeId}'/>">${menu.name}</a></span>
            </span>
        </div>

        <div id="right_down">
            <div id="article">
                <h2>${entry.title}</h2>
                <h5 class="margin12">
                    <s:date name="entry.publishedTime" format="%{getText('dateFormat')}" nice="false"/>
                    <span id="hits"></span>
                </h5>
                <s:if test="entry.summary != null && entry.summary neq ''">
	                <div class="zhaiyao">
	                     <p><s:text name="summary"/>：${entry.summary}</p>
	                </div>
                </s:if>
                <div class="zhengwen">
                    <s:if test="entry.image != null">
                        <div class="art_pic">
                            <a href="<s:url value='%{entry.image.path}'/>" target="_blank" 
                                title="<s:text name='clickToSeeBigImg'/>">
                                <img src="<s:url value='%{entry.image.iconImg}'/>" 
                                    alt="${entry.image.description != null ? entry.image.description : ''}" />
			                </a>
			            </div>
			        </s:if>
			        <s:property value="%{content}" escape="false"/><br/>
			        
			    </div>
			    <s:if test="totalPage > 1">
                        <div id="page">
                            <ul class="pagelist">
                                <li><a href="?page=1" >首页</a></li>
                                <s:iterator var="i" begin="1" end="%{totalPage}" status="s">
                                <li>
                                    <a href="?page=${s.count}" ${s.count == currentPage?"style='background-color:#69d;color: #fff;'":""}>
                                        ${s.count}</a>
                                </li>
                                </s:iterator>
                                <li><a href="?page=${totalPage}" >末页</a></li>
                            </ul>
                        </div>
                    </s:if>
                    
                    
                    <s:if test="!entry.attachEmpty">
	                    <div id="download">
	                    
		                    <s:if test="entry.isPublicAccess">
		                        <s:iterator value="entry.attachments" var="ea" status="s">
		                           <p>
		                               <%-- <s:text name="attachment"/>${s.index+1}：<a href="<s:url value='%{filepath}'/>" target="_blank">${orginalName}</a> --%>
		                              <s:text name="attachment"/>${s.index+1}：<a href="<s:url value='/open/entry/%{entry.id}/downFile?content=%{filepath}&title=%{orginalName}'/>" target="_blank">${orginalName}</a>
		                           </p>
		                        </s:iterator>
		                    </s:if>
		                    
		                    <s:if test="!entry.isPublicAccess">
		                    
		                      <s:if test="accessable && #session.right.getRight() >= 0">
		                           <s:iterator value="entry.attachments" var="ea" status="s">
		                               <p>
		                                   <%-- <s:text name="attachment"/>${s.index+1}：<a href="<s:url value='%{filepath}'/>" target="_blank">${orginalName}</a> --%>
		                                   <s:text name="attachment"/>${s.index+1}：<a href="<s:url value='/open/entry/%{entry.id}/downFile?content=%{filepath}&title=%{orginalName}'/>" target="_blank">${orginalName}</a>
		                               </p>
		                            </s:iterator>
		                        </s:if>
		                        <s:else>
		                            <p class="hiddenAttach">
		                                <s:text name="%{currentUser==null?'loginToAcess':'roleToAcess'}"></s:text><br/><br/>
		                                    <s:iterator value="entry.attachments" var="ea" status="s">
		                                    <p><s:text name="attachment"/>${s.index+1}：${orginalName}</p>
		                                </s:iterator>
		                            </p>
		                        </s:else>
		                        
		                    </s:if>
		                    
	                    </div>
                    </s:if>
                    
	            <!--zhengwen-->
				</div>
            
        </div>
        <s:if test="#application.allowComment && entry.belonged.name.equals('通知公告')">
        <div id="comment">
        
        <script type="text/javascript">
            $("#comment .comcont ul li:last-child").css({
            	   "border-bottom":"none"
        	});
        </script>
        
	        <div class="speak">
			    <h4 class="speaking_title">
			        <a href="<s:url value='/open/comment/%{entry.id}'/>">网上回复或网上报名</a>&nbsp;&nbsp;
			        <span id="contentVmsg" style="color:red">
			          <s:if test="msgs.size != 0"><s:property value="%{msgs.flash}" escape="false"/></s:if>
			        </span>
			    </h4>
            <s:include value="comment.jsp"></s:include>
            </div>
            
        </div>
        </s:if>
    </div>

    <s:include value="foot.jsp" />
    
</div>

</body>
</html>