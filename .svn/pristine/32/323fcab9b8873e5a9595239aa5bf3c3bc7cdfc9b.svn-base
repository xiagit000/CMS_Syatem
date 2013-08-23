<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title><s:text name="sitemap"/>--${application.systemName }</title>
<s:include value="resources.jsp"></s:include>
</head>
<body>
	<div id="waper">
		<div class="map_head">
		   	<p>${application.systemName }<span>
				<s:text name="sitemap"/></span></p>
		</div>
		<div class="map_neirong">
				
				<s:iterator value="links" var="l">
				<p><span>
					<s:if test="link">
						<s:if test="startWithHttp">
							<a class="normal" href="${address}">${name}</a>
						</s:if>
						<s:else>
							<a class="normal" href="<s:url value='/%{address}'/>">${name}</a>
						</s:else>
					</s:if>
					<s:else>
						<a class="normal" href="<s:url value='/open/menu/%{nodeId}'/>">${name}</a>
					</s:else>
					</span>
					<s:if test="!children.empty">
							<s:iterator value="children" var="lc" status="st">
								<s:if test="link">
									<s:if test="startWithHttp">
										<a class="normal" href="${address}">${name}</a>
									</s:if>
									<s:else>
										<a class="normal" href="<s:url value='/%{address}'/>">${name}</a>
									</s:else>
								</s:if>
								<s:else>
									<a class="normal" href="<s:url value='/open/menu/%{nodeId}'/>"> ${name}</a>
								</s:else>
								<s:if test="!#st.last">|</s:if>
							</s:iterator>
					</s:if>
            		</p>
				</s:iterator>
		</div>
    </div>
</body>
</html>