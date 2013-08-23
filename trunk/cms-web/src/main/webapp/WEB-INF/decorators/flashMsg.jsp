<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="msgs.size != 0">
<script type="text/javascript">
//<![CDATA[
$(function() {
	setTimeout('$("#flashMsg").fadeOut("slow");', 3500);
});
//]]>
</script>
	<div id="flashMsg">
		<!-- css 圆角信息 -->
		<div class="nifty"><b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
			<div class="content">
				<s:property value="%{msgs.flash}" escape="false"/>
			</div>
		<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b></div> 	
	</div>
</s:if>