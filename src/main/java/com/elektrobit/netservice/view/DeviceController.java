package com.elektrobit.netservice.view;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.device.DeviceCategory;
import com.elektrobit.netservice.service.DeviceService;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         This class creates the configurations needed for the spring framework
 *         and then post the information on the server
 * 
 */

@RestController
@RequestMapping(value = "/NetService")
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Device> getDevices() {
		List<Device>	list  = deviceService.getDevices();
			
		for(Device dev:list)
		{
			dev.add(linkTo(methodOn(DeviceController.class).searchForm(dev.getAlias())).withRel("search"));
			dev.add(linkTo(methodOn(DeviceController.class).getSingleCategory(dev.getCategoryid())).withRel("category"));
			
		}
		return list;
	}

	@RequestMapping(value = "/device/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> editDevice(@RequestBody Device device,
			@PathVariable("id") UUID id) {

		List<Device> list = deviceService.getDevices();
		if (device.getPrice() < 1 || device.getQuantity() < 1) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE);

		}
		for (Device dev : list) {
			if (id.equals(dev.getId())) {
				dev.setPrice(device.getPrice());
				dev.setQuantity(device.getQuantity());
				return new ResponseEntity<List<Device>>(list, HttpStatus.OK);
			}
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/device/{category}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Device>> addNewDevice(@RequestBody Device device,
			@PathVariable("category") String category) {
			
		List<DeviceCategory> deviceCategories = deviceService.getDeviceCategories();
		List<Device> list = deviceService.getDevices();
		
		
		if(!deviceCategories.contains(category))
		{	
			return new ResponseEntity<List<Device>>(list,HttpStatus.BAD_REQUEST);
		}
		
		for (Device d : list) {
			if (d.getName().equals(device.getName())) {
				System.out.println("Device with name " + device.getName()
						+ " already exist");
				return new ResponseEntity<List<Device>>(list,HttpStatus.CONFLICT);
			}
		}
		List<DeviceCategory> categList = deviceService.getDeviceCategories();
		for (DeviceCategory categ : categList) {
			if (categ.getCategoryName().equals(category)) {
				device.setCategoryid(categ.getIdCategory());
				deviceService.addNewDevice(device);
				list = deviceService.getDevices();
				return new ResponseEntity<List<Device>>(list,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<List<Device>>(list,HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/device/{alias}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Device>> searchForm(
			@PathVariable("alias") String alias) {

		List<Device> list = deviceService.getDevices();
		List<Device> searchedList = new ArrayList<Device>();
		for (Device device : list) {
			if (alias.equals(device.getAlias())
					|| alias.equals(device.getName()))

			{
				searchedList.add(device);
			}
		}
		if (searchedList.isEmpty()) {
			return new ResponseEntity<List<Device>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Device>>(searchedList, HttpStatus.OK);
	}

	@RequestMapping(value = "/device/{name}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Device>> deleteForm(@PathVariable("name") String name) {

		List<Device> list = deviceService.getDevices();
		for (Device d : list) {
			if (d.getName().equals(name)) {
				deviceService.removeDeviceWithName(name);
				list = deviceService.getDevices();
				return new ResponseEntity<List<Device>>(list, HttpStatus.OK);
			}

		}

		return new ResponseEntity<List<Device>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<DeviceCategory>> addCategory(
			@RequestBody DeviceCategory devCateg) {
		List<DeviceCategory> categories = deviceService.getDeviceCategories();
		for (DeviceCategory categ : categories) {
			if (categ.getCategoryName().equals(devCateg.getCategoryName())) {
				return new ResponseEntity<List<DeviceCategory>>(
						HttpStatus.CONFLICT);
			}
		}

		deviceService.addNewCategory(devCateg);
		categories = deviceService.getDeviceCategories();
		return new ResponseEntity<List<DeviceCategory>>(categories,
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<DeviceCategory>> listCategory() {
		List<DeviceCategory> categories = deviceService.getDeviceCategories();
		
		for(DeviceCategory cat:categories)
		{
			cat.add(linkTo(methodOn(DeviceController.class).listDeviceByCategory(cat.getIdCategory())).withRel("devices"));
			cat.add(linkTo(methodOn(DeviceController.class).listDevicesBySubcategory(cat.getSubCategoryName())).withRel("devices-subcategory"));
		}
		
		return new ResponseEntity<List<DeviceCategory>>(categories,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Device>> listDeviceByCategory(
			@PathVariable("categoryid") UUID id) {
		List<Device> list = deviceService.getDevices();
		List<Device> categoryList = new ArrayList<Device>();
		for (Device d : list) {
			if (d.getCategoryid().equals(id)) {
				categoryList.add(d);
			}
		}

		if (categoryList.isEmpty()) {
			return new ResponseEntity<List<Device>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Device>>(categoryList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{subcategory}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<DeviceCategory>> listDevicesBySubcategory(@PathVariable ("subcategory") String subcategory)
	{
		List<DeviceCategory> devCateg = deviceService.getDeviceCategories();
		List<DeviceCategory> devSubCateg=new ArrayList<DeviceCategory>();
		
		for(DeviceCategory categ: devCateg)
		{
			if(categ.getSubCategoryName().equals(subcategory))
			{
				devSubCateg.add(categ);
			}
		}
		if (devSubCateg.isEmpty()) {
			return new ResponseEntity<List<DeviceCategory>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<DeviceCategory>>(devSubCateg, HttpStatus.OK);
	}
	
	@RequestMapping(value="/device/category/{categoryid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DeviceCategory> getSingleCategory(@PathVariable ("categoryid") UUID id)
	{	
		
		List<DeviceCategory> list = deviceService.getDeviceCategories();
		for(DeviceCategory categ: list)
		{
			if(categ.getIdCategory().equals(id))
			{
				return new ResponseEntity<DeviceCategory>(categ,HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<DeviceCategory>(HttpStatus.BAD_REQUEST);
	}
}
