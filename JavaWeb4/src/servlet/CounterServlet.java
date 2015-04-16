package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import util.CountFileHandler;

import entity.Counter;

public class CounterServlet extends HttpServlet {
	
	
  @Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		long count = CountFileHandler.readFile("e:/count.txt");
		this.getServletContext().setAttribute("counter", count);
	}

public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException, IOException {

    //获得ServletContext的引用
    ServletContext context = getServletContext();

    // 从ServletContext中读取counter属性
    Counter counter = (Counter)context.getAttribute("counter");

    // 如果ServletContext中没有counter属性，就创建counter属性
    if ( counter == null ) {
      counter = new Counter(1);
      context.setAttribute("counter", counter);
    }
    
    response.setContentType("text/html;charset=GB2312");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>CounterServlet</TITLE></head>");
    out.println("<body>");
    // 输出当前的counter属性
    out.println("<h1>欢迎光临本站。您是第 " + counter.getCount()+" 位访问者。</h1>");
    out.println("</body></html>");
  
    //将计数器递增1   
    counter.add(1);
    out.close();
  }
}




