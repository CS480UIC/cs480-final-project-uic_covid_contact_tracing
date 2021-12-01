package contact_information.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact_information.dao.ContactInformationDao;
import contact_information.domain.ContactInformation;


/**
 * Servlet implementation class UserServlet
 */

public class ContactInformationServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactInformationServletDelete() {
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
		ContactInformationDao contactInformationDao = new ContactInformationDao();
		ContactInformation contactInformation = null;
		if(method.equals("search"))
		{
			try {
				contactInformation = contactInformationDao.findByUin(Integer.parseInt(request.getParameter("uin")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(contactInformation.getUin() != null){
						System.out.println(contactInformation);
						request.setAttribute("contactInformationEntity", contactInformation);
						request.getRequestDispatcher("/jsps/contactInformationEntity/contactInformationEntity_delete_output.jsp").forward(request, response);			
			}else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/contactInformationEntity/contactInformationEntity_delete_output.jsp").forward(request, response);			
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				contactInformationDao.delete(request.getParameter("uin"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/contactInformationEntity/contactInformationEntity_read_output.jsp").forward(request, response);
		}
	}
}



