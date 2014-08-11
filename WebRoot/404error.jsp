<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta content="IE=11.0000" http-equiv="X-UA-Compatible">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta name="GENERATOR" content="MShtml 11.00.9600.17041">
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/dandelion.css" rel="stylesheet">
<link href="img/icon.png" rel="icon">
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->
<title>404 error</title>
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
  href="index.action">&nbsp;首&nbsp;页&nbsp;</A></li>
            <li><a href="news_teacher.action">&nbsp;总&nbsp;帖&nbsp;</A></li>
            <li><a href="user_teacher.action">&nbsp;关&nbsp;注&nbsp;</A></li>
            
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
<div id="myModal" class="modal fade " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"data-backdrop="static" >
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header">
        <ul class="nav nav-tabs ">
          <li class="active"><a href="#tab1" data-toggle="tab">用户登录</a></li>
        </ul>
        <br>
        <div class="tab-content">
          <div class="tab-pane active" id="tab1">
            <div class="input-group"> <span class="input-group-addon">账号</span>
              <input type="text" class="form-control" placeholder="学号或工号">
            </div>
            <br>
            <div class="input-group"> <span class="input-group-addon">密码</span>
              <input type="password" class="form-control" id="inputPassword3" placeholder="初始密码为身份证号后六位">
            </div>
          </div>
        </div>
        <br>
        <button type="submit" class="btn btn-lg btn-primary btn-block">登录</button>
      </div>
      <div class="modal-footer">
        <li class=" list-group-item pull-left"><a href="#"><u style="color:#A7A7A7">忘记密码？</u></a></li>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
<!--end user login-->

<div class="container"> <br><br><br><br>
 	<!-- Main Wrapper. Set this to 'fixed' for fixed layout and 'fluid' for fluid layout' -->
	<div id="da-wrapper" class="fluid">
    
        <!-- Content -->
        <div id="da-content">
            
            <!-- Container -->
            <div class="da-container clearfix">
            
            	<div id="da-error-wrapper">
                	
                   	<div id="da-error-pin"></div>
                    <div id="da-error-code">
                    	error <span>404</span>                    </div>
                
              
                    
                </div>
            </div>
        </div>
        
       
    </div>
</div>
<div class="footerwarp">
  <footer >
    <hr>
    <P class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有 <a href="about.action">关于我们</A><a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy">管理入口</A></P>
  </footer>
</div>
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.js"></script> 

<script src="js/footer.js"></script>
</body>
</html>
