package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("oid");
		Long fk_cid = resultSet.getLong("fk_cid");
		return new Orders(oid, fk_cid);

	}

	public Orders BigBigModelFromResultSet(ResultSet resultSet, Orders orders) throws SQLException {
		Long fk_oid = resultSet.getLong("fk_oid");
		Long pid = resultSet.getLong("pid");
		Long quantity = resultSet.getLong("quantity");
		Double totalPrice = resultSet.getDouble("Total_Price");
		orders.getPid().add(pid);
		orders.getQuantity().add(quantity);
		orders.getTotalPrice().add(totalPrice);
		orders.setFk_oid(fk_oid);
		return orders;

	}

	// Reads all orders to the console.
	@Override
	public List<Orders> readAll() {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("Select * FROM orders ORDER BY oid DESC LIMIT 1");) {
			Orders order = new Orders(); 
			while(resultSet.next()) {
				order = modelFromResultSet(resultSet);
			}
			return order;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// Reads one order within a table.

	@Override
	public Orders read(Long fk_oid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT transactions.fk_oid, transactions.pid, transactions.quantity, (transactions.quantity * items.price) as Total_Price from transactions, orders, items where transactions.pid = items.pid and transactions.fk_oid = ?;");) {
			statement.setLong(1, fk_oid);
			try (ResultSet resultSet = statement.executeQuery();) {
				Orders order = new Orders(); 
				while(resultSet.next()) {
					BigBigModelFromResultSet(resultSet, order);
				}	
				return order;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (fk_cid) VALUES (?)");) {
			statement.setLong(1, orders.getFk_cid());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	public Orders addItems(Orders items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Transactions (fk_oid, pid, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, items.getFk_oid());
			statement.setLong(2, items.getPid().get(0));
			statement.setLong(3, items.getQuantity().get(0));
			statement.executeUpdate();
			return read(1L);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO transactions (fk_oid, pid, quantity) VALUES (?,?,?)");) {
			statement.setLong(1, orders.getOid());
			statement.setLong(2, orders.getPid().get(0));
			statement.setLong(3, orders.getQuantity().get(0));
			statement.executeUpdate();
			return read(orders.getOid());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e);
		}
		return null;
	}

	
	@Override
	public int delete(long pid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM transactions WHERE transactions.pid = ?");) {
			statement.setLong(1, pid);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
