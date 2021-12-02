package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import student.domain.Course;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class CourseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "uic_covid_contact_tracing"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "covid"; //TODO change password

	public Course findByUIN(Integer uin_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Course student = new Course();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
		    String sql = "SELECT * FROM student where student.uin=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    
		    while(resultSet.next()){
		    	Integer uin = Integer.parseInt(resultSet.getString("uin"));
		    	System.out.println(uin);
		    	System.out.println(uin_p);
		    	System.out.println(uin==uin_p);
		    	System.out.println("1st is db, 2nd is ours");
		    	if(uin.equals(uin_p)){
		    		student.setUin(uin);
		    		student.setVaccination_status(Byte.parseByte(resultSet.getString("vaccination_status")));
		    		student.setFirst_name(resultSet.getString("first_name"));
		    		student.setLast_name(resultSet.getString("last_name"));
		    		student.setStudent_living(Byte.parseByte(resultSet.getString("student_living_status")));
		    		student.setStudent_major_name(resultSet.getString("student_major_name"));
		    		student.setDorm_id(resultSet.getString("dorm_id"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return student;
	}	
	
	/**
	 * insert Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Course form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "insert into student (uin, vaccination_status, first_name, last_name, student_living_status, student_major_name, dorm_id) values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getUin());
		    preparestatement.setByte(2, form.getVaccination_status());
		    preparestatement.setString(3,form.getFirst_name());
		    preparestatement.setString(4,form.getLast_name());
	    	preparestatement.setByte(5,form.getStudent_living());
	    	preparestatement.setString(6, form.getStudent_major_name());
	    	preparestatement.setString(7, form.getDorm_id());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Course form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "UPDATE student SET vaccination_status = ?, first_name = ?, last_name = ?, student_living_status = ?, student_major_name = ?, dorm_id = ? where uin = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setByte(1, form.getVaccination_status());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
	    	preparestatement.setByte(4,form.getStudent_living());
	    	preparestatement.setString(5, form.getStudent_major_name());
	    	preparestatement.setString(6, form.getDorm_id());
	    	preparestatement.setInt(7, form.getUin());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String uin_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Integer uin = Integer.parseInt(uin_p);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "delete from student where uin = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findUnvaxxed() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			String sql = "select * from unvaccinated_students";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Course student = new Course();
				student.setUin(resultSet.getInt("uin"));
				student.setVaccination_status(resultSet.getByte("vaccination_status"));
				student.setFirst_name(resultSet.getString("first_name"));
				student.setLast_name(resultSet.getString("last_name"));
				student.setStudent_living(resultSet.getByte("student_living_status"));
				student.setStudent_major_name(resultSet.getString("student_major_name"));
				student.setDorm_id(resultSet.getString("dorm_id"));
	    		list.add(student);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Object> findVaxStatusResidents() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			String sql = "select * from uic_residents_vaccination_status";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Course student = new Course();
				student.setUin(resultSet.getInt("uin"));
				student.setVaccination_status(resultSet.getByte("vaccination_status"));
				student.setFirst_name(resultSet.getString("first_name"));
				student.setLast_name(resultSet.getString("last_name"));
				student.setDorm_id(resultSet.getString("dorm_id"));
				student.setRoom_number(resultSet.getInt("room_number"));
	    		list.add(student);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
