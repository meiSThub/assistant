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
function cancelCollect(newsId){
	
	var xmlHttpReg=  getXmlHttpReq();
	xmlHttpReg.onreadystatechange = function(){
		if (xmlHttpReg.readyState == 4){
			if(xmlHttpReg.status==200||xmlHttpReg.status==304){
				var result = xmlHttpReg.responseText;
				if(result=="fail"){
					show_message("取消收藏失败","error");
				}
				else{
					
					show_message("取消收藏成功","info");
					window.location.reload();
					
				}
			
			}
		}
	};
	if(newsId !=""){
		// 连接服务器	
		xmlHttpReg.open("post","collect_cancel.action", true);
		xmlHttpReg.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttpReg.send("collect.news.id="+newsId);
	}
	

	
}
