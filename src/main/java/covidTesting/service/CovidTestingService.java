package covidTesting.service;


import java.util.List;

import covidTesting.dao.CovidTestingDao;
import covidTesting.domain.CovidTesting;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class CovidTestingService {
	private CovidTestingDao covidTestDao = new CovidTestingDao();
	
	/**
	 * register a Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(CovidTesting form) throws CovidTestingException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		CovidTesting covidTest = covidTestDao.findByUIN(form.getUin());
		if(covidTest.getUin()!=null && ((covidTest.getUin()).equals(form.getUin()))) throw new CovidTestingException("This UIN has been registered!");
		covidTestDao.add(form);
	}

	public List<Object> findNonNegativeTests() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return covidTestDao.findNonNegativeTests();
	}
	
	public List<Object> findTestResultPercentages() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return covidTestDao.findTestResultPercentages();
	}
	
	public List<Object> findNumTests2021() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return covidTestDao.findNumTests2021();
	}
}
