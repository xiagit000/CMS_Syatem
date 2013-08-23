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
<script type="text/javascript">

$(function(){
	//绑定验证规则
	//addRule("#phone",	"#phoneVmsg",	"(bt)(phone)",					"(<s:text name='mustFill'/>)(<s:text name='errorPhone'/>)");
	//addRule("#email",	"#emailVmsg",	"(bt)(email)",					"(<s:text name='mustFill'/>)(<s:text name='errorEmail'/>)");
	//addRule("#address",	"#addressVmsg",	"(bt)(len[1,85])",					"(<s:text name='mustFill'/>)(<s:text name='errorAddress'/>)");
	//addRule("#appendix",	"#appendixVmsg",	"(bt)(len[1,85])",		"(<s:text name='mustFill'/>)(<s:text name='errorAppendix'/>)");
	//addRule("#file",		"#fileVmsg",		"(!bt|ext[jpg,bmp,png])",		"(<s:text name='errorFormat'/>)");
});

</script>
<div class="class_title">
	<s:text name="manageInfo"/>
</div>
<form id="my_info" action="<s:url value='/admin/my/info'/>" method="post" enctype="multipart/form-data">
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
      <td class="left_title_2"><s:text name="username"/></td>
      <td><s:property value="user.username"/></td>
    </tr>
    <tr class="even high_tr">
      <td width="18%" class="left_title_1"><span class="left-title"><s:text name="portaint"/></span></td>
      <td>
      	<s:if test="user.portrait != null">
	      	<img alt="<s:text name='portaint'/>" src="<s:url value='%{user.portrait.iconImg}'/>"/>
   		</s:if>
   		<s:else>
			<img id="head" alt="<s:text name='portaint'/>" src="<s:url value='/images/default_head.png'/>"/>
		</s:else>
      </td>
    </tr>
    <tr class="odd">
		<td><label><s:text name="changePortaint"/></label></td>
		<td><input id="file" type="file" name="image"/>
		<span id="fileVmsg" class="vmsg"></span><span class="vhint"><span></span><s:text name="imageLimit"/></span>
		</td>
	</tr>
    <tr class="even">
      <td class="left_title_1"><s:text name="phone"/></td>
      <td><input type="text" id="phone" class="w300" name="phone" value="<s:property value='user.phone'/>" maxlength="20"/>
      	<span id="phoneVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="telephoneLimit"/></span>
	</td>
    </tr>
    <tr class="odd">
      <td class="left_title_2"><s:text name="email"/></td>
      <td><input type="text" id="email" class="w300" name="email" value="<s:property value='user.email'/>" maxlength="50"/>
      	<span id="emailVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="emailLimit"/></span></td>
    </tr>
   <tr class="even">
      <td class="left_title_2"><s:text name="address"/></td>
      <td><input type="text" class="w300" name="address" value="<s:property value="user.address"/>" maxlength="85" id="address"/>
      	<span id="addressVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="addressLimit"/></span></td>
    </tr>
    <tr class="odd high_tr">
	    <td class="left_title_1"><s:text name="appendix"/></td>
	    <td><textarea rows="3" cols="25" class="appendix_text" name="appendix" id="appendix"><s:property value="user.appendix"/></textarea>
	    <span id="appendixVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span><s:text name="appendixLimit"/></span>
	    </td>
  	</tr>
	</tbody>
  </table>
</form>
</body>
</html>