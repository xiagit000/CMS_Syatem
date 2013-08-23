<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>内部新闻</title>
</head>
<body>

    <script type="text/javascript" charset="utf-8" src="<s:url value='/javascript/kindeditor.js'/>"></script>
    <script type="text/javascript">
        //初始化显示编辑器
        KE.show({
            id : 'content',
            allowFileManager : true,
            cssPath : '<s:url value="/res/css/editor_index.css"/>',
            contextPath: '<s:url value="/"/>',
            imageUploadJson: '<s:url value="/image-upload"/>',
            fileManagerJson: '<s:url value="/image-manage"/>'
        });
        
        function previewSub() {
            $("#preview").val("true");
            $("form[name=example]").attr("target","_blank");
            if (checkNull()) {
                var content = KE.util.getSrcData('content');
                $("#content").val(content);
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
            var content = KE.util.getSrcData('content');
            content = $('<p>'+content+'</p>').text();
            if(content == null || content.trim().length == 0){
                alert('<s:text name="contentNotNull"/>');
                return false;
            }
            return true;
        }
        
        $(function(){
            addRule("#title",   "#titleVmsg", "(bt)(len[0,30])",     "(<s:text name='mustFill'/>)(标题字数不得多于15个中文字符或30个英文字符)");
        });
    </script>
    <s:include value="../../common/calendar.jsp"></s:include>
    <script src="<s:url value='/javascript/valid/vf.js'/>"  type="text/javascript" /></script>
    <script src="<s:url value='/javascript/valid/vform.js'/>" type="text/javascript" /></script>

    <div class="class_title">内部新闻</div>
    
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
                <td><s:property value="news.title"/>
                </td>
            </tr>
            <tr>
            <td>附件</td>
            <td>
                <a href="<s:url value='%{news.filepath}'/>" target="_blank">${news.attachmentFileName}</a>
            </td>
        </tr>
            <tr class="even">
                <td colspan="2">新闻内容</td>
            </tr>
        </tbody>
        
    </table>
    <div class="editor">
             <s:property value="news.content"  escape="false"/>
    </div>
    
    <s:if test="#session.right.getRight() > 0">
        <div class="rowb">
            <div class="row_left">
                <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
            </div>
            <div class="clear"></div>
        </div>
    </s:if>
    <s:else>
    
	    <s:if test="revert == null">
	        <div class="class_title">新增内部新闻回复</div>  
	        <form  name="example" action="<s:url value='/admin/revert'/>" method="post" enctype="multipart/form-data" 
	            onsubmit="return checkNull();">
	    </s:if>
	    <s:else>
	        <div class="class_title">编辑内部新闻回复</div>  
	        <form action="<s:url value='/admin/revert/%{revert.id}'/>" method="post" enctype="multipart/form-data" 
	            onsubmit="return checkNull();">
	        <input type="hidden" name="_method" value="put"/>
	    </s:else>
	    
		<table class="info">
		    <s:hidden name="newsId" value="%{id}"/>
		    <thead>
		        <tr>
		            <th class="two_col_head"><s:text name="section"></s:text></th>
		            <th><s:text name="info"></s:text></th>
		        </tr>
		    </thead>
		    <tbody>
		        <tr class="odd">
		            <td>标题</td>
		            <td>
			            <input name="revert.title" class="w300" id="title" type="text" value="${revert.title}"/>
			            <span id="titleVmsg" class="vmsg"></span><span class="vhint"><span>&#42;</span></span>
		            </td>
		        </tr>
                                <s:if test="revert.attachmentFileName != null">
		        <tr id="filetr">
                    <td>已上传附件</td>
                    <td>
                        <ul>
                            <li>
                                    <input type="checkbox" value="${revert.id}" name="reserved" checked="checked"/>
                                    <a href="<s:url value='%{revert.filepath}'/>" 
                                       target="_blank">${revert.attachmentFileName}</a>
                            </li>
                        </ul>   
                    </td>
                </tr>
                                </s:if>
                <tr id="filetr">
                    <td>上传附件</td>
                    <td class="files">
                        <p id="filep">
                            <input type="file" name="attachment" class="file" size="50"/>
                            <font class="error" color=red></font>
                        </p>        
                    </td>
                </tr>
		        <tr class="even">
		            <td colspan="2">内容 <span class="vhint"><span>&#42;</span></span></td>
		        </tr>
		    </tbody>
		</table>
	    <div class="editor">
	             <textarea rows="3" cols="25" id="content" name="revert.content" 
	               class="my_editor">${revert.content}</textarea>
	    </div>
	    <div class="rowb">
	     <div class="row_left">
	         <input class="btn bw2" type="submit" onclick="return doSub();" name="button" 
	           value="<s:text name='finish'/>"/>
	         <input class="btn bw2" type="button" onclick="back();" value="<s:text name='back'/>"/>
	     </div>
	        <div class="clear"></div>
	    </div>
	    <br/>
	        
	    </form>
    
    </s:else>
    
</body>
</html>