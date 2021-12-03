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
			System.out.println("Attempting to initialize");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uic_covid_contact_tracing", MySQL_user, MySQL_password);
						
			String drop = "DROP TABLE IF EXISTS covid_test;";
			String drop2 = "DROP TABLE IF EXISTS course;";
			String drop3 = "DROP TABLE IF EXISTS organization;";
			String drop4 = "DROP TABLE IF EXISTS student_housing;";
			String drop5 = "DROP TABLE IF EXISTS contact_information;";
			String drop6 = "DROP TABLE IF EXISTS student;";
			
			String dropView = "DROP VIEW IF EXISTS unvaccinated_students";
			String dropView2 = "DROP VIEW IF EXISTS covid_tests_not_negative";
			String dropView3 = "DROP VIEW IF EXISTS arc_residents";
			String dropView4 = "DROP VIEW IF EXISTS test_result_percentages";
			String dropView5 = "DROP VIEW IF EXISTS num_members_per_org";
			String dropView6 = "DROP VIEW IF EXISTS num_covid_tests_2021";
			String dropView7 = "DROP VIEW IF EXISTS uic_residents_vaccination_status";
			String dropView8 = "DROP VIEW IF EXISTS large_organizations";
			String dropView9 = "DROP VIEW IF EXISTS unvaccinated_students_in_orgs";
						
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
		
			
			String populate = "INSERT INTO student\r\n"
					+ "VALUES ('687695021','1','Lyle','Levy','1','Computer Science','JST'),\r\n"
					+ "		('648394052','2','Woodie','Larsen','0','Biology',NULL),\r\n"
					+ "		('674849301','0','Billy','Good','0','Business Administration',NULL),\r\n"
					+ "		('674393028','2','Delilah','Marx','1','English','CTY'),\r\n"
					+ " 		('647389410','2','Ashley','Jensen','0','Integrated Health Sciences',NULL),\r\n"
					+ "		('689393032','2','Andy','Buzz','1','Chinese','ARC'),\r\n"
					+ "		('612389673','1','Patty','Pine','1','Computer Engineering','ARC'),\r\n"
					+ "		('648394095','2','Sandy','Cheeks','1','Physics','JST');";
			
			String populate2 = "INSERT INTO contact_information (email_address, phone_number, address, uin)\r\n"
					+ "VALUES ('johndoe@uic.edu','3122134567',\"225 S Canal St, Chicago, IL 60606\",'647389410'),\r\n"
					+ "('janedoe@uic.edu','773456123',\"1664 S Blue Island Ave, Chicago, IL 60608\",'648394052'),\r\n"
					+ "('joejo2@uic.edu','6465789821',\"500 W Madison St, Chicago, IL 60661\",'674393028'),\r\n"
					+ "('morristu8@uic.edu','3127690821',\"1035 W Randolph St, Chicago, IL 60607\",'674849301'),\r\n"
					+ "('jreyes21@uic.edu','7738885400',\"1380 W Lake St, Chicago, IL 60607\",'687695021');";
			
			String populate3 = "INSERT INTO course (course_id, uin, course_location)\r\n"
					+ "VALUES ('12345','647389410','AH_101'),\r\n"
					+ "('30210','648394052','ARC_201'),\r\n"
					+ "('40512','674393028','LH_302'),\r\n"
					+ "('67892','674849301','SES_250'),\r\n"
					+ "('32489','687695021','TH_120');";
			
			String populate4 = "INSERT INTO covid_test\r\n"
					+ "VALUES ('647389410','2020-12-21','2020-12-24',1),\r\n"
					+ "('648394052','2020-10-29','2020-11-01',0),\r\n"
					+ "('674393028','2021-10-06','2021-10-10',0),\r\n"
					+ "('674849301','2020-05-08','2020-05-07',1),\r\n"
					+ "('687695021','2021-09-10','2021-09-12',0);";
			
			String populate5 = "INSERT INTO organization (organization_id, organization_name, uin)\r\n"
					+ "VALUES ('25246',\"Filipinos In Alliance\",'674849301'),\r\n"
					+ "('87592',\"Vietnamese Student Association\",'674849301'),\r\n"
					+ "('45482',\"Alpha Kappa Delta Phi Sorority, Inc.\",'648394052'),\r\n"
					+ "('25246',\"Filipinos In Alliance\",'647389410'),\r\n"
					+ "('75932',\"UIC Dental Club\",'648394052');";
			
			String populate6 = "INSERT INTO student_housing (dorm_id, room_number, uin)\r\n"
					+ "VALUES ('JST','120','687695021'),\r\n"
					+ "('JST','503','648394095'),\r\n"
					+ "('ARC','702','612389673'),\r\n"
					+ "('ARC','402','689393032'),\r\n"
					+ "('CTY','608','674393028');";
			
			String view = "CREATE VIEW unvaccinated_students\r\n"
					+ "AS\r\n"
					+ "SELECT *\r\n"
					+ "FROM student\r\n"
					+ "WHERE vaccination_status != 2\r\n"
					+ "ORDER BY uin;";
			
			String view2 = "CREATE VIEW covid_tests_not_negative\r\n"
					+ "AS\r\n"
					+ "SELECT * \r\n"
					+ "FROM covid_test\r\n"
					+ "WHERE test_result != 0\r\n"
					+ "ORDER BY uin;";
			
			String view3 = "CREATE VIEW arc_residents\r\n"
					+ "AS\r\n"
					+ "SELECT *\r\n"
					+ "FROM student_housing\r\n"
					+ "WHERE dorm_id = 'ARC';";
			
			String view4 = "CREATE VIEW test_result_percentages\r\n"
					+ "AS\r\n"
					+ "SELECT test_result, ROUND(COUNT(*)*100.0 / (SELECT COUNT(*) FROM covid_test), 2) AS percentage\r\n"
					+ "FROM covid_test\r\n"
					+ "GROUP BY test_result;";
			
			String view5 = "CREATE VIEW num_members_per_org\r\n"
					+ "AS\r\n"
					+ "SELECT UPPER(organization_name) AS organization_name, COUNT(*) AS count\r\n"
					+ "FROM organization\r\n"
					+ "GROUP BY organization_id HAVING COUNT(*) >= 2;\r\n"
					+ "";
			
			String view6 = "CREATE VIEW num_covid_tests_2021\r\n"
					+ "AS\r\n"
					+ "SELECT COUNT(*) AS count\r\n"
					+ "FROM covid_test\r\n"
					+ "WHERE YEAR(test_date) = 2021;";
			
			String view7 = "CREATE VIEW uic_residents_vaccination_status\r\n"
					+ "AS\r\n"
					+ "SELECT student.uin AS uin, vaccination_status, first_name, last_name, student.dorm_id AS dorm_id, student_housing.room_number AS room_number\r\n"
					+ "FROM student\r\n"
					+ "JOIN student_housing\r\n"
					+ "ON student.uin = student_housing.uin\r\n"
					+ "ORDER BY dorm_id, last_name;";
			
			String view8 = "CREATE VIEW large_organizations\r\n"
					+ "AS\r\n"
					+ "SELECT *\r\n"
					+ "FROM organization A\r\n"
					+ "WHERE 2 <=\r\n"
					+ "	(SELECT COUNT(*)\r\n"
					+ "	 FROM organization\r\n"
					+ "     WHERE organization_id = A.organization_id);";
			
			String view9 = "CREATE VIEW unvaccinated_students_in_orgs\r\n"
					+ "AS\r\n"
					+ "SELECT *\r\n"
					+ "FROM organization A\r\n"
					+ "WHERE EXISTS\r\n"
					+ "	(SELECT *\r\n"
					+ "	 FROM student\r\n"
					+ "     WHERE uin = A.uin AND vaccination_status != 2);";
			
			PreparedStatement dropStatement = connect.prepareStatement(drop); 
			PreparedStatement dropStatement2 = connect.prepareStatement(drop2); 
			PreparedStatement dropStatement3 = connect.prepareStatement(drop3); 
			PreparedStatement dropStatement4 = connect.prepareStatement(drop4); 
			PreparedStatement dropStatement5 = connect.prepareStatement(drop5); 
			PreparedStatement dropStatement6 = connect.prepareStatement(drop6); 
			
			PreparedStatement dropViewStatement = connect.prepareStatement(dropView); 
			PreparedStatement dropViewStatement2 = connect.prepareStatement(dropView2); 
			PreparedStatement dropViewStatement3 = connect.prepareStatement(dropView3); 
			PreparedStatement dropViewStatement4 = connect.prepareStatement(dropView4); 
			PreparedStatement dropViewStatement5 = connect.prepareStatement(dropView5); 
			PreparedStatement dropViewStatement6 = connect.prepareStatement(dropView6); 
			PreparedStatement dropViewStatement7 = connect.prepareStatement(dropView7); 
			PreparedStatement dropViewStatement8 = connect.prepareStatement(dropView8); 
			PreparedStatement dropViewStatement9 = connect.prepareStatement(dropView9); 
			
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			PreparedStatement preparestatement1 = connect.prepareStatement(sql1); 
			PreparedStatement preparestatement2 = connect.prepareStatement(sql2); 
			PreparedStatement preparestatement3 = connect.prepareStatement(sql3); 
			PreparedStatement preparestatement4 = connect.prepareStatement(sql4); 
			PreparedStatement preparestatement5 = connect.prepareStatement(sql5); 
			
			PreparedStatement populateStatement = connect.prepareStatement(populate); 
			PreparedStatement populateStatement2 = connect.prepareStatement(populate2); 
			PreparedStatement populateStatement3 = connect.prepareStatement(populate3); 
			PreparedStatement populateStatement4 = connect.prepareStatement(populate4); 
			PreparedStatement populateStatement5 = connect.prepareStatement(populate5); 
			PreparedStatement populateStatement6 = connect.prepareStatement(populate6); 
			
			PreparedStatement viewStatement = connect.prepareStatement(view); 
			PreparedStatement viewStatement2 = connect.prepareStatement(view2); 
			PreparedStatement viewStatement3 = connect.prepareStatement(view3); 
			PreparedStatement viewStatement4 = connect.prepareStatement(view4); 
			PreparedStatement viewStatement5 = connect.prepareStatement(view5); 
			PreparedStatement viewStatement6 = connect.prepareStatement(view6); 
			PreparedStatement viewStatement7 = connect.prepareStatement(view7); 
			PreparedStatement viewStatement8 = connect.prepareStatement(view8); 
			PreparedStatement viewStatement9 = connect.prepareStatement(view9); 

			
			dropStatement.executeUpdate();
			dropStatement2.executeUpdate();
			dropStatement3.executeUpdate();
			dropStatement4.executeUpdate();
			dropStatement5.executeUpdate();
			dropStatement6.executeUpdate();
			
			dropViewStatement.executeUpdate();
			dropViewStatement2.executeUpdate();
			dropViewStatement3.executeUpdate();
			dropViewStatement4.executeUpdate();
			dropViewStatement5.executeUpdate();
			dropViewStatement6.executeUpdate();
			dropViewStatement7.executeUpdate();
			dropViewStatement8.executeUpdate();
			dropViewStatement9.executeUpdate();
						
		    preparestatement.executeUpdate();
		    preparestatement1.executeUpdate();
		    preparestatement2.executeUpdate();
		    preparestatement3.executeUpdate();
		    preparestatement4.executeUpdate();
		    preparestatement5.executeUpdate();
		    
		    populateStatement.executeUpdate();
		    populateStatement2.executeUpdate();
		    populateStatement3.executeUpdate();
		    populateStatement4.executeUpdate();
		    populateStatement5.executeUpdate();
		    populateStatement6.executeUpdate();
		    
		    viewStatement.executeUpdate();
		    viewStatement2.executeUpdate();
		    viewStatement3.executeUpdate();
		    viewStatement4.executeUpdate();
		    viewStatement5.executeUpdate();
		    viewStatement6.executeUpdate();
		    viewStatement7.executeUpdate();
		    viewStatement8.executeUpdate();
		    viewStatement9.executeUpdate();
		    
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
}
