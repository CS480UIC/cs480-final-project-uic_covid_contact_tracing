package covidTesting.domain;

import java.sql.Date;

/**
 * Course object
 * 
 * @author Sean Kim
 * 
 */
public class CovidTesting {
	/*
	 * Correspond to the course table
	 */
	
	private Integer uin;
	private Date test_date;
	private Date result_date;
	private Byte test_result;
	private Double percentage;
	private Integer count;

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
	 * @return the test_date
	 */
	public Date getTest_date() {
		return test_date;
	}
	/**
	 * @param test_date the test_date to set
	 */
	public void setTest_date(Date test_date) {
		this.test_date = test_date;
	}
	/**
	 * @return the result_date
	 */
	public Date getResult_date() {
		return result_date;
	}
	/**
	 * @param result_date the result_date to set
	 */
	public void setResult_date(Date result_date) {
		this.result_date = result_date;
	}
	/**
	 * @return the result
	 */
	public Byte getTest_result() {
		return test_result;
	}
	/**
	 * @param result the result to set
	 */
	public void setTest_result(Byte result) {
		this.test_result = result;
	}
	
	public Double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

}
