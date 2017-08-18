package com.elektrobit.netservice.device;

import java.util.UUID;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DeviceCategory extends ResourceSupport{

	private String categoryName;
	private String subCategoryName;
	private UUID idCategory;
	
	
	
	public UUID getIdCategory() {
		return idCategory;
	}
	@JsonCreator
	public void setIdCategory(UUID idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}
	@JsonCreator
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}
	@JsonCreator
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" +this.idCategory + this.categoryName + this.subCategoryName + "]";
	}
}
