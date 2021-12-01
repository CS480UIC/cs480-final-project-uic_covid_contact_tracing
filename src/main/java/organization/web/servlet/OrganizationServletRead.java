package organization.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import organization.dao.OrganizationDao;
import organization.domain.Organization;


/**
 * Servlet implementation class UserServlet
 */

public class OrganizationServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizationServletRead() {
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
		Organization course = null;
		OrganizationDao courseDao = new OrganizationDao();
		
		try {
			course = courseDao.findByUIN(Integer.parseInt(request.getParameter("uin")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(!(course.getUin()).equals(null)){
					System.out.println(course);
					request.setAttribute("organization", course);
					request.getRequestDispatcher("/jsps/organizationEntity/organizationEntity_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/organizationEntity/organizationEntity_read_output.jsp").forward(request, response);
		}
	}
}


