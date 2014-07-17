package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diegoliveira.interdisciplinar4.ConnectionFactory;

public class AbstractDAO {
	private static final String COUNT_SQL = "SELECT count(*) as c FROM ";
	private static final String GETLASTID_SQL = "SELECT DISTINCT last_insert_id() last FROM ";
	private Connection connection;

	public AbstractDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public int getLastID(String tabela) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement(GETLASTID_SQL
				+ tabela);

		ResultSet rs = stmt.executeQuery();

		rs.next();

		return rs.getInt("last");
	}

	public int count(String tabela) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement(COUNT_SQL
				+ tabela);

		ResultSet rs = stmt.executeQuery();

		rs.next();

		return rs.getInt("c");
	}
}
