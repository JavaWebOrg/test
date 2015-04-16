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

    //���ServletContext������
    ServletContext context = getServletContext();

    // ��ServletContext�ж�ȡcounter����
    Counter counter = (Counter)context.getAttribute("counter");

    // ���ServletContext��û��counter���ԣ��ʹ���counter����
    if ( counter == null ) {
      counter = new Counter(1);
      context.setAttribute("counter", counter);
    }
    
    response.setContentType("text/html;charset=GB2312");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>CounterServlet</TITLE></head>");
    out.println("<body>");
    // �����ǰ��counter����
    out.println("<h1>��ӭ���ٱ�վ�����ǵ� " + counter.getCount()+" λ�����ߡ�</h1>");
    out.println("</body></html>");
  
    //������������1   
    counter.add(1);
    out.close();
  }
}




