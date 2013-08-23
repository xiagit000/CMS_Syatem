<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>新增交易量</title>
</head>
<body>

    <script src="<s:url value='/javascript/deal-amount/form.js'/>" type="text/javascript"></script>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>
    <s:include value="../../common/calendar.jsp"></s:include>

	<div class="class_title">新增交易量</div>
	
	<form action="<s:url value='/admin/deal-amount'/>" method="post" >
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
		            <td>公司名称</td>
		            <td><input name="dealAmount.company" class="w300" id="company" type="text"/>
		            <span id="companyVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
		            </td>
		        </tr>
		        <tr class="even">
		            <td>百分比</td>
		            <td><input name="dealAmount.percent" class="w300" id="percent" type="text"/> %
		            <span id="percentVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
		            </td>
		        </tr>
                <tr class="odd">
                    <td>金额总数</td>
                    <td><input name="dealAmount.totalAmount" class="w300" id="totalAmount" type="text"/>
                    <span id="totalAmountVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
                    </td>
                </tr>
                <tr class="even">
                    <td>交易时间</td>
                    <td>
                    <input name="dealAmount.dealTime" class="w130" id="dealTime" type="text" value="<s:date name='dealAmount.dealTime' format='yyyy-MM-dd'/>"/>
                    <img onclick="WdatePicker({el:'dealTime'})" src="<s:url value='/javascript/My97DatePicker/skin/datePicker.gif'/>" width="16" height="22" align="absmiddle"/>
                    <span id="dealTimeVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
                    </td>
                </tr>
                <tr class="odd">
                    <td>排序值</td>
                    <td><input name="dealAmount.orderBy" class="w30" id="orderBy" type="text"/>
                    <span id="orderByVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
                    </td>
                </tr>
		        <%-- <tr class="odd">
		            <td>交易时间</td>
		            <td><input name="linkHref" class="w300" value="http://" id="href" type="text"/>
		            <span id="hrefVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
		            </td>
		        </tr> --%>
		    </tbody>
		    
		</table>
	</form>
	
</body>
</html>