package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.diegoliveira.interdisciplinar4.DO.HospedagemServicoDO;

public class HospedagemServicoDAO extends AbstractDAO {
	private static final String SALVA_SQL = "INSERT INTO hospedagem_servico "
			+ "(codHospedagem, codServico, valorServico, dataServico) "
			+ "VALUES (?,?,?,?)";

	private static final String REMOVEBYID_SQL = "DELETE FROM hospedagem_servico "
			+ "WHERE codHospedagemServico = ?";

	// private static final String PROCURABYID_SQL = "SELECT * FROM
	// hospedagem_servico "
	// + "WHERE codHospedagem = ? AND codServico = ? AND dataServico = ?";

	private static final String ATUALIZA_SQL = "UPDATE hospedagem_servico "
			+ "SET codHospedagem=?, codServico=?, valorServico=?, dataServico=?"
			+ "WHERE codHospedagemServico = ?";
	
	private static final String PROCURABYHOSPEDAGEM_SQL = "SELECT * FROM hospedagem_servico WHERE codHospedagem = ?";

	private static final String GETLISTA_SQL = "SELECT * FROM hospedagem_servico "
			+ " WHERE codHospedagem = ? ORDER BY dataServico DESC";
	
	private static final String GETLISTAPAGINADA_SQL = "SELECT * FROM hospedagem_servico "
			+ "WHERE codHospedagem = ? ORDER BY dataServico DESC LIMIT ?,?";

	private static final String COUNT_SQL_HS = "SELECT count(*) as c FROM hospedagem_servico WHERE codHospedagem = ?";

	public void salva(HospedagemServicoDO hospedagem) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				SALVA_SQL);

		stmt.setInt(1, hospedagem.getCodHospedagem());
		stmt.setInt(2, hospedagem.getCodServico());
		stmt.setDouble(3, hospedagem.getValorServico());
		stmt.setTimestamp(4, new Timestamp(hospedagem.getDataServico()
				.getTime()));

		stmt.execute();

		stmt.close();
	}

	public void atualiza(HospedagemServicoDO hospedagem) throws SQLException {
		if (hospedagem.getCodHospedagem() < 0 || hospedagem.getCodServico() < 0) {
			// TODO Reportar erro
			return;
		}
		PreparedStatement stmt = this.getConnection().prepareStatement(
				ATUALIZA_SQL);

		stmt.setInt(1, hospedagem.getCodHospedagem());
		stmt.setInt(2, hospedagem.getCodServico());
		stmt.setDouble(3, hospedagem.getValorServico());
		stmt.setDate(4, new Date(hospedagem.getDataServico().getTime()));
		stmt.setInt(5, hospedagem.getCodHospedagemServico());

		stmt.execute();
		stmt.close();
	}

	public void remove(HospedagemServicoDO hospedagem) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				REMOVEBYID_SQL);

		stmt.setInt(1, hospedagem.getCodHospedagemServico());

		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<HospedagemServicoDO> procuraByHospedagem(int codHospedagem) throws SQLException {
		if (codHospedagem < 0)
			return null;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYHOSPEDAGEM_SQL);

		stmt.setInt(1, codHospedagem);

		ResultSet rs = stmt.executeQuery();

		HospedagemServicoDO servico = null;
		ArrayList<HospedagemServicoDO> lista = new ArrayList<HospedagemServicoDO>();

		while(rs.next()) {
			servico = criaHospedagem(rs);
			lista.add(servico);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<HospedagemServicoDO> getLista(int codHospedagem)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTA_SQL);

		stmt.setLong(1, codHospedagem);

		ResultSet rs = stmt.executeQuery();

		List<HospedagemServicoDO> lista = new ArrayList<HospedagemServicoDO>();

		while (rs.next()) {
			HospedagemServicoDO hospedagem = criaHospedagem(rs);

			lista.add(hospedagem);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<HospedagemServicoDO> getListaPaginada(int codHospedagem, int inicio, int quantidade)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTAPAGINADA_SQL);

		stmt.setLong(1, codHospedagem);
		stmt.setInt(2, inicio);
		stmt.setInt(3, quantidade);

		ResultSet rs = stmt.executeQuery();

		List<HospedagemServicoDO> lista = new ArrayList<HospedagemServicoDO>();

		while (rs.next()) {
			HospedagemServicoDO hospedagem = criaHospedagem(rs);

			lista.add(hospedagem);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public int getLastID() throws SQLException {
		return getLastID("hospedagem_servico");
	}

	public int count() throws SQLException {
		return count("hospedagem_servico");
	}

	private HospedagemServicoDO criaHospedagem(ResultSet rs)
			throws SQLException {
		HospedagemServicoDO hospedagem = new HospedagemServicoDO();
		hospedagem.setCodHospedagem(rs.getInt("codHospedagem"));
		hospedagem.setCodServico(rs.getInt("codServico"));
		hospedagem.setValorServico(rs.getDouble("valorServico"));
		hospedagem.setDataServico(rs.getTimestamp("dataServico"));

		return hospedagem;
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