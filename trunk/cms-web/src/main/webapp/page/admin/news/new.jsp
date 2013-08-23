<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>新增内部新闻</title>
</head>
<body>

    <%-- <script type="text/javascript" charset="utf-8" src="<s:url value='/javascript/kindeditor.js'/>"></script> --%>
    <s:include value="../../common/calendar.jsp"></s:include>
    <s:include value="../../common/showEditor.jsp"></s:include>
	<script type="text/javascript">
	    
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
	    
	    function checkNull(){
	    	editor.sync();
	    	var content = document.getElementById('content1').value;
	        content = $('<p>'+content+'</p>').text();
	        if(content == null || content.trim().length == 0){
	            alert('<s:text name="contentNotNull"/>');
	            return false;
	        }
	        return true;
	    }
	    
	    $(function(){
	        addRule("#title",   "#titleVmsg", "(bt)(len[0,30])",     "(<s:text name='mustFill'/>)(新闻标题字数不得多于15个中文字符或30个英文字符)");
	    });
	    
	</script>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>

	<div class="class_title">新增内部新闻</div>
	
	<form  name="example" action="<s:url value='/admin/news'/>" method="post" enctype="multipart/form-data" 
	    onsubmit="return checkNull();">
		<table class="info">
		    <thead>
		        <tr>
		            <th class="two_col_head"><s:text name="section"></s:text></th>
		            <th><s:text name="info"></s:text></th>
		        </tr>
		    </thead>
		    
		    <tbody>
		        <tr class="odd">
		            <td>新闻标题</td>
		            <td><input name="news.title" class="w300" id="title" type="text"/>
		            <span id="titleVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
		            </td>
		        </tr>
		        <tr>
	                <td>上传附件</td>
	                <td class="files">
	                    <p id="filep">
	                        <input type="file" name="attachment" class="file" size="50" /><font class="error" color=red></font>
	                    </p>
	                </td>
                </tr>
		        <tr class="even">
		            <td colspan="2">新闻内容 <span id="contentVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span></td>
		        </tr>
		    </tbody>
		    
		</table>
			<div class="editor">
                     <textarea rows="3" cols="25" id="content1" name="content" class="my_editor"></textarea>
            </div>
           <div class="rowb">
            <div class="row_left">
                <%-- <input type="hidden" name="preview" id="preview" value="false"/>
                <input class="btn bw2" type="submit" onclick="return previewSub();" value="<s:text name='preview'/>"/> --%>
                <input class="btn bw2" type="submit" onclick="return doSub();" name="button" value="<s:text name='finish'/>"/>
                <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
            </div>
            <div class="clear"></div>
        </div>
	</form>
	
</body>
</html>