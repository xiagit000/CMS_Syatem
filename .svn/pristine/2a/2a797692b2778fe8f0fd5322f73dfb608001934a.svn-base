/**
 * @author sunlin
 * 分页单元
 * 调用：
 * makePagin(总记录数,当前页,共页数,返回类型);
 * 返回类型:true：返回html fasle直接写入页面
 */

function makePaging(total,page,pages,result){
	if(total=="" || total=="0")return "";
	page = parseInt(page);
	var html = "<span>共<span class='en'>"+ total +"</span>条<span class='en'>"+ pages +"</span>页&nbsp;</span>";
	
	var start = page-2<1?1:page-2;
	var end = start+4>pages?pages:start+4;
	if(pages-page<2) start = pages-4<1?1:pages-4;
	 
	if (page != 1) {
		html += makePageLink("上一页", page - 1, null, pages);
	}

	if (start != 1) {
		html += makeFirst(page, pages);
	}
	
	for(var i=start;i<=end;i++){
		html += makePageLink(i,i,page,pages);
	}
	if (pages != end) {
		html += makeLast(page, pages);
	}
	if(page != pages){
		html += makePageLink("下一页",page+1,null,pages);	
	}
	
	html += makePageSelect(page,pages);

	html= "<div class='paging'>"+ html +"</div>";

	if(result)
		return html;
	else
		document.write(html);
}

function makeFirst(){
	return makePageLink("1...",1);
}

function makeLast(page,pages){
	return makePageLink("..."+pages,pages);
}

function makePageLink(text,page,curr,pages){
	if(page==curr)
		return "<a href=\""+ makeUrl(page) +"\" style=\"background-color:#fff;margin:0 2px;\">&nbsp;<span style='color:#670505;text-decoration:underline;font-weight:bold;'>"+ warpPage(text) +"</span>&nbsp;</a>"
	else
		return "<a href=\""+ makeUrl(page) +"\">&nbsp;"+ warpPage(text) +"&nbsp;</a>"
}

function warpPage(page){
	page = new String(page);
	if(!page.match(/^[\u0391-\uFFE5]+$/)){
		return "<span class='en'>"+ page +"</span>";
	}
	return page;
}

function makePageSelect(curr,pages){
	var html = "&nbsp;<span>跳转至</span><select class='sel' name='currentPage' onchange='goPage(this.value)' >";
	for(var i=1;i<=pages;i++)
		html+= "<option value='"+ i +"' "+ (curr==i?" selected='selected' ":"") +">"+ i +"</option>";
	html +="</select><span>页</span>";
	return html;
}
	
function makeUrl(page){
	var url = window.location.toString();
	url = url.replace(/#.*$/,"");
	if(url.match(/pageNo=\d+/)){
		url = url.replace(/pageNo=\d+/,"pageNo="+page);
	}else{
		if(url.indexOf("?")==-1){
			url  += "?pageNo="+page;
		}else{
			url += "&pageNo="+page;
		}
	}
	return url;
}
	
function goPage(page){
	window.location = makeUrl(page);
}
	