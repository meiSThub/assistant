<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta content="IE=11.0000" 
http-equiv="X-Ua-Compatible">
<meta charset="utf-8">
<meta http-equiv="X-Ua-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta name="GENERaTOR" content="MSHTML 11.00.9600.17041">
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/message.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->
<title>账号管理</title>

</head>

<body >

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
           <A class="navbar-brand" href="#"> <img alt="Brand" src="img/logo.png"></A> </div>
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
      <div class="col-lg-12" style="margin-bottom: 20px">
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
          <li><a href="comment_reply.action"> <s:if test="user.newReply >0"><span class="badge pull-right">new</span> </s:if><span class="glyphicon glyphicon-comment"></span> &nbsp;查看评论</a> </li>
          <li><a href="collect_list.action"><span class="glyphicon glyphicon-star-empty"></span> &nbsp;我的收藏</a></li>
          <li class="active"><a href="user_account.action"><span class="glyphicon glyphicon-user"></span> &nbsp;账号管理</a></li>
          <li><a href="user_logout.action"><span class="glyphicon glyphicon-off"></span> &nbsp;退出登录</a></li>
        </ul>
      </div>
    </div>

    <div class="col-lg-8">

      <div class="col-lg-12 bkgd" style=" height:40px; padding-top:1px" >
        <h4><strong>基本资料</strong></h4>
      </div>
      <br>
      <br>
      <br>
      
      <!-- 姓名简介 -->
	  <div class="col-lg-12">
      <form class="form-horizontal" role="form">
        <div class="form-group ">
          <label class="col-sm-2 control-label" for="formGroupInputLarge">姓名：</label>
          <div class="col-sm-4">
          <label class="form-control"><%=session.getAttribute("userName") %></label>
          <!--  <input class="form-control " readonly= "true " type="text" id="formGroupInputLarge" placeholder="">-->
          </div>
        </div>
        <div class="form-group form-group-sm">
          <label class="col-sm-2 control-label" for="formGroupInputLarge">简介：</label>
          <div class="col-sm-9"> 
            <textarea class="form-control myposition" placeholder="20字以内" rows="2" id="intro"><s:property value="user.intro"/></textarea>
            <label class="custom-error" id="intro_error">超出字数范围</label>
          </div>
          
        </div>

		<div class=" pull-right" id="save_intro"><a href="#"><button type="button" class="btn btn-primary">保&nbsp;存</button></a><br></div>  
      </form>
	  </div>
      <!--end 姓名简介 -->
      <br>
      <hr>
      <div class="col-lg-12 bkgd" style="height:40px; padding-top:1px;margin:10px 0" >
        <h4 ><strong>安全设置</strong></h4>
      </div>
      
      <!--safe-->
	  <div class="col-lg-12">
      <form class="form-horizontal" role="form">
          <div class="form-group">
		
		  <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
		  <div class="col-sm-9">
            <input type="password" class="form-control myposition" id="password" placeholder="输入当前密码">
            <label class="custom-error" id="password_error">密码格式不正确</label>
          </div>
		  </div>
		  
		  <div class="form-group">
          <label for="inputEmail3" class="col-sm-2 control-label">邮箱绑定：</label>
          <div class="col-sm-9">
            <input type="email" class="form-control myposition"  id="email"  placeholder="邮箱">
            <label class="custom-error" id="email_error">邮箱格式不正确</label>
          </div>  
          </div>
		<div class=" pull-right" id="save_email"><a href="#"><button type="button" class="btn btn-primary">保&nbsp;存</button></a></div>
        	
      </form>
	  </div>
      <!--end safe-->
      <br>
      <hr>
      <div class="col-lg-12" style="margin-bottom:20px">
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">修改密码：</label>
          <div class="col-sm-9">
            <input type="password" class="form-control myposition" id="oldPassword" placeholder="当前密码">
            <label class="custom-error" id="oldPassword_error">密码格式不正确</label>
           
            <br>
            <input type="password" class="form-control myposition" id="newPassword" placeholder="新密码">
             <label class="custom-error" id="newPassword_error">密码格式不正确</label>
            <br>
            <input type="password" class="form-control myposition" id="newPassword2" placeholder="确认新密码">
            <label class="custom-error" id="newPassword2_error">两次输入密码不一致</label>
          </div>
        </div>
		<div class=" pull-right"><a href="#">
        <button type="button"  id="save_password" class="btn btn-primary">保&nbsp;存</button>
        </a></div>
      </form>
	  </div>
      
    </div>
  </div>
</div>
<div class="footerwarp">
  <footer >
    <hr>
    <p class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有 <A href="about.action"><span>关于我们</span></A> <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy"><span>管理入口</span></a></p>
  </footer>
</div>
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.js"></script> 
<script src="js/footer.js"></script>
<script src="ajaxjs/person.js"></script>
<script src='js/message.js'></script>
</body>
</html>
