package com.diegoliveira.interdisciplinar4.form;

import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DO.ChaleDO;
import com.diegoliveira.interdisciplinar4.DO.ItemDO;

public class ChaleForm extends AbstractForm {
	private static final long serialVersionUID = 7273360460988432141L;
	private String codChale = "-1";
	private String localizacao = "";
	private String capacidade = "";
	private String valorAltaEstacao = "";
	private String valorBaixaEstacao = "";
	private String acaoForm = "";
	private ArrayList<ItemDO> itensChale = null;
	
	private String[] codItens = null;
	private String[] codTodosItens = null;
	private ArrayList<ItemDO> itensNaoChale = null;

	public ArrayList<ItemDO> getItensChale() {
		return itensChale;
	}

	public void setItensChale(ArrayList<ItemDO> itensChale) {
		this.itensChale = itensChale;
	}

	public String[] getCodItens() {
		return codItens;
	}

	public void setCodItens(String[] codItens) {
		this.codItens = codItens;
	}

	public String[] getCodTodosItens() {
		return codTodosItens;
	}

	public void setCodTodosItens(String[] codTodosItens) {
		this.codTodosItens = codTodosItens;
	}

	public ArrayList<ItemDO> getItensNaoChale() {
		return itensNaoChale;
	}

	public void setItensNaoChale(ArrayList<ItemDO> itensNaoChale) {
		this.itensNaoChale = itensNaoChale;
	}

	public String getAcaoForm() {
		return acaoForm;
	}

	public void setAcaoForm(String acaoForm) {
		this.acaoForm = acaoForm;
	}

	public ChaleDO getChale() throws NumberFormatException, ParseException {
		ChaleDO chale = new ChaleDO();

		if (codChale != null && !codChale.equals(""))
			chale.setCodChale(Integer.parseInt(codChale));
		chale.setLocalizacao(localizacao);
		chale.setCapacidade(Integer.parseInt(capacidade));
		chale.setValorAltaEstacao(Double.parseDouble(converteCurrencyParaDouble(valorAltaEstacao)));
		chale.setValorBaixaEstacao(Double.parseDouble(converteCurrencyParaDouble(valorBaixaEstacao)));

		return chale;
	}

	public void setChale(ChaleDO chale) {
		codChale = String.valueOf(chale.getCodChale());
		localizacao = chale.getLocalizacao();
		capacidade = String.valueOf(chale.getCapacidade());
		valorAltaEstacao = converteDoubleParaCurrency(String.valueOf(chale.getValorAltaEstacao()));
		valorBaixaEstacao = converteDoubleParaCurrency(String.valueOf(chale.getValorBaixaEstacao()));
	}

	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica o nome
		if (stringVazia(getLocalizacao())) {
			erros.add("localizacao", new ActionMessage("erro.campoFaltando",
					"Localização"));
		}
		if (stringVazia(getCapacidade())) {
			erros.add("capacidade", new ActionMessage("erro.campoFaltando",
					"Capacidade"));
		} else if(intInvalido(getCapacidade())) {
			erros.add("capacidade", new ActionMessage("erro.campoIncorreto",
			"Capacidade", "2"));
		}
		if (stringVazia(getValorAltaEstacao())) {
			erros.add("valorAltaEstacao", new ActionMessage(
					"erro.campoFaltando", "Valor Alta Estação"));
		} else if(currencyInvalido(getValorAltaEstacao())) {
			erros.add("valorAltaEstacao", new ActionMessage("erro.campoIncorreto",
					"valorAltaEstacao", "10.50"));
		}
		if (stringVazia(getValorBaixaEstacao())) {
			erros.add("valorBaixaEstacao", new ActionMessage(
					"erro.campoFaltando", "Valor Baixa Estação"));
		} else if(currencyInvalido(getValorBaixaEstacao())) {
			erros.add("valorBaixaEstacao", new ActionMessage("erro.campoIncorreto",
					"valorBaixaEstacao", "10.50"));
		}
		return erros;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codChale = "-1";
		localizacao = "";
		capacidade = "";
		valorAltaEstacao = "";
		valorBaixaEstacao = "";
		acaoForm = "";
		itensChale = null;
		codItens = null;
		codTodosItens = null;
		itensNaoChale = null;
	}

	public String getCodChale() {
		return codChale;
	}

	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getValorAltaEstacao() {
		return valorAltaEstacao;
	}

	public void setValorAltaEstacao(String valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}

	public String getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}

	public void setValorBaixaEstacao(String valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}
}