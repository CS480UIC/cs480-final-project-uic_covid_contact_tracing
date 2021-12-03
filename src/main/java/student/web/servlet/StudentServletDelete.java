package student.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.domain.Student;


/**
 * Servlet implementation class UserServlet
 */

public class StudentServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletDelete() {
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
						System.out.println(student);
						request.setAttribute("student", student);
						request.getRequestDispatcher("/jsps/studentEntity/studentEntity_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/studentEntity/studentEntity_delete_output.jsp").forward(request, response);			
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.println(request.getParameter("uin"));
				studentDao.delete(request.getParameter("uin"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/studentEntity/studentEntity_read_output.jsp").forward(request, response);
		}
	}
}



