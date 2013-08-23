<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>导入交易量</title>
</head>
<body>

    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>
    <s:include value="../../common/calendar.jsp"></s:include>
    
    <div class="class_title">导入交易量</div>
    
    <form action="<s:url value='/admin//deal-amount-upload'/>" method="post" enctype="multipart/form-data" >
        <table class="info">
            <thead>
                <tr>
                    <th class="two_col_head"><s:text name="section"></s:text></th>
                    <th><s:text name="info"></s:text></th>
                </tr>
            </thead>
            
            <tbody>
                <tr class="odd">
                    <td>交易时间</td>
                    <td>
	                    <input name="dealTime" class="w130" id="dealTime" type="text" />
	                    <img onclick="WdatePicker({el:'dealTime'})" width="16" height="22" align="absmiddle"
	                       src="<s:url value='/javascript/My97DatePicker/skin/datePicker.gif'/>" />
	                    <span id="dealTimeVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
                    </td>
                </tr>
                <tr class="even">
                    <td>导入文件</td>
                    <td>
	                    <input name="excelFile" class="w300" id="excelFile" type="file"/>
	                    <span id="fileVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
                    </td>
                </tr>
            </tbody>
            
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
            
        </table>
    </form>

</body>
</html>