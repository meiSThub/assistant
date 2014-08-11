<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<link href="img/icon.png" rel="icon">
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<title>admin add user</title>
</head>

<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="index.html"> <img alt="Brand" src="img/logo.png"></a> </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a 
  href="index.html">&nbsp;首&nbsp;页&nbsp;</A></li>
            <li ><a href="news_list.html">&nbsp;总&nbsp;帖&nbsp;</A></li>
            <li><a href=" focus_list.html">&nbsp;关&nbsp;注&nbsp;</A></li>
            <li class="active"> <a href="">管理员</a> </li>
          </ul>
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
          <img class="img-circle" alt="Generic placeholder image" 
        src="img/tou.png" width="120px" height="120px">
        </center>
      </div>
      <br>
      <div class="center-block">
        <p class="text-center"><strong>管理员</strong></p>
      </div>
      <div class="col-lg-2"></div>
      <div class="col-lg-12">
        <ul class="nav nav-pills nav-stacked" role="tablist">
          <br>
          <li><a href="admin_addnotice.action"> &nbsp;发布公告</a></li>
          <li class="active"> <a href="admin_public.action">&nbsp;开通公众号</a> </li>
          <li> <a href="manage_adTeacher.action">&nbsp;发布管理 </a> </li>
          <li> <a href="admin_option.action">&nbsp;意见反馈</a> </li>
         </ul>
      </div>
    </div>
    <div class="col-lg-8"> 
      <!--Content 发帖框-->
      <div class="col-lg-3 ">
        <label class="btn-primary" style="padding-right:10px">
        <h4> &nbsp;&nbsp;开通公众号</h4>
        </label>
      </div>
	  
	  <div class="col-lg-12">
		  <br>
		  
	  <div class="col-lg-2"></div>
	  <div class="col-lg-9">
	  <br>
	    <form class="form-horizontal" role="form" action="admin_adduser.action" method="post">
        
        <div class="form-group form-group-sm">
          <label class="col-sm-2 control-label" for="formGroupInputLarge">名称：</label>
          <div class="col-sm-9">
            <input name="user.name" type="text" class="form-control input-lg" placeholder="">
          </div>
        </div>
		
		<div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账号：</label>
    <div class="col-sm-9">
      <input name="user.id" type="text" class="form-control" id="inputEmail3" placeholder="">
    </div>
  </div>
		
		<div class="form-group form-group-sm">
          <label class="col-sm-2 control-label" for="formGroupInputLarge">密码：</label>
          <div class="col-sm-9">
            <input name="user.password" type="password" class="form-control" id="inputPassword3" placeholder="">
          </div>
        </div>
		
     
	  <div class="col-lg-2"></div>
	   <div class="col-lg-9 btn-primary text-center"> <a href=""><button type="submit" class="btn btn-primary" style="font-size:16px;padding-left:160px;padding-right:160px"><strong>开通帐号</strong></button></a></div>
	  </div>
	   </form>
	  <div class="col-lg-1"></div>
	  
	
	  </div>
    
   
	  
	
    </div>

  </div>
</div>

<div class="footerwarp">
  <footer >
    <hr>
    <p class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有. · <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy"><span>联系我们</span></A>. · <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy"><span>管理入口</span></A></p>
  </footer>
</div>

  
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script> 
<script src="js/footer.js"></script>

</body>
</html>
