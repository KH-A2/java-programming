package dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/depts/del")
public class DeptDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService service = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		DeptDTO data = service.getId(id);
		request.setAttribute("data", data);
		
		String view = "/WEB-INF/jsp/dept/del.jsp";
		if(data == null) {
			view = "/WEB-INF/jsp/dept/del_no.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int result = service.deleteDept(id);
		switch(result) {
			case 1:
				response.sendRedirect("/jsp01/depts");
				return;
			case 0:
				System.out.println("삭제 처리 중 문제 발생");
				return;
			case -1:
				System.out.println("삭제할 데이터가 존재하지 않습니다.");
				return;
		}
	}

}
