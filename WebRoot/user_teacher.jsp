<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<!-- saved from url=(0038)http://bp.315ok.org/examples/carousel/ -->
<html lang="en">
<head>
<meta content="IE=11.0000" 
http-equiv="X-UA-Compatible">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="fonts/glyphicons-halflings-regular.svg" rel="shortcut icon">
<title>关注</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<!-- html5 shim and Respond.js IE8 support of html5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../docs-assets/js/html5shiv.js"></script>
      <script src="../../docs-assets/js/respond.min.js"></script>
    <![endif]-->
<!-- Custom styles for this template -->

<meta name="GENERATOR" content="MShtml 11.00.9600.17041">
</head>
<!-- NAVBAR
================================================== -->

<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">

        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="#"> <img alt="Brand" src="img/logo.png"></a> 
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a  href="index.action">&nbsp;首&nbsp;页&nbsp;</a></li>
            <li><a href="news_teacher.action">&nbsp;总&nbsp;帖&nbsp;</a></li>
            <li class="active"><a href="user_teacher.action">&nbsp;关&nbsp;注&nbsp;</a></li>
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
<br>
<div class="container"> 
  <!-- Two columns of text below the carousel --> 
  <br>
  <div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-2" >
      <ul class="nav nav-pills nav-stacked text-center" role="tablist" style="background-color:#F6F6F6; height:200px; padding:10px" >
        <li class="active"><a href="#">辅导员</a></li>
        <li><a href="user_publicnum.action">公共号</a></li>
      </ul>
    </div>
    <div class="col-lg-8">
      <div class="col-lg-12">
        <div class=" col-lg-3" >
          <h4>关注列表</h4>
        </div>
        <div class=" col-lg-4" > </div>
        <div class="col-lg-5" >
          <form class="navbar-form " role="search" action="user_SeekTeacher.action?page=${page}" method="post">
            <div class="form-group">
              <input type="text" class="form-control input-sm" name="name"  placeholder="用户名">
            </div>
            <button type="submit" class="btn btn-sm btn-default" >搜索</button>
          </form>
        </div>
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
            <s:if test="#user.id in followList.{startId}">
          	    <button type="button" class="btn btn-primary navbar-btn pull-right"  >已关注</button>
          	</s:if>
          	<s:else>
          		<s:if test="#session.userId!=null">
          			<a type="button" href="follow_add.action?follw.startId=<s:property value='#user.id'/>&page=${page}" class="btn btn-default navbar-btn pull-right" >&nbsp;关&nbsp;&nbsp;注&nbsp;</a>
          		</s:if>
          		<s:else>
               		<button type="button" class="btn btn-default navbar-btn pull-right" data-toggle="modal" data-target="#myModal">&nbsp;关&nbsp;&nbsp;注&nbsp;</button>
          		</s:else>
          	</s:else>
          </div>
        </div>
      </div>
      </s:iterator>
      <div class="col-lg-12"> 
        <br>
         <ul class="pager pull-right">
	     <s:if test= "page>1" >
	  		<li><a href="user_teacher.action?page=${page-1}">上一页</a></li>
		 </s:if> 
		 <s:if test= "userList.size()>7" >
	  		<li><a href="user_teacher.action?page=${page+1}">下一页</a></li>
	  	 </s:if>
		</ul>
      </div>
      <!-- /.row --> <!-- START THE FEATURETTES --> 
    </div>
    
    <!-- /END THE FEATURETTES --> <!-- FOOTER --> 
  </div>
</div>
<div class="footerwarp">
  <footer >
    <hr>
    <p class="text-center">© 2014 郑州轻工业学院国际教育学院版权所有 <A href="about.action"><span>关于我们</span></A> <A href="http://web.zzuli.edu.cn/s/137/t/405/main.jspy"><span>管理入口</span></A></p>
  </footer>
</div>
<!-- /.container --> 
<!-- Bootstrap core JavaScript
    ================================================== --> 
<!-- Placed at the end of the document so the pages load faster --> 
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.js"></script> 
<script src="js/footer.js"></script>
<script src="js/holder.js"></script>
<script src="ajaxjs/login.js"></script>
</body>
</html>
