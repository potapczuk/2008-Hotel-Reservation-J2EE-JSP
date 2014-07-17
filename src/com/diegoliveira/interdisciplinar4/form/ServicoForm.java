package com.diegoliveira.interdisciplinar4.form;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DO.ServicoDO;

public class ServicoForm extends AbstractForm {
	private static final long serialVersionUID = 7273360460988432141L;
	private String codServico = "-1";
	private String nomeServico;
	private String valorServico;
	private String acaoForm = "";

	public String getAcaoForm() {
		return acaoForm;
	}

	public void setAcaoForm(String acaoForm) {
		this.acaoForm = acaoForm;
	}

	public ServicoDO getServico() throws NumberFormatException, ParseException {
		ServicoDO servico = new ServicoDO();

		if (codServico != null && !codServico.equals(""))
			servico.setCodServico(Integer.parseInt(codServico));
		servico.setNomeServico(nomeServico);
		servico.setValorServico(Double.parseDouble(converteCurrencyParaDouble(valorServico)));

		return servico;
	}

	public void setServico(ServicoDO servico) {
		codServico = String.valueOf(servico.getCodServico());
		nomeServico = servico.getNomeServico();
		valorServico = converteDoubleParaCurrency(String.valueOf(servico.getValorServico()));
	}

	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica o nome
		if (stringVazia(getNomeServico())) {
			erros.add("localizacao", new ActionMessage("erro.campoFaltando",
					"Nome do Serviço"));
		}
		if (stringVazia(getValorServico())) {
			erros.add("valorServico", new ActionMessage("erro.campoFaltando",
					"Valor do Serviço"));
		} else if(currencyInvalido(getValorServico())) {
			erros.add("valorServico", new ActionMessage("erro.campoIncorreto",
					"Valor do Serviço", "99.999.999,50"));
		}
		return erros;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codServico = "-1";
		nomeServico = "";
		valorServico = "";
		acaoForm = "";
	}

	public String getCodServico() {
		return codServico;
	}

	public void setCodServico(String codServico) {
		this.codServico = codServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getValorServico() {
		return valorServico;
	}

	public void setValorServico(String valorServico) throws ParseException {
		this.valorServico = valorServico;
	}
}