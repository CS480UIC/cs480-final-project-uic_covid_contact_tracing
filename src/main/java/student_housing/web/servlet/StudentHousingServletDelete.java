package student_housing.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_housing.dao.StudentHousingDao;
import student_housing.domain.StudentHousing;


/**
 * Servlet implementation class UserServlet
 */

public class StudentHousingServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHousingServletDelete() {
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
		StudentHousingDao courseDao = new StudentHousingDao();
		StudentHousing course = null;
		if(method.equals("search"))
		{
			try {
				course = courseDao.findByUIN(Integer.parseInt(request.getParameter("uin")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(course.getUin() != null){
						request.setAttribute("studentHousing", course);
						request.getRequestDispatcher("/jsps/studentHousingEntity/studentHousingEntity_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/studentHousingEntity/studentHousingEntity_read_output.jsp").forward(request, response);			
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.println(request.getParameter("uin"));
				courseDao.delete(request.getParameter("uin"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/studentHousingEntity/studentHousingEntity_read_output.jsp").forward(request, response);
		}
	}
}



