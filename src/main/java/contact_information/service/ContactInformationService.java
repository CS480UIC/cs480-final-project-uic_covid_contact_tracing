package contact_information.service;


import contact_information.dao.ContactInformationDao;
import contact_information.domain.ContactInformation;
import student.service.StudentException;

/**
 * logic functions such as register, login
 * @author Sean Kim
 *
 */
public class ContactInformationService {
	private ContactInformationDao contactInformationDao = new ContactInformationDao();
	
	/**
	 * register a ContactInformation
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(ContactInformation form) throws ContactInformationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		ContactInformation contactInformation = contactInformationDao.findByUin(form.getUin());
		if(contactInformation.getUin()!=null && ((contactInformation.getUin()).equals(form.getUin()))) throw new ContactInformationException("This UIN has a schedule that has been registed!");
		contactInformationDao.add(form);
	}

}
