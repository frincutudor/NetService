package com.elektrobit.netservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.elektrobit.netservice.device.Device;
import com.elektrobit.netservice.device.DeviceCategory;

/**
 * @Author Frincu Tudor <Tudor.Frincu@elektrobit.com>
 * 
 *         This class stores the Device type objects and returns the Set of
 *         Devices when called
 * 
 */

@Repository
public class DeviceRepositoryImpl implements DeviceRepository {

	private final JdbcTemplate jdbcTemplate;

	public DeviceRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate,
				"The given jdbcTemplate is not allowed to be null.");
	}

	public void addNewDevice(Device device) {

		String sql = "INSERT INTO devicestore (id,name, alias, price, quantity,categoryid)"
				+ " VALUES (?,?,?,?,?,?)";

		jdbcTemplate.update(sql, UUID.randomUUID().toString(), device.getName(), device.getAlias(), device
				.getPrice(), device.getQuantity(), device.getCategoryid()
				.toString());

	}

	public void editDeviceImpl(Device device) {
		String sql = "UPDATE devicestore SET  price=?, "
				+ "quantity=? WHERE id=?";
		jdbcTemplate.update(sql, device.getPrice(), device.getQuantity(),
				device.getId().toString());

	}

	public void delete(String name) {
		String sql = "DELETE FROM devicestore WHERE name=?";
		jdbcTemplate.update(sql, name);
	}

	public List<Device> list() {
		String sql = "SELECT * FROM devicestore";
		List<Device> listDevice = jdbcTemplate.query(sql,
				new RowMapper<Device>() {

					public Device mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Device device = new Device();

						device.setDeviceid(UUID.fromString(rs.getString("id")));
						device.setName(rs.getString("name"));
						device.setAlias(rs.getString("alias"));

						device.setPrice(rs.getInt("price"));
						device.setQuantity(rs.getInt("quantity"));
						device.setCategoryid(UUID.fromString(rs
								.getString("categoryid")));
						return device;
					}

				});

		return listDevice;
	}

	public List<Device> listCategory(UUID category) {


		String sql= "SELECT * FROM devicestore WHERE categoryid=\'" + category.toString() + "\'";
		System.out.println(sql);
		
		List<Device> listDevice = jdbcTemplate.query(sql,
				new RowMapper<Device>() {

					public Device mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Device device = new Device();

						device.setName(rs.getString("name"));
						device.setPrice(rs.getInt("price"));
						device.setQuantity(rs.getInt("quantity"));
						device.setCategoryid(UUID.fromString(rs.getString("categoryid")));
						return device;
					}

				});

		return listDevice;
	}

	public List<DeviceCategory> getCategories() {
		String sql = "SELECT * FROM devicecategory ";
		List<DeviceCategory> devCateg = jdbcTemplate.query(sql,
				new RowMapper<DeviceCategory>() {

					public DeviceCategory mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						DeviceCategory device = new DeviceCategory();

						device.setCategoryName(rs.getString("categoryname"));
						device.setSubCategoryName(rs.getString("subcategory"));
						device.setIdCategory(UUID.fromString(rs
								.getString("idcategory")));

						return device;
					}

				});
		return devCateg;
	}

	public void addCategory(DeviceCategory devCategory) {
		String sql = "INSERT INTO devicecategory (idcategory,categoryname,subcategory)"
				+ " VALUES (?,?,?)";
		jdbcTemplate
				.update(sql, UUID.randomUUID().toString(),
						devCategory.getCategoryName(),
						devCategory.getSubCategoryName());
	}

}
