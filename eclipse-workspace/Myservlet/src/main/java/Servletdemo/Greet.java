package Servletdemo;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class Greet extends HttpServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException {
    res.setContentType("test/html");
    res.getWriter().print("Hello World!");
    }
}
