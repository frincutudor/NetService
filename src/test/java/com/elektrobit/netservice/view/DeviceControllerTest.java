//package com.elektrobit.netservice.view;
//
//import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.mockito.Mockito.*;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.hibernate.validator.internal.util.privilegedactions.NewSchema;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.UUIDEditor;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.WebIntegrationTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.elektrobit.netservice.device.Device;
//import com.elektrobit.netservice.device.DeviceCategory;
//import com.elektrobit.netservice.service.DeviceService;
//import com.google.gson.Gson;
//
//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(DeviceController.class)
//public class DeviceControllerTest {
//
//	@Mock
//	private DeviceService deviceService;
//
//	@Mock
//	private DeviceController deviceController;
//
//	private MockMvc mockMvc;
//
//	public void createDevices(Device dev1, Device dev2) {
//		dev1.setId(UUID.fromString("07c6194e-5eb8-4f29-b557-d60c04198db0"));
//		dev2.setId(UUID.fromString("c2bd507d-e544-4ce8-b272-34cab732adb4"));
//		dev1.setName("ASUS");
//		dev1.setAlias("electronics");
//		dev1.setPrice(222);
//		dev1.setQuantity(122);
//		dev1.setCategoryid(UUID.fromString("11535983-b9d0-4a0f-8d53-ca204446e0b8"));
//		dev2.setName("SONYk");
//		dev2.setAlias("electronicsm");
//		dev2.setPrice(2222);
//		dev2.setQuantity(122);
//		dev2.setCategoryid(UUID.fromString("91a71dc0-4d40-4d20-a59d-bb30a348a7f2"));
//	}
//
//	@Before
//	public void setup() {
//
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(deviceController).build();
//
//	}
//
//	@Test
//	public void testGetDevices() throws Exception {
//		String getUrl = "/NetService";
//		Device dev1 = new Device();
//		Device dev2 = new Device();
//		createDevices(dev1, dev2);
//		when(deviceController.getDevices()).thenReturn(Arrays.asList(dev1, dev2));
//
//		mockMvc.perform(get(getUrl)).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(jsonPath("$[0].id").value("07c6194e-5eb8-4f29-b557-d60c04198db0"))
//				.andExpect(jsonPath("$[0].name", is("ASUS"))).andExpect(jsonPath("$[0].alias", is("electronics")))
//				.andExpect(jsonPath("$[0].quantity", is(122))).andExpect(jsonPath("$[0].price", is(222)))
//				.andExpect(jsonPath("$[0].categoryid", is("11535983-b9d0-4a0f-8d53-ca204446e0b8")))
//				.andExpect(jsonPath("$[1].id", is("c2bd507d-e544-4ce8-b272-34cab732adb4")))
//				.andExpect(jsonPath("$[1].name", is("SONYk"))).andExpect(jsonPath("$[1].alias", is("electronicsm")))
//				.andExpect(jsonPath("$[1].quantity", is(122))).andExpect(jsonPath("$[1].price", is(2222)))
//				.andExpect(jsonPath("$[1].categoryid", is("91a71dc0-4d40-4d20-a59d-bb30a348a7f2"))).andDo(print())
//				.andReturn();
//
//	}
//
//	@Test
//	public void testAddNewDevice_IfItCreates() throws Exception {
//		Device dev1 = new Device();
//		Device dev2 = new Device();
//		createDevices(dev1, dev2);
//		Gson gson = new Gson();
//		String json = gson.toJson(dev2);
//		List<Device> list = new ArrayList<Device>();
//		list.add(dev1);
//		list.add(dev2);
//		ResponseEntity<List<Device>> response = new ResponseEntity<List<Device>>(list, HttpStatus.CREATED);
//		doReturn(response).when(deviceController).addNewDevice(dev2, "Phone");
//
//		mockMvc.perform((post("/NetService/device/Phone").contentType(MediaType.APPLICATION_JSON)).content(json))
//				.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(jsonPath("$[0].id").value("07c6194e-5eb8-4f29-b557-d60c04198db0"))
//				.andExpect(jsonPath("$[0].name", is("ASUS"))).andExpect(jsonPath("$[0].alias", is("electronics")))
//				.andExpect(jsonPath("$[0].quantity", is(122))).andExpect(jsonPath("$[0].price", is(222)))
//				.andExpect(jsonPath("$[0].categoryid", is("11535983-b9d0-4a0f-8d53-ca204446e0b8")))
//				.andExpect(jsonPath("$[1].id", is("c2bd507d-e544-4ce8-b272-34cab732adb4")))
//				.andExpect(jsonPath("$[1].name", is("SONYk"))).andExpect(jsonPath("$[1].alias", is("electronicsm")))
//				.andExpect(jsonPath("$[1].quantity", is(122))).andExpect(jsonPath("$[1].price", is(2222)))
//				.andExpect(jsonPath("$[1].categoryid", is("91a71dc0-4d40-4d20-a59d-bb30a348a7f2"))).andDo(print())
//				.andReturn();
//
//	}
//
//	@Test
//	public void testSearchForm_IfItFinds() throws Exception {
//
//		Device dev1 = new Device();
//
//		dev1.setId(UUID.fromString("07c6194e-5eb8-4f29-b557-d60c04198db0"));
//		dev1.setName("ASUS");
//		dev1.setAlias("electronicsm");
//		dev1.setPrice(222);
//		dev1.setQuantity(122);
//		dev1.setCategoryid(UUID.fromString("11535983-b9d0-4a0f-8d53-ca204446e0b8"));
//
//		List<Device> list = new ArrayList<Device>();
//		list.add(dev1);
//
//		ResponseEntity<List<Device>> response = new ResponseEntity<List<Device>>(list, HttpStatus.OK);
//
//		doReturn(response).when(deviceController).searchForm("electronicsm");
//
//		mockMvc.perform(get("/NetService/device/electronicsm")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(jsonPath("$[0].id").value("07c6194e-5eb8-4f29-b557-d60c04198db0"))
//				.andExpect(jsonPath("$[0].name", is("ASUS"))).andExpect(jsonPath("$[0].alias", is("electronicsm")))
//				.andExpect(jsonPath("$[0].quantity", is(122))).andExpect(jsonPath("$[0].price", is(222)))
//				.andExpect(jsonPath("$[0].categoryid", is("11535983-b9d0-4a0f-8d53-ca204446e0b8"))).andDo(print())
//				.andReturn();
//
//	}
//
//	@Test
//	public void testSearchForm_IfIsEmpty() throws Exception {
//
//		ResponseEntity<List<Device>> response = new ResponseEntity<List<Device>>(HttpStatus.NOT_FOUND);
//		doReturn(response).when(deviceController).searchForm("eadsa");
//		mockMvc.perform(get("/NetService/device/eadsa")).andExpect(status().isNotFound()).andDo(print()).andReturn();
//	}
//
//	@Test
//	public void testAddNewDevice_WhenDuplicate() throws Exception {
//		Device dev1 = new Device();
//		Device dev2 = new Device();
//		dev1.setId(UUID.fromString("07c6194e-5eb8-4f29-b557-d60c04198db0"));
//		dev1.setName("ASUS");
//		dev1.setAlias("electronics");
//		dev1.setPrice(222);
//		dev1.setQuantity(122);
//		dev1.setCategoryid(UUID.fromString("11535983-b9d0-4a0f-8d53-ca204446e0b8"));
//		dev2 = dev1;
//
//		Gson gson = new Gson();
//		String json = gson.toJson(dev2);
//		List<Device> list = new ArrayList<Device>();
//		list.add(dev1);
//
//		ResponseEntity<List<Device>> response = new ResponseEntity<List<Device>>(list, HttpStatus.CONFLICT);
//		doReturn(response).when(deviceController).addNewDevice(dev2, "Leptop");
//
//		mockMvc.perform((post("/NetService/device/Leptop").contentType(MediaType.APPLICATION_JSON)).content(json))
//				.andExpect(status().isConflict()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(jsonPath("$[0].id").value("07c6194e-5eb8-4f29-b557-d60c04198db0"))
//				.andExpect(jsonPath("$[0].name", is("ASUS"))).andExpect(jsonPath("$[0].alias", is("electronics")))
//				.andExpect(jsonPath("$[0].quantity", is(122))).andExpect(jsonPath("$[0].price", is(222)))
//				.andExpect(jsonPath("$[0].categoryid", is("11535983-b9d0-4a0f-8d53-ca204446e0b8"))).andDo(print())
//				.andReturn();
//	}
//
//	@Test
//	public void testAddNewDevice_WhenBadCategory() throws Exception {
//		Device dev1 = new Device();
//		Device dev2 = new Device();
//		createDevices(dev1, dev2);
//
//		Gson gson = new Gson();
//		String json = gson.toJson(dev2);
//		List<Device> list = new ArrayList<Device>();
//		list.add(dev1);
//
//		ResponseEntity<List<Device>> response = new ResponseEntity<List<Device>>(list, HttpStatus.BAD_REQUEST);
//		doReturn(response).when(deviceController).addNewDevice(dev2, "leptop");

