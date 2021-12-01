package covidTesting.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import covidTesting.dao.CovidTestingDao;
import covidTesting.domain.CovidTesting;

/**
 * Servlet implementation class UserServlet
 */

public class CovidTestingServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CovidTestingServletUpdate() {
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

			if(!(course.getUin()).equals(null)){
				request.setAttribute("covid", course);
				request.getRequestDispatcher("/jsps/covidTestingEntity/covidTestingEntity_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/covidTestingEntity/covidTestingEntity_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			CovidTesting form = new CovidTesting();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setUin(Integer.parseInt(info.get(1)));
			form.setTest_date( java.sql.Date.valueOf(info.get(2)));
			form.setResult_date( java.sql.Date.valueOf(info.get(3)));
			form.setTest_result(Byte.parseByte(info.get(4)));

			try {
				courseDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/covidTestingEntity/covidTestingEntity_read_output.jsp").forward(request, response);
		}
	}
}



