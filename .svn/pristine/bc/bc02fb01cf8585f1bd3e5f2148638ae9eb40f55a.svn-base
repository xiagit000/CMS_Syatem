<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@page import="com.boventech.cms.module.web.PageIndex"%>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%

PageIndex paging = (PageIndex)request.getAttribute("pageIndex");
//页面请求
String query = request.getQueryString(); 
//String query=getQueryStringOverRide(request);
//总记录数
int total = paging.getTotalRows();
//当前页面
int currPage = paging.getCurrentPage();
//总页面数
int pages = paging.getTotalPages();
//生成输出HTML
if(total > 0 ){
	out.print(makePaging(total,currPage,pages,query==null?"":query));
}

%>

<%!

//生成翻页
//total 总记录数, page 当前页, pages 总页数 location 请求
public String makePaging(int total,int page,int pages,String location){
	//String html = "<span>共<span class='en'>"+ total +"</span>条<span class='en'>"+ pages +"</span>页&nbsp;</span>";
	String html = "共" + total + "条" + pages + "页";
	int start = page-2<1?1:page-2;
	int end = start+4>pages?pages:start+4;
	if(pages-page<2) start = pages-4<1?1:pages-4;
	if (page != 1) {
		html += makePageLink("上一页", page - 1, 0, pages,location);
	}
	
	if(end - start > 1){
		for(int i=start;i<=end;i++){
			html += makePageLink(String.valueOf(i),i,page,pages,location);
		}
	}

	if(page != pages){
		html += makePageLink("下一页",page+1,0,pages,location);	
	}
	
	//html += makePageSelect(page,pages);

	html= "<div class='fenye'>"+ html +"</div>";
	
	return html;
}

//text 文字，page 页数，currPage 当前页
public String makePageLink(String text,int page,int currPage,int pages,String location){
	if(page==currPage)
		return "<span>"+ text +"</span>";
	else
		return "<a href=\""+ makeUrl(page,location) +"\">"+ text +"</a>";
}

//生成SELECT
public String makePageSelect(int curr,int pages){
	String html = "&nbsp;<span>跳转至</span><select class='sel' name='currentPage' onchange='goPage(this.value)' >";
	for(int i=1;i<=pages;i++)
		html+= "<option value='"+ i +"' "+ (curr==i?" selected='selected' ":"") +">"+ i +"</option>";
	html +="</select><span>页</span>";
	return html;
}

//产生url
public String makeUrl(int page,String location){
	String url = (location=="" ? "" : "?") + location;		
	url = url.replaceAll("#.*$","");
	if(url.indexOf("page=")!=-1){
		url = url.replaceAll("page=\\d*","page="+String.valueOf(page));
	}else{
		if(url.indexOf("?")==-1){
			url += "?page="+String.valueOf(page);
		}else{
			url += "&page="+String.valueOf(page);
		}
	}
	return url;
}

%>


		