function getXmlHttpReq(){
	var xmlHttpReq ;
	try{
		xmlHttpReq = new ActiveXObject("MSXML2.XMLHTTP.3.0");
	}
	catch (e){// 非IE 创建方式
		xmlHttpReq = new XMLHttpRequest();
	}
	return xmlHttpReq;
}

//动画
function animate(obj){
  $(obj).stop()
  .animate({ left: "-10px" }, 100).animate({ left: "10px" }, 100)
  .animate({ left: "-10px" }, 100).animate({ left: "10px" }, 100)
  .animate({ left: "0px" }, 100)
  .removeClass("mysuccess")
  .addClass("error");
}
	
//输入框监听事件start

// 验证个人简介
$("#intro").blur(function(){
	validateIntro();
});
$("#intro").focus(function(){
	$('#intro_error').hide();
	$('#intro').removeClass("error");
});

//验证个人简介的具体方法
function validateIntro(){
	if($("#intro").val().length>15 || $("#intro").val().length==0){			
		animate("#intro");
		$("#intro_error").show();
		return false;
	} 
	else{
	$("#intro").addClass("mysuccess");	
	return true;
	}
}

//验证邮箱
$("#save_email").click(function() { 
	if( validatePassword()==false || validateEmail()==false){
		return false;
	}
	else{
		
	}
});

$("#email").blur(function(){
	validateEmail();
});
$("#email").focus(function(){
	$('#email_error').hide();
	$('#email').removeClass("error");
});

//验证个邮箱的具体方法
function validateEmail(){
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	
	if(!reg.test($("#email").val())){			
		animate("#email");
		$("#email_error").show();
		return false;
	} 
	else{
	$("#email").addClass("mysuccess");	
	return true;
	}
}

// 验证密码格式
$("#password").blur(function(){
	validatePassword();
});
$("#password").focus(function(){
	$('#password_error').hide();
	$('#password').removeClass("error");
});

//验证密码格式的具体方法
function validatePassword(){
	if($("#password").val().length>15 || $("#password").val().length==0){			
		animate("#password");
		$("#password_error").show();
		return false;
	} 
	else{
	$("#password").addClass("mysuccess");	
	return true;
	}
}

// 旧密码
$("#oldPassword").blur(function(){
	validateOldPassword();
});
$("#oldPassword").focus(function(){
	$('#oldPassword_error').hide();
	$('#oldPassword').removeClass("error");
});

//验证密码的具体方法
function validateOldPassword(){
	if($("#oldPassword").val().length>15 || $("#oldPassword").val().length==0){			
		animate("#oldPassword");
		$("#oldPassword_error").show();
		return false;
	} 
	else{
	$("#oldPassword").addClass("mysuccess");	
	return true;
	}
}

$("#newPassword").blur(function(){
	validateNewPassword();
});
$("#newPassword").focus(function(){
	$('#newPassword_error').hide();
	$('#newPassword').removeClass("error");
});

//验证密码的具体方法
function validateNewPassword(){
	if($("#newPassword").val().length>15 || $("#newPassword").val().length==0){			
		animate("#newPassword");
		$("#newPassword_error").show();
		return false;
	} 
	else{
	$("#newPassword").addClass("mysuccess");	
	return true;
	}
}


$("#newPassword2").blur(function(){
	validateNewPassword2();
});
$("#newPassword2").focus(function(){
	$('#newPassword2_error').hide();
	$('#newPassword2').removeClass("error");
});

//验证密码的具体方法
function validateNewPassword2(){
	if($("#newPassword2").val().length>15 || $("#newPassword2").val().length==0 || $("#newPassword2").val()!= $("#newPassword").val() ){			
		animate("#newPassword2");
		$("#newPassword2_error").show();
		return false;
	} 
	else{
	$("#newPassword2").addClass("mysuccess");	
	return true;
	}
}
//输入框监听事件end

//提交按钮事件

//更改个人信息
$("#save_intro").click(function() { 
	if( validateIntro()==false ){
		return false;
	}
	else{
		 modifyIntro();
	}
});
// 绑定邮箱
$("#save_email").click(function() { 
	if( validatePassword()==false || validateEmail()==false){
		return false;
	}
	else{
		 modifyEmail();
	}
});
// 修改密码
$("#save_password").click(function() { 
	if( validateOldPassword()==false || validateNewPassword()==false || validateNewPassword2()==false){
		return false;
	}
	else{
		 modifyPassword();
	}
});
	

function show_message(text,type){
	var message = {
		text:text,
		type:(type)
	}
	dhtmlx.message(message);
}

function modifyIntro(){
	var xmlHttpReg=  getXmlHttpReq();
	// 状态改变
	xmlHttpReg.onreadystatechange = function(){
		if (xmlHttpReg.readyState == 4){
			if(xmlHttpReg.status==200||xmlHttpReg.status==304){
				var result = xmlHttpReg.responseText;
				if(result=="success"){
					//window.location.reload();
					show_message("修改成功","info");
				}
				else{
					show_message("修改失败","error");
				}
			
			}
		}
	}
	var intro=document.getElementById("intro").value;
	// 连接服务器
	xmlHttpReg.open("post","modifyIntro.action", true);
	xmlHttpReg.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpReg.send("user.intro="+intro);
}
function modifyEmail(){
	var xmlHttpReg=  getXmlHttpReq();
	// 状态改变
	xmlHttpReg.onreadystatechange = function(){
		if (xmlHttpReg.readyState == 4){
			if(xmlHttpReg.status==200||xmlHttpReg.status==304){
				var result = xmlHttpReg.responseText;
				if(result=="success"){
					//window.location.reload();
					show_message("修改成功","info");
				}
				else{
					show_message("修改失败","error");
				}
			
			}
		}
	}
	var password=document.getElementById("password").value;
	var email = document.getElementById("email").value;
	// 连接服务器
	xmlHttpReg.open("post","modifyEmail.action", true);
	xmlHttpReg.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpReg.send("user.password="+password +"&user.email="+email);
}
function modifyPassword(){
	var xmlHttpReg=  getXmlHttpReq();
	// 状态改变
	xmlHttpReg.onreadystatechange = function(){
		if (xmlHttpReg.readyState == 4){
			if(xmlHttpReg.status==200||xmlHttpReg.status==304){
				var result = xmlHttpReg.responseText;
				if(result=="success"){
					show_message("修改成功","info");
				}
				if (result=="password_error"){
					show_message("原始密码错误","error");
				}
				if(result=="fail"){
					
					show_message("修改失败","error");
				}
			
			}
		}
	}
	var oldPassword=document.getElementById("oldPassword").value;
	var newPassword = document.getElementById("newPassword").value;
	// 连接服务器
	xmlHttpReg.open("post","modifyPassword.action", true);
	xmlHttpReg.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpReg.send("user.password="+oldPassword +"&newPassword="+newPassword);
}