package com.elektrobit.netservice.view;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Spring annotation configuration class
 * 
 */

@Configuration
@ComponentScan(basePackages = { "com.elektrobit.netservice.service",
		"com.elektrobit.netservice.dao" })
public class AppConfig {

}