package com.diegoliveira.interdisciplinar4;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.diegoliveira.interdisciplinar4.DAO.HospedagemDAO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;

public class testHospedagemDAO extends TestCase {

	protected void setUp() throws Exception {
		
	}

	public void testSalva() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();
		HospedagemDO c = criaHospedagemTeste("testSalva");
		
		cDAO.salva(c);
	}

	public void testRemove() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();
		
		HospedagemDO c = criaHospedagemTeste("testRemove");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodHospedagem(lastID);
		
		cDAO.remove(c);
	}

	public void testRemoveById() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();	
		
		HospedagemDO c = criaHospedagemTeste("testRemoveByID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		cDAO.removeById(lastID);
	}

	public void testProcura() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();
		
		HospedagemDO hospedagem = new HospedagemDO();
		
		hospedagem.setCodHospedagem(1);
		
		List<HospedagemDO> encontrado = cDAO.procura(hospedagem);
		
		System.out.println("\nMostrando hospedagem encontrado de nome testSalva (Busca simples)");
		System.out.println(encontrado);
	}
	
	public void testProcuraById() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();
		
		HospedagemDO c = criaHospedagemTeste("testBuscaPoID");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		HospedagemDO encontrado = cDAO.procuraById(lastID);
		
		System.out.println("\nMostrando hospedagem encontrado no ultimo ID (Busca por ID)");
		System.out.println(encontrado);
	}

	public void testAtualiza() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();
		HospedagemDO c = criaHospedagemTeste("testSalva");
		
		cDAO.salva(c);
		
		int lastID = cDAO.getLastID();
		
		c.setCodHospedagem(lastID);
		c.setEstado(1);
		
		cDAO.atualiza(c);
	}

	public void testGetLista() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();
		List<HospedagemDO> lista = cDAO.getLista();
		
		System.out.println("\nMostrando a lista de hospedagems");
		for(HospedagemDO hospedagem : lista){
			System.out.println(hospedagem);
		}
	}

	public void testGetListaPaginada() throws SQLException {
		HospedagemDAO cDAO = new HospedagemDAO();
		List<HospedagemDO> lista = cDAO.getListaPaginada(1, 2);
		
		System.out.println("\nMostrando a lista de hospedagems de 2-3");
		for(HospedagemDO hospedagem : lista){
			System.out.println(hospedagem);
		}
	}

	private HospedagemDO criaHospedagemTeste(String nome){
		HospedagemDO c = new HospedagemDO();
		
		c.setCodCliente(1);
		c.setCodChale(1);
		c.setDataInicio(new Date(2008, 05, 14, 14, 25, 00));
		c.setDataFim(new Date(2008, 05, 18, 16, 35, 00));
		c.setDiaria(30);
		c.setEstado(0);
		c.setQtdPessoas(2);
		
		return c;
	}
}
