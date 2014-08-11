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
<link href="css/bootstrap.css" rel="stylesheet">
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->

<title>我的关注</title>
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
          	<li><a href="news_post.action"><span class="glyphicon glyphicon-edit"></span> &nbsp;发帖</a></li>
  		  </s:if>
          <li><a href="news_follow.action"><span class="glyphicon glyphicon-list-alt"></span> &nbsp;关注动态</a></li>
		  <li  class="active" ><a href="follow_start.action">  <span class="glyphicon glyphicon-heart-empty"></span> &nbsp;关注列表 </a> </li>
          <s:if test="#session.status!=0"><%-- 0是学生 --%>
          <li ><a href="news_self.action"> <span class="glyphicon glyphicon-file"></span> &nbsp;我的帖子 </a> </li>
          </s:if>
          <li ><a href="comment_reply.action"> <s:if test="user.newReply >0"><span class="badge pull-right">new</span> </s:if><span class="glyphicon glyphicon-comment"></span> &nbsp;查看评论</a> </li>
          <li><a href="collect_list.action"><span class="glyphicon glyphicon-star-empty"></span> &nbsp;我的收藏</a></li>
          <li><a href="user_account.action"><span class="glyphicon glyphicon-user"></span> &nbsp;账号管理</a></li>
          <li><a href="user_logout.action"><span class="glyphicon glyphicon-off"></span> &nbsp;退出登录</a></li>
        </ul>
      </div>
    </div>
    <div class="col-lg-8">
      <div class="col-lg-12 bkgd">
        <div class=" col-lg-3" >
          <h4>关注列表</h4>
        </div>
        <div class=" col-lg-4" > </div>
        <div class="col-lg-5" >
          <form class="navbar-form " role="search">
            <div class="form-group">
              <input type="text" class="form-control input-sm" placeholder="用户名">
            </div>
            <button type="submit" class="btn btn-sm btn-default">搜索</button>
          </form>
        </div>
      </div>
      <div class="col-lg-4"> <br>
        <label  class="bkgd">
        <p> <a href="follow_fans.action" class="btn  pull-right"  role="button"><strong>关注我的</strong></a> <a href="follow_start.action" class="btn  btn-primary pull-right"  role="button" ><strong>我关注的</strong></a> </p>
        </label>
      </div>
      <!--******************人物列表***********************-->
      <s:iterator value= "userList" var="user" >
      <div class="media col-lg-12"> <a class="pull-left" href="user_startDetail.action?id=<s:property value="#user.id"/>"><img class="media-object img-circle" width="70px" height="70px"  src="imghead/<s:property value="#user.headUrl"/>"  alt="Generic placeholder image"></a>
        <div class="media-body">
          <div class="col-lg-9">
            <h5><strong><s:property value="#user.name" /></strong></h5>
          </div>
          <div class="col-lg-9">
            <p> 关注：<s:property value="#user.followNum" />&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生：<s:property value="#user.fansNum" /></p>
          </div>
          <div class="col-lg-9">
            <p><s:property value="#user.intro" /></p>
          </div>
          <div class="col-lg-3">
          	<a type="button" class="btn btn-default navbar-btn pull-right" href="follow_cancel.action?follw.startId=<s:property value='#user.id'/>&follw.fansId=<s:property value='#session.userId'/>&page=${page}" >取消关注</a>
          </div>
        </div>
      </div>
      </s:iterator>
      <!--*****************************************-->
      
      <div class="col-lg-12"> 
        <br>
         <ul class="pager pull-right">
	     <s:if test= "page>1" >
	  		<li><a href="follow_start.action?page=${page-1}">上一页</a></li>
		 </s:if> 
		 <s:if test= "userList.size()>7" >
	  		<li><a href="follow_start.action?page=${page+1}">下一页</a></li>
	  	 </s:if>
		</ul>
      </div>
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
