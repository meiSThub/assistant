<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta content="IE=11.0000" http-equiv="X-Ua-Compatible">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<link rel="stylesheet" href="control/css/zyUpload.css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/message.css" rel="stylesheet" >
<title>发帖</title>
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
           		<a href=""><%=session.getAttribute("userName") %></a>
            </li>
          </ul>
          <!-- sample modal content --> 
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container" style="margin-bottom:20px"> <br>
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
          	<li class="active" ><a href="news_post.action" ><span class="glyphicon glyphicon-edit"></span> &nbsp;发帖</a></li>
  		  </s:if>
          <li><a href="news_follow.action"><span class="glyphicon glyphicon-list-alt"></span> &nbsp;关注动态</a></li>
		  <li><a href="follow_start.action">  <span class="glyphicon glyphicon-heart-empty"></span> &nbsp;关注列表 </a> </li>
          <s:if test="#session.status!=0"><%-- 0是学生 --%>
          <li ><a href="news_self.action"> <span class="glyphicon glyphicon-file"></span> &nbsp;我的帖子 </a> </li>
          </s:if>
          <li><a href="comment_reply.action"> <s:if test="tempUser.newReply >0"><span class="badge pull-right">new</span> </s:if><span class="glyphicon glyphicon-comment"></span> &nbsp;查看评论</a> </li>
          <li><a href="collect_list.action"><span class="glyphicon glyphicon-star-empty"></span> &nbsp;我的收藏</a></li>
          <li><a href="user_account.action"><span class="glyphicon glyphicon-user"></span> &nbsp;账号管理</a></li>
          <li><a href="user_logout.action"><span class="glyphicon glyphicon-off"></span> &nbsp;退出登录</a></li>
        </ul>
      </div>
    </div>
    <div class="col-lg-8"> 
      <!--Content 发帖框-->
    <div class="col-lg-12 bkgd">
        <div class=" col-lg-3" >
          <h4>发帖</h4>
        </div>
     </div>
      <form class="form-horizontal" role="form" action="news_send.action" method="post" id="post_news" onsubmit="return checkPost()">
        <br>
        <br>
        <div class="form-group"> <br>
          <label class="col-sm-2 control-label">主题</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" name ="title" placeholder="主题不超过十六个字" id="title">
          </div>
        </div>
        <div class="form-group">
          <label  class="col-sm-2 control-label" >正文</label>
          <div class="col-sm-10">
            <textarea class="form-control" placeholder="" rows="10" name ="content" id="content"></textarea>
          </div>
        </div>
         <input id="puc_url" class="hidden" name="pic_list" >
      </form>
      <div class="col-lg-12"  style="margin-bottom:35px">
	  
        <div class="col-lg-1 pull-right">
          <button type="button" class="btn btn-sm upload_btn btn-primary">&nbsp;&nbsp;发&nbsp;&nbsp;布&nbsp;&nbsp;</button>
          </div>
		   <div class="col-lg-1 pull-right">
          
          </div>
        <div class="col-lg-1 pull-right">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
         <button type="button" class="btn btn-sm btn-default"> 添加图片</button>
        </a>
      </div>
       <!-- <div class="col-lg-2 pull-right ctrlhidden"><a href="#">
          <button type="button" class="btn btn-sm btn-default">预　览</button>
          </a></div>-->
      </div>
	  
	  <div class="col-lg-10">
      
           <div class="col-lg-10 pull-right">
            <div class="panel-group" id="accordion">
			  <div class="panel panel-default">
				<div id="collapseOne" class="panel-collapse collapse">
				  <div class="panel-body" style="height:600px">
                  
				   <div id="demo" class="demo"></div>
				  </div>
				</div>
			  </div>
		    </div>  
          </div>
	 </div>
    </div>
  </div>
</div>
<div class="footerwarp">
  <footer >
    <hr>
    <p class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有 <a href="about.action"><span>关于我们</span></A> <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy"><span>管理入口</span></A></p>
  </footer>
</div> 
<script src="js/jquery.js"></script>
<!-- 引用核心层插件 --> 
<script  src="core/zyFile.js"></script> 
<!-- 引用控制层插件 --> 
<script  src="control/js/zyUpload.js"></script> 
<!-- 引用初始化JS --> 
<script src='js/message.js'></script>
<script  src="js/demo.js"></script> 
<script src="js/bootstrap.js"></script> 
<script src="js/footer.js"></script>
</body>
</html>
