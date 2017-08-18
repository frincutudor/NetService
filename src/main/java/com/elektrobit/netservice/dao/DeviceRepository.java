package com.elektrobit.netservice.dao;

import java.util.*;

import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.device.DeviceCategory;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Interface to DeviceRepositoryImpl
 * 
 */

public interface DeviceRepository {

	// public Map<UUID,Device> getDevices();
	// public void removeDevice(UUID id);
	// public void addDevice(String name, String alias ,int price, int
	// quantity);
	// public void editD(UUID id, int price , int quantity);

	void addNewDevice(Device device);

	void editDeviceImpl(Device device);

	public List<Device> listCategory(UUID category);

	public void delete(String name);

	public List<Device> list();

	public List<DeviceCategory> getCategories();
	public void addCategory(DeviceCategory devCategory);
	

}
