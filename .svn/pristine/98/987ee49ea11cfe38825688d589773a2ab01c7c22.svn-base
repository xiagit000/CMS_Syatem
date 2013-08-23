<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="${application.keyWords }" />
<meta name="description" content="${application.description }" />
<title>湖北省证券业协会</title>
<link href="<s:url value="/templates/default/static/css/tt.css"/>" rel="stylesheet" type="text/css"/>
<script src="<s:url value="/templates/default/static/js/jquery-1.8.0.min.js"/>" type="text/javascript" language="javascript"></script>
<script src="<s:url value="/templates/default/static/js/common.js"/>" type="text/javascript" language="javascript"></script>
<%-- <script src="<s:url value="/templates/default/static/js/curvycorners.js"/>" type="text/javascript" language="javascript"></script> --%>
<!--[if lt IE 7]>
    <script type="text/javascript" src="<s:url value="/templates/default/static/js/unitpngfix.js"/>"></script>
<![endif]-->

<!--[if IE]>
    <link rel="stylesheet" media="all" type="text/css" href="<s:url value="/templates/default/static/css/ie.css"/>" />
<![endif]-->
</head>

<body>

<div id="ad">
    <div class="close" onclick="hidead();">关闭</div>
    <a href="#">${drift.content}</a>
</div>
<script type="text/javascript">
    var ad1=new AdMove("ad");
        ad1.Run();
</script>

