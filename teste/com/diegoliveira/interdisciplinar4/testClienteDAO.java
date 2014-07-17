package com.diegoliveira.interdisciplinar4;

import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import com.diegoliveira.interdisciplinar4.DAO.ClienteDAO;
import com.diegoliveira.interdisciplinar4.DO.ClienteDO;

public class testClienteDAO extends TestCase {

	protected void setUp() throws Exception {
		
	}

	public void testSalva() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		ClienteDO c = criaClienteTeste("testSalva");
		
		cDAO.salva(c);
	}

	public void testRemove() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		
		ClienteDO c = criaClienteTeste("testRemove");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodCliente(lastID);
		
		cDAO.remove(c);
	}

	public void testRemoveById() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();	
		
		ClienteDO c = criaClienteTeste("testRemoveByID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		cDAO.removeById(lastID);
	}

	public void testProcura() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		
		ClienteDO cliente = new ClienteDO();
		
		cliente.setNomeCliente("testSalva");
		
		List<ClienteDO> encontrado = cDAO.procura(cliente);
		
		System.out.println("\nMostrando cliente encontrado de nome testSalva (Busca simples)");
		System.out.println(encontrado);
	}

	public void testProcuraByNome() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		
		List<ClienteDO> encontrado = cDAO.procuraByNome("testSalva");
		
		System.out.println("\nMostrando cliente encontrado de nome testSalva (Busca por nome)");
		System.out.println(encontrado);
	}
	
	public void testProcuraById() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		
		ClienteDO c = criaClienteTeste("testBuscaPoID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		ClienteDO encontrado = cDAO.procuraById(lastID);
		
		System.out.println("\nMostrando cliente encontrado no ultimo ID (Busca por ID)");
		System.out.println(encontrado);
	}

	public void testAtualiza() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		ClienteDO c = criaClienteTeste("testSalva");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodCliente(lastID);
		c.setNomeCliente("testAtualiza");
		
		cDAO.atualiza(c);
	}

	public void testGetLista() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		List<ClienteDO> lista = cDAO.getLista();
		
		System.out.println("\nMostrando a lista de clientes");
		for(ClienteDO cliente : lista){
			System.out.println(cliente);
		}
	}

	public void testGetListaPaginada() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		List<ClienteDO> lista = cDAO.getListaPaginada(1, 2);
		
		System.out.println("\nMostrando a lista de clientes de 2-3");
		for(ClienteDO cliente : lista){
			System.out.println(cliente);
		}
	}
	
	public void testCount() throws SQLException {
		ClienteDAO cDAO = new ClienteDAO();
		
		int count = cDAO.count();
		
		System.out.println("Numero de registro: "+count);
	}

	private ClienteDO criaClienteTeste(String nome){
		ClienteDO c = new ClienteDO();
		
		c.setNomeCliente(nome);
		c.setNascimentoCliente("1923-09-04");
		c.setEnderecoCliente("Rua: lala");
		c.setCidadeCliente("Lauro de Freitas");
		c.setEstadoCliente("Bahia");
		c.setCEPCliente("42700-000");
		c.setBairroCliente("Joquey");
		c.setRgCliente("35033342-4");
		c.setTelefoneResidencial("(71) 3213-4214");
		
		return c;
	}
}
