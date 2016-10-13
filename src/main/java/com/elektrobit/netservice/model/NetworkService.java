package com.elektrobit.netservice.model;

import java.util.Set;

import com.elektrobit.netservice.dao.Device;
import com.elektrobit.netservice.dao.DeviceRepository;
// TODO Tudor, please add java doc
// TODO Tudor why is this in model package ?
public interface NetworkService {

 // TODO Tudor, please add java doc
	public Set<Device> getDevices();
	
}
