<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="changePassword"/></title>
</head>
<body>
<script type="text/javascript" src="<s:url value = '/javascript/rules.js'/>"></script>
<script type="text/javascript">
$(function(){
	//绑定验证规则
	//addRule("#pass",	"#passVmsg",	"(bt)(len[6,10])",				"(<s:text name='mustFill'/>)(<s:text name='errorLength'/>)");
	//addRule("#newPass",	"#newPassVmsg",	"(bt)(len[6,10])",				"(<s:text name='mustFill'/>)(<s:text name='errorLength'/>)");
	//addRule("#newRePass",	"#reNewPassVmsg",	"(bt)(equal[newPass])",		"(<s:text name='mustFill'/>)(<s:text name='errorRepeatPassword'/>)");
});
</script>
<div class="class_title">
	<s:text name="changePassword"/>
</div>
<form id="user_manager_changepassword" action="<s:url value='/user/manage/self/changePassword'/>" method="post">
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
      <td width="18%" class="left_title_1"><s:text name="inputOldPass"/></td>
      <td><input type="password" name="password" id="pass"/>
      	<span id="passVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
    <tr class="even">
      <td class="left_title_2"><s:text name="inputNewPass"/></td>
      <td><input type="password" name="newPassword" id="newPass"/>
      	<span id="newPassVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
   <tr class="odd">
      <td class="left_title_2"><s:text name="inputNewPassAgain"/></td>
      <td><input type="password" name="newRepeartPassword" id="newRePass"/>
      	<span id="reNewPassVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span></span>
      </td>
    </tr>
	</tbody>
  </table>
</form>
</body>
</html>