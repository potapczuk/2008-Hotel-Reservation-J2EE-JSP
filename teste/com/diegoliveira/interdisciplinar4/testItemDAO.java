package com.diegoliveira.interdisciplinar4;

import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import com.diegoliveira.interdisciplinar4.DAO.ItemDAO;
import com.diegoliveira.interdisciplinar4.DO.ItemDO;

public class testItemDAO extends TestCase {

	protected void setUp() throws Exception {
		
	}

	public void testSalva() throws SQLException {
		ItemDAO cDAO = new ItemDAO();
		ItemDO c = criaItemTeste("testSalva");
		
		cDAO.salva(c);
	}

	public void testRemove() throws SQLException {
		ItemDAO cDAO = new ItemDAO();
		
		ItemDO c = criaItemTeste("testRemove");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodItem(lastID);
		
		cDAO.remove(c);
	}

	public void testRemoveById() throws SQLException {
		ItemDAO cDAO = new ItemDAO();	
		
		ItemDO c = criaItemTeste("testRemoveByID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		cDAO.removeById(lastID);
	}

	public void testProcura() throws SQLException {
		ItemDAO cDAO = new ItemDAO();
		
		ItemDO cliente = new ItemDO();
		
		cliente.setNomeItem("testSalva");
		
		List<ItemDO> encontrado = cDAO.procura(cliente);
		
		System.out.println("\nMostrando cliente encontrado de nome testSalva (Busca simples)");
		System.out.println(encontrado);
	}

	public void testProcuraById() throws SQLException {
		ItemDAO cDAO = new ItemDAO();
		
		ItemDO c = criaItemTeste("testBuscaPoID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		ItemDO encontrado = cDAO.procuraById(lastID);
		
		System.out.println("\nMostrando cliente encontrado no ultimo ID (Busca por ID)");
		System.out.println(encontrado);
	}

	public void testAtualiza() throws SQLException {
		ItemDAO cDAO = new ItemDAO();
		ItemDO c = criaItemTeste("testSalva");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodItem(lastID);
		c.setNomeItem("testAtualiza");
		
		cDAO.atualiza(c);
	}

	public void testGetLista() throws SQLException {
		ItemDAO cDAO = new ItemDAO();
		List<ItemDO> lista = cDAO.getLista();
		
		System.out.println("\nMostrando a lista de clientes");
		for(ItemDO cliente : lista){
			System.out.println(cliente);
		}
	}

	public void testGetListaPaginada() throws SQLException {
		ItemDAO cDAO = new ItemDAO();
		List<ItemDO> lista = cDAO.getListaPaginada(1, 2);
		
		System.out.println("\nMostrando a lista de clientes de 2-3");
		for(ItemDO cliente : lista){
			System.out.println(cliente);
		}
	}

	private ItemDO criaItemTeste(String nome){
		ItemDO c = new ItemDO();
		
		c.setNomeItem(nome);
		c.setDescricaoItem("Descricao");
		
		return c;
	}
}