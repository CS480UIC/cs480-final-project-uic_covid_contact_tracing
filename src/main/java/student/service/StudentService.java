package student.service;


import student.dao.StudentDao;
import student.domain.Student;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class StudentService {
	private StudentDao entity1Dao = new StudentDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Student form) throws StudentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Student entity1 = entity1Dao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new StudentException("This user name has been registered!");
		entity1Dao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(Student form) throws StudentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Student user = entity1Dao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new StudentException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new StudentException(" The password is not right");
		
	}
}
