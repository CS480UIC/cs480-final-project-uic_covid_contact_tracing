package student_housing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import covidTesting.domain.CovidTesting;

//import java.util.ArrayList;
//import java.util.List;

import student_housing.domain.StudentHousing;

/**
 * DDL functions performed in database
 */
public class StudentHousingDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "uic_covid_contact_tracing"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "covid"; //TODO change password

	public StudentHousing findByUIN(Integer uin_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		StudentHousing student = new StudentHousing();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
		    String sql = "SELECT * FROM student_housing where uin=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    
		    while(resultSet.next()){
		    	Integer uin = Integer.parseInt(resultSet.getString("uin"));
		    	if(uin.equals(uin_p)){
		    		student.setUin(uin);
		    		student.setDorm_id(resultSet.getString("dorm_id"));
		    		student.setRoom_number(Integer.parseInt(resultSet.getString("room_number")));
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
	
	public void add(StudentHousing form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "insert into student_housing (uin, dorm_id, room_number) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getUin());
		    preparestatement.setString(2, form.getDorm_id());
		    preparestatement.setInt(3,form.getRoom_number());
		    
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
	public void update(StudentHousing form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "UPDATE student_housing SET dorm_id = ?, room_number = ? where uin = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, form.getDorm_id());
		    preparestatement.setInt(2,form.getRoom_number());
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
			
			String sql = "delete from student_housing where uin = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findArcResidents() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			String sql = "select * from arc_residents";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				StudentHousing housing = new StudentHousing();
				housing.setUin(resultSet.getInt("uin"));
				housing.setDorm_id(resultSet.getString("dorm_id"));
				housing.setRoom_number(resultSet.getInt("room_number"));
	    		list.add(housing);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
