package com.elektrobit.netservice.device;

import java.util.Objects;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Device class used by DeviceRepositoryImpl
 */

// TODO Tudor why this is in Dao package ? - moved it to a different package -
// DONE
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
		return "[" + this.name + "]";
	}

}
