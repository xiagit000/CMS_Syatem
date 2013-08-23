<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="add"/><s:text name="user"/></title>
</head>
<body>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>
	<script type="text/javascript">
	$(function(){
		//绑定验证规则
		addRule("#name",	"#nameVmsg",	"(bt)(char)(lenb[5,16])(unique[<s:url value='/user/register/try/checkName'/>,name,Y])",		"(<s:text name='mustFill'/>)(<s:text name='illegalChar'/>)(<s:text name='errorLength'/>)(<s:text name='usernameExist'/>)");			
		addRule("#pass",	"#passVmsg",	"(bt)(len[6,10])",				"(<s:text name='mustFill'/>)(<s:text name='errorLength'/>)");			
		addRule("#repass",	"#repassVmsg",	"(bt)(equal[pass])",					"(<s:text name='mustFill'/>)(<s:text name='errorRepeatPassword'/>)");
		addRule("#phone",	"#phoneVmsg",	"(bt)(phone)",					"(<s:text name='mustFill'/>)(<s:text name='errorPhone'/>)");
		addRule("#email",	"#emailVmsg",	"(bt)(email)(unique[<s:url value='/user/register/try/checkEmail'/>,email,Y])",					"(<s:text name='mustFill'/>)(<s:text name='errorEmail'/>)(<s:text name='emailExist'/>)");
		addRule("#address",	"#addressVmsg",	"(bt)(len[1,85])",					"(<s:text name='mustFill'/>)(<s:text name='errorAddress'/>)");
		addRule("#appendix",	"#appendixVmsg",	"(bt)(len[1,85])",		"(<s:text name='mustFill'/>)(<s:text name='errorAppendix'/>)");
	});
	</script>

    
<div class="class_title">
	<s:text name="add"/><s:text name="user"/>
</div>
<form id="user_manager_new" action="<s:url value='/admin/user/manage'/>" method="post" onsubmit="return vform(this);">
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
			  	<input class="btn bw2" id="subtn" type="submit" name="button" value="<s:text name='ok'/>" />
			  	<input class="btn bw2" type="button" onclick="back();" name="button" value="<s:text name='back'/>"/>
			  </div>
			  <div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
	<s:if test="ldapEnabled">
	<tr class="even">
      <td><s:text name="ifLdapValidate"/></td>
      <td class="left"><input type="checkbox" class="w250" name="ldapValidate" value="true"
      	onchange="disable(this,'subtn','pass','repass')" id="ldapValidate"/>
      	<span id="ldapValidateVmsg"></span>
      </td>
    </tr>
	</s:if>
    <tr class="even">
      <td><s:text name="username"/></td>
      <td><input type="text" class="w250" name="username" id="name"/>
      	<span id="nameVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="usernameLimit"/></span>
      </td>
    </tr>
    <tr class="odd">
      <td>用户类型</td>
      <td>
            <s:select list="#{'1':'普通管理员','0':'普通会员'}" name="right" />
      </td>
    </tr>
    <tr class="even">
      <td><s:text name="password2"/></td>
      <td><input type="password" class="w250" name="password" id="pass"/>
      <span id="passVmsg" class="vmsg"></span>
	<span class="vhint"><span>&#42;</span><s:text name="passwordLimit"/></span>
      </td>
    </tr>
    <tr class="odd">
      <td><s:text name="repeatPassword"/></td>
      <td><input type="password" class="w250" id="repass"/>
      <span id="repassVmsg" class="vmsg"></span>
	<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
    <tr class="even">
      <td><s:text name="phone"/></td>
      <td><input type="text" id="phone" class="w250" name="phone" maxlength="20"/>
      <span id="phoneVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="telephoneLimit"/></span>
      </td>
    </tr>
    <tr class="odd">
      <td><s:text name="email"/></td>
      <td><input type="text" class="w250" name="email" id="email" maxlength="50"/>
      <span id="emailVmsg" class="vmsg"></span>
	<span class="vhint"><span>&#42;</span><s:text name="emailLimit"/></span>
      </td>
    </tr>
   <tr class="even">
      <td><s:text name="address"/></td>
      <td><input type="text" class="w250" name="address" id="address" maxlength="85"/>
      <span id="addressVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="addressLimit"/></span>
      </td>
    </tr>
    <tr class="odd high_tr">
	    <td><s:text name="appendix"/></td>
	    <td><textarea rows="3" cols="25" class="appendix_text" name="appendix" id="appendix"></textarea>
	    <span id="appendixVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="appendixLimit"/></span>
	    </td>
  	</tr>
	</tbody>
  </table>
</form>
</body>
</html>