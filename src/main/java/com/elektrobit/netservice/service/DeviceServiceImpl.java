package com.elektrobit.netservice.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.elektrobit.netservice.dao.DeviceRepository;
import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.device.DeviceCategory;

/**
 * This class does the logistic , it communicates with the DeviceRepositoryImpl
 * class and returnes the set of devices when the getter is called.
 * 
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 * 
 */

@Transactional
public class DeviceServiceImpl implements DeviceService {
	
	private final DeviceRepository deviceRepository;

	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = Objects.requireNonNull(deviceRepository,
				"The given device repository ca not be null.");
	}


	public List<Device> getDevices() {
		return deviceRepository.list();
	}

	public List<Device> getDevicesByCategory(UUID category) {
		return deviceRepository.listCategory(category);
	}

	public void removeDeviceWithName(String name) {
		deviceRepository.delete(name);
	}

	public void addNewDevice(Device d) {
		deviceRepository.addNewDevice(d);
	}

	public void editDevice(Device d) {
		deviceRepository.editDeviceImpl(d);
	}

	public List<DeviceCategory> getDeviceCategories() {
		return deviceRepository.getCategories();
	}

	public void addNewCategory(DeviceCategory devCategory) {
		deviceRepository.addCategory(devCategory);
	}

	
}
