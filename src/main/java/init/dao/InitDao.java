package init.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import user.domain.User;



/**
 * DDL functions performed in database
 */
public class InitDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "uic_covid_contact_tracing";  //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "covid";  //TODO change password
	
	/**
	 * get the Search result with Username 
	 */
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
		    String sql = "select * from user where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		user.setUsername(resultSet.getString("username"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setEmail(resultSet.getString("email"));
		    		
		    	}
		    }
		
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	

	
	
	/**
	 * insert User
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "insert into user values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			String sql = "select * from user";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				User user = new User();
				user.setUsername(resultSet.getString("username"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}




	public void initialize() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "CREATE TABLE student (\r\n"
					+ "	uin INTEGER UNSIGNED NOT NULL UNIQUE,\r\n"
					+ "    vaccination_status TINYINT NOT NULL,\r\n"
					+ "    first_name VARCHAR(20) NOT NULL,\r\n"
					+ "    last_name VARCHAR(20) NOT NULL,\r\n"
					+ "    student_living_status TINYINT NOT NULL,\r\n"
					+ "    student_major_name VARCHAR(30),\r\n"
					+ "    dorm_id VARCHAR(10),\r\n"
					+ "    PRIMARY KEY (uin)\r\n"
					+ "		\r\n"
					+ ");";
			String sql1 = "CREATE TABLE covid_test (\r\n"
					+ "	uin INTEGER UNSIGNED NOT NULL,\r\n"
					+ "    test_date DATE NOT NULL,\r\n"
					+ "    result_date DATE NOT NULL,\r\n"
					+ "    test_result TINYINT NOT NULL,\r\n"
					+ "    PRIMARY KEY (uin, test_date),\r\n"
					+ "    FOREIGN KEY (uin) REFERENCES student(uin)\r\n"
					+ "		ON UPDATE CASCADE\r\n"
					+ "        ON DELETE CASCADE\r\n"
					+ ");";
			
			String sql2 = "CREATE TABLE course (\r\n"
					+ "	uin INTEGER UNSIGNED NOT NULL,\r\n"
					+ "    course_id MEDIUMINT UNSIGNED NOT NULL,\r\n"
					+ "    course_location VARCHAR(30) NOT NULL,\r\n"
					+ "    PRIMARY KEY (uin),\r\n"
					+ "    FOREIGN KEY (uin) REFERENCES student(uin)\r\n"
					+ "		ON UPDATE CASCADE\r\n"
					+ "        ON DELETE CASCADE\r\n"
					+ ");";
			
			String sql3 = "CREATE TABLE organization (\r\n"
					+ "	uin INTEGER UNSIGNED NOT NULL,\r\n"
					+ "    organization_id MEDIUMINT UNSIGNED NOT NULL,\r\n"
					+ "    organization_name VARCHAR(100) NOT NULL,\r\n"
					+ "    PRIMARY KEY (uin, organization_id),\r\n"
					+ "    FOREIGN KEY (uin) REFERENCES student(uin)\r\n"
					+ "		ON UPDATE CASCADE\r\n"
					+ "        ON DELETE CASCADE\r\n"
					+ ");";
			
			String sql4 = "CREATE TABLE student_housing (\r\n"
					+ "	uin INTEGER UNSIGNED NOT NULL UNIQUE,\r\n"
					+ "    dorm_id VARCHAR(10) NOT NULL,\r\n"
					+ "    room_number SMALLINT UNSIGNED NOT NULL,\r\n"
					+ "    PRIMARY KEY (uin),\r\n"
					+ "    FOREIGN KEY (uin) REFERENCES student(uin)\r\n"
					+ ");";
			
			String sql5 = "CREATE TABLE contact_information (\r\n"
					+ "	uin INTEGER UNSIGNED NOT NULL UNIQUE,\r\n"
					+ "    email_address VARCHAR(50) NOT NULL UNIQUE,\r\n"
					+ "    phone_number VARCHAR(10) UNIQUE,\r\n"
					+ "    address VARCHAR(100) NOT NULL,\r\n"
					+ "    PRIMARY KEY (uin),\r\n"
					+ "    FOREIGN KEY (uin) REFERENCES student(uin)\r\n"
					+ "		ON UPDATE CASCADE\r\n"
					+ "        ON DELETE CASCADE\r\n"
					+ ");";
			
			String sql6 = "CREATE TABLE user (\r\n"
					+ "	username VARCHAR(50),\r\n"
					+ "	password VARCHAR(50),\r\n"
					+ "	email VARCHAR(50)\r\n"
					+ ");";
			
			String sql7 = "CREATE TABLE entity1 (\r\n"
					+ "	username VARCHAR(50),\r\n"
					+ "	password VARCHAR(50),\r\n"
					+ "	email VARCHAR(50)\r\n"
					+ ");";
			
			
			
			
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			PreparedStatement preparestatement1 = connect.prepareStatement(sql1); 
			PreparedStatement preparestatement2 = connect.prepareStatement(sql2); 
			PreparedStatement preparestatement3 = connect.prepareStatement(sql3); 
			PreparedStatement preparestatement4 = connect.prepareStatement(sql4); 
			PreparedStatement preparestatement5 = connect.prepareStatement(sql5); 
			PreparedStatement preparestatement6 = connect.prepareStatement(sql6); 
			PreparedStatement preparestatement7 = connect.prepareStatement(sql7); 
			
			
		    preparestatement.executeUpdate();
		    preparestatement1.executeUpdate();
		    preparestatement2.executeUpdate();
		    preparestatement3.executeUpdate();
		    preparestatement4.executeUpdate();
		    preparestatement5.executeUpdate();
		    preparestatement6.executeUpdate();
		    preparestatement7.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
}
