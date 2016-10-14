package com.elektrobit.netservice.dao;

import java.util.Set;

import com.elektrobit.netservice.device.Device;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Interface to DeviceRepositoryImpl
 * 
 */
// TODO Tudor java doc, what does this serves for ?
// TODO Tudor rename to getDevices or something more intuitive - DONE
public interface DeviceRepository {

	public Set<Device> getDevices();

}
