package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;

public class HospedagemDAO extends AbstractDAO {
	private static final String SALVA_SQL = "INSERT INTO hospedagem "
			+ "(codCliente, codChale, estado, dataInicio, "
			+ "dataFim, qtdPessoas, desconto, valorFinal, " + "diaria) "
			+ "VALUES (?,?,?,?,?,?,?,?,?)";

	private static final String REMOVEBYID_SQL = "DELETE FROM hospedagem "
			+ "WHERE codHospedagem = ?";

	private static final String PROCURABYID_SQL = "SELECT * FROM hospedagem WHERE codHospedagem = ?";

	private static final String ATUALIZA_SQL = "UPDATE hospedagem "
			+ "SET codCliente=?, codChale=?, estado=?, dataInicio=?, dataFim=?, "
			+ "qtdPessoas=?, desconto=?, valorFinal=?, diaria=? "
			+ "WHERE codHospedagem = ?";

	private static final String GETLISTA_SQL = "SELECT * FROM hospedagem "
			+ "ORDER BY dataInicio DESC, estado, codHospedagem";

	private static final String GETLISTAPAGINADA_SQL = "SELECT * FROM hospedagem "
			+ "ORDER BY dataInicio DESC, estado, codHospedagem LIMIT ?,?";

	private static final String CHECADATADAHOSPEDAGEM = "SELECT count(*) c FROM hospedagem "
			+ "WHERE (dataInicio <= ?) AND (dataFim >= ?) AND codChale = ?";
	
	private static final String CHECADATADAHOSPEDAGEMEXISTENTE = "SELECT count(*) c FROM hospedagem "
		+ "WHERE (dataInicio <= ?) AND (dataFim >= ?) AND codChale = ? AND codHospedagem != ?";
	
	/*private static final String CHECADATADAHOSPEDAGEM = "SELECT count(*) c FROM hospedagem "
		+ "WHERE ((dataInicio BETWEEN ? AND ?) OR (dataFim BETWEEN ? AND ?) OR "
		+ "(dataInicio <= ? AND dataFim >= ?)) AND codChale = ?";*/

