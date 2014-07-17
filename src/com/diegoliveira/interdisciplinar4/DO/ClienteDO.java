package com.diegoliveira.interdisciplinar4.DO;

import java.io.Serializable;
import java.util.Date;

import com.diegoliveira.interdisciplinar4.form.AbstractForm;

public class ClienteDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 0L;
	private int codCliente = -1;
	private String nomeCliente = null;
	private String rgCliente = null;
	private String enderecoCliente = null;
	private String bairroCliente = null;
	private String cidadeCliente = null;
	private String estadoCliente = null;
	private String CEPCliente = null;
	private Date nascimentoCliente = null;
	private String telefoneResidencial = null;
	private String telefoneComercial = null;
	private String telefoneCelular = null;

	@Override
	public String toString() {
		String result;
		result = "COD: " + getCodCliente() + "\t";
		result += "Nome: " + getNomeCliente() + "\t";
		result += "RG: " + getRgCliente() + "\t";
		result += "Data de nascimento: " + getNascimentoCliente() + "\n\t";
		result += "Endereço: " + getEnderecoCliente() + "\n\t";
		result += "Bairro: " + getBairroCliente() + "\t";
		result += "Cidade: " + getCidadeCliente() + "\t";
		result += "Estado: " + getEstadoCliente() + "\t";
		result += "CEP: " + getCEPCliente() + "\n\t";
		if (getTelefoneResidencial() != null
				&& getTelefoneResidencial().length() > 0)
			result += "Telefone Residencial: " + getTelefoneResidencial() + " ";
		if (getTelefoneComercial() != null
				&& getTelefoneComercial().length() > 0)
			result += "Telefone Comercial: " + getTelefoneComercial() + " ";
		if (getTelefoneCelular() != null && getTelefoneCelular().length() > 0)
			result += "Telefone Celular: " + getTelefoneCelular();
		return result;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getRgCliente() {
		return rgCliente;
	}

	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getCEPCliente() {
		return CEPCliente;
	}

	public void setCEPCliente(String cliente) {
		CEPCliente = cliente;
	}

	public Date getNascimentoCliente() {
		return nascimentoCliente;
	}
	
	public String getNascimentoClienteFormatado(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(AbstractForm.FORMATODATA);  

		return formato.format(nascimentoCliente);
	}

	public void setNascimentoCliente(Date nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
}