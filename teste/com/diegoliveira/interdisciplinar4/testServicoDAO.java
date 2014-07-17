package com.diegoliveira.interdisciplinar4;

import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import com.diegoliveira.interdisciplinar4.DAO.ServicoDAO;
import com.diegoliveira.interdisciplinar4.DO.ServicoDO;

public class testServicoDAO extends TestCase {

	protected void setUp() throws Exception {
		
	}

	public void testSalva() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();
		ServicoDO c = criaServicoTeste("testSalva");
		
		cDAO.salva(c);
	}

	public void testRemove() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();
		
		ServicoDO c = criaServicoTeste("testRemove");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodServico(lastID);
		
		cDAO.remove(c);
	}

	public void testRemoveById() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();	
		
		ServicoDO c = criaServicoTeste("testRemoveByID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		cDAO.removeById(lastID);
	}

	public void testProcura() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();
		
		ServicoDO cliente = new ServicoDO();
		
		cliente.setNomeServico("testSalva");
		
		List<ServicoDO> encontrado = cDAO.procura(cliente);
		
		System.out.println("\nMostrando cliente encontrado de nome testSalva (Busca simples)");
		System.out.println(encontrado);
	}

	public void testProcuraById() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();
		
		ServicoDO c = criaServicoTeste("testBuscaPoID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		ServicoDO encontrado = cDAO.procuraById(lastID);
		
		System.out.println("\nMostrando cliente encontrado no ultimo ID (Busca por ID)");
		System.out.println(encontrado);
	}

	public void testAtualiza() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();
		ServicoDO c = criaServicoTeste("testSalva");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodServico(lastID);
		c.setNomeServico("testAtualiza");
		
		cDAO.atualiza(c);
	}

	public void testGetLista() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();
		List<ServicoDO> lista = cDAO.getLista();
		
		System.out.println("\nMostrando a lista de clientes");
		for(ServicoDO cliente : lista){
			System.out.println(cliente);
		}
	}

	public void testGetListaPaginada() throws SQLException {
		ServicoDAO cDAO = new ServicoDAO();
		List<ServicoDO> lista = cDAO.getListaPaginada(1, 2);
		
		System.out.println("\nMostrando a lista de clientes de 2-3");
		for(ServicoDO cliente : lista){
			System.out.println(cliente);
		}
	}

	private ServicoDO criaServicoTeste(String nome){
		ServicoDO c = new ServicoDO();
		
		c.setNomeServico(nome);
		c.setValorServico(30);
		
		return c;
	}
}