package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diegoliveira.interdisciplinar4.DO.ChaleDO;

public class ChaleDAO extends AbstractDAO {
	private static final String SALVA_SQL = "INSERT INTO chale "
			+ "(localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) "
			+ "VALUES (?,?,?,?)";

	private static final String REMOVEBYID_SQL = "DELETE FROM chale "
			+ "WHERE codChale = ?";

	private static final String PROCURABYNOME_SQL = "SELECT * FROM chale WHERE nomeChale LIKE ?";

	private static final String PROCURABYID_SQL = "SELECT * FROM chale WHERE codChale = ?";

	private static final String ATUALIZA_SQL = "UPDATE chale "
			+ "SET localizacao=?, capacidade=?, valorAltaEstacao=?, valorBaixaEstacao=? WHERE codChale = ?";

	private static final String GETLISTA_SQL = "SELECT * FROM chale";

	private static final String GETLISTAPAGINADA_SQL = "SELECT * FROM chale LIMIT ?,?";

	public void salva(ChaleDO chale) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				SALVA_SQL);

		stmt.setString(1, chale.getLocalizacao());
		stmt.setInt(2, chale.getCapacidade());
		stmt.setDouble(3, chale.getValorAltaEstacao());
		stmt.setDouble(4, chale.getValorBaixaEstacao());

		stmt.execute();

		stmt.close();
	}

	public void atualiza(ChaleDO chale) throws SQLException {
		if (chale.getCodChale() < 0) {
			// TODO Reportar erro
			return;
		}
		PreparedStatement stmt = this.getConnection().prepareStatement(
				ATUALIZA_SQL);

		stmt.setString(1, chale.getLocalizacao());
		stmt.setInt(2, chale.getCapacidade());
		stmt.setDouble(3, chale.getValorAltaEstacao());
		stmt.setDouble(4, chale.getValorBaixaEstacao());
		stmt.setInt(5, chale.getCodChale());

		stmt.execute();
		stmt.close();
	}

	public void remove(ChaleDO chale) throws SQLException {
		removeById(chale.getCodChale());
	}

	public void removeById(int id) throws SQLException {
		if (id < 0)
			return;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				REMOVEBYID_SQL);

		stmt.setLong(1, id);

		stmt.execute();
		stmt.close();
	}

	public List<ChaleDO> procura(ChaleDO chale) throws SQLException {
		if (chale != null) {
			if (chale.getCodChale() >= 0) {
				List<ChaleDO> lista = new ArrayList<ChaleDO>();
				lista.add(procuraById(chale.getCodChale()));
				return lista;
			}
		}
		return null;
	}

	public ChaleDO procuraById(int id) throws SQLException {
		if (id < 0)
			return null;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYID_SQL);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		ChaleDO chale = null;

		if (rs.next()) {
			chale = criaChale(rs);
		}

		rs.close();
		stmt.close();

		return chale;
	}

	public List<ChaleDO> procuraByNome(String nomeChale) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYNOME_SQL);

		stmt.setString(1, "%" + nomeChale + "%");

		ResultSet rs = stmt.executeQuery();

		List<ChaleDO> lista = new ArrayList<ChaleDO>();

		while (rs.next()) {
			ChaleDO chale = criaChale(rs);

			lista.add(chale);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<ChaleDO> getLista() throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTA_SQL);

		ResultSet rs = stmt.executeQuery();

		List<ChaleDO> lista = new ArrayList<ChaleDO>();

		while (rs.next()) {
			ChaleDO chale = criaChale(rs);

			lista.add(chale);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<ChaleDO> getListaPaginada(int inicio, int quantidade)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTAPAGINADA_SQL);

		stmt.setInt(1, inicio);
		stmt.setInt(2, quantidade);

		ResultSet rs = stmt.executeQuery();

		List<ChaleDO> lista = new ArrayList<ChaleDO>();

		while (rs.next()) {
			ChaleDO chale = criaChale(rs);

			lista.add(chale);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public int getLastID() throws SQLException {
		return getLastID("chale");
	}

	public int count() throws SQLException {
		return count("chale");
	}

	private ChaleDO criaChale(ResultSet rs) throws SQLException {
		ChaleDO chale = new ChaleDO();
		chale.setLocalizacao(rs.getString("localizacao"));
		chale.setCapacidade(rs.getInt("capacidade"));
		chale.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
		chale.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
		chale.setCodChale(rs.getInt("codChale"));
		return chale;
	}
}