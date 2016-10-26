package com.elektrobit.netservice.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class AppController {

	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//binder.setDisallowedFields(new String[] {"studentMobile" });
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy*MM*dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName",new nameEditor());
		
		
		
	}
	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView getForm() {

		ModelAndView model = new ModelAndView("view");
		
		return model;
	}
   
	@ModelAttribute
	public void addingCommonObjects(Model model)
	{
		model.addAttribute("headerMessage", "IESC -  TI");
		
	}
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public ModelAndView postForm(@Valid @ModelAttribute("student1") Student student1,BindingResult result) {
        
		if(result.hasErrors())
		{
			ModelAndView model = new ModelAndView("view");
			return model;
			
		}
		
		
		ModelAndView model = new ModelAndView("hello");

		return model;
	}

}
