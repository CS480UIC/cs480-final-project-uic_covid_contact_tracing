package course.domain;

/**
 * Course object
 * 
 * @author Sean Kim
 * 
 */
public class Course {
	/*
	 * Correspond to the course table
	 */
	
	private Integer uin;
	private Double course_id;
	private String course_location;
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
	 * @return the course_id
	 */
	public Double getCourse_id() {
		return course_id;
	}
	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(Double course_id) {
		this.course_id = course_id;
	}
	/**
	 * @return the course_location
	 */
	public String getCourse_location() {
		return course_location;
	}
	/**
	 * @param course_location the course_location to set
	 */
	public void setCourse_location(String course_location) {
		this.course_location = course_location;
	}
}
