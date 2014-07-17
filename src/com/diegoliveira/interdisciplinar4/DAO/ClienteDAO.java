package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diegoliveira.interdisciplinar4.DO.ClienteDO;

public class ClienteDAO extends AbstractDAO {
	private static final String SALVA_SQL = "INSERT INTO cliente "
			+ "(nomeCliente, rgCliente, enderecoCliente, bairroCliente, "
			+ "cidadeCliente, estadoCliente, CEPCliente, nascimentoCliente, "
			+ "telefoneResidencial, telefoneComercial, telefoneCelular) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	private static final String REMOVEBYID_SQL = "DELETE FROM cliente "
			+ "WHERE codCliente = ?";

	private static final String PROCURABYNOME_SQL = "SELECT codCliente, nomeCliente, "
			+ "rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, "
			+ "CEPCliente, nascimentoCliente, telefoneResidencial, telefoneComercial, "
			+ "telefoneCelular FROM cliente WHERE nomeCliente LIKE ?";

	private static final String PROCURABYID_SQL = "SELECT codCliente, nomeCliente, "
			+ "rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, "
			+ "CEPCliente, nascimentoCliente, telefoneResidencial, telefoneComercial, "
			+ "telefoneCelular FROM cliente WHERE codCliente = ?";

	private static final String ATUALIZA_SQL = "UPDATE cliente "
			+ "SET nomeCliente=?, rgCliente=?, enderecoCliente=?, bairroCliente=?, cidadeCliente=?, "
			+ "estadoCliente=?, CEPCliente=?, nascimentoCliente=?, telefoneResidencial=?, "
			+ "telefoneComercial=?, telefoneCelular=? WHERE codCliente = ?";

	private static final String GETLISTA_SQL = "SELECT codCliente, nomeCliente, "
			+ "rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, "
			+ "CEPCliente, nascimentoCliente, telefoneResidencial, telefoneComercial, "
			+ "telefoneCelular FROM cliente ORDER BY nomeCliente";

	private static final String GETLISTAPAGINADA_SQL = "SELECT codCliente, nomeCliente, "
			+ "rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, "
			+ "CEPCliente, nascimentoCliente, telefoneResidencial, telefoneComercial, "
			+ "telefoneCelular FROM cliente ORDER BY nomeCliente LIMIT ?,?";

