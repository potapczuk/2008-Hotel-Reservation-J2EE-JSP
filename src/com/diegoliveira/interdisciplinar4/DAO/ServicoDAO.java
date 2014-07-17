package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diegoliveira.interdisciplinar4.DO.ServicoDO;

public class ServicoDAO extends AbstractDAO {
	private static final String SALVA_SQL = "INSERT INTO servico "
			+ "(nomeServico, valorServico) "
			+ "VALUES (?,?)";

	private static final String REMOVEBYID_SQL = "DELETE FROM servico "
			+ "WHERE codServico = ?";

	private static final String PROCURABYID_SQL = "SELECT * FROM servico WHERE codServico = ?";
	
	private static final String PROCURABYHOSPEDAGEM_SQL = "SELECT * FROM servico WHERE codHospedagem = ?";

	private static final String ATUALIZA_SQL = "UPDATE servico "
			+ "SET nomeServico=?, valorServico=? WHERE codServico = ?";

	private static final String GETLISTA_SQL = "SELECT * FROM servico";

	private static final String GETLISTAPAGINADA_SQL = "SELECT * FROM servico LIMIT ?,?";

	public void salva(ServicoDO servico) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				SALVA_SQL);

		stmt.setString(1, servico.getNomeServico());
		stmt.setDouble(2, servico.getValorServico());

		stmt.execute();

		stmt.close();
	}

	public void atualiza(ServicoDO servico) throws SQLException {
		if (servico.getCodServico() < 0) {
			// TODO Reportar erro
			return;
		}
		PreparedStatement stmt = this.getConnection().prepareStatement(
				ATUALIZA_SQL);

		stmt.setString(1, servico.getNomeServico());
		stmt.setDouble(2, servico.getValorServico());
		stmt.setInt(3, servico.getCodServico());

		stmt.execute();
		stmt.close();
	}

	public void remove(ServicoDO servico) throws SQLException {
		removeById(servico.getCodServico());
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

	public List<ServicoDO> procura(ServicoDO servico) throws SQLException {
		if (servico != null) {
			if (servico.getCodServico() >= 0) {
				List<ServicoDO> lista = new ArrayList<ServicoDO>();
				lista.add(procuraById(servico.getCodServico()));
				return lista;
			}
		}
		return null;
	}

	public ServicoDO procuraById(int id) throws SQLException {
		if (id < 0)
			return null;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYID_SQL);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		ServicoDO servico = null;

		if (rs.next()) {
			servico = criaServico(rs);
		}

		rs.close();
		stmt.close();

		return servico;
	}
	
	public ArrayList<ServicoDO> procuraByHospedagem(int id) throws SQLException {
		if (id < 0)
			return null;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYHOSPEDAGEM_SQL);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		ServicoDO servico = null;
		ArrayList<ServicoDO> lista = new ArrayList<ServicoDO>();

		while(rs.next()) {
			servico = criaServico(rs);
			lista.add(servico);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<ServicoDO> getLista() throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTA_SQL);

		ResultSet rs = stmt.executeQuery();

		List<ServicoDO> lista = new ArrayList<ServicoDO>();

		while (rs.next()) {
			ServicoDO servico = criaServico(rs);

			lista.add(servico);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<ServicoDO> getListaPaginada(int inicio, int quantidade)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTAPAGINADA_SQL);

		stmt.setInt(1, inicio);
		stmt.setInt(2, quantidade);

		ResultSet rs = stmt.executeQuery();

		List<ServicoDO> lista = new ArrayList<ServicoDO>();

		while (rs.next()) {
			ServicoDO servico = criaServico(rs);

			lista.add(servico);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public int getLastID() throws SQLException {
		return getLastID("servico");
	}

	public int count() throws SQLException {
		return count("servico");
	}

	private ServicoDO criaServico(ResultSet rs) throws SQLException {
		ServicoDO servico = new ServicoDO();
		servico.setNomeServico(rs.getString("nomeServico"));
		servico.setValorServico(rs.getDouble("valorServico"));
		servico.setCodServico(rs.getInt("codServico"));
		return servico;
	}
}