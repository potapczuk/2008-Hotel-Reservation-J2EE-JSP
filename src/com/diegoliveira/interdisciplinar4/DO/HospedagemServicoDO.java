package com.diegoliveira.interdisciplinar4.DO;

import java.sql.SQLException;
import java.util.Date;

import com.diegoliveira.interdisciplinar4.DAO.ServicoDAO;

public class HospedagemServicoDO {
	private Long id;
	private int codHospedagemServico;
	private int codServico;
	private int codHospedagem;
	private Date dataServico;
	private double valorServico;

	public String getNomeServico() throws SQLException{
		ServicoDAO dao = new ServicoDAO();
		ServicoDO servico = dao.procuraById(codServico);
		if(servico != null)
			return servico.getNomeServico();
		else
			return "";
	}
	
	public int getCodServico() {
		return codServico;
	}

	public void setCodServico(int codServico) {
		this.codServico = codServico;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public double getValorServico() {
		return valorServico;
	}

	public void setValorServico(double valorServico) {
		this.valorServico = valorServico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodHospedagemServico() {
		return codHospedagemServico;
	}

	public void setCodHospedagemServico(int codHospedagemServico) {
		this.codHospedagemServico = codHospedagemServico;
	}
}
