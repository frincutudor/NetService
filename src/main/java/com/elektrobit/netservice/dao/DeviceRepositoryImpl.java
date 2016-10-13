package com.elektrobit.netservice.dao;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableSet;


 // TODO Tudor dc repository e un spring Configuration ? 
@Configuration
public class DeviceRepositoryImpl implements DeviceRepository {

	private final Set<Device> set = ImmutableSet.of(new Device("TUFR261616"),
			new Device("RM12312312"), new Device("PEOV1231312"));
	
	
	
	public Set<Device> getSet() {
		
		return set;

	}

}