//		mockMvc.perform((post("/NetService/device/leptop").contentType(MediaType.APPLICATION_JSON)).content(json))
//				.andExpect(status().isBadRequest()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(jsonPath("$[0].id").value("07c6194e-5eb8-4f29-b557-d60c04198db0"))
//				.andExpect(jsonPath("$[0].name", is("ASUS"))).andExpect(jsonPath("$[0].alias", is("electronics")))
//				.andExpect(jsonPath("$[0].quantity", is(122))).andExpect(jsonPath("$[0].price", is(222)))
//				.andExpect(jsonPath("$[0].categoryid", is("11535983-b9d0-4a0f-8d53-ca204446e0b8"))).andDo(print())
//				.andReturn();
//
//	}
//
//	@Test
//	public void testGetCategory() throws Exception {
//		DeviceCategory cat1 = new DeviceCategory();
//		cat1.setCategoryName("Phone");
//		cat1.setIdCategory(UUID.fromString("11535983-b9d0-4a0f-8d53-ca204446e0b8"));
//		cat1.setSubCategoryName("electronics");
//
//		List<DeviceCategory> list = new ArrayList<DeviceCategory>();
//		list.add(cat1);
//		ResponseEntity<List<DeviceCategory>> response = new ResponseEntity<List<DeviceCategory>>(list, HttpStatus.OK);
//		doReturn(response).when(deviceController).listCategory();
//
//		mockMvc.perform(get("/NetService/category")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//
//				.andExpect(jsonPath("$[0].categoryName", is("Phone")))
//				.andExpect(jsonPath("$[0].subCategoryName", is("electronics")))
//				.andExpect(jsonPath("$[0].idCategory").value("11535983-b9d0-4a0f-8d53-ca204446e0b8")).andDo(print())
//				.andReturn();
//
//	}
//
//}
