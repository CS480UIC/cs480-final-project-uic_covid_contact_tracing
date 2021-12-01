package student_housing.domain;

/**
 * Course object
 * 
 * @author Sean Kim
 * 
 */
public class StudentHousing {
	/*
	 * Correspond to the course table
	 */
	
	private Integer uin;
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
	/**
	 * @return the room_number
	 */
	public Byte getRoom_number() {
		return room_number;
	}
	/**
	 * @param room_number the room_number to set
	 */
	public void setRoom_number(Byte room_number) {
		this.room_number = room_number;
	}
	private String dorm_id;
	private Byte room_number;

}
