package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public abstract class ItemsDAO implements Dao<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long pid = resultSet.getLong("pid");
		String productName = resultSet.getString("productName");
		Float price = resultSet.getFloat("price");
		return new Items(pid, productName, price);
	}

	@Override 
		public List<Items> readAll() {
		try {Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Items"); {
		
		List<Items> Items = new ArrayList<>();
		while (resultSet.next()) {
			Items.add(modelFromResultSet(resultSet));
		
		}
			
			return Items;
			
			}
			
		} catch (SQLException e) {
				LOGGER.debug (e);
				LOGGER.error(e.getMessage());
			}
		
		return new ArrayList<>();
	
}
}