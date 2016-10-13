package com.elektrobit.netservice.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import com.elektrobit.netservice.dao.Device;

public class TestDevice {

	@Test
	public void testConstructor() {
		Device d = new Device("test");

		assertEquals("test", d.getName());

	}

	@Test
	public void testEquals_Reflexiv() {
		Device d1 = new Device("leptop");
		assertTrue(d1.equals(d1));

	}

	@Test
	public void testEquals_Simetric() {
		Device d1 = new Device("leptop");
		Device d2 = new Device("leptop");
		// TODO Tudor 
		// asert true d1 eq d2
		// asert true d2 eq d1
		assertTrue(d1.equals(d2) == d2.equals(d1));

	}

	@Test
	public void testEquals_Transitive() {
		Device d1 = new Device("leptop");
		Device d2 = new Device("leptop");
		Device d3 = new Device("leptop");
		// TODO Tudor 
        // asert true d1 eq d2
		// asert true d2 eq d3
		// asert true d1 eq d3
		
		assertTrue(d1.equals(d2) == d2.equals(d3));

	}

	@Test
	public void testEquals_Consistent() {
		Device d1 = new Device("leptop");
		Device d2 = new Device("leptop");
		// TODO Tudor 
        // asert true d1 eq d2
		// asert true d1 eq d2
		assertTrue(d1.equals(d2) == d1.equals(d2));

	}

	@Test
	public void testEquals_WhenDevicesAreDifferent() {
		Device d1 = new Device("leptop");
		Device d2 = new Device("computer");
		
		// TODO Tudor 
        // asert false d1 eq d2
		assertTrue(d1.equals(d2) == false);

	}

	@Test
	public void testEquals_WhenNull() {

		assertFalse(new Device("leptop").equals(null));

	}

	@Test
	public void testHashCode_HashCodeShouldBeEqual() {
		Device d1 = new Device("Calculator");
		Device d2 = new Device("Calculator");
		// TODO Tudor add
        // asert false d1.hashCode() == d1.hashCode()
		assertTrue(d1.hashCode() == d2.hashCode());

	}

}
