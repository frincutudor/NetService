package com.elektrobit.netservice.service;

import java.util.Set;

import com.elektrobit.netservice.device.Device;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Interface to NetworkServiceImpl
 * 
 */

// TODO Tudor, please add java doc
// TODO Tudor why is this in model package ? - renamed to service -DONE
public interface NetworkService {

	// TODO Tudor, please add java doc
	public Set<Device> getDevices();

}
