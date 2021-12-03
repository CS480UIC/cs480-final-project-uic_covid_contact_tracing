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

import student.dao.StudentDao;
import student.domain.Student;

/**
 * Servlet implementation class UserServlet
 */

public class StudentServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServletUpdate() {
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

		String method = request.getParameter("method");
		StudentDao studentDao = new StudentDao();
		Student student = null;

		if(method.equals("search"))
		{
			try {
				student = studentDao.findByUIN(Integer.parseInt(request.getParameter("uin")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(student.getUin() != null){
				request.setAttribute("student", student);
				request.getRequestDispatcher("/jsps/studentEntity/studentEntity_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/studentEntity/studentEntity_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Student form = new Student();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setUin(Integer.parseInt(info.get(1)));
			form.setVaccination_status(Byte.parseByte(info.get(2)));
			form.setFirst_name(info.get(3));
			form.setLast_name(info.get(4));
			form.setStudent_major_name(info.get(5));
			form.setDorm_id(info.get(6));
			if(form.getDorm_id() != "NULL") {
				Integer a = 1;
				form.setStudent_living(a.byteValue());
			} else {
				Integer b = 0;
				form.setStudent_living(b.byteValue());
			}

			try {
				studentDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/studentEntity/studentEntity_read_output.jsp").forward(request, response);
		}
	}
}



