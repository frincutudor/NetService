package com.elektrobit.netservice.view;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.elektrobit.netservice.dao.DeviceRepository;
import com.elektrobit.netservice.dao.DeviceRepositoryImpl;
import com.elektrobit.netservice.service.DeviceService;
import com.elektrobit.netservice.service.DeviceServiceImpl;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Spring annotation configuration class
 * 
 */
@Configuration
@EnableAutoConfiguration
public class AppConfig {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	private JdbcTemplate testJdbcTemplate;
	
	@Bean
	public DeviceService deviceService() {
		return new DeviceServiceImpl(deviceRepository());
	}

	@Bean
	public DeviceRepository deviceRepository() {
		return new DeviceRepositoryImpl(jdbcTemplate);
	}
	
//	@Bean
//	public DeviceRepository testDeviceRepository() {
//		
//		return new DeviceRepositoryImpl(testJdbcTemplate);
//	}
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dao");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");

		return dataSource;
	}
	
//	@Bean
//	public DataSource testDataSource() {
//		DriverManagerDataSource testDataSource = new DriverManagerDataSource();
//		testDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		testDataSource.setUrl("jdbc:mysql://localhost:3306/daotest");
//		testDataSource.setUsername("root");
//		testDataSource.setPassword("1234");
//
//		return testDataSource;
//	}
	


	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
//	@Bean
//	public JdbcTemplate testJdbcTemplate() {
//		return new JdbcTemplate(testDataSource());
//	}
	

}