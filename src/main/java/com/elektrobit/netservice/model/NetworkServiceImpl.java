package com.elektrobit.netservice.model;

import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elektrobit.netservice.dao.Device;
import com.elektrobit.netservice.dao.DeviceRepository;
import com.google.common.base.MoreObjects;

import org.springframework.stereotype.*;

@Configuration
public class NetworkServiceImpl implements NetworkService {
	
	private DeviceRepository deviceRepository;
	
	    @Autowired
		public void setDeviceRepository(DeviceRepository deviceRepository) {
			this.deviceRepository = deviceRepository;

		}
	
	public Set<Device> getDevices() {
		return deviceRepository.getSet();
	}
   

}
