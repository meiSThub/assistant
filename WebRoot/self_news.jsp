<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta content="IE=11.0000" 
http-equiv="X-Ua-Compatible">
<meta charset="utf-8">
<meta http-equiv="X-Ua-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta name="GENERaTOR" content="MShtml 11.00.9600.17041">
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->

<title>我的帖子</title>
</head>

<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="#"> <img alt="Brand" src="img/logo.png"></a> </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a  href="index.action">&nbsp;首&nbsp;页&nbsp;</a></li>
            <li><a href="news_teacher.action">&nbsp;总&nbsp;帖&nbsp;</a></li>
            <li><a href="user_teacher.action">&nbsp;关&nbsp;注&nbsp;</a></li>
            <!-- Button trigger modal -->
            <li class="active">
           		<a href=""><%=session.getAttribute("userName") %></a>
            </li>
          </ul>
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
          	<li ><a href="news_post.action" ><span class="glyphicon glyphicon-edit"></span> &nbsp;发帖</a></li>
  		  </s:if>
          <li><a href="news_follow.action"><span class="glyphicon glyphicon-list-alt"></span> &nbsp;关注动态</a></li>
		  <li><a href="follow_start.action">  <span class="glyphicon glyphicon-heart-empty"></span> &nbsp;关注列表 </a> </li>
          <s:if test="#session.status!=0"><%-- 0是学生 --%>
          <li class="active"><a href="news_self.action"> <span class="glyphicon glyphicon-file"></span> &nbsp;我的帖子 </a> </li>
          </s:if>
          <li><a href="comment_reply.action"> <s:if test="tempUser.newReply >0"><span class="badge pull-right">new</span> </s:if><span class="glyphicon glyphicon-comment"></span> &nbsp;查看评论</a> </li>
          <li><a href="collect_list.action"><span class="glyphicon glyphicon-star-empty"></span> &nbsp;我的收藏</a></li>
          <li><a href="user_account.action"><span class="glyphicon glyphicon-user"></span> &nbsp;账号管理</a></li>
          <li><a href="user_logout.action"><span class="glyphicon glyphicon-off"></span> &nbsp;退出登录</a></li>
        </ul>
      </div>
    </div>
    <div class="col-lg-8">
     <div class="col-lg-12 bkgd">
        <div class=" col-lg-3" >
          <h4>我的帖子</h4>
        </div>
     </div>
      <!-- Table -->
      <div class="col-lg-12">
        <table class="table text-overflow">
          <thead>
            <tr>
              <th>标题</th>
              <th></th>
              <th>回帖</th>
              <th>时间</th>
            </tr>
          </thead>
          <tbody class="text_ellipsis">
          <s:iterator value="newsList" var="news">
          <tr>
              <td><div class=" text-overflow width"><a href="news_detail.action?id=<s:property value="#news.id" />"> <s:property value="#news.title" /></a></div></td>
              <td></td>
              <td><s:property value="#news.commentNum" /></td>
              <td><s:date name="#news.postTime" format="yyyy-MM-dd" /></td>
            </tr>
            </s:iterator>       
          </tbody>
        </table>
      </div>
      <div class="col-lg-12"> 
      <br>
        <ul class="pager pull-right">
	     <s:if test= "page>1" >
	  		<li><a href="news_self.action?page=${page-1}">上一页</a></li>
		 </s:if> 
		 <s:if test= "newsList.size()>7" >
	  		<li><a href="news_self.action?page=${page+1}">下一页</a></li>
	  	 </s:if>
		</ul>
    </div>
  </div>
</div>
<div class="footerwarp">
  <footer >
    <hr>
    <p class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有<a href="about.action"><span>关于我们</span></a> <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy"><span>管理入口</span></a></p>
  </footer>
</div>
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.js"></script> 
<script src="js/holder.js"></script> 
<script src="js/footer.js"></script>
</body>
</html>
