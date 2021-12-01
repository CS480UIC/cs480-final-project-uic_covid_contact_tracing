package student_housing.service;


import student_housing.dao.StudentHousingDao;
import student_housing.domain.StudentHousing;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class StudentHousingService {
	private StudentHousingDao studentDao = new StudentHousingDao();
	
	/**
	 * register a Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(StudentHousing form) throws StudentHousingException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		StudentHousing student = studentDao.findByUIN(form.getUin());
		if(student.getUin()!=null && ((student.getUin()).equals(form.getUin()))) throw new StudentHousingException("This UIN has been registered!");
		studentDao.add(form);
	}
}
