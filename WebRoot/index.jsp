<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0038)http://bp.315ok.org/examples/carousel/ -->
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta content="IE=11.0000" http-equiv="X-UA-Compatible">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta name="GENERATOR" content="MShtml 11.00.9600.17041">
<!-- Bootstrap core CSS -->
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="img/icon.png" rel="icon">
<title>微圈</title>
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->


</head>

<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
         <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
         <a class="navbar-brand" href="#"> <img  alt="Brand" src="img/logo.png"></a>
        <!--  
          <button type="button" class="navbar-toggle " data-toggle="collapse" data-target=".navbar-collapse"> 
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="#"><img  alt="Brand" src="img/logo.png"></a> 
          -->
          
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a  href="index.action">&nbsp;首&nbsp;页&nbsp;</a></li>
            <li><a href="news_teacher.action">&nbsp;总&nbsp;帖&nbsp;</a></li>
            <li><a href="user_teacher.action">&nbsp;关&nbsp;注&nbsp;</a></li>
            <!-- Button trigger modal -->
		  	 <li >
		  	  	<s:if test="#session.userId!=null">
                	<a href="news_follow.action"><%=session.getAttribute("userName") %></a>
 			 	</s:if>
 			 	<s:else>
              		<button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#myModal" >登&nbsp;&nbsp;&nbsp;录</button>
 			 	</s:else>
		  	 </li>
          </ul>
        </div> <!-- end navbar-collapse -->
       
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
           <p class="hidden orange"  id="login_error" ><small>用户名或密码错误</small></p>
            <div class="input-group"> <span class="input-group-addon">账号</span>
              <input type="text"   id="id" class="form-control" placeholder="学号或工号">
            </div>
            <br>
            <div class="input-group"> <span class="input-group-addon">密码</span>
              <input type="password" id="password" class="form-control" id="inputpassword3" placeholder="初始密码为身份证号后六位">
            </div>
          </div>
        </div>
        <br>
        <button  id="login_btn"class="btn btn-lg btn-primary btn-block">登录</button>
      </div>
      <div class="modal-footer">
        <a class="pull-left" href="#" style="color:#A7A7A7">忘记密码？</a>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
<!--end user login-->
  <div class="content">
<div class="carousel slide" id="carousel-example-generic" data-ride="carousel" style="margin-top:20px"><!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
   <s:iterator value= "noticeList" var="notice" status="status">
   	<s:if test= "#status.first" >
    <div class="item active"><img class="img-responsive" alt="First slide" src="imgnotice/${notice.coverUrl}">
  	</s:if>
  	<s:else>
    <div class="item "><img class="img-responsive" alt="First slide" src="imgnotice/${notice.coverUrl}">
  	</s:else>
      <div class="container">
        <div class="carousel-caption">
          <p><s:property value="#notice.title" /></p>
          <p><a class="btn btn-lg btn-primary" role="button" href="notice_detail.action?notice.id=${notice.id}">详情</a></p>
        </div>
      </div>
    </div>
  </s:iterator>
  </div>
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span> <span class="sr-only">previous</span> </a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right"></span> <span class="sr-only">Next</span> </a> 
  </div>

<!-- /.carousel --> <!-- Marketing messaging and featurettes
    ================================================== --> 

<!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="row"> 
    
    <div class="col-lg-9" >
      <H2 class="pull-left"><a href=""><span class="glyphicon glyphicon-fire">热门新帖</span></a></H2>
      <br>
      <br>
      <br>
      <br>
      <!-- Table -->
      <div>
        <table class="table" >
          <tbody class="text_ellipsis text-overflow">
          	<s:iterator value= "newsList" var="news" >
            <tr>
              <td>
              	<a href="news_detail.action?id=${news.id}">
     				<div class=" text-overflow width"><s:property value="#news.title" /></div>
                </a>
              </td>
              <td><div  class=" text-overflow" style="width:80px"><s:property value="#news.authorName" /></div></td>
              <td><s:date name="#news.postTime" format="yyyy-MM-dd" /></td>
            </tr>
			</s:iterator>
            <tr>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="col-lg-1" ></div>
    <div class="col-lg-2" >
      <H2><a href=""><span class="glyphicon glyphicon-phone"></span>App下载</a></H2>
      <IMG class="rounded" alt="Generic placeholder image"  src="img/qrcode.png" style="margin-right:0px; padding-right:0px;">
      <p><br>
        <span class="glyphicon glyphicon-arrow-down">扫一扫下载
        安卓版</span></p>
    </div>
   
    
    <!-- /.col-lg-4 --> 
  </div>
  </div>
<div class="footerwarp">
<footer >
<hr>
  <p class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有  <A href="about.action"><span>关于我们</span></A> <A href="admin.action"><span>管理入口</span></A></p>
</footer>
</div>
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.js"></script> 
<script src="js/footer.js"></script>
<script src="ajaxjs/login.js"></script>
</body>
</html>
