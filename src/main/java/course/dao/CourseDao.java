package course.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import course.domain.Course;

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
		    String sql = "SELECT * FROM course where uin=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    
		    while(resultSet.next()){
		    	Integer uin = Integer.parseInt(resultSet.getString("uin"));
		    	if(uin.equals(uin_p)){
		    		student.setUin(uin);
		    		student.setCourse_id(Double.parseDouble(resultSet.getString("course_id")));
		    		student.setCourse_location(resultSet.getString("course_location"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return student;
	}	
	
	/**
	 * insert Course
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Course form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "insert into course (uin, course_id, course_location) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getUin());
		    preparestatement.setDouble(2, form.getCourse_id());
		    preparestatement.setString(3,form.getCourse_location());
		    
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
			
			String sql = "UPDATE course SET course_id = ?, course_location = ? where uin = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setDouble(1, form.getCourse_id());
		    preparestatement.setString(2,form.getCourse_location());
	    	preparestatement.setInt(3, form.getUin());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * @param  uin
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String uin_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Integer uin = Integer.parseInt(uin_p);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "delete from course where uin = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
