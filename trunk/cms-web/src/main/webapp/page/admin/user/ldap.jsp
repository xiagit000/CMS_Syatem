<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="ldapSetting"/></title>
</head>
<body>
<script type="text/javascript">
$(function(){

	var must = "(<s:text name='mustFill'/>)";
	//绑定验证规则
	//addRule("#host",	"#hostVmsg",	"(bt)",		must);			
	//addRule("#port",	"#portVmsg",	"(bt)",		must);			
	//addRule("#admin",	"#adminVmsg",	"(bt)",		must);
	//addRule("#password",	"#passwordVmsg",	"(bt)",	must);
	//addRule("#baseDN",	"#baseDNVmsg",	"(bt)",		must);
	//addRule("#loginName",	"#loginNameVmsg",	"(bt)",	must);
});
</script>
<div class="class_title">
	<s:text name="ldapSetting"/>
</div>
<form id="idap_edit" action="<s:url value='/admin/user/ldap/setting'/>" method="post" onsubmit="return vform(this);">
  <input type="hidden" name="_method" value="put"/>
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
			  	<input class="btn bw2" type="submit" name="button" value="<s:text name='ok'/>"/>
			  	<input class="btn bw2" type="button" onclick="back();" name="button" value="<s:text name='back'/>"/>
			  </div>
			  <div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
    <tr class="odd">
      <td><s:text name="ldapHost"/></td>
      <td><input type="text" class="w250" name="host" id="host" value="${setting.host}"/>
      	<span id="hostVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
    <tr class="even">
      <td><s:text name="port"/></td>
      <td><input type="text" class="w250" name="port" id="port" value="${setting.port}"/>
		<span class="vhint"><span>&#42;</span></span>
      <s:if test="setting.secure">
	      <input type="checkbox" checked="checked" name="secure" value="true">
      </s:if>
      <s:else>
	      <input type="checkbox" name="secure" value="true">
      </s:else><span>LDAPS</span>
      <span id="portVmsg" class="vmsg"></span>
      </td>
    </tr>
    <tr class="odd">
      <td><s:text name="ldapAdmin"/></td>
      <td><input type="text" class="w250" name="admin" 
      	id="admin" value="${setting.admin}"/>
      	<span id="adminVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
    <tr class="even">
      <td><s:text name="ldapPassword"/></td>
      <td><input type="password" class="w250" name="password" id="password"
      	 value="${setting.password}"/>
      <span id="passwordVmsg" class="vmsg"></span>
	<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
    <tr class="odd">
      <td><s:text name="ldapBaseDN"/></td>
      <td><input type="text" id="baseDN" class="w250" name="baseDN"
      	 maxlength="20" value="${setting.baseDN}"/>
      <span id="baseDNVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
    <tr class="even">
      <td><s:text name="ldapUser"/></td>
      <td><input type="text" class="w250" name="loginName" id="loginName"
      	 maxlength="50" value="${setting.loginName}"/>
      <span id="loginNameVmsg" class="vmsg"></span>
	<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
	</tbody>
  </table>
</form>
</body>
</html>