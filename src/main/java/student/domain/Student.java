package student.domain;

/**
 * Student object
 * 
 * @author Sean Kim
 * 
 */
public class Student {
	/*
	 * Correspond to the Student table
	 */
	
	private Integer uin;
	private Byte vaccination_status;
	private String first_name;
	private String last_name;
	private Byte student_living;
	
	/**
	 * @return the uin
	 */
	public Integer getUin() {
		return uin;
	}
	/**
	 * @param uin the uin to set
	 */
	public void setUin(Integer uin) {
		this.uin = uin;
	}
	/**
	 * @return the vaccination_status
	 */
	public Byte getVaccination_status() {
		return vaccination_status;
	}
	/**
	 * @param vaccination_status the vaccination_status to set
	 */
	public void setVaccination_status(Byte vaccination_status) {
		this.vaccination_status = vaccination_status;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the student_living
	 */
	public Byte getStudent_living() {
		return student_living;
	}
	/**
	 * @param student_living the student_living to set
	 */
	public void setStudent_living(Byte student_living) {
		this.student_living = student_living;
	}
	/**
	 * @return the student_major_name
	 */
	public String getStudent_major_name() {
		return student_major_name;
	}
	/**
	 * @param student_major_name the student_major_name to set
	 */
	public void setStudent_major_name(String student_major_name) {
		this.student_major_name = student_major_name;
	}
	/**
	 * @return the dorm_id
	 */
	public String getDorm_id() {
		return dorm_id;
	}
	/**
	 * @param dorm_id the dorm_id to set
	 */
	public void setDorm_id(String dorm_id) {
		this.dorm_id = dorm_id;
	}
	private String student_major_name;
	private String dorm_id;
}