	public void salva(ClienteDO cliente) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				SALVA_SQL);

		stmt.setString(1, cliente.getNomeCliente());
		stmt.setString(2, cliente.getRgCliente());
		stmt.setString(3, cliente.getEnderecoCliente());
		stmt.setString(4, cliente.getBairroCliente());
		stmt.setString(5, cliente.getCidadeCliente());
		stmt.setString(6, cliente.getEstadoCliente());
		stmt.setString(7, cliente.getCEPCliente());
		stmt.setDate(8, new Date(cliente.getNascimentoCliente().getTime()));
		stmt.setString(9, cliente.getTelefoneResidencial());
		stmt.setString(10, cliente.getTelefoneComercial());
		stmt.setString(11, cliente.getTelefoneCelular());

		stmt.execute();

		stmt.close();
	}

	public void atualiza(ClienteDO cliente) throws SQLException {
		if (cliente.getCodCliente() < 0) {
			// TODO Reportar erro
			return;
		}
		PreparedStatement stmt = this.getConnection().prepareStatement(
				ATUALIZA_SQL);

		stmt.setString(1, cliente.getNomeCliente());
		stmt.setString(2, cliente.getRgCliente());
		stmt.setString(3, cliente.getEnderecoCliente());
		stmt.setString(4, cliente.getBairroCliente());
		stmt.setString(5, cliente.getCidadeCliente());
		stmt.setString(6, cliente.getEstadoCliente());
		stmt.setString(7, cliente.getCEPCliente());
		stmt.setDate(8, new Date(cliente.getNascimentoCliente().getTime()));
		stmt.setString(9, cliente.getTelefoneResidencial());
		stmt.setString(10, cliente.getTelefoneComercial());
		stmt.setString(11, cliente.getTelefoneCelular());
		stmt.setLong(12, cliente.getCodCliente());

		stmt.execute();
		stmt.close();
	}

	public void remove(ClienteDO cliente) throws SQLException {
		removeById(cliente.getCodCliente());
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

	public List<ClienteDO> procura(ClienteDO cliente) throws SQLException {
		if (cliente != null) {
			if (cliente.getCodCliente() >= 0) {
				List<ClienteDO> lista = new ArrayList<ClienteDO>();
				lista.add(procuraById(cliente.getCodCliente()));
				return lista;
			}
			if (cliente.getNomeCliente() != null
					&& cliente.getNomeCliente() != "")
				return procuraByNome(cliente.getNomeCliente());
		}
		return null;
	}

	public ClienteDO procuraById(int id) throws SQLException {
		if (id < 0)
			return null;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYID_SQL);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		ClienteDO cliente = null;

		if (rs.next()) {
			cliente = criaCliente(rs);
		}

		rs.close();
		stmt.close();

		return cliente;
	}

	public List<ClienteDO> procuraByNome(String nomeCliente)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYNOME_SQL);

		stmt.setString(1, "%" + nomeCliente + "%");

		ResultSet rs = stmt.executeQuery();

		List<ClienteDO> lista = new ArrayList<ClienteDO>();

		while (rs.next()) {
			ClienteDO cliente = criaCliente(rs);

			lista.add(cliente);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<ClienteDO> getLista() throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTA_SQL);

		ResultSet rs = stmt.executeQuery();

		List<ClienteDO> lista = new ArrayList<ClienteDO>();

		while (rs.next()) {
			ClienteDO cliente = criaCliente(rs);

			lista.add(cliente);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<ClienteDO> getListaPaginada(int inicio, int quantidade)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTAPAGINADA_SQL);

		stmt.setInt(1, inicio);
		stmt.setInt(2, quantidade);

		ResultSet rs = stmt.executeQuery();

		List<ClienteDO> lista = new ArrayList<ClienteDO>();

		while (rs.next()) {
			ClienteDO cliente = criaCliente(rs);

			lista.add(cliente);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public int getLastID() throws SQLException {
		return getLastID("cliente");
	}

	public int count() throws SQLException {
		return count("cliente");
	}

	private ClienteDO criaCliente(ResultSet rs) throws SQLException {
		ClienteDO cliente = new ClienteDO();
		cliente.setNomeCliente(rs.getString("nomeCliente"));
		cliente.setRgCliente(rs.getString("rgCliente"));
		cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
		cliente.setBairroCliente(rs.getString("bairroCliente"));
		cliente.setCidadeCliente(rs.getString("cidadeCliente"));
		cliente.setEstadoCliente(rs.getString("estadoCliente"));
		cliente.setCEPCliente(rs.getString("CEPCliente"));
		cliente.setNascimentoCliente(rs.getDate("nascimentoCliente"));
		cliente.setTelefoneResidencial(rs.getString("telefoneResidencial"));
		cliente.setTelefoneComercial(rs.getString("telefoneComercial"));
		cliente.setTelefoneCelular(rs.getString("telefoneCelular"));
		cliente.setCodCliente(rs.getInt("codCliente"));
		return cliente;
	}
	
	public ArrayList<String> getEstados(){
		ArrayList<String> estados = new ArrayList<String>();
		
		estados.add("Acre");
		estados.add("Alagoas");
		estados.add("Amapá");
		estados.add("Amazonas");
		estados.add("Bahia");
		estados.add("Ceará");
		estados.add("Distrito Federal");
		estados.add("Goiás");
		estados.add("Espírito Santo");
		estados.add("Maranhão");
		estados.add("Mato Grosso");
		estados.add("Mato Grosso do Sul");
		estados.add("Minas Gerais");
		estados.add("Pará");
		estados.add("Paraiba");
		estados.add("Paraná");
		estados.add("Pernambuco");
		estados.add("Piauí");
		estados.add("Rio de Janeiro");
		estados.add("Rio Grande do Norte");
		estados.add("Rio Grande do Sul");
		estados.add("Rondônia");
		estados.add("Rorâima");
		estados.add("São Paulo");
		estados.add("Santa Catarina");
		estados.add("Sergipe");
		estados.add("Tocantins");
		
		return estados;
	}
}