	public void salva(HospedagemDO hospedagem) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				SALVA_SQL);

		stmt.setInt(1, hospedagem.getCodCliente());
		stmt.setInt(2, hospedagem.getCodChale());
		stmt.setInt(3, hospedagem.getEstado());
		stmt.setTimestamp(4,
				new Timestamp(hospedagem.getDataInicio().getTime()));
		stmt.setTimestamp(5, new Timestamp(hospedagem.getDataFim().getTime()));
		stmt.setInt(6, hospedagem.getQtdPessoas());
		stmt.setDouble(7, hospedagem.getDesconto());
		stmt.setDouble(8, hospedagem.getValorFinal());
		stmt.setDouble(9, hospedagem.getDiaria());

		stmt.execute();

		stmt.close();
	}

	public void atualiza(HospedagemDO hospedagem) throws SQLException {
		if (hospedagem.getCodHospedagem() < 0) {
			// TODO Reportar erro
			return;
		}
		PreparedStatement stmt = this.getConnection().prepareStatement(
				ATUALIZA_SQL);

		stmt.setInt(1, hospedagem.getCodCliente());
		stmt.setInt(2, hospedagem.getCodChale());
		stmt.setInt(3, hospedagem.getEstado());
		stmt.setTimestamp(4,
				new Timestamp(hospedagem.getDataInicio().getTime()));
		stmt.setTimestamp(5, new Timestamp(hospedagem.getDataFim().getTime()));
		stmt.setInt(6, hospedagem.getQtdPessoas());
		stmt.setDouble(7, hospedagem.getDesconto());
		stmt.setDouble(8, hospedagem.getValorFinal());
		stmt.setDouble(9, hospedagem.getDiaria());
		stmt.setLong(10, hospedagem.getCodHospedagem());

		stmt.execute();
		stmt.close();
	}

	public void remove(HospedagemDO hospedagem) throws SQLException {
		removeById(hospedagem.getCodHospedagem());
	}

	public void removeById(int id) throws SQLException {
		if (id < 0)
			return;
		// TODO remover as hospedagens servicos

		PreparedStatement stmt = this.getConnection().prepareStatement(
				REMOVEBYID_SQL);

		stmt.setLong(1, id);

		stmt.execute();
		stmt.close();
	}

	public List<HospedagemDO> procura(HospedagemDO hospedagem)
			throws SQLException {
		if (hospedagem != null) {
			if (hospedagem.getCodHospedagem() >= 0) {
				List<HospedagemDO> lista = new ArrayList<HospedagemDO>();
				lista.add(procuraById(hospedagem.getCodHospedagem()));
				return lista;
			}
		}
		return null;
	}

	public HospedagemDO procuraById(int id) throws SQLException {
		if (id < 0)
			return null;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYID_SQL);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		HospedagemDO hospedagem = null;

		if (rs.next()) {
			hospedagem = criaHospedagem(rs);
		}

		rs.close();
		stmt.close();

		return hospedagem;
	}

	public List<HospedagemDO> getLista() throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTA_SQL);

		ResultSet rs = stmt.executeQuery();

		List<HospedagemDO> lista = new ArrayList<HospedagemDO>();

		while (rs.next()) {
			HospedagemDO hospedagem = criaHospedagem(rs);

			lista.add(hospedagem);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<HospedagemDO> getListaPaginada(int inicio, int quantidade)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTAPAGINADA_SQL);

		stmt.setInt(1, inicio);
		stmt.setInt(2, quantidade);

		ResultSet rs = stmt.executeQuery();

		List<HospedagemDO> lista = new ArrayList<HospedagemDO>();

		while (rs.next()) {
			HospedagemDO hospedagem = criaHospedagem(rs);

			lista.add(hospedagem);
		}

		rs.close();
		stmt.close();

		return lista;
	}
	
	public boolean dataInvalida(Date dataInicio, Date dataFim, int codChale) throws SQLException{
		PreparedStatement stmt = this.getConnection().prepareStatement(
				CHECADATADAHOSPEDAGEM);

		stmt.setTimestamp(1, new Timestamp(dataFim.getTime()));
		stmt.setTimestamp(2, new Timestamp(dataInicio.getTime()));
		stmt.setInt(3, codChale);

		ResultSet rs = stmt.executeQuery();
		
		rs.next();
		int c = rs.getInt("c");

		if(c > 0)
			return true;
		
		return false;
	}
	
	public boolean dataInvalidaExistente(Date dataInicio, Date dataFim, int codChale, int codHospedagem) throws SQLException{
		PreparedStatement stmt = this.getConnection().prepareStatement(
				CHECADATADAHOSPEDAGEMEXISTENTE);

		stmt.setTimestamp(1, new Timestamp(dataFim.getTime()));
		stmt.setTimestamp(2, new Timestamp(dataInicio.getTime()));
		stmt.setInt(3, codChale);
		stmt.setInt(4, codHospedagem);

		ResultSet rs = stmt.executeQuery();
		
		rs.next();
		int c = rs.getInt("c");

		if(c > 0)
			return true;
		
		return false;
	}

	public int getLastID() throws SQLException {
		return getLastID("hospedagem");
	}

	public int count() throws SQLException {
		return count("hospedagem");
	}

	private HospedagemDO criaHospedagem(ResultSet rs) throws SQLException {
		HospedagemDO hospedagem = new HospedagemDO();
		hospedagem.setCodCliente(rs.getInt("codCliente"));
		hospedagem.setCodChale(rs.getInt("codChale"));
		hospedagem.setEstado(rs.getInt("estado"));
		hospedagem.setDataInicio(rs.getDate("dataInicio"));
		hospedagem.setDataFim(rs.getDate("dataFim"));
		hospedagem.setQtdPessoas(rs.getInt("qtdPessoas"));
		hospedagem.setDesconto(rs.getInt("desconto"));
		hospedagem.setValorFinal(rs.getDouble("valorFinal"));
		hospedagem.setDiaria(rs.getDouble("diaria"));
		hospedagem.setCodHospedagem(rs.getInt("codHospedagem"));
		return hospedagem;
	}

	public ArrayList<Estado> getEstados() {
		ArrayList<Estado> estados = new ArrayList<Estado>();

		Estado estado1 = new Estado();
		Estado estado2 = new Estado();

		estado1.setTipo("Reserva");
		estado2.setTipo("Ativa");

		estado1.setId(HospedagemDO.RESERVA);
		estado2.setId(HospedagemDO.ATIVA);

		estados.add(estado1);
		estados.add(estado2);

		return estados;
	}

	public class Estado {
		private String tipo;
		private int id;

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
}