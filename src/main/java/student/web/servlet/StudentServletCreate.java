package student.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.domain.Student;
import student.service.StudentException;
import student.service.StudentService;


/**
 * Servlet implementation class UserServlet
 */

public class StudentServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletCreate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService entity1service = new StudentService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Student form = new Student();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setUin(Integer.parseInt(info.get(0)));
		form.setVaccination_status(Byte.parseByte(info.get(1)));
		form.setFirst_name(info.get(2));
		form.setLast_name(info.get(3));
		form.setStudent_major_name(info.get(4));
		form.setDorm_id(info.get(5));
		if(form.getDorm_id() != "NULL") {
			Integer a = 1;
			form.setStudent_living(a.byteValue());
		} else {
			Integer b = 0;
			form.setStudent_living(b.byteValue());
		}
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | StudentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
