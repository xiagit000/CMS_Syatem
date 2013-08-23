<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
<s:text name="addEntry"/>
</title>
</head>
<body>
<s:include value="../../common/showEditor.jsp"></s:include>
<script type="text/javascript">
//<![CDATA[
$(function () {
	//addRule("#name",	"#des_name_Vmsg",	"(bt)(len[1,10])",		"(<s:text name='mustFill'/>)(<s:text name='errorLength'/>)");	
	//addRule("#alias",	"#des_alias_Vmsg",	"(bt)(char)(len[1,10])({checkAlias[update,${alias}]})",		"(<s:text name='mustFill'/>)(<s:text name='errorFormat' />)(<s:text name='errorLength'/>)(已存在)");	
});
function checkAlias(value, opt) {
	var checkURL = "<s:url value='/admin/description/manage/try/checkAlias'/>";
	var datas = {alias:value, type:opt[0], oldAlias:opt[1]};
	var result = $.ajax({
		ifModified: true,
		url: checkURL,
		type: "get",
		async: false,
		data: datas
	}).responseText;
	return result == "Y";
}
//]]>
</script>
<div class="class_title"><s:text name="addEntry"/></div>
  <form id="description_edit" method="post" action="update" >
	  <input type="hidden" name="id" value="${id }"/>
	  <table class="info">
	  <thead>
		<tr>
			<th class="two_col_head"><s:text name="section"></s:text></th>
			<th><s:text name="info"></s:text></th>
		</tr>
		</thead>
		<tbody>
		  	<tr>
				<td><s:text name="des_name"/></td>
				<td><input type="text" class="w500" name="name" id="name" maxlength="30" value="${name }"/>
				<span id="des_name_Vmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span><s:text name="des_name_limit"/></span>
				</td>
			</tr>
			<tr>
				<td><s:text name="des_alias"/></td>
				<td><input type="text" class="w500" name="alias" id="alias" maxlength="30" value="${alias }"/>
				<span id="des_alias_Vmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span><s:text name="des_alias_limit"/></span>
				</td>
			</tr>
		</tbody>
	  </table>
	    <div class="editor">
	      <textarea rows="3" cols="25" id="content1" name="description" class="my_editor">${description }</textarea>
	    </div>
	    <div class="rowb">
	    	<div class="row_left">
	    		<input class="btn bw2" type="submit" name="button" value="<s:text name='finish'/>" />
	    		<input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
	    	</div>
	    	<div class="clear"></div>
	    </div>
  	</form>
</body>
</html>