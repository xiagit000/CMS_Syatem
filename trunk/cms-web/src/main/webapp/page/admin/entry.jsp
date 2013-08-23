<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="entryManage"/>--${currentMenu.name}</title>
</head>
<body>
<SCRIPT type="text/javascript">
//<![CDATA[
function showMenu(id) {
	$("#move_entry_id").val(id);
//	$("#show_menu").show();

	var e = $("#show_menu");
	var width = e.width()?e.width():400;
	var height = e.height()?e.height():300;
	var top,top2;
	if(document.documentElement.clientHeight < height){
		top = top2 = 0;
	}else{
		top2 = parseInt(document.documentElement.clientHeight/2 - (height+20)/2)+document.documentElement.scrollTop;
		top = parseInt(document.documentElement.clientHeight/2 - (height+20)/2);
	}
	var left = parseInt(document.body.offsetWidth/2 - width/2);
	e.css({
		'width':width+'px',
		'height':height+'px',
		'position':'absolute',
		'left':left+'px',
		'top':top+'px',
		'z-index':1,
		'border': 'solid 2px #5A8BE7'
		}).show();
}
//]]
</SCRIPT>
<div class="class_title">
<s:text name="entryManage"/>--<s:if test="nodeId != null">${currentMenu.name}</s:if><s:else><s:text name="rootNav"/></s:else>
</div>
<div class="parentNav">
	<s:text name="yourPosition"/>
	<a href="<s:url value='/admin/entry'/>"><s:text name="rootNav"/></a>
	<s:if test="nodeId != null">
		<s:iterator value="parentMenus" id="p">
			&gt;&gt;<a href="<s:url value='/admin/entry?nodeId=%{#p.nodeId}'/>">${p.name}</a>
		</s:iterator>
		&gt;&gt;${currentMenu.name}
	</s:if>
</div>
<div class="childNav">
	<s:text name="childNode"/>
	<s:if test="childMenus.empty">
		<s:text name="noChildNode"/>
	</s:if>
	<s:else>
		<s:iterator value="childMenus" id="c">
			<a href="<s:url value='/admin/entry?nodeId=%{#c.nodeId}'/>">${c.name}</a>&nbsp;&nbsp;
		</s:iterator>
	</s:else>
</div>
<s:if test="currentMenu.link">
	<s:text name="linkTip"/>:
	<a href="${currentMenu.address}" target="${currentMenu.blank?'_blank':''}">${currentMenu.address}</a>
</s:if>
<s:else>
<table class="list">
	<thead>
		<tr class="w300">
			<th class="number"><s:text name="orderNumber"></s:text></th>
			<th><s:text name="title"></s:text></th>
            <th class="operation">URL</th>
			<th class="baseunit"><s:text name="section"></s:text></th>
			<th class="baseunit"><s:text name="publisher"></s:text></th>
			<th class="dateline"><s:text name="publishDate"></s:text></th>
			<th class="baseunit"><s:text name="status"></s:text></th>
			<th class="operation"><s:text name="operation"></s:text></th>
		</tr>
	</thead>
	<tbody>
		<s:if test="currentMenu.right">
			<!--<tr>
				<td colspan="3"><s:text name="entryList"/></td>
			</tr>
			-->
			<s:if test="entries.empty">
				<tr>
					<td colspan="8"><s:text name="nodata"/></td>
				</tr>
			</s:if>
			<s:else>
				<s:iterator value="entries" var="e" status="status">
					<tr>
						<td class="left">${status.count}</td>
						<td class="left">${e.title}
						<s:if test="#e.image != null">
							<img src="<s:url value='/res/images/hasimg.png'/>" alt="<s:text name='hasImage'/>" title="<s:text name='hasImage'/>"/>
						</s:if>
						</td>
						<td><s:property value='%{url(#e)}'/></td>
						<td>${e.belonged.name}</td>
						<td>${e.author.username}</td>
						<td><s:date name="publishedDate"/></td>
						<td><s:text name="%{published ? 'hasPublished':'notPublished'}"/></td>
						<td>
						<a href="#" onclick="showMenu('${e.id}')"><s:text name="move" /></a>
							<a href="<s:url value='/admin/entry/%{#e.id}/edit'/>"><s:text name="edit"/></a>
						<a href="<s:url value='/admin/entry/%{#e.id}?_method=delete'/>" onclick="return delConfirm();"><s:text name="delete"/></a>
						<s:if test="published">
							<a href="<s:url value='/admin/entry/%{#e.id}/unpublish'/>"><s:text name="unpublish"/></a>
						</s:if><s:else>
							<a href="<s:url value='/admin/entry/%{#e.id}/publish'/>"><s:text name="publish"/></a>
						</s:else>
						<s:if test="currentMenu.orders.name() eq 'MANUAL'&&childMenus.empty">
							<a href="<s:url value='/admin/entry/%{id}/up?nodeId=%{currentMenu.nodeId}&position=%{position}'/>"><s:text name="upEntry"/></a>
							<a href="<s:url value='/admin/entry/%{id}/down?nodeId=%{currentMenu.nodeId}&position=%{position}'/>"><s:text name="downEntry"/></a>
						</s:if>
						</td>
				</tr>
				</s:iterator>
			</s:else>
		</s:if>
		</tbody>
		<tfoot>
			<tr class="toolbar">
					<td colspan="8">
						<div class="row_left">
							<s:if test="currentMenu.right">
							<input type="button" value="<s:text name='addEntry'/>"
							 onclick="go('<s:url value='/admin/entry/new?nodeId=%{nodeId}'/>')" class="btn bw4" />&nbsp;&nbsp;
							</s:if>
							<input type="button" value="<s:text name='backUpperNode'/>"
							 onclick="go('<s:url value='/admin/entry?nodeId=%{currentMenu.parentId}'/>')" class="btn bw6" />
						</div>
						<div class="row_right">
							<s:include value="../common/page.jsp"></s:include>
						</div>
					</td>
				</tr>
		</tfoot>
</table>
</s:else>
<s:include value="entry-move.jsp"></s:include>
</body>
</html>