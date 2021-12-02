package student.service;


import java.util.List;

import student.dao.CourseDao;
import student.domain.Course;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class StudentService {
	private CourseDao studentDao = new CourseDao();
	
	/**
	 * register a Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Course form) throws StudentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Course student = studentDao.findByUIN(form.getUin());
		if(student.getUin()!=null && ((student.getUin()).equals(form.getUin()))) throw new StudentException("This UIN has been registered!");
		studentDao.add(form);
	}
	
	public List<Object> findUnvaxxed() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return studentDao.findUnvaxxed();
	}

	public List<Object> findVaxStatusResidents() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return studentDao.findVaxStatusResidents();
	}
}
