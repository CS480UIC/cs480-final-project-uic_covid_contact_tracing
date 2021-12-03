package covidTesting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import covidTesting.domain.CovidTesting;

/**
 * DDL functions performed in database
 */
public class CovidTestingDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "uic_covid_contact_tracing"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "covid"; //TODO change password

	public CovidTesting findByUIN(Integer uin_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		CovidTesting student = new CovidTesting();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
		    String sql = "SELECT * FROM covid_test where uin=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    
		    while(resultSet.next()){
		    	Integer uin = Integer.parseInt(resultSet.getString("uin"));
		    	if(uin.equals(uin_p)){
		    		student.setUin(uin);
		    		student.setTest_date( java.sql.Date.valueOf(resultSet.getString("test_date")));
		    		student.setResult_date( java.sql.Date.valueOf(resultSet.getString("result_date")));
		    		student.setTest_result(Byte.parseByte(resultSet.getString("test_result")));
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
	
	public void add(CovidTesting form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "insert into covid_test (uin, test_date, result_date, test_result) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getUin());
		    preparestatement.setDate(2, form.getTest_date());
		    preparestatement.setDate(3,form.getResult_date());
		    preparestatement.setByte(4, form.getTest_result());
		    
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
	public void update(CovidTesting form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			
			String sql = "UPDATE covid_test SET test_date = ?, result_date = ?, test_result = ? where uin = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(4,form.getUin());
		    preparestatement.setDate(1, form.getTest_date());
		    preparestatement.setDate(2,form.getResult_date());
		    preparestatement.setByte(3, form.getTest_result());
		    
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
			
			String sql = "delete from covid_test where uin = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,uin);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findNonNegativeTests() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			String sql = "select * from covid_tests_not_negative";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				CovidTesting covidTest = new CovidTesting();
				covidTest.setUin(resultSet.getInt("uin"));
				covidTest.setTest_date(resultSet.getDate("test_date"));
				covidTest.setResult_date(resultSet.getDate("result_date"));
				covidTest.setTest_result(resultSet.getByte("test_result"));
	    		list.add(covidTest);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<Object> findTestResultPercentages() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			String sql = "select * from test_result_percentages";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				CovidTesting covidTest = new CovidTesting();
				covidTest.setTest_result(resultSet.getByte("test_result"));
				covidTest.setPercentage(resultSet.getDouble("percentage"));
	    		list.add(covidTest);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findNumTests2021() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
			String sql = "select * from num_covid_tests_2021";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				CovidTesting covidTest = new CovidTesting();
				covidTest.setCount(resultSet.getInt("count"));
	    		list.add(covidTest);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
