<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>

<%@page import="java.util.Date"%><script type="text/javascript">
$(function(){
	$("a").click(function(){
		var ul = $(this).par("li").find("ul");
		if(ul.length){
			if(ul.css("display")=="none"){
				$("ul").filter("[show=1],.now").hide().attr("show","0");
				ul.show().attr("show","1");
			}else{
				ul.hide().attr("show","0");
			}
		}
	});
});
</script>
<div id="menu">
   		<div class="menu_title">
			<h4><s:text name="systemNav"/></h4>
   			<p><s:date name="currentDate" format="yyyy-MM-dd"/></p>
		</div>
    	<div class="nav">
 		<ul>
 		<!--<li><a href="#"><s:text name="applicationSettings"/></a>
           	<ul class="<s:property value='%{current=="application"?"now":"hid"}'/>">
	        	<li><a href="<s:url value='/admin/application/setting'/>" ><s:text name="applicationParamSettings"/></a></li>
           </ul>
		</li>
       	-->
       	<%-- <s:property value="#session.right.getRight()"/> --%>
       	<s:if test="#session.right.getRight() > 0">
       	<li><a href="#"><s:text name="personalSettings"/></a>
           	<ul class="<s:property value='%{current=="my"?"now":"hid"}'/>">
	        	<li><a href="<s:url value='/admin/my/info'/>" ><s:text name="manageInfo"/></a></li>
	        	<s:if test="!currentUser.ldapValidate">
		            <li>
		            <a href="<s:url value='/admin/my/password'/>" ><s:text name="changePassword"/></a>
		            </li>
	        	</s:if>
           </ul>
		</li>
		<li><a href="#"><s:text name="applicationManage"/></a>
           	<ul class="<s:property value='%{current=="system"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/system/manage'/>" ><s:text name="applicationSettings"/></a></li>
	           	 <!-- <li><a href="<s:url value='/admin/system/log'/>" ><s:text name="applicationLog"/></a></li> -->
           </ul>			
		</li>
		<li><a href="#"><s:text name="index_m_indexManage"/></a>
           	<ul class="<s:property value='%{current=="index"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/index/manager'/>" ><s:text name="index_m_indexConfig"/></a></li>
           </ul>			
		</li>
		<li><a href="#"><s:text name="nodeManage"/></a>
           	<ul class="<s:property value='%{current=="node"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/node'/>" ><s:text name="nodeManage"/></a></li>
           </ul>			
		</li>
        <!-- <li><a href="#"><s:text name="des_column"/></a>
           	<ul class="<s:property value='%{current=="description"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/description/manage'/>" ><s:text name="des_column"/></a></li>
           </ul>			
		</li> -->
        <li><a href="#"><s:text name="newsManage"/></a>
           	<ul class="<s:property value='%{current=="entry"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/entry'/>" ><s:text name="newsManage"/></a></li>
           </ul>			
		</li>
		<li><a href="#"><s:text name="roleManage"/></a>
           	<ul class="<s:property value='%{current=="role"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/role'/>" ><s:text name="roleManage"/></a></li>
           </ul>			
		</li>
		<li><a href="#"><s:text name="userManage"/></a>
            <ul class="<s:property value='%{current=="user"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/user/manage'/>" ><s:text name="viewUserInfo"/></a></li>
                <li><a href="<s:url value='/admin/user/right'/>" ><s:text name="assignRights"/></a></li>
                <s:if test="#application.allowLDAP">
                    <li><a href="<s:url value='/admin/user/ldap'/>" ><s:text name="ldapSetting"/></a></li>
                </s:if>
            </ul>
        </li>
		<li><a href="#"><s:text name="linkManage"/></a>
           	<ul class="<s:property value='%{current=="info"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/info/friendly-link'/>" ><s:text name="manageLinks"/></a></li>
	           	 <li><a href="<s:url value='/admin/info/friendly-link-type'/>" ><s:text name="manageLinkTypes"/></a></li><!--
	           	 
	           	 <li><a href="<s:url value='/admin/info/message'/>" ><s:text name="manageMsgs"/></a></li>
	           	 <li><a href="<s:url value='/admin/info/suggestion'/>" ><s:text name="manageSuggestions"/></a></li>
           --></ul>			
		</li>
		<li><a href="#">投诉管理</a>
            <ul class="<s:property value='%{current=="complaint"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/complaint'/>" >查看投诉</a></li>
            </ul>
        </li>
        <li><a href="#">交易量管理</a>
            <ul class="<s:property value='%{current=="deal-amount"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/deal-amount'/>" >查看交易量</a></li>
            </ul>
        </li>
        <li><a href="#">文字广告管理</a>
            <ul class="<s:property value='%{current=="adword"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/adword'/>" >查看文字广告</a></li>
            </ul>
        </li>
        <li><a href="#">悬浮广告管理</a>
            <ul class="<s:property value='%{current=="drift"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/drift'/>" >查看悬浮广告</a></li>
            </ul>
        </li>
        <li><a href="#">投票管理</a>
            <ul class="<s:property value='%{current=="vote"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/vote'/>" >查看投票</a></li>
            </ul>
        </li>
        <li><a href="#">内部新闻管理</a>
            <ul class="<s:property value='%{current=="news"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/news'/>" >查看内部新闻</a></li>
            </ul>
        </li>
        </s:if>
        <s:if test="#session.right.toString() == 'NORMAL'">
	        <li><a href="#"><s:text name="personalSettings"/></a>
	            <ul class="<s:property value='%{current=="my"?"now":"hid"}'/>">
	                <li><a href="<s:url value='/admin/my/info'/>" ><s:text name="manageInfo"/></a></li>
	                <s:if test="!currentUser.ldapValidate">
	                    <li>
	                    <a href="<s:url value='/admin/my/password'/>" ><s:text name="changePassword"/></a>
	                    </li>
	                </s:if>
	           </ul>
	        </li>
	        <li><a href="#">内部新闻查看</a>
	            <ul class="<s:property value='%{current=="news"?"now":"hid"}'/>">
	                <li><a href="<s:url value='/admin/news'/>" >查看内部新闻</a></li>
	            </ul>
	        </li>
        </s:if>
        
		<!--<li><a href="#"><s:text name="downloadManage"/></a>
           	<ul class="<s:property value='%{current=="download"?"now":"hid"}'/>">
	           	 <li><a href="<s:url value='/admin/download/attachment'/>" ><s:text name="manageAttachment"/></a></li>
	           	 <s:if test="currentUser.userRight.right == 999">
	           	 <li><a href="<s:url value='/admin/download/attachment-type'/>" ><s:text name="manageAttType"/></a></li>
	           	 </s:if>
           </ul>			
		</li>
		-->
		<!--<li><a href="#"><s:text name="unitManage"/></a>
           	<ul class="<s:property value='%{current=="unit"?"now":"hid"}'/>">
                <li><a href="<s:url value='/admin/unit/manage'/>" ><s:text name="manageUnitInfo"/></a></li>
               	<s:if test="currentUser.userRight.right == 999">
               	<li><a href="<s:url value='/admin/unit/unit-type'/>" ><s:text name="manageUnitType"/></a></li>
               	</s:if>
                <li><a href="<s:url value='/admin/unit/need'/>" ><s:text name="manageUnitNeed"/></a></li>
           </ul>
		</li>

		<li><a href="#"><s:text name="imageManage"/></a>
			<ul class="<s:property value='%{current=="image"?"now":"hid"}'/>">
				<li><a href="<s:url value='/admin/image/manage'/>"><s:text name="manageImage"/></a></li>
			</ul>
		</li> 
		-->
		</ul>
    </div>
</div>