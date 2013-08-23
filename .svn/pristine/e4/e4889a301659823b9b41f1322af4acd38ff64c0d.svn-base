<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="add"/><s:text name="friendlyLink"/></title>
</head>
<body>
<script type="text/javascript">
$(function(){
	//addRule("#name",	"#nameVmsg",	"(bt)",		"(<s:text name='mustFill'/>)");
	//addRule("#href",	"#hrefVmsg",	"(bt)",		"(<s:text name='mustFill'/>)");
});
</script>
<div class="class_title">
<s:text name="add"/><s:text name="friendlyLink"/>
</div>
<form id="friendly_new" action="<s:url value='/admin/info/friendly-link'/>" method="post" enctype="multipart/form-data">
<table class="info">
	<thead>
		<tr>
            <th class="two_col_head"><s:text name="section"></s:text></th>
            <th><s:text name="info"></s:text></th>
		</tr>
	</thead>
	<tfoot>
		<tr class="toolbar">
			<td colspan="2">
				<div class="row_left">
					<input class="btn bw2" type="submit" value="<s:text name='ok'/>" />
					<input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
				</div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<tr class="odd">
			<td><s:text name="friendlyLinkType"/></td>
			<td><s:select list="types" listKey="id" listValue="name" name="typeId" theme="simple"></s:select>
			</td>
		</tr>
		<tr class="even">
			<td><s:text name="name"/></td>
			<td><input name="linkName" class="w300" id="name" type="text"/>
			<span id="nameVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
			</td>
		</tr>
		<tr class="odd">
			<td><s:text name="link"/></td>
			<td><input name="linkHref" class="w300" value="http://" id="href" type="text"/>
			<span id="hrefVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
			</td>
		</tr>
		<tr class="even">
			<td><s:text name="imageUpload"/></td>
			<td><input type="file" name="image" id="file"/>
			<span id="fileVmsg" class="vmsg"></span><span class="vhint"><s:text name="imageLimit"/></span>
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>