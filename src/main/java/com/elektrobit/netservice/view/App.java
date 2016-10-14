package com.elektrobit.netservice.view;

import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.service.NetworkService;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         This class creates the configurations needed for the spring framework
 * 
 * 
 * 
 * 
 */
// TODO Tudpor java doc

// TODO Tudor please format you sources and
// get used to format after each save overwise you'll have bilions of code
// conflicts - Okey
// TODO Tudor next task change everything to annotations, get rid of xml -DONE
// this
// then we will create a REST endoint to serve devices

public class App {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		NetworkService networkObj = (NetworkService) context
				.getBean("application");

		Set<Device> set = networkObj.getDevices();

		System.out.println(set);
		context.close();
	}

}
