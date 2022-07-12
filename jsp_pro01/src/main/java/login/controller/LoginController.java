package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.service.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String deptId = request.getParameter("deptId");
		String empName = request.getParameter("empName");
		
		LoginService service = new LoginService();
		boolean result = service.login(request.getSession(), empId, deptId, empName);
		
		if(result) {
			// 로그인 성공
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			// 로그인 실패
			System.out.println("로그인 실패");
		}
		
	}

}
