package edu.zzuli.assistant.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.StrutsRequestWrapper;

public class SessionFilter extends HttpServlet implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		/*HttpServletResponse response = (HttpServletResponse) response;  
		HttpServletRequest request=(HttpServletRequest)request;*/
		HttpSession session = ((HttpServletRequest) request).getSession(true);  
		String url=((HttpServletRequest) request).getRequestURI();

		//判断获取的路径不为空且时跳转
		if(url==null ||"".equals(url) )
		{
			String contextPath=((HttpServletRequest)request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath+"/index.action");
			return ;
		}
		else{
			if(url.indexOf(".jsp")>0){
				String contextPath=((HttpServletRequest)request).getContextPath();
				((HttpServletResponse) response).sendRedirect(contextPath+"/index.action");
				return ;
			}
			
		}
			//已通过验证，用户访问继续
		//chain.doFilter(new StrutsRequestWrapper((HttpServletRequest) request), response); 
		//filterChain.doFilter(new StrutsRequestWrapper((HttpServletRequest) request), response); 
		filterChain.doFilter(new StrutsRequestWrapper((HttpServletRequest) request), response); 
		return;
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}