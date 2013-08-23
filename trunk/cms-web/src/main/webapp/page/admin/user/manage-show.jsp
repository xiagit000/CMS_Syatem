<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="viewInfo"/></title>
</head>
<body>
<div class="class_title">
	<s:text name="viewInfo"/>
</div>
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
			  	<s:if test="#session.userId == user.id">
			  		<input class="btn bw2" type="button" onclick="go('<s:url value="/admin/my/info"/>')" value="<s:text name='edit'/>"></input>
			  	</s:if>
		  		<input class="btn bw2" type="button" onclick="go('${previousUrl}')" value="<s:text name='back'/>"></input>
			  </div>
			  <div class="clear"></div>
			</td>
		</tr>
	</tfoot>
	<tbody>
  <tr class="odd high_tr">
    <td class="two_col_head"><span class="left-title"><s:text name="portaint"/></span></td>
    <td>
    	<div>
    		<s:if test="user.portrait != null"><img alt="<s:text name='portaint'/>" src="<s:url value='%{user.portrait.iconImg}'/>"/></s:if>
    		<s:else><img id="head" alt="<s:text name='portaint'/>" src="<s:url value='/images/default_head.png'/>"/></s:else>
    	</div>
    </td>
  </tr>
  <tr class="even"><td><s:text name="username"/></td><td><s:property value="user.username"/></td></tr>
  <tr class="odd"><td><s:text name="email"/></td><td><s:property value="user.email"/></td></tr>
  <tr class="even"><td><s:text name="phone"/></td><td><s:property value="user.phone"/></td></tr>
  <tr class="odd"><td><s:text name="address"/></td><td><s:property value="user.address"/></td></tr>
  <tr class="even high_tr"><td><s:text name="appendix"/></td> <td><textarea rows="3" cols="25" class="appendix_text" readonly="readonly"><s:property value="user.appendix"/></textarea></td>  </tr>
    </tbody>
    
</table>
</body>
</html>