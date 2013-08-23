<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>
<s:text name="index_m_indexManage"></s:text>
</title>
</head>
<body>
<script type="text/javascript">
//<!CDATA[
$(function(){
	//addRule("#nodeSize",		"#nodeSizeVmsg",		"(bt)(number)",		"(<s:text name='mustFill'/>)(<s:text name='errorFormat'/>)");
});          
//]>
</script>
<div class="class_title">
<s:text name="index_m_new"></s:text>
</div>
<form id="manager_new" action="<s:url value='/admin/index/manager'/>" method="post">
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
					<input class="btn bw2" type="submit" value="<s:text name='ok'/>"/>
					<input class="btn bw2" type="reset" value="<s:text name="reset" />" />
					<input class="btn bw2" type="button" onclick="window.location='<s:url value='/admin/index/manager'/>'" value="<s:text name='back'/>"/>
				</div>
				<div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
		<tr>
			<td><s:text name="index_m_blockArea" /></td>
			<td><s:text name="index_m_blockIndex"><s:param value="blockIndex"></s:param></s:text></td>
		</tr>
		<tr>
			<td><s:text name="index_show_image" /></td>
			<td><img src="<s:url value='/templates/%{#request.template}/template.jpg'/>" alt="<s:text name="index_show_image" />" class="index_image"/></td>
		</tr>
		<tr>
			<td><label for="selNodeId"><s:text name="index_m_viewNode"></s:text></label></td>
			<td>
				<select id="selNodeId" name="selNodeId">
				<s:iterator value="menus" id="m" status="m_status">
				<option value="${m.nodeId }" ><s:iterator begin="2" end="#m.level">---</s:iterator>${m.name }</option>
				</s:iterator>
				</select>
				<span id="nameVmsg" class="vmsg"></span>
				<span class="vhint"><span>&#42;</span></span>
			</td>
		</tr>
		<tr>
			<td><label for="nodeSize"><s:text name="index_m_viewSize"></s:text></label></td>
			<td><input id="nodeSize" name="nodeSize" type="text"/><span id="nodeSizeVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span></td>
		</tr>
	</tbody>
</table>
</form>

</body>
</html>