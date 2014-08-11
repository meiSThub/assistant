<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta content="IE=11.0000" http-equiv="X-Ua-Compatible">
<meta charset="utf-8">
<meta http-equiv="X-Ua-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta name="GENERaTOR" content="MShtml 11.00.9600.17041">
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/fileinput.css" rel="stylesheet">
<link href="css/message.css" rel="stylesheet"   >
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->

<title>评论我的</title>
</head>

<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
           <A class="navbar-brand" href="#"> <img alt="Brand" src="img/logo.png"></A> 
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a  href="index.action">&nbsp;首&nbsp;页&nbsp;</a></li>
            <li><a href="news_teacher.action">&nbsp;总&nbsp;帖&nbsp;</a></li>
            <li><a href="user_teacher.action">&nbsp;关&nbsp;注&nbsp;</a></li>
            <!-- Button trigger modal -->
            <li class="active">
           			<a href="comment_reply.action"><%=session.getAttribute("userName") %></a>
            </li>
          </ul>
          <!-- sample modal content --> 
          
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container"> <br>
  <div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-2 bkgd"> <br>
      <div class="center-block">
        <center>
          <img class="img-circle" alt="Generic placeholder image" src="imghead/<s:property value ='#session.headUrl' />" width="120px" height="120px">
        </center>
      </div>
      <br>
      <div class="center-block">
        <p class="text-center"><strong><%=session.getAttribute("userName") %></strong></p>
      </div>
      <div class="col-lg-2"></div>
      <div class="col-lg-12">
        <ul class="nav nav-pills nav-stacked" role="tablist">
          <br>
          <s:if test="#session.status!=0"><%-- 0是学生 --%>
          	<li><a href="news_post.action"><span class="glyphicon glyphicon-edit"></span> &nbsp;发帖</a></li>
  		  </s:if>
          <li><a href="news_follow.action"><span class="glyphicon glyphicon-list-alt"></span> &nbsp;关注动态</a></li>
		  <li><a href="follow_start.action">  <span class="glyphicon glyphicon-heart-empty"></span> &nbsp;关注列表 </a> </li>
          <s:if test="#session.status!=0"><%-- 0是学生 --%>
          <li ><a href="news_self.action"> <span class="glyphicon glyphicon-file"></span> &nbsp;我的帖子 </a> </li>
          </s:if>
          <li class="active"><a href="comment_reply.action"> <s:if test="user.newReply >0"><span class="badge pull-right">new</span> </s:if><span class="glyphicon glyphicon-comment"></span> &nbsp;查看评论</a> </li>
          <li><a href="collect_list.action"><span class="glyphicon glyphicon-star-empty"></span> &nbsp;我的收藏</a></li>
          <li><a href="user_account.action"><span class="glyphicon glyphicon-user"></span> &nbsp;账号管理</a></li>
          <li><a href="user_logout.action"><span class="glyphicon glyphicon-off"></span> &nbsp;退出登录</a></li>
        </ul>
      </div>
    </div>
    <div class="col-lg-8">
     <div class="col-lg-12 bkgd">
        <div class=" col-lg-3" >
          <h4>查看评论</h4>
        </div>
     </div>
     <br>
     <br>
     <br>
      <div class="col-lg-4">
        <label  class="bkgd">
        <p> <a href="comment_other.action" class="btn  pull-right"  role="button"><strong>我的回复</strong></a> <a href="comment_reply.action" class="btn  btn-primary pull-right"  role="button"><strong>评论我的</strong></a> </p>
        </label>
      </div>
      
      <!--class="media col-lg-12"评论用户-->
      <s:iterator value= "commentList" var="comment" status="status" >
      <div class="media col-lg-12">
        <div class="media-body">
          <p>
          	<a href="#"><s:property value="#comment.authorName" /></a>在：&nbsp;<a href="news_detail.action?id=<s:property value="#comment.news.id" />"><s:property value="#comment.news.title" /></a>
            &nbsp;回复了我：
            <span class="help-block pull-right"><s:date name="#comment.postTime" format="yyyy-MM-dd hh:mm" /></span>
          </p>
          <s:property value="#comment.content" /> 
        </div>
        <div class="panel-group" id="accordion">
          <div class="panel panel-default">
            <div class="panel-heading" >
              <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapse<s:property value="#status.index" />">
      
                <p class="text-right" style="color:#0093d6">回复</p>
                </a> 
                </h4>
            </div>
            	<div id="collapse<s:property value="#status.index" />" class="panel-collapse collapse">
			  <div class="panel-body">
			   <form action="comment_addReply.action?comment.replyId=<s:property value="#comment.authorId" />&replyName=<s:property value="#comment.authorName"/>&news.id=<s:property value="news.id"/>" method="post" onsubmit="return checkReply('reply<s:property value="#comment.id"/>')">
			   <div class=" ">
				  <textarea class="form-control" rows="3" placeholder="回复<s:property value="#comment.authorName"/>" name="content" id="reply<s:property value="#comment.id"/>"></textarea>
				  <br>
				  	 <s:if test="#session.userId!=null">
				  	 	<input type="submit" class="btn  btn-primary pull-right" value="发&nbsp;表">
	  				 </s:if>
	  				 <s:else>
      					<a href="#" class="btn  btn-primary pull-right" data-toggle="modal" data-target="#myModal" role="button"><strong>发&nbsp;表</strong></a>
	  				 </s:else>
			   </div>
			   </form>
			  </div>
			</div>
          </div>
        </div>
      </div>
      </s:iterator>
      <!--评论结束-->
      <div class="col-lg-12"> 
        <br>
      	<ul class="pager pull-right">
	     <s:if test= "page>1" >
	  		<li><a href="comment_other.action?page=${page-1}">上一页</a></li>
		 </s:if> 
		 <s:if test= "commentList.size()>7" >
	  		<li><a href="comment_reply.action?page=${page+1}">下一页</a></li>
	  	 </s:if>
		</ul>
     </div>
    </div>
  </div>
</div>
<div class="footerwarp">
  <footer >
    <hr>
    <p class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有 <a href="about.action"><span>关于我们</span></a> <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy"><span>管理入口</span></a></p>
  </footer>
</div>
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.js"></script> 
<script src="js/fileinput.js"></script> 
<script src="js/footer.js"></script>
<script src='js/message.js'></script>
<script src="ajaxjs/collect.js"></script>

</body>
</html>
