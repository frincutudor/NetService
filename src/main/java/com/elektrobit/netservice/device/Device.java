package com.elektrobit.netservice.device;

import java.util.Objects;
import java.util.UUID;

import org.springframework.hateoas.ResourceSupport;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         Device class used by DeviceRepositoryImpl
 */

public class Device extends ResourceSupport{

	private UUID deviceid;
	private String name;
	private String alias;
	private int quantity;
	private int price;
	private UUID categoryid;

	public Device() {

	}

	public Device(String name, String alias, int quantity, int price) {
		this.alias = alias;
		this.name = name;
		this.quantity = quantity;
		this.price = price;

	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(UUID categoryid) {
		this.categoryid = categoryid;
	}



	public UUID getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(UUID deviceid) {
		this.deviceid = deviceid;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAlias() {
		return alias;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
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
