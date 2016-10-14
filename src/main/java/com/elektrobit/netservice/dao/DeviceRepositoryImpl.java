package com.elektrobit.netservice.dao;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.elektrobit.netservice.device.Device;
import com.google.common.collect.ImmutableSet;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         This class stores the Device type objects and returns the Set of
 *         Devices when called
 * 
 */

@Repository
public class DeviceRepositoryImpl implements DeviceRepository {

	private final Set<Device> set = ImmutableSet.of(new Device("TUFR261616"),
			new Device("RM12312312"), new Device("PEOV1231312"));

	public Set<Device> getDevices() {

		return set;

	}

}
