package course.service;


import course.dao.CourseDao;
import course.domain.Course;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class CourseService {
	private CourseDao studentDao = new CourseDao();
	
	/**
	 * register a Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Course form) throws CourseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Course student = studentDao.findByUIN(form.getUin());
		if(student.getUin()!=null && ((student.getUin()).equals(form.getUin()))) throw new CourseException("This UIN has been registered!");
		studentDao.add(form);
	}
}
