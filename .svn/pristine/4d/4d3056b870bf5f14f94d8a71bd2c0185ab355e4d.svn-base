<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<div id="link">

	<s:iterator value="linkTypes" var="t" status="status">

		<div class="fenyuan ${status.even?'link_bg':''} clearfix">
			<span class="${status.even?'link_head':'link_head2'}">${name}</span>
			<span class="name_link1"> <s:iterator
					value="%{fetchLinks(#t)}" var="lo" status="status">
					<s:if test="#status.index % 5 != 0 "> │ </s:if>
					<a href="${link}">${name}</a>
					<s:if test="#status.index % 5 == 4">
						<br />
					</s:if>
				</s:iterator>
			</span>
		</div>

	</s:iterator>

</div>