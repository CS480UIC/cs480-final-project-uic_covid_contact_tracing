package organization.service;


import java.util.List;

import organization.dao.OrganizationDao;
import organization.domain.Organization;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class OrganizationService {
	private OrganizationDao organizationDao = new OrganizationDao();
	
	/**
	 * register a Student
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Organization form) throws OrganizationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Organization organization = organizationDao.findByUIN(form.getUin());
		if(organization.getUin()!=null && ((organization.getUin()).equals(form.getUin()))) throw new OrganizationException("This UIN has been registered!");
		organizationDao.add(form);
	}

	public List<Object> findNumMembersPerOrg() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return organizationDao.findNumMembersPerOrg();
	}

	public Object findStudentsInOrgs() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return organizationDao.findStudentsInOrgs();
	}
	
	public List<Object> findUnvaxxedStudentsInOrgs() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return organizationDao.findUnvaxxedStudentsInOrgs();
	}
}
