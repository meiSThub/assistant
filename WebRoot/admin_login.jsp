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
<link href="css/table.css" rel="stylesheet">
<link href="img/icon.png" rel="icon">
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<title>admin login</title>
</head>

<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
         <a class="navbar-brand" href="index.html"> <img  alt="Brand" src="img/logo.png"></a> </div>
        <div class="navbar-collapse collapse">
        
          <ul class="nav navbar-nav navbar-right">
          
            <li><a  href="index.action">&nbsp;首&nbsp;页&nbsp;</A></li>
            <li><a href="news_teacher.action">&nbsp;总&nbsp;帖&nbsp;</A></li>
            <li><a href="user_teacher.action">&nbsp;关&nbsp;注&nbsp;</A></li>
            
            <!-- Button trigger modal -->
            <li>
              <button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#myModal">登&nbsp;&nbsp;&nbsp;录</button>
            </li>
          </ul>
          <!-- sample modal content --> 
          
        </div>
      </div>
    </div>
  </div>
</div>
<!--user login-->
<div id="myModal" class="modal fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"data-backdrop="static" >
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header">
        <ul class="nav nav-tabs ">
          <!-- <li class="active"><a href="#tab1" data-toggle="tab">　　　　　　　　　　　用户登录　　　　　　　　　　　　　　　　　　</a></li>-->
          <li class="active"><a href="#tab1" data-toggle="tab">用户登录</a></li>
        </ul>
        <br>
        <div class="tab-content">
          <div class="tab-pane active" id="tab1">
            <p  class="hidden orange" id="login_error" ><small>用户名或密码错误</small></p>
            <div class="input-group"> <span class="input-group-addon">账号</span>
              <input type="text" class="form-control" placeholder="学号或工号">
            </div>
            <br>
            <div class="input-group"> <span class="input-group-addon">密码</span>
              <input type="password" class="form-control" id="inputpassword3" placeholder="初始密码为身份证号后六位">
            </div>
          </div>
        </div>
        <br>
        <button type="submit" class="btn btn-lg btn-primary btn-block">登入</button>
      </div>
      <div class="modal-footer"> <a class="pull-left"style="color:#A7A7A7" href="#">忘记密码？</a>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
<!--end user login-->
<div class="container" style="margin-bottom:20px"> <br>
  <div class="row">
    <div class="col-lg-2"></div>
    
    <div class="col-lg-8"> 
      <!--Content 发帖框-->
	  <div class="col-lg-5 "  ></div>
      <div class="col-lg-4 "  >
	  <br><br><br><br>
        <label class="btn-primary" style="padding-right:10px">
        <h4> &nbsp;&nbsp;管理员登录</h4>
        </label>
      </div>
	
            <div class="col-lg-12">
        
        <br><br>
           
	  <br>
	    <form class="form-horizontal" role="form" action="admin_login.action" method="post">
		
		<div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账号：</label>
    <div class="col-sm-9">
      <input name="admin.email" type="email" class="form-control" id="inputEmail3" placeholder="">
    </div>
  </div>
		
		<div class="form-group form-group-sm">
          <label class="col-sm-2 control-label" for="formGroupInputLarge">密码：</label>
          <div class="col-sm-9">
            <input name="admin.password" type="password" class="form-control" id="inputPassword3" placeholder="">
          </div>
        </div>
		
      
	  <br>
	  <div class="col-lg-2"></div>
	   <div class="col-lg-9 btn-primary text-center"> <button type="submit" id="admin_login_btn" class="btn btn-primary btn-lg" style="font-size:16px;padding-left:160px;padding-right:160px"><strong>登&nbsp;录</strong></button></div>
	 </form>
      
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
<script src="ajaxjs/login.js"></script>
</body>
</html>
