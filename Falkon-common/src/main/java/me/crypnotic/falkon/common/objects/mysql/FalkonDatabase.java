package me.crypnotic.falkon.common.objects.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.zaxxer.hikari.HikariDataSource;

public class FalkonDatabase {

	private HikariDataSource source;

	public FalkonDatabase() {
		source.setJdbcUrl("Not finished");
		source.setUsername("with this");
		source.setPassword("constructor.");
	}

	private void getConnection(FalkonCallback<Optional<Connection>> callback) {
		Connection connection = null;
		try {
			if (source == null || source.isClosed()) {
				callback.call(Optional.empty());
			}
			connection = source.getConnection();
			callback.call(Optional.of(connection));
		} catch (SQLException exception) {
			exception.printStackTrace();
			callback.call(Optional.empty());
		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
	}

	private void getStatement(FalkonCallback<Optional<PreparedStatement>> callback, FalkonQuery query) {
		getConnection((optional) -> {
			if (optional.isPresent()) {
				Connection connection = optional.get();
				PreparedStatement statement = null;
				try {
					statement = connection.prepareStatement(query.getQuery());
					if (statement == null || statement.isClosed()) {
						callback.call(Optional.empty());
					}
					for (int i = 0; i < query.getValues().length; i++) {
						statement.setObject(i + 1, query.getValues()[i]);
					}
					callback.call(Optional.of(statement));
				} catch (SQLException exception) {
					exception.printStackTrace();
					callback.call(Optional.empty());
				} finally {
					try {
						if (statement != null && !statement.isClosed()) {
							statement.close();
						}
					} catch (SQLException exception) {
						exception.printStackTrace();
					}
				}
			} else {
				callback.call(Optional.empty());
			}
		});
	}

	public void update(FalkonCallback<Optional<Integer>> callback, FalkonQuery query) {
		getStatement((optional) -> {
			if (optional.isPresent()) {
				PreparedStatement statement = optional.get();
				try {
					callback.call(Optional.of(statement.executeUpdate()));
				} catch (Exception exception) {
					exception.printStackTrace();
					callback.call(Optional.empty());
				}
			} else {
				callback.call(Optional.empty());
			}
		}, query);
	}

	public void query(FalkonCallback<Optional<ResultSet>> callback, FalkonQuery query) {
		getStatement((optional) -> {
			if (optional.isPresent()) {
				PreparedStatement statement = optional.get();
				ResultSet result = null;
				try {
					result = statement.executeQuery();
					callback.call(Optional.of(result));
				} catch (Exception exception) {
					exception.printStackTrace();
					callback.call(Optional.empty());
				} finally {
					try {
						if (result != null && !result.isClosed()) {
							result.close();
						}
					} catch (SQLException exception) {
						exception.printStackTrace();
					}
				}
			} else {
				callback.call(Optional.empty());
			}
		}, query);
	}
}
