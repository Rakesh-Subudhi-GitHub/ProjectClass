package com.rk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rk.entity.Contact;
import com.rk.service.ContactServiceImpl;
import com.rk.service.IContactService;

@Controller
public class ViewController {

	private ContactServiceImpl contactService;
	
	@Autowired
	public ViewController(ContactServiceImpl contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping("/editContact")
	public ModelAndView editContactMethod(@RequestParam("cid") Integer contactId)
	{
		ModelAndView mav=new ModelAndView();
	
		Contact contactById = contactService.getContactById(contactId);
		
		mav.addObject("contact",contactById);
		mav.setViewName("contact");
		
		return mav;
	}
	
	@GetMapping("/deleteContact")
	public String deleteContactModel(@RequestParam("cid") Integer contactId,Model model) {
		
		contactService.deleteContactById(contactId);

		return "redirect:viewContacts";
	}
}//class
