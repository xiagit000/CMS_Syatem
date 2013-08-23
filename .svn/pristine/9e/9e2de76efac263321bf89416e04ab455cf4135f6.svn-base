<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="${entry.keyword}" />
<meta name="description" content="${entry.description}" />
<title>${entry.title}</title>
<link href="<s:url value="/templates/default/static/css/tt.css"/>"
	rel="stylesheet" type="text/css" />
<script src="<s:url value="/templates/default/static/js/common.js"/>"
	type="text/javascript"></script>
<script
	src="<s:url value="/templates/default/static/js/curvycorners.js"/>"
	type="text/javascript"></script>
<script
	src="<s:url value="/templates/default/static/js/jquery-1.3.2.min.js"/>"
	type="text/javascript"></script>

</head>
<%-- <body>
<div id="waper">
	<s:include value="head.jsp"></s:include>
	<div id="main" class="clearfix">
           	<p class="position" >您所在的位置：
				<s:iterator value="parentMenus" id="pm">
					<s:if test="#pm.link">
						<a href="${pm.address}">${pm.name}</a><span class="guid"></span>
					</s:if>
					<s:else>
						<a href="<s:url value='/open/menu/%{#pm.nodeId}'/>">${pm.name}</a><span class="guid"></span>
					</s:else>
				</s:iterator>
				<s:if test="menu.link">
					<a href="${menu.address}">${menu.name}</a>
				</s:if>
				<s:else>
					<a href="<s:url value='/open/menu/%{menu.nodeId}'/>">${menu.name}</a>
				</s:else>
				<span class="guid"></span>
				<span>
					<a href="<s:url value='/open/entry/%{entry.id}'/>">${entry.title}</a>
				</span>
				<span class="guid"></span><span><s:text name="comment"></s:text></span>
			</p>
            <div id="neirong" class="clearfix">
               <h3  class="margin28">${entry.title}</h3>
               <h5 class="margin12"><s:text name="commentTip"></s:text></h5>
               <s:if test="comments.size == 0">
					<div class="speaking_massage">
						<a href="#comment">
						<s:text name="noneComment"></s:text>
						</a>
					</div>
				</s:if>
				<s:else>
				 	<s:iterator value="comments" var="c" status="s">
					   <div class="speaking_massage">
							<div class="massage_head clearfix">
								<span class="massage_left">${username}</span>
								<span class="massage_right">
									<s:date name="addTime" format="%{getText('tailDateFormat')}"/>
								</span>
							</div>
							<p><s:property value="content" escape="false"/></p>
						</div>
				 	</s:iterator>
				</s:else>
			</div>
			<s:if test="entrys.size != 0">
			    <div class="fenye">
			    	<s:include value="/res/plugins/page.jsp"></s:include>
			    </div>
			</s:if>
			<s:include value="comment.jsp"></s:include>
	</div>
	<s:include value="friendly-link.jsp"></s:include>
	<s:include value="foot.jsp"></s:include>
</div>
</body> --%>

<body>
	<!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js">
</script>-->

	<div id="wraper">
		<s:include value="../open/head.jsp"></s:include>

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
			
			<div id="comment">
				<div class="comtitle">
					<h2>${entry.title}</h2>
					<h5>所有评论仅代表网友意见，本网保持中立。
					   <s:if test="#session.right.getRight() >= 999">
					       <a href="<s:url value='/open/comment/%{id}/noComment'/>" >查看未回复会员</a>
					   </s:if>
				    </h5>
				</div>
				
				<div class="comcont">
					<ul>
						<s:if test="comments.size == 0">
							<div class="speaking_massage">
								<a href="#comment"> <s:text name="noneComment"></s:text>
								</a>
							</div>
						</s:if>
						<s:else>
							<s:iterator value="comments" var="c" status="s">
								<li>
									<span class="comname">${username}</span> 
									<span class="comtime">
									    <s:date name="addTime" format="%{getText('tailDateFormat')}" />
									</span>
									<p class="comtent">
									    <s:if test="attachment != null">
										<a href="<s:url value='/admin/entry/%{id}/downFile?content=%{attachment.filepath}&title=%{attachment.orginalName}'/>" 
										          target="_blank">${attachment.orginalName}</a><br /><br />
										</s:if>          
										<s:property value="content" escape="false" /> &nbsp;
										<s:if test="#session.right.getRight() >= 999">
										  <a href="<s:url value='/open/comment/%{id}/delete'/>" 
										      onclick="return delConfirm();">删除</a>
										</s:if>
									</p>
									<div class="clear"></div>
								</li>
							</s:iterator>
						</s:else>

					</ul>
				</div>
				
				<s:if test="entrys.size != 0">
					<div class="fenye">
						<s:include value="/res/plugins/page.jsp"></s:include>
					</div>
				</s:if>
                
                <div class="speak">
				<s:include value="comment.jsp"></s:include>
				</div>
				
			</div>

		</div>

		<s:include value="foot.jsp" />
	</div>

</body>

</html>