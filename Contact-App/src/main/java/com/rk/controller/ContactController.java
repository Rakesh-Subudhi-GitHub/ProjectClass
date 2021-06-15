package com.rk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rk.entity.Contact;
import com.rk.service.ContactServiceImpl;

@Controller
public class ContactController {

	private ContactServiceImpl contactService;
	
	@Autowired
	public ContactController(ContactServiceImpl contactService) {
		this.contactService = contactService;
	}

	@GetMapping({"/loadForm","/"})
	public String loadForm(Model model)
	{
		Contact cobj=new Contact();
		
		model.addAttribute("contact",cobj);
		
		return "contact";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact cont,Model model)
	{
		
		Boolean isSaved = contactService.saveContact(cont);
		if(isSaved)
		{
			model.addAttribute("succMsg","ContactSaved SuccessFully");
		}
		else
		{
			model.addAttribute("errMsg","Contact Not Saved some Internal problem here... Try Again ");
		}
		return "contact";
	}

	/*
	@GetMapping("/viewContact")
	public String viewContacts(Model model)
	{
	 
		List<Contact> allContact = contactService.getAllContact();
		
		model.addAttribute("contacts",allContact);
		
		return "viewContacts";
	}
	*/
	
	//or
 
	/*@GetMapping("/viewContacts")
	public ModelAndView viewContactsMethod()
	{
		ModelAndView mav=new ModelAndView();
		
		List<Contact> allContacts = contactService.getAllContact();
		
		mav.addObject("contacts",allContacts);
		mav.setViewName("viewContacts");
		
		return mav;
	
	}
	*/
	
	//Pagination
	@GetMapping("/viewContacts")
	public ModelAndView viewContactsMethod(HttpServletRequest req)
	{
		int pageNum=1;
		int pageSize=3;  //one page 3 record display
		
		String reqParam = req.getParameter("pNo");
		if(reqParam !=null && !"".equals(reqParam))
		{
			pageNum=Integer.parseInt(reqParam);      //starting page or pageNo change here
		}
		
		Page<Contact> page = contactService.getAllContactForPageNation(pageNum-1, pageSize);
		
		//count the total page here
		int totalPages = page.getTotalPages();
		
		List<Contact> allContacts = page.getContent();
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("contacts",allContacts);
		mav.addObject("tp",totalPages);
		mav.addObject("currentPage",pageNum);
		
		mav.setViewName("viewContacts");
		
		return mav;
	
	}
	
}//class
