package com.diegoliveira.interdisciplinar4;

import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import com.diegoliveira.interdisciplinar4.DAO.ChaleDAO;
import com.diegoliveira.interdisciplinar4.DO.ChaleDO;

public class testChaleDAO extends TestCase {

	protected void setUp() throws Exception {
		
	}

	public void testSalva() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();
		ChaleDO c = criaChaleTeste("testSalva");
		
		cDAO.salva(c);
	}

	public void testRemove() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();
		
		ChaleDO c = criaChaleTeste("testRemove");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodChale(lastID);
		
		cDAO.remove(c);
	}

	public void testRemoveById() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();	
		
		ChaleDO c = criaChaleTeste("testRemoveByID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		cDAO.removeById(lastID);
	}

	public void testProcura() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();
		
		ChaleDO cliente = new ChaleDO();
		
		cliente.setLocalizacao("testSalva");
		
		List<ChaleDO> encontrado = cDAO.procura(cliente);
		
		System.out.println("\nMostrando cliente encontrado de nome testSalva (Busca simples)");
		System.out.println(encontrado);
	}

	public void testProcuraById() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();
		
		ChaleDO c = criaChaleTeste("testBuscaPoID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		ChaleDO encontrado = cDAO.procuraById(lastID);
		
		System.out.println("\nMostrando cliente encontrado no ultimo ID (Busca por ID)");
		System.out.println(encontrado);
	}

	public void testAtualiza() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();
		ChaleDO c = criaChaleTeste("testSalva");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodChale(lastID);
		c.setLocalizacao("testAtualiza");
		
		cDAO.atualiza(c);
	}

	public void testGetLista() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();
		List<ChaleDO> lista = cDAO.getLista();
		
		System.out.println("\nMostrando a lista de clientes");
		for(ChaleDO cliente : lista){
			System.out.println(cliente);
		}
	}

	public void testGetListaPaginada() throws SQLException {
		ChaleDAO cDAO = new ChaleDAO();
		List<ChaleDO> lista = cDAO.getListaPaginada(1, 2);
		
		System.out.println("\nMostrando a lista de clientes de 2-3");
		for(ChaleDO cliente : lista){
			System.out.println(cliente);
		}
	}

	private ChaleDO criaChaleTeste(String nome){
		ChaleDO c = new ChaleDO();
		
		c.setCapacidade(2);
		c.setLocalizacao(nome);
		c.setValorAltaEstacao(60);
		c.setValorBaixaEstacao(35);
		
		return c;
	}
}
