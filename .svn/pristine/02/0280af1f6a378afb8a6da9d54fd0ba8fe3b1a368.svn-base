<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>交易量列表</title>
</head>
<body>
    <s:include value="../../common/calendar.jsp"></s:include>
    <script src="<s:url value='/javascript/deal-amount/search_form.js'/>" type="text/javascript"></script>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>
    <script src="<s:url value='/javascript/deal-amount/multi_delete.js'/>" type="text/javascript"></script>
<script>
var totalRows="<s:property value='pageIndex.totalRows'/>";
var currentPage="<s:property value='pageIndex.currentPage'/>";
var totalPages="<s:property value='pageIndex.totalPages'/>";
var pageSize="<s:property value='pageIndex.pageSize'/>";
</script>
<div class="class_title">交易量列表</div>
<%-- <a href="<s:url value="/admin/deal-amount-upload"/>">导入交易量</a> --%>
<form name="searchForm" action="<s:url value='/admin/deal-amount/all/search'/>" method="get">
公司名称：<input name="dealAmount.company" class="w300" id="company" type="text" value="<s:property value="dealAmount.company"/>"/>
               <span id="companyVmsg" class="vmsg"></span>
               <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
交易日期：<input  name="dealAmount.dealTime" class="w130" id="dealTime" type="text" value="<s:date name='dealAmount.dealTime' format='yyyy-MM-dd'/>" />
               <img onclick="WdatePicker({el:'dealTime'})" src="<s:url value='/javascript/My97DatePicker/skin/datePicker.gif'/>" width="16" height="22" align="absmiddle"/>
               <input id="dealState" type="hidden" />
               <span id="dealStateVmsg" class="vmsg"></span>
        <input type="submit" class="btn bw2" value="查询">            
</form>
<table class="list">
    <thead>    
        <tr class="w300">
            <th width="5%">选择</th>
            <th class="number" width="5%"><s:text name="orderNumber"/></th>     
            <th width="40%">公司名称</th>
            <th width="8%">交易量百分比</th>
            <th width="12%">交易量金额</th>
            <th width="10%">交易时间</th>
            <!-- <th width="6%">排序值</th> -->
            <th width="6%" class="operation"><s:text name="operation"></s:text></th>
        </tr>
    </thead>
		<tfoot >
        <tr class="toolbar">
            <td colspan="7">
                <div class="row_left">
                   
                   <input type="button" class="btn bw2"  onclick="checkAll()"  value="全选"/>
                   <input type="button" class="btn bw3"  onclick="unCheckAll()"  value="全不选"/>
                   <input type="button" class="btn bw2"  onclick="checkInverse()" value="反选"/>
                   <input type="button" class="btn bw4"  onclick="multiDelete()" value="批量删除"/>
                   <span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span>
                   <input class="btn bw2" onclick="go('<s:url value="/admin/deal-amount/new"/>')"
                    value="<s:text name='add'/>" type="button"/>
                   <input class="btn bw5" onclick="go('<s:url value="/admin/deal-amount-upload"/>')"
                    value="导入交易量" type="button"/>
                
                </div>
                <s:if test="dealAmounts.size != 0">
                    <div class="row_right"><s:include value="../../common/page.jsp"></s:include></div>
                </s:if>
                <div class="clear"></div>
            </td>
        </tr>
    </tfoot>
		<tbody>
        <s:if test="dealAmounts.size != 0">
        <form name="dealForm"  method="post">
        <input type="hidden" id="page" name="page" value="1" />
        <s:iterator value="dealAmounts" var="entry" status="status">
            <tr class="${status.odd ? 'odd':'even'}">
                <td>
                <input type="checkbox" name="chk_list"  value="<s:property value="id"/>" />
                </td>
                <td>
                    ${status.index+1}
                </td>
                <td class="left">
                    <s:property value="company"/>
                </td>
                <td class="left">
                    <s:property value="percent"/> %
                </td>
                <td class="left">
                    <s:property value="totalAmountString"/>
                </td>
                <td class="left">
                    <s:date name="dealTime" format="yyyy年MM月"/>
                </td>
               <%--  <td class="left">
                    <s:property value="orderBy"/>
                </td> --%>
                <td><a href="<s:url value='/admin/deal-amount/%{id}/edit'/>" >编辑</a>&nbsp;&nbsp;
                <s:if test="pageIndex.currentPage==pageIndex.totalPages && pageIndex.totalRows%pageIndex.pageSize==1" >
                         <a href="<s:url value='/admin/deal-amount/%{id}/delete?page=%{pageIndex.currentPage}'/>"
                         onclick="return delConfirm();"><s:text name="delete"></s:text></a>
                 </s:if>
                 <s:else>
                 <a href="<s:url value='/admin/deal-amount/%{id}/delete'/>"
                         onclick="return delConfirm();"><s:text name="delete"></s:text></a>
                 </s:else>
                </td>
            </tr>
        </s:iterator>
        
        </form>
        </s:if>
        <s:else>
            <tr>
                <td colspan="7" class="center"><s:text name="nodata"/></td>
            </tr>
        </s:else>
    </tbody>
</table>
</body>
</html>