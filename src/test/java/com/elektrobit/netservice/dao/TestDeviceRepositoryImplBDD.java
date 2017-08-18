//package com.elektrobit.netservice.dao;
//
//import static org.junit.Assert.assertTrue;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class TestDeviceRepositoryImplBDD {
//	
//	
//	private static DriverManagerDataSource testDataSource;
//	private static DeviceRepository dr;
//
//	static {
//		testDataSource = new DriverManagerDataSource();
//		testDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		testDataSource.setUrl("jdbc:mysql://localhost:3306/daotest");
//		testDataSource.setUsername("root");
//		testDataSource.setPassword("1234");
//
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(testDataSource);
//
//		dr = new DeviceRepositoryImpl(jdbcTemplate);
//
//	}
//	
//
//	@Given("^I am on login page$")
//	public void goToLoginPage() {
//		goTo(loginPage);
//	}
//
//	@When("^I enter username as '(.*?)'$")
//	public void enterUsername(String username) {
//
//		waitAndFill(loginPage.username, username);
//
//	}
//
//	@When("^I enter password as '(.*?)'$")
//	public void enterPassword(String password) {
//
//		waitAndFill(loginPage.password, password);
//		waitUntilCliclableAndClick(loginPage.loginButton);
//
//	}
//	
//	@Then("^Login should be succesfull$") 
//	   public void checkLoginStatus() {  
//		assertTrue(getDriver().getCurrentUrl().contains("login_attempt=1"));
//	   } 
//
//	
//	
//	
//}
