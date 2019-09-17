package edu.ht.Common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器初始化中1......");
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setCharacterEncoding("utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		 System.out.println("过滤器执行中......");
		//执行过滤器 返回servlet容器 查找下一个过滤器 如果没有 就往下执行
		chain.doFilter(request, response);
	}
	public void destroy() {
		System.out.println("过滤器关闭中......");
	}
}
