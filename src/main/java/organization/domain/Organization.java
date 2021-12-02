package organization.domain;

/**
 * Course organization
 * 
 * @author Sean Kim
 * 
 */
public class Organization {
	/*
	 * Correspond to the course table
	 */
	
	private Integer uin;
	private Integer organization_id;
	private String organization_name;
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
	 * @return the organization_id
	 */
	public Integer getOrganization_id() {
		return organization_id;
	}
	/**
	 * @param organization_id the organization_id to set
	 */
	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}
	/**
	 * @return the organization_name
	 */
	public String getOrganization_name() {
		return organization_name;
	}
	/**
	 * @param organization_name the organization_name to set
	 */
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

}
