package com.diegoliveira.interdisciplinar4.DO;

import java.sql.SQLException;
import java.util.Date;

import com.diegoliveira.interdisciplinar4.DAO.ClienteDAO;
import com.diegoliveira.interdisciplinar4.form.AbstractForm;

public class HospedagemDO {
	private Long id;
	private int codHospedagem;
	private int codCliente;
	private int codChale;
	private int estado;
	private Date dataInicio;
	private Date dataFim;
	private int qtdPessoas;
	private int desconto;
	private double valorFinal;
	private double diaria;
	public static final int RESERVA = 0;
	public static final int ATIVA = 1;
	public static final int ENCERRADA = 2;
	public static final int BAIXAESTACAO = 0;
	public static final int ALTAESTACAO = 1;

	@Override
	public String toString() {
		String result;
		result = "COD: " + getCodHospedagem() + "\t";
		result += "Cliente: " + getCodCliente() + "\t";
		result += "Chale: " + getCodChale() + "\t";
		result += "Qtd Pessoas: " + getQtdPessoas() + "\n\t";
		result += "Estado: " + getEstado() + "\t";
		result += "Data Inicio: " + getDataInicio() + "\t";
		if (getDataFim() != null)
			result += "Data Encerramento: " + getDataFim() + "\n\t";

		return result;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	
	public String getNomeChale(){
		return "Chalé "+codChale;
	}
	
	public String getNomeCliente() throws SQLException{
		ClienteDAO dao = new ClienteDAO();
		ClienteDO cliente = dao.procuraById(codCliente);
		if(cliente != null)
			return cliente.getNomeCliente();
		else
			return "";
	}

	public int getCodChale() {
		return codChale;
	}

	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}

	public int getEstado() {
		return estado;
	}
	
	public String getTipoEstado(){
		switch(estado) {
			case RESERVA:
				return "Reserva";
			case ATIVA:
				return "Ativa";
			case ENCERRADA:
				return "Encerrada";
			default:
				return "";			
		}
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getDataInicio() {
		return dataInicio;
	}
	
	public String getDataInicioFormatado(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(AbstractForm.FORMATODATA);  

		return formato.format(dataInicio);
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}
	
	public String getDataFimFormatado(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(AbstractForm.FORMATODATA);

		return formato.format(dataFim);
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getEstacao(){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("MM");
		if(formato.format(dataInicio).equals("12") || formato.format(dataInicio).equals("01") || 
				formato.format(dataInicio).equals("02") || formato.format(dataInicio).equals("03") || 
				formato.format(dataInicio).equals("06") || formato.format(dataInicio).equals("07"))
			return 1;
		else
			return 0;
	}
}
