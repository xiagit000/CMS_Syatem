<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><s:text name="applicationParamSettings"/></title>
</head>
<body>
<script type="text/javascript">
$(function(){
	//绑定验证规则
	//addRule("#url",	"#urlVmsg",	"(bt)(url)",					"(<s:text name='mustFill'/>)(<s:text name='errorURL'/>)");
});
</script>
<div class="class_title">
	<s:text name="applicationParamSettings"/>
</div>
<form id="application_setting" action="<s:url value='/admin/application/setting'/>" method="post">
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
    	<td width="18%" class="left_title_1"><s:text name="baseURL"/></td>
    	<td><input id="url" class="url" type="text" name="baseURL" value="<s:property value='baseURL'/>"/>
    		<span><s:text name="urlExample"/></span>
    		<span id="urlVmsg" class="vmsg"></span>
		<span class="vhint"><span>&#42;</span></span>
    	</td>
    </tr>
    </tbody>
</table>
</form>
</body>
</html>