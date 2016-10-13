package com.elektrobit.netservice.view;

/**
 * Hello world!
 *
 */
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.elektrobit.netservice.dao.Device;
import com.elektrobit.netservice.model.NetworkService;
import com.elektrobit.netservice.model.NetworkServiceImpl;
import com.google.common.base.MoreObjects;

public class App {
	
	public static void main(String[] args) {

		URL resource = App.class.getResource("Config.xml");
       
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { resource.toString() });
		
		NetworkService networkObj = (NetworkService) context
				.getBean("ControllerBean");
      
		Set<Device> set = networkObj.getDevices();

		System.out.println(set);
		
		
		
		

	}

}