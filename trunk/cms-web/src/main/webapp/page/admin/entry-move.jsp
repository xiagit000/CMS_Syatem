<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
//<![CDATA[
$(function(){
	$(".menu_div").find(":checkbox").attr("checked", false);
	$(".menu_div").find(":checkbox").click(function(){
		$(this).par("div").find(":checkbox").attr("checked", false);
		$(this).attr("checked", true);
	});
});
function moveNode() {
	var nodeId = $(":checkbox:checked").val();
	if (nodeId == undefined || nodeId == "") {
		alert("请选择要移动到的节点！");
		return;
	} 
	var url = "<s:url value='/admin/entry/' />";
	url = url + $("#move_entry_id").val() + "/move?nodeId=" + nodeId;
	$("#show_menu").fadeOut("100");
	window.location = url;
}

function cancelMoveNode() {
	$("#show_menu").fadeOut("slow");
	$(".menu_div").find(":checkbox").attr("checked", false);
	$("#move_entry_id").val("");
}
//]]>
</script>
<div id="show_menu" style="display: none; position: absolute; background-color: #A9CFF1; padding: 4px;">
<form>
<div class="menu_div" style="width:400px;height: 250px; overflow-y: scroll;padding:10px; background: white;border: solid 1px #5A8BE7;">
<s:iterator value="menus" id="m">
<ul class="menu_list">
	<li style="display: inline; margin: 0; padding: 0;"><input type="checkbox" name="moveTo" value="${m.nodeId }"/></li>
	<li style="padding-left: ${(level-1)*18 + 4}px; display: inline; margin: 0; ">
		<%--<a href="<s:url value='/admin/entry/%{entry.id}/move?nodeId=%{#m.nodeId}'/>">${m.name}</a> --%>
		${m.name}
	</li>
</ul>
</s:iterator>
<input type="hidden" id="move_entry_id">
</div>
<div style="text-align:center">
<input type="button" value="确定" onclick="moveNode();">
<input type="reset" value="重置">
<input type="button" value="取消" onclick="cancelMoveNode();">
</div>
</form>
</div>
