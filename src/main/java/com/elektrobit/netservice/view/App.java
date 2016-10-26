package com.elektrobit.netservice.view;

import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.service.NetworkService;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         This class creates the configurations needed for the spring framework
 *         and then post the information on the server
 * 
 */

@Controller
public class App {

	@RequestMapping(value = "/Device")
	public ModelAndView postForm() {

		ModelAndView model = new ModelAndView("Device");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		NetworkService networkObj = (NetworkService) context
				.getBean("application");

		Set<Device> device = networkObj.getDevices();
		model.addObject("device", device);

		return model;
	}

}
