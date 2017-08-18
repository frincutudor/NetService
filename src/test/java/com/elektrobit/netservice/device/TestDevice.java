package com.elektrobit.netservice.device;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.elektrobit.netservice.device.Device;

public class TestDevice {

	@Test
	public void testEquals_Reflexiv() {
		Device d1 = new Device("ACER", "laptop", 100, 200);

		assertTrue(d1.equals(d1));

	}

	@Test
	public void testEquals_Simetric() {
		//arrange
		Device d1 = new Device("ACER", "laptop", 100, 200);
		Device d2 = new Device("ACER", "laptop", 100, 200);

		//act 
	
		
		//
		assertTrue(d1.equals(d2));
		assertTrue(d2.equals(d1));

	}

	@Test
	public void testEquals_Transitive() {
		Device d1 = new Device("ACER", "laptop", 100, 200);
		Device d2 = new Device("ACER", "laptop", 100, 200);
		Device d3 = new Device("ACER", "laptop", 100, 200);

		assertTrue(d1.equals(d2));
		assertTrue(d2.equals(d3));
		assertTrue(d1.equals(d3));
		
		

	}

	@Test
	public void testEquals_Consistent() {
		Device d1 = new Device("ACER", "laptop", 100, 200);
		Device d2 = new Device("ACER", "laptop", 100, 200);

		assertTrue(d1.equals(d2));
		assertTrue(d1.equals(d2));

	}

	@Test
	public void testEquals_WhenDevicesAreDifferent() {
		Device d1 = new Device("ACER", "laptop", 100, 200);
		Device d2 = new Device("SANSUNG", "laptop", 100, 200);
		
		assertFalse(d1.equals(d2));

	}
	
	 @Test
	 public void testEquals_WhenNull() {
	
	 assertFalse(new Device("ACER", "laptop", 100, 200).equals(null));
	
	 }
	
	 @Test
	 public void testHashCode_HashCodeShouldBeEqual() {
		 Device d1 = new Device("ACER", "laptop", 100, 200);
		 Device d2 = new Device("ACER", "laptop", 100, 200);
	 // TODO Tudor add
	 // asert false d1.hashCode() == d1.hashCode()
	 assertTrue(d1.hashCode() == d2.hashCode());
	
	 }
	 
	 @Test
	 public void testHashCode_SameDeviceDifferentHashCode()
	 {
		 Device d1 = new Device("ACER", "laptop", 100, 200);
		 assertTrue(d1.hashCode()==d1.hashCode());
	 }

}
