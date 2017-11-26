package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		//获取访问ip
		String ip = request.getRemoteAddr();
		String host = request.getRemoteHost();
		System.out.println(ip+"+"+host);
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		//分析请求资源路径
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		/*if("/web04-3/list.do".equals(uri)){
			System.out.println("员工列表");
		}*/	
		try {
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			if("/list".equals(action)){				
				List<Employee> employees = dao.findAll();
				request.setAttribute("employees",employees);
				RequestDispatcher rd = request.getRequestDispatcher("listEmp.jsp");
				rd.forward(request, response);
			}else if("/add".equals(action)){
				String name = request.getParameter("name");
				Double sal = Double.parseDouble(request.getParameter("sal"));                                    
				int age = Integer.parseInt(request.getParameter("age"));
				e.setName(name);
				e.setSal(sal);
				e.setAge(age);
				dao.save(e);
				response.sendRedirect("list.do");
			}
			else if("/del".equals(action)){
				int id = Integer.parseInt(request.getParameter("id"));
				dao.del(id);
				response.sendRedirect("list.do");
			}else if("/update".equals(action)){
				int id = Integer.parseInt(request.getParameter("id"));
				e = dao.load(id);			
				request.setAttribute("update",e);
				RequestDispatcher rd = request.getRequestDispatcher("updateEmp.jsp");
				rd.forward(request, response);
			}else if("/modify".equals(action)){
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				String name = request.getParameter("name");
				Double sal = Double.parseDouble(request.getParameter("sal"));        
				int age = Integer.parseInt(request.getParameter("age"));
				e.setId(id);
				e.setName(name);
				e.setSal(sal);
				e.setAge(age);
				dao.modify(e);
				response.sendRedirect("list.do");
			}		
		} catch (Exception e) {
			e.printStackTrace();
			//1、交给浏览页面处理
			/*request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response)*/;
			//2、抛给服务器处理
			throw new ServletException(e);
		}
	}
}
