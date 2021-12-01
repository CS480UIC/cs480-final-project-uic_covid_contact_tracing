package covidTesting.service;


import covidTesting.dao.CovidTestingDao;
import covidTesting.domain.CovidTesting;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class CovidTestingService {
	private CovidTestingDao studentDao = new CovidTestingDao();
	
	/**
	 * register a Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(CovidTesting form) throws CovidTestingException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		CovidTesting student = studentDao.findByUIN(form.getUin());
		if(student.getUin()!=null && ((student.getUin()).equals(form.getUin()))) throw new CovidTestingException("This UIN has been registered!");
		studentDao.add(form);
	}
}
