package com.elektrobit.netservice.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.device.DeviceCategory;

public class TestDeviceRepositoryImpl {

	static DriverManagerDataSource testDataSource;
	static DeviceRepository dr;

	static {
		testDataSource = new DriverManagerDataSource();
		testDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		testDataSource.setUrl("jdbc:mysql://localhost:3306/daotest");
		testDataSource.setUsername("root");
		testDataSource.setPassword("1234");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(testDataSource);

		dr = new DeviceRepositoryImpl(jdbcTemplate);

	}

	@Test
	public void testIfAddsDevice() {

		Device dev1 = new Device();
		dev1.setName("SONYk");
		dev1.setAlias("electronicsm");
		dev1.setPrice(2222);
		dev1.setQuantity(122);
		dev1.setCategoryid(UUID
				.fromString("91a71dc0-4d40-4d20-a59d-bb30a348a7f2"));

		dr.addNewDevice(dev1);
		List<Device> list = new ArrayList<Device>();
		list = dr.list();
		assertEquals(list.get(0).getName(), dev1.getName());
		assertEquals(list.get(0).getAlias(), dev1.getAlias());
		assertEquals(list.get(0).getPrice(), dev1.getPrice());
		assertEquals(list.get(0).getQuantity(), dev1.getQuantity());

	}

//	@Test
//	public void testIfDeletsDevice() {
//		List<Device> list = new ArrayList<Device>();
//		list = dr.list();
//		UUID id = list.get(0).getDeviceid();
//
//		dr.delete(id);
//		assertTrue(dr.list().isEmpty());
//
//	}

	@Test
	public void testIfEditsTheDevice() {

		List<Device> list = new ArrayList<Device>();
		list = dr.list();
		UUID id = list.get(0).getDeviceid();
		Device dev = new Device();
		dev.setDeviceid(id);
		dev.setPrice(123);
		dev.setQuantity(12);

		dr.editDeviceImpl(dev);
		list = dr.list();
		assertEquals(list.get(0).getPrice(), dev.getPrice());

		assertEquals(list.get(0).getQuantity(), dev.getQuantity());

	}

	@Test
	public void testIfAddsCategory() {
		DeviceCategory devCateg = new DeviceCategory();
		
		devCateg.setCategoryName("Leptop");
		devCateg.setSubCategoryName("electronics");
		
		dr.addCategory(devCateg);
		
		List<DeviceCategory> listCateg = new ArrayList<DeviceCategory>();
		listCateg = dr.getCategories();
		assertEquals(listCateg.get(0).getCategoryName(), devCateg.getCategoryName());
		assertEquals(listCateg.get(0).getSubCategoryName(), devCateg.getSubCategoryName());
		
	}
	
	@Test
	public void testListByCategory()
	{
		UUID id= UUID.fromString("91a71dc0-4d40-4d20-a59d-bb30a348a7f2");
		
		List<Device> list=dr.listCategory(id);
	
		assertEquals(list.get(0).getCategoryid(),id);
		
	}

}
