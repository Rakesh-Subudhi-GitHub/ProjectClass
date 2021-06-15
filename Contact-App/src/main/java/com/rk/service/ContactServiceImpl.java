package com.rk.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rk.entity.Contact;
import com.rk.repository.IContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	private IContactRepository contactRepo;
	
	//Constructor injection
	@Autowired
	public ContactServiceImpl(IContactRepository contactRepo) {
	
		this.contactRepo=contactRepo;
	}
	
	@Override
	public Boolean saveContact(Contact contact) {
		
		contact.setActiveSwitch("Y");
		Contact saveContact = contactRepo.save(contact);
		if(saveContact != null && saveContact.getContactId() !=null) {
			return true;
		}
		return false;
		
	}//save contact

	/*
	@Override
	public List<Contact> getAllContact() {
	
		//	List<Contact> contacts = contactRepo.findAll(); //show all contacts is saved
		
		//show activeSwitch is "Y" only that record is show 
		Contact contactFilter= new Contact();
		contactFilter.setActiveSwitch("Y");
		
		Example<Contact> example=Example.of(contactFilter);
		List<Contact> contacts = contactRepo.findAll(example);
		
		return contacts;
	
	}
   */
	
	//for the pagination to use this
	@Override
	public Page<Contact> getAllContactForPageNation(Integer pageNo, Integer pageSize) {
		
		//show activeSwitch is "Y" only that record is show 
		Contact contactFilter= new Contact();
		contactFilter.setActiveSwitch("Y");
		
		Example<Contact> example=Example.of(contactFilter);
		
		PageRequest pageRequest = PageRequest.of(pageNo,pageSize);
		
		Page<Contact> findAll = contactRepo.findAll(example, pageRequest);
		
		return findAll;
	
	}
	
	@Override
	public Contact getContactById(Integer contactId) {
		
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent())
		{
			return findById.get(); //return specific contact details
		}
		return null;
	}

	@Override
	public Boolean deleteContactById(Integer contactId) {
		
		boolean existsById = contactRepo.existsById(contactId); //fast check it exist the contact or not
		
		//hard delete
		/*
		if(existsById) {
			contactRepo.deleteById(contactId);    //if exists then delete the contact
			return true;
		}
		*/
		
		//soft delete
		if(existsById) {
		
		Optional<Contact> findById = contactRepo.findById(contactId);
		  
		if(findById.isPresent())
		  {
			Contact contact=findById.get();
			contact.setActiveSwitch("N");
			
			contactRepo.save(contact);
			
			//all are done then return (true)
			return true;
			
		  }//if
		}//if
		
		return false;
	}

}
