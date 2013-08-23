<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="addNode"/></title>
</head>
<body>
<script type="text/javascript">
$(function(){
	//addRule("#name",	"#nameVmsg",	"(bt)",		"(<s:text name='mustFill'/>)");
});
</script>
<div class="class_title">
<s:text name="addNode"/>
</div>
<form id="node_new" action="<s:url value='/admin/node'/>" method="post">
<input type="hidden" name="redirectURL" value="${redirectURL}">
<input type="hidden" name="parentId" value="${parentId}">
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
		<tr>
			<td><label for="name"><s:text name="nodeName"/></label></td>
			<td>
				<input class="w250" type="text" name="name" id="name" maxlength="10"/>
				<span id="nameVmsg" class="vmsg"></span>
				<span class="vhint"><span>&#42;</span><s:text name="nodeName"/><s:text name="maxLength"><s:param>7</s:param></s:text></span>
			</td>
		</tr>
		<tr>
			<td><label for="display"><s:text name="nodeDisplay"/></label></td>
			<td><s:if test="node.display"><input type="checkbox" value="true" name="display" checked="checked"/></s:if>
				<s:else><input type="checkbox" value="true" name="display"/></s:else>
			</td>
		</tr>
		<tr>
			<td><label for="link"><s:text name="isLink"/></label></td>
			<td>
				<s:if test="node.link">
					<input type="checkbox" value="true" name="link" checked="checked"/>
				</s:if>
				<s:else>
					<input type="checkbox" value="true" name="link"/>
				</s:else>
			</td>
		</tr>
		<tr>
			<td><label for="address"><s:text name="linkAddress"/></label></td>
			<td>
				<input class="w250" type="text" name="address" id="address"
					 maxlength="255"/>
				<span id="addressVmsg" class="vmsg"></span>
				<span class="vhint">
					<s:text name="%{linkAddress}"/><s:text name="fillLinkTip"/>，<s:text name="maxLength"><s:param>255</s:param></s:text></span>
			</td>
		</tr>
		<tr>
			<td><label for="_blank"><s:text name="_blank"/></label></td>
			<td>
				<s:if test="node.blank">
					<input type="checkbox" value="true" name="blank" checked="checked"/>
				</s:if>
				<s:else>
					<input type="checkbox" value="true" name="blank"/>
				</s:else>
			</td>
		</tr>
		<tr>
			<td><label for="order"><s:text name="order"/></label></td>
			<td>
				<s:select list="orders" theme="simple" name="order"
					listValue="%{getText(name())}"></s:select>
			</td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>