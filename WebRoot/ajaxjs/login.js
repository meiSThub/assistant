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
window.onload=function(){
	
	document.getElementById("login_btn").onclick= function(){
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
						/*$('#login_error').show();*/
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
	}
	
}