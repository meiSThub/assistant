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
function show_message(text,type){
	var message = {
		text:text,
		type:(type)
	}
	dhtmlx.message(message);
}
function checkContent(){
	var content=document.getElementById("content").value;
	if(content==null|| content==""){
		show_message("内容不能为空","error");
		return false;
	}
	
}
function checkReply(replyContent){
	var reply=document.getElementById(replyContent).value;
	if(reply==null|| reply==""){
		show_message("内容不能为空","error");
		return false;
	}
}
$("#login_btn").click(function(){
	
	// 创建对象
	var xmlHttpReg=  getXmlHttpReq();
	// 状态改变
	xmlHttpReg.onreadystatechange = function(){
		if (xmlHttpReg.readyState == 4){
			if(xmlHttpReg.status==200||xmlHttpReg.status==304){
				var result = xmlHttpReg.responseText;
				if(result=="success"){
					$('#myModal').modal('hide');
					  window.location.reload();
				}
				else{
					$('#login_error').show();
					$('#login_error').removeClass("hidden");
				}
			
			}
		}
	}
	var id=document.getElementById("id").value;
	var password=document.getElementById("password").value;
	
	if(id!="" && password!=""){
		// 连接服务器
		
		xmlHttpReg.open("post","login.action", true);
		xmlHttpReg.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttpReg.send("id="+id+"&password="+password);
	}
});

$("#collect").click(function(){
	// 创建对象
	var xmlHttpReg=  getXmlHttpReq();
	// 状态改变
	var news=document.getElementById("news").value;

	if(news!=""){
		// 连接服务器	
		xmlHttpReg.open("post","collect_add.action", true);
		xmlHttpReg.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttpReg.send("collect.news.id="+news);
        
	}
	xmlHttpReg.onreadystatechange = function(){
		if (xmlHttpReg.readyState == 4){
			if(xmlHttpReg.status==200||xmlHttpReg.status==304){
				var result = xmlHttpReg.responseText;
				if(result=="fail"){
					show_message("收藏失败","error");
				}
				else{
					show_message("收藏成功","info");
					
				}
			
			}
		}
	}
});

