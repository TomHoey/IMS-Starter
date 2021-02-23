package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {
	
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("oid");
		String productName = resultSet.getString("productName");
		Long quantity = resultSet.getLong("quantity");
		Double total = resultSet.getDouble("total");
		return new Orders(oid, productName, quantity, total);
	}

	@Override
	public List<Orders> readAll() {
		try { Connection connection = DBUtils.getInstance().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from Orders");
		{
			List <Orders> orders = new ArrayList<>();
		while (resultSet.next()) {
			orders.add(modelFromResultSet(resultSet));
		}
		return orders;
		}
		}catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}


	@Override
	public Orders read(Long oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE oid = ?");) {
			statement.setLong(1, oid);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders orders) {
		return null;
	}

	@Override
	public Orders update(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
