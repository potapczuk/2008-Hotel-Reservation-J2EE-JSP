package com.diegoliveira.interdisciplinar4.DO;

import java.util.ArrayList;

public class ChaleDO {
	private Long id;
	private int codChale;
	private String localizacao;
	private int capacidade;
	private double valorAltaEstacao;
	private double valorBaixaEstacao;
	private ArrayList<ItemDO> itens;

	public int getCodChale() {
		return codChale;
	}

	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}
	
	public String getNomeChale(){
		return "Chalé "+codChale;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public double getValorAltaEstacao() {
		return valorAltaEstacao;
	}

	public void setValorAltaEstacao(double valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}

	public double getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}

	public void setValorBaixaEstacao(double valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}

	public ArrayList<ItemDO> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemDO> itens) {
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		String result;
		result = "COD: " + getCodChale() + "\t";
		result += "Localização: " + getLocalizacao() + "\t";
		result += "Capacidade: " + getCapacidade() + "\n\t";
		result += "Alta estação: R$" + getValorAltaEstacao() + "\t";
		result += "Baixa estação: R$" + getValorBaixaEstacao();

		return result;
	}
}
