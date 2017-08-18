package com.elektrobit.netservice.service;

import java.util.List;
import java.util.UUID;

import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.device.DeviceCategory;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Interface to NetworkServiceImpl
 * 
 */

// TODO Tudor, please add java doc
// TODO Tudor why is this in model package ? - renamed to service -DONE
public interface DeviceService {

	// TODO Tudor, please add java doc
	public List<Device> getDevices();
	public void removeDeviceWithName(String name);
	public void editDevice(Device d);
	public void addNewDevice(Device d);
	public List<Device> getDevicesByCategory(UUID category) ;
	public List<DeviceCategory> getDeviceCategories();
	public void addNewCategory(DeviceCategory devCategory);

	
//	public void editDevice(UUID id ,int price, int quantity);
}
