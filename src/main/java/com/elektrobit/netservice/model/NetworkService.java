package com.elektrobit.netservice.model;

import java.util.Set;

import com.elektrobit.netservice.dao.Device;
import com.elektrobit.netservice.dao.DeviceRepository;

public interface NetworkService {

	
	public Set<Device> getDevices();
	
}
