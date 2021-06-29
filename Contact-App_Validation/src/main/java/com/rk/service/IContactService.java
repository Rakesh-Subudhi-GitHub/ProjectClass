package com.rk.service;

import org.springframework.data.domain.Page;

import com.rk.entity.Contact;

public interface IContactService {

	public Boolean saveContact(Contact contact);
	
	//public List<Contact> getAllContact();
	
	public Page<Contact> getAllContactForPageNation(Integer pageNo, Integer pageSize);
	
	public Contact getContactById(Integer contactId);
	
	public Boolean deleteContactById(Integer contactId);
	
	public Boolean isContactExist(Contact contact);
	
}
