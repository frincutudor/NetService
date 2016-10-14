package com.elektrobit.netservice.service;

import com.elektrobit.netservice.dao.*;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.elektrobit.netservice.dao.DeviceRepositoryImpl;
import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.service.NetworkServiceImpl;
import com.google.common.collect.ImmutableSet;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NetworkServiceImpl.class,
		DeviceRepositoryImpl.class })
public class TestNetworkServiceImpl {

	@Autowired
	NetworkServiceImpl netDevice;

	@Test
	public void testGetDevices() {
		final Set<Device> set = ImmutableSet.of(new Device("TUFR261616"),
				new Device("RM12312312"), new Device("PEOV1231312"));

		// = new NetworkServiceImpl();
		// netDevice.setDeviceRepository(new DeviceRepositoryImpl());

		assertEquals(netDevice.getDevices(), set);

	}

}
