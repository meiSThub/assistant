<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<title>admin manage public</title>
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
          <li > <a href="admin_public.action">&nbsp;开通公众号</a> </li>
          <li class="active"> <a href="manage_adTeacher.action">&nbsp;发布管理 </a> </li>
          <li> <a href="admin_option.action">&nbsp;意见反馈</a> </li>
         </ul>
      </div>
    </div>
    <div class="col-lg-8"> 
      <!--Content 发帖框-->
      <div class="col-lg-2 " style="padding-bottom:5px;" >
        <label class="btn-primary" style="padding-right:10px">
        <h4> &nbsp;&nbsp;发布管理</h4>
        </label>
      </div>
	   <div class="col-lg-12">
	  
        <label  class="bkgd padding-left" style="padding-left:-5px">
        <p> <a href="admin_notice_adList.action" class="btn  pull-right"  role="button"><strong>管理员发布</strong></a> <a href="manage_adPublicnum.action" class="btn  btn-primary pull-right"  role="button"><strong>公共号发布</strong></a> <a href="manage_adTeacher.action" class="btn  pull-right"  role="button"><strong>导员发布</strong></a></p>
        </label>
      </div>
	  <div class="col-lg-12"> <br>
        <table class="table text-overflow">
          <thead style="background-color:#F6F6F6">
            <tr>
              <th>标题</th>
              <th></th>
              <th>回帖</th>
              <th>时间</th>
            </tr>
          </thead>
          <tbody class="text_ellipsis">
          <s:iterator value="newsList">
            <tr>
              <td><div class=" text-overflow width"><a href="news_detail.action?news.id=<s:property value="id"/>"><s:property value="title"/></a></div></td>
              <td><a href="manage_delete.action?news.id=<s:property value="id"/>"><span class="glyphicon glyphicon-trash"></span></a></td>
              <td><s:property value="commentNum"/></td>
              <td><s:property value="postTime"/></td>
            </tr>
		</s:iterator>
          </tbody>
        </table>
     <div class="col-lg-12">
		<br>
	    <ul class="pager pull-right">
	     <s:if test= "page>1" >
	  		<li><a href="manage_publicnum.action?page=${page-1}">上一页</a></li>
		 </s:if> 
		 <s:if test= "newsList.size()>7" >
	  		<li><a href="manage_publicnum.action?page=${page+1}">下一页</a></li>
	  	 </s:if>
		</ul>
     </div>
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
