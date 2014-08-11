<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
<link href="img/icon.png" rel="icon">
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->
<title>about us</title>
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
            <li><a href=" user_teacher.action">&nbsp;关&nbsp;注&nbsp;</A></li>
            
            <!-- Button trigger modal -->
            <li>
             	<s:if test="#session.userId!=null">
                	<a href="news_follow.action"><%=session.getAttribute("userName") %></a>
 			 	</s:if>
 			 	<s:else>
              		<button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#myModal" >登&nbsp;&nbsp;&nbsp;录</button>
 			 	</s:else>
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

<div class="container"> <br>
  <div class="row">
    <div class="col-lg-2"> </div>
    <div class="col-lg-8"> 
      <!--Content 内容页-->
      
      <div class="col-lg-12 bkgd">
        <h4> 当前位置：<a style="color:#0093d6" href="index.action">首页</a>关于我们</h4>
      </div>
      <br>
	    <br>  <br>  
 
     <div class="col-lg-12">
        <h3> <strong>开发团队：</strong></h3>
		<p>大学生IT创新工作室</p>
      </div>
	  <div class="col-lg-12">
	 
        <h3> <strong>开发团队：</strong></h3>
		<p>工作室由网络中心负责日常管理和指导，其前身是1999年组建的网络中心开发小组，
		因此又称开发小组。“大学生IT工作室”的宗旨是：面向社会需求，培养大学生IT精英，
		在广大学生中营造理论联系实践，团队协作，勇于实践创新的氛围，
		网络中心定期选拔具有良好基础的学生参加到大学生IT创新工作室中，
		为其提供专业的学习研究环境，定期组织培训和技术交流，
		并组织工作室成员参与教师的研究项目和学校的网络建设。</p>
      </div>

     <div class="col-lg-12">
        <h3> <strong>联系地址：</strong></h3>
		<p><strong>东风校区：</strong>教二楼五楼505室</p>
		<p><strong>科学校区：</strong>电教楼五楼522室</p>
      </div>

     
      
  

      
      
    </div>
  </div>
</div>
<div class="footerwarp">
  <footer >
    <hr>
    <P class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有 <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy">联系我们</A> <a href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy">管理入口</A></P>
  </footer>
</div>
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.js"></script> 

<script src="js/footer.js"></script>
</body>
</html>
