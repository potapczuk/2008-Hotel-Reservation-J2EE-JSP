package com.diegoliveira.interdisciplinar4.form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DAO.HospedagemDAO.Estado;
import com.diegoliveira.interdisciplinar4.DO.ChaleDO;
import com.diegoliveira.interdisciplinar4.DO.ClienteDO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;

public class HospedagemForm extends AbstractForm {
	private static final long serialVersionUID = 7273360460988432141L;
	private String codHospedagem = "-1";
	private String codCliente = "";
	private String codChale = "";
	private String estado = "";
	private String dataInicio = "";
	private String dataFim = "";
	private String qtdPessoas = "";
	private String desconto = "";
	private String valorFinal = "";
	private String diaria = "";
	private ArrayList<ClienteDO> clientes = null;
	private ArrayList<ChaleDO> chales = null;
	private ArrayList<Estado> estados = null;
	private String acaoForm = "";

	public String getAcaoForm() {
		return acaoForm;
	}

	public void setAcaoForm(String acaoForm) {
		this.acaoForm = acaoForm;
	}

	public HospedagemDO getHospedagem() {
		HospedagemDO hospedagem = new HospedagemDO();

		if (codHospedagem != null && !codHospedagem.equals(""))
			hospedagem.setCodHospedagem(Integer.parseInt(codHospedagem));
		hospedagem.setCodCliente(Integer.parseInt(codCliente));
		hospedagem.setCodChale(Integer.parseInt(codChale));
		hospedagem.setEstado(Integer.parseInt(estado));
		hospedagem.setDataInicio(converterStringParaDate(dataInicio, FORMATODATA));
		hospedagem.setDataFim(converterStringParaDate(dataFim, FORMATODATA));
		hospedagem.setQtdPessoas(Integer.parseInt(qtdPessoas));

		return hospedagem;
	}

	public void setHospedagem(HospedagemDO hospedagem) {
		codHospedagem = String.valueOf(hospedagem.getCodHospedagem());
		codCliente = String.valueOf(hospedagem.getCodCliente());
		codChale = String.valueOf(hospedagem.getCodChale());
		estado = String.valueOf(hospedagem.getEstado());
		dataInicio = hospedagem.getDataInicioFormatado();
		dataFim = hospedagem.getDataFimFormatado();
		qtdPessoas = String.valueOf(hospedagem.getQtdPessoas());
	}

	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica o nome
		if (stringVazia(getCodCliente())) {
			erros.add("codCliente", new ActionMessage("erro.campoFaltando",
					"Cliente"));
		}
		if (stringVazia(getCodChale())) {
			erros.add("codChale", new ActionMessage("erro.campoFaltando",
					"Chalé"));
		}
		if (stringVazia(getEstado())) {
			erros.add("estado", new ActionMessage("erro.campoFaltando",
					"Estado da hospedagem"));
		}
		if (stringVazia(getDataInicio())) {
			erros.add("dataInicio", new ActionMessage("erro.campoFaltando",
					"Data de início"));
		} else if (dataErrada(getDataInicio())){
			erros.add("dataInicio", new ActionMessage("erro.campoIncorreto",
			"Data de início", "30/12/2008"));
		}
		if (stringVazia(getDataFim())) {
			erros.add("dataFim", new ActionMessage("erro.campoFaltando",
					"Data de término"));
		}
		if (stringVazia(getQtdPessoas())) {
			erros.add("qtdPessoas", new ActionMessage("erro.campoFaltando",
					"Qtd. de pessoas"));
		} else if(intInvalido(getQtdPessoas())) {
			erros.add("qtdPessoas", new ActionMessage("erro.campoIncorreto",
					"Qtd. de pessoas", "2"));
		}
		return erros;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codHospedagem = "-1";
		codCliente = "";
		codChale = "";
		estado = "";
		dataInicio = "";
		dataFim = "";
		qtdPessoas = "";
		desconto = "";
		valorFinal = "";
		diaria = "";
		clientes = null;
		chales = null;
		estados = null;
		acaoForm = "";
	}

	public String getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodChale() {
		return codChale;
	}

	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getDiaria() {
		return diaria;
	}

	public void setDiaria(String diaria) {
		this.diaria = diaria;
	}

	public ArrayList<ClienteDO> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<ClienteDO> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<ChaleDO> getChales() {
		return chales;
	}

	public void setChales(ArrayList<ChaleDO> chales) {
		this.chales = chales;
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
	}
}