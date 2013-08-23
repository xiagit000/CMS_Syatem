<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="editInfo"></s:text></title>
</head>
<body>

	<script src="<s:url value='/javascript/popup.js'/>" type="text/javascript"></script>
	<script src="<s:url value='/javascript/ajaxupload.js'/>" type="text/javascript"></script>
	<script src="<s:url value='/javascript/upload.js'/>" type="text/javascript"></script>
	<script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
	<script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>
	<script type="text/javascript">
	$(function(){
		//绑定验证规则
		//addRule("#phone",	"#phoneVmsg",	"(bt)(phone)",					"(<s:text name='mustFill'/>)(<s:text name='errorPhone'/>)");
		//addRule("#email",	"#emailVmsg",	"(bt)(email)",					"(<s:text name='mustFill'/>)(<s:text name='errorEmail'/>)");
		//addRule("#address",	"#addressVmsg",	"(bt)(len[1,85])",					"(<s:text name='mustFill'/>)(<s:text name='errorAddress'/>)");
		//addRule("#appendix",	"#appendixVmsg",	"(bt)(len[1,85])",		"(<s:text name='mustFill'/>)(<s:text name='errorAppendix'/>)");
	});
	</script>

<div class="class_title">
	<s:text name="editInfo"/>
</div>
<s:if test="currentUser.userRight.right >= user.userRight.right">

<form id="user_manager_edit" action="<s:url value='/admin/user/manage/%{user.id}'/>" method="post">
	<input type="hidden" name="_method" value="PUT"/>
	<input type="text" name="userId" value="${user.id}" style="display: none;"/>
	<s:hidden name="user.id"></s:hidden>
  <table class="info">
  	<thead>
		<tr>
			<th class="two_col_head">
				<s:text name="section"></s:text>
			</th>
			<th>
				<s:text name="info"></s:text>
			</th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="2">
			  <div class="row_left">
			  	<input class="btn bw2" type="submit" value="<s:text name='save'/>"/>
			  </div>
			  <div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
    <tr class="odd">
      <td width="18%" class="left_title_1"><span class="left-title"><s:text name="changePortaint"/></span></td>
      <td width="82%">
      	<div id="popButton" class="w100">
      	<s:if test="user.portrait != null">
	      	<img alt="<s:text name='portaint'/>" src="<%=request.getContextPath()%>/image/<s:property value='user.portrait.id'/>/icon"/>
    		</s:if>
    		<s:else>
				<img id="head" alt="<s:text name='portaint'/>" src="<s:url value='/images/head.jpg'/>"/>
			</s:else>
      	</div>
      </td>
    </tr>
    <tr class="even">
      <td class="left_title_2"><s:text name="username"/></td>
      <td>${user.username}</td>
    </tr>
    <tr class="odd">
      <td class="left_title_1"><s:text name="phone"/></td>
      <td><input type="text" id="phone" class="w300" name="phone" value="${user.phone}" maxlength="20"/>
      	<span id="phoneVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="telephoneLimit"/></span>
	</td>
    </tr>
    <tr class="even">
      <td class="left_title_2"><s:text name="email"/></td>
      <td><input type="text" id="email" class="w300" name="email" value="${user.email}" maxlength="50"/>
      	<span id="emailVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="emailLimit"/></span></td>
    </tr>
   <tr class="odd">
      <td class="left_title_2"><s:text name="address"/></td>
      <td><input type="text" class="w300" name="address" id="address" value="${user.address}" maxlength="85"/>
      	<span id="addressVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="addressLimit"/></span></td>
    </tr>
    <tr class="even">
	    <td class="left_title_1"><s:text name="appendix"/></td>
	    <td><textarea rows="6" cols="30" name="appendix" id="appendix">${user.appendix}</textarea>
	    <span id="appendixVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="appendixLimit"/></span>
	    </td>
  	</tr>
  	<tr class="odd">
      <td>用户类型</td>
      <td>
        <select name="right" id="right" >
	        <s:if test="currentUser.userRight.right == 999">
	            <option value="2" <s:if test="user.userRight.right == 999">selected="selected"</s:if> >超级管理员</option>
            </s:if>
            <option value="1" <s:if test="user.userRight.right == 777">selected="selected"</s:if> >普通管理员</option>
            <option value="0" <s:if test="user.userRight.right == 0">selected="selected"</s:if> >普通会员</option>
      </select>
      </td>
    </tr>
    <tr class="even">
      <td class="left_title_2">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr class="odd">
      <td class="left_title_1">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td class="left_title_2">&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
	</tbody>
  </table>
</form>

</s:if>
<s:else>请从正确的路径访问！</s:else>
<s:include value="changePhoto.jsp"></s:include>
<div id="backgroundPopup"></div>
</body>
</html>