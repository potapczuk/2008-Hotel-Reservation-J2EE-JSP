package com.diegoliveira.interdisciplinar4.DO;

public class ServicoDO {
	private Long id;
	private int codServico;
	private String nomeServico;
	private double valorServico;

	public int getCodServico() {
		return codServico;
	}

	public void setCodServico(int codServico) {
		this.codServico = codServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
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
}
