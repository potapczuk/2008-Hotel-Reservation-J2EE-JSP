package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChaleItemDAO extends AbstractDAO {
	private static final String SALVA_SQL = "INSERT INTO chale_item "
			+ "(codChale, codItem) "
			+ "VALUES (?,?)";

	private static final String REMOVEBYCHALE_SQL = "DELETE FROM chale_item "
			+ "WHERE codChale = ?";

	private static final String COUNT_SQL_HS = "SELECT count(*) as c FROM chale_item WHERE codChale = ?";

	public void salva(int codChale, int codItem) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				SALVA_SQL);

		stmt.setInt(1, codChale);
		stmt.setInt(2, codItem);

		stmt.execute();

		stmt.close();
	}

	public void removeByChale(int codChale) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				REMOVEBYCHALE_SQL);

		stmt.setInt(1, codChale);

		stmt.execute();
		stmt.close();
	}

	public int getLastID() throws SQLException {
		return getLastID("chale_item");
	}

	public int count() throws SQLException {
		return count("chale_item");
	}

	public int count(String tabela, int codHospedagem) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				COUNT_SQL_HS);

		stmt.setInt(1, codHospedagem);

		ResultSet rs = stmt.executeQuery();

		rs.next();

		return rs.getInt("c");
	}
}