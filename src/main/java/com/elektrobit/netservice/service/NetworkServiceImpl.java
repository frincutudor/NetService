package com.elektrobit.netservice.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.elektrobit.netservice.dao.DeviceRepository;
import com.elektrobit.netservice.device.Device;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         This class does the logistic , it communicates with the
 *         DeviceRepositoryImpl class and returnes the set of devices when the
 *         getter is called.
 * 
 */
// TODO Tudor where is the java doc
// why this is in the model package

@Configuration("application")
public class NetworkServiceImpl implements NetworkService {
	@Autowired
	private DeviceRepository deviceRepository;

	public void setDeviceRepository(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;

	}

	public Set<Device> getDevices() {
		return deviceRepository.getDevices();
	}

}
