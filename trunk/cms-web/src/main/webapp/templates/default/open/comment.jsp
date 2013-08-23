<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>
    <script type="text/javascript">
	$( function() {
	    //绑定验证规则
	    addRule("#content",   "#contentVmsg",   "(bt)(len[15,200])", "(评论必填)(评论长度必须为15到200个字符)");
	});
	</script>
	
    <div class="speak_nei">
        <s:if test="currentUser == null">
	        <form action="<s:url value='/user/login'/>" method="post">
		        <label>帐号</label>
		        <input type="text" name="username">
		        <label>密码</label>
		        <input type="password" name="password">             
		        <label class="val">验证码</label>
		        <img id="VerificationCode" src="<s:url value='/templates/default/VerificationCode.jsp'/>" 
		            title="太难了，换个简单的..." style="vertical-align: middle;"/>
		        <input type="text" name="verifyCode" style="width:40px;vertical-align: middle;"/>
		        <input type="submit" value="登录" style="color:red; margin-left:10px;" />
	        </form>
	        <span style="color:red ">
	            <br/><s:if test="msgs.size != 0"><s:property value="%{msgs.flash}" escape="false"/></s:if>
	        </span>
        </s:if>
    </div>
    
    <form style="width:665px" action="<s:url value='/open/comment'/>" method="post" 
        onsubmit="return checkOnLine(${currentUser!=null});" enctype="multipart/form-data" >
        
	    <input type="hidden" name="id" value="${entry.id}">
	    <s:if test="currentUser != null">
            <p id="filep"><input type="file" name="attachment"/></p>
	        <br/>
		    <textarea name="content" id="content" onblur="if(this.value==''){value='文明上网，登录评论！'}" 
		        onfocus="if(this.value==this.defaultValue){this.value=''}" >文明上网，登录评论！</textarea>
		    <span style="color:red">&#42;</span>
		    <br><a href="<s:url value='/open/comment/%{entry.id}'/>" style="float:left;margin-top:8px;">查看评论</a>
		    <input type="submit" value="确认" style="float:right;margin-top:4px;margin-right:10px;"/>
	    </s:if>
	    
	</form>
