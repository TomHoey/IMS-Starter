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

	public Orders ModelFromResultSet(ResultSet resultSet) throws SQLException {
		Long oid = resultSet.getLong("oid");
		Long fk_cid = resultSet.getLong("fk_cid");
		return new Orders(oid, fk_cid);

	}

	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long fk_oid = resultSet.getLong("fk_oid");
		Long pid = resultSet.getLong("pid");
		Long quantity = resultSet.getLong("quantity");
		return new Orders(fk_oid, pid, quantity);

	}

	// Reads all orders to the console.
	@Override
	public List<Orders> readAll() {
		try {
			Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders");
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(ModelFromResultSet(resultSet));
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
				ResultSet resultSet = statement.executeQuery("Select * FROM Orders ORDER BY oid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
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
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM transactions WHERE fk_oid = ?");) {
			statement.setLong(1, fk_oid);
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
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders (fk_cid) VALUES (?)");) {
			statement.setLong(1, orders.getFk_cid());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	// TODO This doesn't work.
	public Orders addItems(Orders items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Transactions (fk_oid, pid, quantity) VALUES (?, ?)");) {
			statement.setLong(1, items.getFk_oid());
			statement.setLong(2, items.getPid());
			statement.setLong(3, items.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	// This doesn't work.
	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Orders SET pid = ?, quantity = ? WHERE fk_cid = ?");) {
			statement.setLong(1, orders.getOid());
			statement.setLong(2, orders.getPid());
			statement.setLong(3, orders.getQuantity());
			statement.executeUpdate();
			return read(orders.getOid());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e);
		}
		return null;
	}

	// This doesn't work.
	@Override
	public int delete(long pid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM Transactions WHERE items.pid = ?");) {
			statement.setLong(1, pid);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
