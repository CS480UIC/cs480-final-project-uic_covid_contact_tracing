package student.service;


import student.dao.StudentDao;
import student.domain.Student;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	/**
	 * register a Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Student form) throws StudentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Student student = studentDao.findByUIN(form.getUin());
		if(student.getUin()!=null && ((student.getUin()).equals(form.getUin()))) throw new StudentException("This UIN has been registered!");
		studentDao.add(form);
	}
}
