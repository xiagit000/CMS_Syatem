<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="editEntry"/></title>
</head>
<body>
<s:include value="../common/calendar.jsp"></s:include>
<s:include value="../common/showEditor.jsp"></s:include>
<script type="text/javascript">
//<![CDATA[
function checkNull(){
	editor.sync();
    var content = document.getElementById('content1').value;
	content = $('<p>'+content+'</p>').text();
	if(content == null || content.trim().length == 0){
		alert('<s:text name="contentNotNull"/>');
		return false;
	}
	document.getElementById('plain').value = content;
	return true;
}

function previewSub() {
	$("#preview").val("true");
	$("form[name=example]").attr("target","_blank");
	if (checkNull()) {
		var content = KE.util.getSrcData('content1');
		$("#content1").val(content);
		$("form[name=example]").submit();
	}
	return false;
}

function doSub() {
	$("#preview").val("false");
	$("form[name=example]").removeAttr("target");
	return true;
}

$(function(){
	//addRule("#file",		"#fileVmsg",		"(!bt|ext[jpg,jpeg,bmp,png])",		"(<s:text name='errorFormat'/>)");
	//addRule("#summary",	"#summaryVmsg",	"(len[0,300])",		"(<s:text name='errorLength'/>)");
	addRule("#title",	"#titleVmsg",	"(bt)",		"(<s:text name='mustFill'/>)");
});
//]]>
</script>
<div class="class_title"><s:text name="editEntry"/></div>
	<form name="example" method="post" action="<s:url value='/admin/entry/%{entry.id}'/>" enctype="multipart/form-data"
	 onsubmit="return checkNull();">
	 <input type="hidden" name="plainText" id="plain"/>
	 <input type="hidden" name="_method" value="put"/>
	 <input type="hidden" name="continueURL" value="${continueURL}"/>
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
		<tbody>
		  	<tr>
				<td><s:text name="title"/></td>
				<td><input type="text" class="w500" name="title" id="title" maxlength="50" value="<s:property value='%{entry.title}'/>"/>
				<span id="titleVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span><s:text name="titleLimit"/></span>
				</td>
			</tr>
			<tr>
				<td><s:text name="summary"/></td>
				<td><textarea name="summary" rows="5" cols="25" class="w500" id="summary">${entry.summary}</textarea>
				<span id="summaryVmsg" class="vmsg"></span><span class="vhint"><s:text name="summaryLimit"/></span>
				</td>
			</tr>
			<tr>
				<td><s:text name="entry_keyword"/></td>
				<td><input type="text" class="w500" name="entryKeyword" id="entryKeyword" value="${entry.keyword }" maxlength="30"/>
				<span id="keywordVmsg" class="vmsg"></span><span class="vhint"><span></span><s:text name="entry_seo_note"/></span>
				</td>
			</tr>
			<tr>
				<td><s:text name="entry_description"/></td>
				<td><input type="text" class="w500" name="entryDescription" id="entryDescription" value="${entry.description }" maxlength="30"/>
				<span id="descriptionVmsg" class="vmsg"></span><span class="vhint"><span></span><s:text name="entry_seo_note"/></span>
				</td>
			</tr>
			<tr>
				<td><s:text name="isSimpleStyle"/></td>
				<td>
					<s:if test="entry.simple">
						<input type="checkbox" name="simple" checked="checked" value="true"/>
					</s:if>
					<s:else>
						<input type="checkbox" name="simple" value="true"/>
					</s:else>
				</td>
			</tr>
			<tr>
				<td><s:text name="expiredDay"/></td>
				<td>
					<input class="w50" type="text" name="expiredDay" value="${entry.expiredDay}"/><label><s:text name="day"/></label>
				</td>
			</tr>
			<tr>
               <td>新闻访问权限</td>
               <td>
                   <input type="radio" value="0" ${entry.accessRight == 0 ? "checked='checked'" : ""} name="accessRight"/><label>所有人</label>
                   <input type="radio" value="1" ${entry.accessRight == 1 ? "checked='checked'" : ""} name="accessRight"/><label>普通用户</label>
                   <input type="radio" value="2" ${entry.accessRight == 2 ? "checked='checked'" : ""} name="accessRight"/><label>管理员</label>
               </td>
            </tr>
			<s:if test="entry.image!=null">
				<tr>
					<td><s:text name="uploadedImage"/></td>
					<td>
						<img src="<s:url value='%{entry.image.iconImg}'/>" alt="${entry.image.description}" />
					</td>
				</tr>
				<tr>
					<td><s:text name="removeUploadedImage"/></td>
					<td>
						<input type="checkbox" name="removeUploadedImage" value="true"/>
						<label><s:text name="remove"></s:text></label>
					</td>
				</tr>
			</s:if>
		  	<tr>
				<td><s:text name="imageUpload"/></td>
				<td><input type="file" name="image" id="file"/>
				<span id="fileVmsg" class="vmsg"></span><span class="vhint"><s:text name="imageShowTip"/>，<s:text name="imageLimit"/></span>
				</td>
			</tr>
			<tr>
				<td><s:text name="imageDescription"/></td>
				<td><input class="w500" type="text" name="description" id="desc" maxlength="85"
					 value="${entry.image != null ? entry.image.description :''}"/>
				<span class="vhint"><s:text name="imageDescLimit"/></span>
				</td>
			</tr>
			<tr>
				<td><s:text name="attachmentAccessStrategy"/></td>
				<td>
					<s:if test="%{entry.attachmentTag == null || entry.attachmentTag.value == 'PUBLICACESS'}">
						<input type="radio" value="PUBLICACESS" checked="checked" name="tag"/>
					</s:if>
					<s:else>
						<input type="radio" value="PUBLICACESS" name="tag"/>
					</s:else>
					<label><s:text name="PUBLICACESS"/></label>
					<s:if test="%{entry.attachmentTag.value eq 'LOGINACESS'}">
						<input type="radio" value="LOGINACESS" checked="checked" name="tag"/>
					</s:if>
					<s:else>
						<input type="radio" value="LOGINACESS" name="tag"/>
					</s:else>
					<label><s:text name="LOGINACESS"/></label>
					<%-- <s:if test="!roles.empty">
					<s:if test="%{entry.attachmentTag.value eq 'ROLEBASED'}">
						<input type="radio" value="ROLEBASED" checked="checked" name="tag"/>
					</s:if>
					<s:else>
						<input type="radio" value="ROLEBASED" name="tag"/>
					</s:else>
					<label><s:text name="ROLEBASED"/></label>
						<s:select list="roles" listKey="id" listValue="name" theme="simple" 
						name="roleId" value="%{roleId}"></s:select>
					</s:if> --%>
				</td>
			</tr>
			<tr id="filetr">
				<td><s:text name="uploadedAttachment"/></td>
				<td>
					<ul>
						<s:iterator value="entry.attachments" var="ea">
							<li>
								<input type="checkbox" value="${id}" name="reserved" checked="checked"/>
								<a href="<s:url value='%{filepath}'/>" target="_blank">${orginalName}</a>
							</li>
						</s:iterator>
					</ul>	
				</td>
			</tr>
			<tr id="filetr">
				<td><s:text name="attachment"/></td>
				<td class="files">
					<p id="filep">
						<input type="file" name="attachment" class="file" size="50" onchange="fileType(this,6)"/><font class="error" color=red></font>
						<input type="button" value="<s:text name="add"/>" id="addBtn" class="btn bw2" onclick="addFile(this)" />			
					</p>		
				</td>
			</tr>
			<tr>
				<td><s:text name="userPublishedDate"/></td>
				<td>
					<input id="d12" type="text" name="userPublishedDate" value="<s:date name='entry.userPublishedDate' format='yyyy-MM-dd'/>"/>
					<img onclick="WdatePicker({el:'d12'})" src="<s:url value='/javascript/My97DatePicker/skin/datePicker.gif'/>" width="16" height="22" align="absmiddle"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:text name="content"/>
				</td>
			</tr>
		</tbody>
	  </table>
	    <div class="editor">
	      <textarea name="content" id="${entry.link ? 'content2':'content1'}" class="my_editor" style="height:300px;">${entry.content}</textarea>
	    </div>
	    <div class="rowb">
	    	<div class="row_left">
	    		<input type="hidden" name="preview" id="preview" value="false"/>
	    		<%-- <input class="btn bw2" type="submit" onclick="return previewSub();" value="<s:text name='preview'/>"/> --%>
	    		<input class="btn bw2" type="submit" onclick="return doSub();" name="button" value="<s:text name='finish'/>"/>
	    		<input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
	    	</div>
	    	<div class="clear"></div>
	    </div>
	</form>
</body>
</html>