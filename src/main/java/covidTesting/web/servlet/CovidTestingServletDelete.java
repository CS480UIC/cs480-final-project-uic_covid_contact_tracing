package covidTesting.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import covidTesting.dao.CovidTestingDao;
import covidTesting.domain.CovidTesting;


/**
 * Servlet implementation class UserServlet
 */

public class CovidTestingServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CovidTestingServletDelete() {
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
		CovidTestingDao courseDao = new CovidTestingDao();
		CovidTesting course = null;
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
						System.out.println(course);
						request.setAttribute("covid", course);
						request.getRequestDispatcher("/jsps/covidTestingEntity/covidTestingEntity_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/covidTestingEntity/covidTestingEntity_read_output.jsp").forward(request, response);			
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
			request.getRequestDispatcher("/jsps/covidTestingEntity/covidTestingEntity_read_output.jsp").forward(request, response);
		}
	}
}



