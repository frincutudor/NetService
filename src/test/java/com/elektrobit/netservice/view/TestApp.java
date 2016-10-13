package com.elektrobit.netservice.view;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import com.elektrobit.netservice.dao.Device;
import com.google.common.collect.ImmutableSet;

public class TestApp {

//TODO Tudor remove this     
 @Test 
  public void  testMain()
 {
	 App a = new App();
	 final Set<Device> set = ImmutableSet.of(new Device("TUFR261616"),
				new Device("RM12312312"), new Device("PEOV1231312"));
	 //assertEquals(set, App.main(new String[] {"main"}));
	 
	 
 }

}