<div id="wraper">
    
    <s:include value="open/head.jsp"></s:include>
    
    <script type="text/javascript">
	    jQuery(document).ready(function(){
            jQuery('#VerificationCode').click(function(){
                jQuery(this).attr('src',"<s:url value='/templates/default/VerificationCode.jsp'/>?" + Math.random());
            })
        })
	</script>
	
    <div id="main" class="clearfix">
    <div id="column_left">
		<s:if test="currentUser == null">
			<div id="login">
				<form class="loginbox" action="<s:url value='/user/login'/>" method="post">
				<input type="hidden" name="noVerifyCode" value="true" /> 
					<p><span>帐&nbsp;&nbsp;号</span><input type="text" name="username"/></p>
					<p><span>密&nbsp;&nbsp;码</span><input type="password" name="password"/></p>
					<p>
						<span>验证码</span>
						<img id="VerificationCode" src="<s:url value='/templates/default/VerificationCode.jsp'/>" 
                           title="太难了，换个简单的..." style="vertical-align: middle;"/>
						<input id="verifyCode" name="verifyCode" type="text" 
	                        style="width:42px;vertical-align: middle;" value="" maxlength="3" 
	                        onkeyup="this.value=this.value.replace(/(^-)|\D/g,'$1')" onafterpaste="this.onkeyup" />
                    </p>
					<p><input class="loginbtn" type="submit" value="登录"/><a href="#">忘记密码？</a></p>
					<p style="color:red ">
					   <s:if test="msgs.size != 0"><s:property value="%{msgs.flash}" escape="false"/></s:if>
					</p>
				</form>
			</div>
		</s:if>
		<s:else>
			<div id="welcome">
				<span>${currentUser.username}&nbsp;<s:text name="welcome"></s:text></span>
				<ul>
					<li><a href="<s:url value='/admin/manage'/>"><s:text name="backManage"/>&gt;&gt;</a></li>
					<li><a href="<s:url value='/user/logout'/>"><s:text name="logout"/>&gt;&gt;</a></li>
				</ul>
			</div>
		</s:else>
		
        <div class="lim-height">
        </div>
        <div id="search">
             <form name="form1" id="form1" action="<s:url value='/open/search'/>" method="post" >
            <input class="btn2 font1" type="text" value="请输入搜索关键字" name="keyword" id="keyword" 
                onblur="if(this.value==''){value='请输入搜索关键字';this.className='btn2 font1'}" 
                onfocus="if(this.value==this.defaultValue){this.value='';this.className='btn2 font2'}"/>
            <a href="javascript:document.form1.submit()" target="_self" style="">
                <img style="text-indent:0;" width="32" height="32" src="<s:url value='/images/blank.gif'/>"/></a>
            </form>
        </div>
        <div class="lim-height">
        </div>
        <div id="leftrank">
            <div class="title">             
                <h2>交易量排行榜</h2>
                <a href="<s:url value='/deal-amount'/>">更多</a>
            </div>
            <div class="rankbox">
                <!-- <div class="sectitle">
                    <h3>2012年1-9月</h3>                  
                </div>  -->             
                <div class="rankcontent" id="marquee_d">
                    <ul>
                        <s:iterator value="dealAmounts" id="entry">
	                       <li>
	                           <div class="rankcom">
	                               <a href="#" title="${entry.company}">${entry.company}</a>
	                           </div>
	                       </li>
                        </s:iterator>
                        <s:iterator value="dealAmounts" id="entry">
                           <li>
                               <div class="rankcom">
                                   <a href="#" title="${entry.company}">${entry.company}</a>
                               </div>
                           </li>
                        </s:iterator>
                    </ul>
                </div>
            </div>
        </div>
        <div class="lim-height">
        </div>
        <div id="vote">
            <div class="title">
                <h2>投票箱</h2>
                <a href="<s:url value='/ticket'/>">更多</a>
            </div>
            <div class="votebox">
                <div class="sectitle">
                    <h3>${vote.title}</h3>
                </div>
                <s:if test="tickets != null" >
                <form action="<s:url value='/ticket'/>" method="post" >
                    <input type="hidden" name="voteId" value="${vote.id}"/>
	                <div class="votecontent">
	                    <ul>
		                    <s:iterator value="tickets" id="entry" status="status">
		                        <li>
		                            <input class="check" type="radio" name="ticket.id" id="ticket.id" 
		                              value="${entry.id}" />${entry.title}
		                        </li>
		                    </s:iterator>
	                        <li>
	                            <input class="check" type="radio" name="ticket.id" id="ticket.id" value="0"/>其他：
	                            <input class="input font1"  type="text" name="ticket.title" id= ticket.title value="请输入内容" 
	                            onblur="if(this.value==''){value='请输入内容';this.className='input font1'}" 
	                            onfocus="if(this.value==this.defaultValue){this.value='';this.className='input font2'}" />
	                        </li>
	                        <li class="center">
	                            <input class="btn" type="submit" value="投票"/>
	                            <input class="btn" type="button" value="查看" 
	                               onclick="location.href='<s:url value='/ticket/%{vote.id}/show'/>'"/>
	                        </li>
	                    </ul>
	                </div>
                </form>
                </s:if>
            </div>
        </div>
    </div>

    <div id="column_right">
        <div id="column_right_top">
            <div id="news">
                <div id="news_pic">
                    <div class="hot">
                        <div id="idNum" class="num">
                            <h3 class="slide_triger">
                                <s:iterator value="picNews" var="pn" status="status" id="entry">
                                    <a href="#" data-target="bd${status.index+1}">${status.index+1}</a>
		                        </s:iterator>
                            </h3>
                        </div> 
                         <div class="bd" style="width:370px;height:300px;">
                            <ul >
	                            <s:iterator value="picNews" var="pn" status="status" id="entry">
	                            <s:set name="palt" value="%{image.description!=null?image.description:''}"></s:set>
	                                <li id="cover${status.index+1}" class="bd${status.index+1}" style="display:block;">
		                                <a href="<s:url value='%{url(#entry)}'/>" target="_blank" 
		                                  style="width:370px;height:300px;display:block;background:url(<s:url 
		                                  value='%{image.iconImg}' />) no-repeat center center;" title="${palt}"></a>
		                                <p><a href="<s:url value='%{url(#entry)}'/>" target="_blank">${palt}</a></p>
	                                </li>
	                            </s:iterator>
                            </ul>
                        </div>
                    </div>
                </div>

                <script>
                    $(".bd2,.bd3,.bd4,.bd5").hide();
                
                    $(".slide_triger").find("a").click(function(){
                        $(".bd1,.bd2,.bd3,.bd4,.bd5").hide();
                        $("." + $(this).attr("data-target")).show();
                        return false;
                    });
                    var bds = [".bd1",".bd2",".bd3",".bd4",".bd5"];
                    var index = 0;

                    setInterval(function(){
                        $(".bd1,.bd2,.bd3,.bd4,.bd5").hide();
                        $(bds[index]).show();
                        $(".slide_triger").find("a").removeClass("curr");
                        $("[data-target=bd"+ (index+1) +"]").addClass("curr");  
                        index ++ ;
                        if(index >= bds.length){
                            index = 0;
                        }

                    },4000);

                </script>
            
                <div id="news_list">
                  <%-- 第一、二、三区块 --%>  
                  <div class="tabmenu">
                   <ul>
                    <li onmouseover="tabChange(this,'tabcontent')" class="cli">
                        <a href="<s:url value='/open/menu/%{blocks[0].node.id}'/>">${blocks[0].name } </a>
                    </li>
                    <li onmouseover="tabChange(this,'tabcontent')">
                        <a href="<s:url value='/open/menu/%{blocks[1].node.id}'/>">${blocks[1].name } </a>
                    </li>
                    <li onmouseover="tabChange(this,'tabcontent')">
                        <a href="<s:url value='/open/menu/%{blocks[2].node.id}'/>">${blocks[2].name }</a>
                    </li>
                   </ul>
                  </div>
                  <div id="tabcontent">
                   <ul name="tabul">
                    <s:iterator value="entrysMap[blocks[0].id]" id="entry" status="st0">
                    <li>
	                    <a href="<s:url value='%{url(#entry)}'/>" target="_blank" title="${entry.title }">${entry.title }</a>
	                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/> </span>
                    </li> 
                    <s:date name="#e.publishedTime" format="%{getText('simpleDateFormat')}"/> 
                    </s:iterator>                  
                   </ul>
                   <ul class="hidden" name="tabul">
                    <s:iterator value="entrysMap[blocks[1].id]" id="entry" status="st1">
                    <li>
	                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title } </a>
	                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                    </li>
                    </s:iterator>
                   </ul>
                   <ul class="hidden" name="tabul">
                    <s:iterator value="entrysMap[blocks[2].id]" id="entry" status="st2">
                    <li>
	                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title } </a>
	                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                    </li>
                    </s:iterator>
                   </ul>
                  </div>
                 </div>
            </div>
        </div>
        
        <div id="column_right_down">
            <div id="column_right_down_left">
                <div id="guanggao">
                        <ul class="gg">
                            <s:iterator value="adwords" id="entry" status="status">
                                <li class="gg${status.count}" 
                                style="${status.count == 1 ? 'display:block;' : 'opacity:0;filter:alpha(opacity=0); '}">
	                                <table>
		                                <tr>
		                                  <td>${title}<br />${content}</td>
		                                </tr>
	                                </table>
                                </li>
                            </s:iterator>
                        </ul>
                </div>
                
                <script>
                    var bds1 = [<s:iterator value="adwords" id="entry" status="status">".gg${status.count}",</s:iterator>0];
                    var index1 = 1;

                    setInterval(function(){
                        $(bds1.join(",")).animate({
                            opacity:0
                        },500);
                        $(bds1[index1]).animate({
                            opacity:1
                        },500);
                        index1 ++ ;
                        if(index1 >= bds1.length-1){
                            index1 = 0;
                        }

                    },5000);
                </script>
                <!-- <div class="lim-height"></div> -->
                <div id="tjcy">
                    <%-- 第四、五、六、七区块 --%>
                    <div id="chuangxin">
                        <div class="title">
                            <h2>${blocks[3].name }</h2>
                            <a href="<s:url value='/open/menu/%{blocks[3].node.id}'/>">更多</a>
                        </div>
                        <div class="cxbox">                             
                            <div class="tabmenu">
                                <ul>
                                    <li class="cli" onmouseover="tabChange(this,'cxcontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[4].node.id}'/>">${blocks[4].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'cxcontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[5].node.id}'/>">${blocks[5].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'cxcontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[6].node.id}'/>">${blocks[6].name }</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tabcontent" id="cxcontent">
                                <ul>
                                    <s:iterator value="entrysMap[blocks[4].id]" id="entry" status="st4">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator>                                    
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[5].id]" id="entry" status="st5">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[6].id]" id="entry" status="st6">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div id="huiyuan">
                        <%-- 第八、九、十、十一区块 --%>
                        <div class="title">
                            <h2>${blocks[7].name }</h2>
                            <a href="<s:url value='/open/menu/%{blocks[7].node.id}'/>">更多</a>
                        </div>
                        <div class="cxbox">
                            <div class="tabmenu">
                                <ul>
                                    <li class="cli" onmouseover="tabChange(this,'hycontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[8].node.id}'/>">${blocks[8].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'hycontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[9].node.id}'/>">${blocks[9].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'hycontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[10].node.id}'/>">${blocks[10].name }</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tabcontent" id="hycontent">
                                <ul>
                                    <s:iterator value="entrysMap[blocks[8].id]" id="entry" status="st8">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator>                                    
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[9].id]" id="entry" status="st9">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[10].id]" id="entry" status="st10">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div id="jiufen">
                        <%-- 第十二、十三、十四、十五区块 --%>
                        <div class="title">
                            <h2>${blocks[11].name }</h2>
                            <a href="<s:url value='/open/menu/%{blocks[11].node.id}'/>">更多</a>
                        </div>
                        <div class="cxbox">                            
                            <div class="tabmenu">
                                <ul>
                                    <li class="cli" onmouseover="tabChange(this,'jfcontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[12].node.id}'/>">${blocks[12].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'jfcontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[13].node.id}'/>">${blocks[13].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'jfcontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[14].node.id}'/>">${blocks[14].name }</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tabcontent" id="jfcontent">
                                <ul>
                                    <s:iterator value="entrysMap[blocks[12].id]" id="entry" status="st12">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator>                                    
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[13].id]" id="entry" status="st13">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[14].id]" id="entry" status="st14">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div id="congye">
                        <%-- 第十六、十七、十八、十九区块 --%>
                        <div class="title">
                            <h2>${blocks[15].name }</h2>
                            <a href="<s:url value='/open/menu/%{blocks[15].node.id}'/>">更多</a>
                        </div>
                        <div class="cxbox">
                            <div class="tabmenu">
                                <ul>
                                    <li class="cli" onmouseover="tabChange(this,'cycontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[16].node.id}'/>">${blocks[16].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'cycontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[17].node.id}'/>">${blocks[17].name }</a>
                                    </li>
                                    <li onmouseover="tabChange(this,'cycontent')">
                                        <a href="<s:url value='/open/menu/%{blocks[18].node.id}'/>">${blocks[18].name }</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tabcontent" id="cycontent">
                                <ul>
                                    <s:iterator value="entrysMap[blocks[16].id]" id="entry" status="st16">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator>                                    
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[17].id]" id="entry" status="st17">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                                <ul class="hidden">
                                    <s:iterator value="entrysMap[blocks[18].id]" id="entry" status="st18">
                                    <li>
	                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                    </li>
                                    </s:iterator> 
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="lim-height"></div>
                <div id="data">
                    <%-- 第二十、二十一、二十二、二十三区块 --%>
                    <ul>
                        <li><a href="<s:url value='/open/menu/%{blocks[19].node.id}'/>">${blocks[19].name }</a></li>
                        <li><a href="<s:url value='/open/menu/%{blocks[20].node.id}'/>">${blocks[20].name }</a></li>
                        <li><a href="<s:url value='/open/menu/%{blocks[21].node.id}'/>">${blocks[21].name }</a></li>
                        <%-- <li><a href="<s:url value='/open/menu/%{blocks[22].node.id}'/>">${blocks[22].name }</a></li> --%>
						<li>
						    <s:if test="blocks[22].node.link">
								<s:if test="startWithHttp">
									<a href="${address}" target="${blank}">${blocks[22].name}</a>
								</s:if>
								<s:else>
									<a href="<s:url value='%{blocks[22].node.address}'/>" target="${blank}">${blocks[22].name}</a>
								</s:else>
							</s:if> 
							<s:else>
								<a href="<s:url value='/open/menu/%{blocks[22].node.id}'/>">${blocks[22].name}</a>
							</s:else>
					     </li>
					</ul>   
                </div>
            </div>
            <div id="column_right_down_right">
                <div id="tousu">
                    <div class="title">
                        <h2>投诉平台</h2>
                    </div>
                    <div class="tousubox">
                        <ul>
                            <%-- <li>
                                <div class="tsn1">
                                    <a href="<s:url value='/complaint/new'/>">网络投诉</a>
                                </div>
                            </li> --%>
                            <li>
                                <div class="tsn2">
                                    <a>电话投诉</a>
                                </div>
                                <p class="dh">投诉电话：027-87460061</p>
                            </li>

                        </ul>
                    </div>
                </div>
                <%-- 第二十四区块 --%>
                <div id="wenhua">
                    <div class="title">
                        <h2>${blocks[23].name}</h2>
                        <a href="<s:url value='/open/menu/%{blocks[23].node.id}'/>">更多</a>
                    </div>
                    <div class="cxbox">
                        <div class="tabmenu">
                            <ul>
                                <li class="cli" onmouseover="tabChange(this,'whcontent')">
                                    <a href="<s:url value='/open/menu/%{blocks[25].node.id}'/>">${blocks[25].name }</a>
                                </li>
                                <li onmouseover="tabChange(this,'whcontent')">
                                    <a href="<s:url value='/open/menu/%{blocks[26].node.id}'/>">${blocks[26].name }</a>
                                </li>
                            </ul>
                        </div>
                        <div class="tabcontent" id="whcontent">
                        <ul>
                            <s:iterator value="entrysMap[blocks[25].id]" id="entry" status="st26">
                                <li>
	                                <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                </li>
                            </s:iterator> 
                        </ul>
                        <ul class="hidden">
                            <s:iterator value="entrysMap[blocks[26].id]" id="entry" status="st27">
                                <li>
                                    <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
                                    <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                </li>
                            </s:iterator> 
                        </ul>
                    </div>
                </div>
                </div>
                <div class="lim-height"></div>
                <div id="caijing">
                    <div class="title">
                        <h2>${blocks[24].name}</h2>
                        <a href="<s:url value='/open/menu/%{blocks[24].node.id}'/>">更多</a>
                    </div>
                    <div class="cjbox">
                        <ul>
                            <s:iterator value="entrysMap[blocks[24].id]" id="entry" status="st23">
                                <li>
	                                <a href="<s:url value='%{url(#entry)}'/>" title="${entry.title }">${entry.title }</a>
	                                <span><s:date name="#entry.publishedDate" format="yyyy-MM-dd"/></span>
                                </li>
                            </s:iterator> 
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="link">
    <div class="title">
        <h2>友情链接</h2>
    </div>
    <div class="lin">
        <a class="zuo"></a>
        <div id="marquee_c" class="marquee_c">
	        <ul>
	            <li>
		            <s:iterator value="linkTypes" var="t" status="status">
		                <s:iterator value="%{fetchLinks(#t)}" var="lo" status="status">
		                    <a href="${link}" target="_blank">${name}</a> │ 
		                </s:iterator>
		            </s:iterator>
	            </li>           
	        </ul>
        </div>
        <a class="you"></a>
    </div>
</div>
      
<script src="<s:url value="/templates/default/static/js/kxbdmarquee.js"/>" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$("#marquee_a").kxbdMarquee();
	$("#marquee_b").kxbdMarquee({direction:"down"});
	$("#marquee_c").kxbdMarquee({direction:"left",isEqual:false});
	$("#marquee_d").kxbdMarquee({direction:"up",isEqual:false});
});
</script>

<s:include value="open/foot.jsp" />
</div>

</body>
</html>