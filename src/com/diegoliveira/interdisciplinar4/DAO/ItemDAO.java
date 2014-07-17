package com.diegoliveira.interdisciplinar4.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diegoliveira.interdisciplinar4.DO.ItemDO;

public class ItemDAO extends AbstractDAO {
	private static final String SALVA_SQL = "INSERT INTO item "
			+ "(nomeItem, descricaoItem) "
			+ "VALUES (?,?)";

	private static final String REMOVEBYID_SQL = "DELETE FROM item "
			+ "WHERE codItem = ?";

	private static final String PROCURABYID_SQL = "SELECT * FROM item WHERE codItem = ?";

	private static final String ATUALIZA_SQL = "UPDATE item "
			+ "SET nomeItem=?, descricaoItem=? WHERE codItem = ?";

	private static final String GETLISTA_SQL = "SELECT * FROM item ORDER BY nomeItem";
	
	private static final String GETLISTACHALE_SQL = "SELECT i.codItem, nomeItem, descricaoItem FROM chale_item ci, item i "
		+ " WHERE i.codItem = ci.codItem AND codChale = ? ORDER BY nomeItem";

	private static final String GETLISTANAOCHALE_SQL = "SELECT * FROM item i "
		+ " WHERE i.codItem not in (SELECT ci.codItem FROM chale_item ci WHERE codChale = ?) ORDER BY nomeItem";

	private static final String GETLISTAPAGINADA_SQL = "SELECT * FROM item LIMIT ?,?";

	public void salva(ItemDO item) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				SALVA_SQL);

		stmt.setString(1, item.getNomeItem());
		stmt.setString(2, item.getDescricaoItem());

		stmt.execute();

		stmt.close();
	}

	public void atualiza(ItemDO item) throws SQLException {
		if (item.getCodItem() < 0) {
			// TODO Reportar erro
			return;
		}
		PreparedStatement stmt = this.getConnection().prepareStatement(
				ATUALIZA_SQL);

		stmt.setString(1, item.getNomeItem());
		stmt.setString(2, item.getDescricaoItem());
		stmt.setInt(3, item.getCodItem());

		stmt.execute();
		stmt.close();
	}

	public void remove(ItemDO item) throws SQLException {
		removeById(item.getCodItem());
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

	public List<ItemDO> procura(ItemDO item) throws SQLException {
		if (item != null) {
			if (item.getCodItem() >= 0) {
				List<ItemDO> lista = new ArrayList<ItemDO>();
				lista.add(procuraById(item.getCodItem()));
				return lista;
			}
		}
		return null;
	}

	public ItemDO procuraById(int id) throws SQLException {
		if (id < 0)
			return null;
		PreparedStatement stmt = this.getConnection().prepareStatement(
				PROCURABYID_SQL);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		ItemDO item = null;

		if (rs.next()) {
			item = criaItem(rs);
		}

		rs.close();
		stmt.close();

		return item;
	}

	public List<ItemDO> getLista() throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTA_SQL);

		ResultSet rs = stmt.executeQuery();

		List<ItemDO> lista = new ArrayList<ItemDO>();

		while (rs.next()) {
			ItemDO item = criaItem(rs);

			lista.add(item);
		}

		rs.close();
		stmt.close();

		return lista;
	}
	
	public List<ItemDO> getListaItensNoChale(int codChale) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTACHALE_SQL);
		
		stmt.setInt(1, codChale);
		
		ResultSet rs = stmt.executeQuery();

		List<ItemDO> lista = new ArrayList<ItemDO>();

		while (rs.next()) {
			ItemDO item = criaItem(rs);

			lista.add(item);
		}

		rs.close();
		stmt.close();

		return lista;
	}
	
	public List<ItemDO> getListaItensForaDoChale(int codChale) throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTANAOCHALE_SQL);
		
		stmt.setInt(1, codChale);
		
		ResultSet rs = stmt.executeQuery();

		List<ItemDO> lista = new ArrayList<ItemDO>();

		while (rs.next()) {
			ItemDO item = criaItem(rs);

			lista.add(item);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public List<ItemDO> getListaPaginada(int inicio, int quantidade)
			throws SQLException {
		PreparedStatement stmt = this.getConnection().prepareStatement(
				GETLISTAPAGINADA_SQL);

		stmt.setInt(1, inicio);
		stmt.setInt(2, quantidade);

		ResultSet rs = stmt.executeQuery();

		List<ItemDO> lista = new ArrayList<ItemDO>();

		while (rs.next()) {
			ItemDO item = criaItem(rs);

			lista.add(item);
		}

		rs.close();
		stmt.close();

		return lista;
	}

	public int getLastID() throws SQLException {
		return getLastID("item");
	}

	public int count() throws SQLException {
		return count("item");
	}

	private ItemDO criaItem(ResultSet rs) throws SQLException {
		ItemDO item = new ItemDO();
		item.setNomeItem(rs.getString("nomeItem"));
		item.setDescricaoItem(rs.getString("descricaoItem"));
		item.setCodItem(rs.getInt("codItem"));
		return item;
	}
}