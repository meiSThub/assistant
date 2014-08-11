package edu.zzuli.assistant.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import edu.zzuli.assistant.until.StrUtil;

public class UploadAction extends ActionSupport implements SessionAware{

	//上传文件的保存路径  
    protected String imgnews = "imgnews/";  
    protected String imgNotice = "imgNotice/";  
    protected String imgHead = "imgHead/";  
    protected String dirTemp = "temp/";  
    private Map<String, Object> session;
    
    
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void uploadNewsPic(){
		  
			if(session.get("userId")!=null){
				
				upLoad(imgnews);
			}
	
	}
	public void uploadNoticePic(){
		
		if(session.get("userId")!=null){
			
			upLoad(imgNotice);
		}
		
	}
	public void uploadHeadPic(){
		
		if(session.get("userId")!=null){
			
			upLoad(imgHead);
		}
		
	}
    
	public void upLoad(String path) {
		
		HttpServletRequest request = ServletActionContext.getRequest();
    	HttpServletResponse response = ServletActionContext.getResponse(); 
        try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        response.setContentType("text/html; charset=UTF-8");  
        //文件保存目录路径  
        String savePath = ServletActionContext.getServletContext().getRealPath("/") + path;  
        // 临时文件目录   
        String tempPath = ServletActionContext.getServletContext().getRealPath("/") + dirTemp;  
        //创建文件夹  
        File dirFile = new File(savePath);  
        if (!dirFile.exists()) {  
            dirFile.mkdirs();  
        }  
        //创建临时文件夹  
        File dirTempFile = new File(tempPath);  
        if (!dirTempFile.exists()) {  
            dirTempFile.mkdirs();  
        }  
        DiskFileItemFactory  factory = new DiskFileItemFactory();  
        factory.setSizeThreshold(20 * 1024 * 1024); //设定使用内存超过5M时，将产生临时文件并存储于临时目录中。     
        factory.setRepository(new File(tempPath)); //设定存储临时文件的目录。     
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setHeaderEncoding("UTF-8");  
        try {  
            List items = upload.parseRequest(request); 
            Iterator itr = items.iterator();  
              
            while (itr.hasNext())   
            {  
                FileItem item = (FileItem) itr.next();  
                String fileName = item.getName();  
                long fileSize = item.getSize();
                if(fileSize>2*1024*1024){
                	return; // 文件大于2m 阻止上传
                }
                if (!item.isFormField()) {  
                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();  
                   if(fileExt==null || (!"jpg".equals(fileExt) && !"png".equals(fileExt) && !"gif".equals(fileExt))){
                	    //不是支持的图片
                	   return;
                   }
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
                    String newFileName = StrUtil.getTimeStr() + "." + fileExt;  
                    File uploadedFile ;  
                    OutputStream outputStream = null ;  
                    InputStream inputStream = null ;  
                    PrintWriter printWriter = null;
                    try{  
                    	uploadedFile = new File(savePath, newFileName);  
                    	printWriter = response.getWriter();
                        outputStream = new FileOutputStream(uploadedFile);  
                        inputStream = item.getInputStream();  
                        byte buf[] = new byte[1024];//可以修改 1024 以提高读取速度  
                        int length = 0;    
                        while( (length = inputStream.read(buf)) > 0 ){    
                            outputStream.write(buf, 0, length);    
                        }    
                        printWriter.write(newFileName);                        
                       // System.out.println("上传成功！路径："+savePath+"/"+newFileName);  
                    }catch(Exception e){  
                        e.printStackTrace();  
                    }
                    finally{
                        //关闭流    
                        try {
							outputStream.flush();
							outputStream.close();    
							inputStream.close(); 
							printWriter.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
                    }
                }            
            }   
              
        } catch (FileUploadException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}
}
