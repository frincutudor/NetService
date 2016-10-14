package com.elektrobit.netservice.dao;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import com.elektrobit.netservice.device.Device;
import com.google.common.collect.ImmutableSet;

public class TestDeviceRepositoryImpl {

	@Test
	public void testDeviceRepositoryImpl_GetSet() {

		final Set<Device> set = ImmutableSet.of(new Device("TUFR261616"),
				new Device("RM12312312"), new Device("PEOV1231312"));

		DeviceRepositoryImpl devRep = new DeviceRepositoryImpl();

		assertEquals(devRep.getDevices(), set);

	}

}
