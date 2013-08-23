<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title>湖北省证券业协会</title>
<link href="<s:url value="/templates/default/static/css/tt.css"/>" rel="stylesheet" type="text/css"/>
<script src="<s:url value="/templates/default/static/js/common.js"/>" type="text/javascript" language="javascript"></script>
<script src="<s:url value="/templates/default/static/js/curvycorners.js"/>" type="text/javascript" language="javascript"></script>
<script src="<s:url value="/templates/default/static/js/jquery-1.3.2.min.js"/>" type="text/javascript" language="javascript"></script>

    <script src="<s:url value='/javascript/complaint/form.js'/>" type="text/javascript"></script>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>
<!--[if lt IE 7]>
    <script type="text/javascript" src="js/unitpngfix.js"></script>
<![endif]-->

<!--[if IE 6]>
    <script type="text/javascript" language="javascript" src="js/iepngfix_tilebg.js"></script>
<![endif]–->

<!-[if It IE 6]>
    <link rel="stylesheet" media="all" type="text/css" href="css/ie.css" />
<![endif]-->


</head>

<body>
<!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js">
</script>-->

<div id="wraper">
    <s:include value="../../open/head.jsp"></s:include>
    
    <div id="main" class="clearfix">

        <div id="right_down">
            <div id="location">
                <a href="<s:url value='/'/>">首页</a>
                <span>&gt;&gt;</span>
                <span>投诉平台</span>
            </div>
            <form action="<s:url value='/complaint'/>" method="post">
            <div id="complain">
                <ul>
                    <li>
                        <span>被投诉人及单位：</span>
                        <input type="text" name="complaint.company" id="company"/>
                        <span class="xin">*</span>
                        <span id="companyVmsg" style="color:red"></span>
                    </li>
                    <li>
	                    <span>投诉人：</span>
	                    <input type="text" name="complaint.person" id="person"/>
	                    <span class="xin">*</span>
	                    <span id="personVmsg" style="color:red"></span>
                    </li>
                    <li>
	                    <span>联系方式：</span>
	                    <input type="text" name="complaint.contact" id="contact"/>
	                    <span class="xin">*</span>
	                    <span id="contactVmsg" style="color:red"></span>
                    </li>
                    <li class="text">
	                    <span>投诉内容：</span>
	                    <textarea name="complaint.content" id="content"></textarea>
	                    <span class="xin">*</span>
	                    <span id="contentVmsg" style="color:red"></span>
                    </li>
                    <li class="btn">
                    <input type="submit" value="提交" /><input type="reset" value="重置" /></li>
                </ul>
            </div>
            </form>
        </div>

</div>

    
<s:include value="open/foot.jsp" />
</div>
        
</body>
</html>
