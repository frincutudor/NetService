package com.elektrobit.netservice.dao;

import java.util.Objects;

// TODO Tudor why this is in Dao package ?
public final class Device {

	private final String name;

	public Device(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Device) {
			Device other = (Device) obj;

			return Objects.equals(name, other.name);
		}

		return false;
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+this.name +"]";
	}
	
	

}
