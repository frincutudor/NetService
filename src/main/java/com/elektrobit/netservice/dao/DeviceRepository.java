package com.elektrobit.netservice.dao;

import java.util.Set;

// TODO Tudor java doc, what does this serves for ? 
public interface DeviceRepository {

    // TODO Tudor rename to getDevices or something more intuitive
	public Set<Device> getSet();
	
}
