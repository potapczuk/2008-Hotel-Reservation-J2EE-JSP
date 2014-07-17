package com.diegoliveira.interdisciplinar4.form;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;

public class HospedagemEncerraForm extends AbstractForm {
	private static final long serialVersionUID = 7273360460988432141L;
	private String codHospedagem = "-1";
	private String nomeCliente = "";
	private String nomeChale = "";
	private String dataInicio = "";
	private String dataFim = "";
	private String qtdPessoas = "";
	private String desconto = "0";
	private String diaria = "";
	private String valorTotal = "";
	private String acaoForm = "";

	public String getAcaoForm() {
		return acaoForm;
	}

	public void setAcaoForm(String acaoForm) {
		this.acaoForm = acaoForm;
	}

	public void getHospedagem(HospedagemDO hospedagem) {
		hospedagem.setDesconto(Integer.parseInt(desconto));
		hospedagem.setEstado(HospedagemDO.ENCERRADA);
		hospedagem.setDataFim(new Date());
		
		double valorTotalDouble = Double.parseDouble(valorTotal);
		valorTotalDouble = valorTotalDouble * (1 - ((double)hospedagem.getDesconto() / 100));
		
		hospedagem.setValorFinal(valorTotalDouble);
	}

	public void setHospedagem(HospedagemDO hospedagem) throws SQLException {
		codHospedagem = String.valueOf(hospedagem.getCodHospedagem());
		nomeCliente = hospedagem.getNomeCliente();
		nomeChale = hospedagem.getNomeChale();
		dataInicio = hospedagem.getDataInicioFormatado();
		//dataFim = hospedagem.getDataFimFormatado();
		dataFim = converterDateParaString(new Date(), AbstractForm.FORMATODATA);
		qtdPessoas = String.valueOf(hospedagem.getQtdPessoas());
		diaria = String.valueOf(hospedagem.getDiaria());
		desconto = String.valueOf(hospedagem.getDesconto());
	}

	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica o nome
		if (stringVazia(getDesconto())) {
			erros.add("desconto", new ActionMessage("erro.campoFaltando",
					"Desconto"));
		}
		return erros;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codHospedagem = "-1";
		nomeCliente = "";
		nomeChale = "";
		dataInicio = "";
		dataFim = "";
		qtdPessoas = "";
		desconto = "0";
		diaria = "";
		acaoForm = "";
	}

	public String getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeChale() {
		return nomeChale;
	}

	public void setNomeChale(String nomeChale) {
		this.nomeChale = nomeChale;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(String qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public String getDiaria() {
		return diaria;
	}

	public void setDiaria(String diaria) {
		this.diaria = diaria;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

}