package com.diegoliveira.interdisciplinar4.form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DO.ClienteDO;

public class ClienteForm extends AbstractForm {
	private static final long serialVersionUID = 7273360460988432141L;
	private String codCliente = "-1";
	private String nomeCliente = "";
	private String rgCliente = "";
	private String enderecoCliente = "";
	private String bairroCliente = "";
	private String cidadeCliente = "";
	private String estadoCliente = "";
	private String CEPCliente = "";
	private String nascimentoCliente = "";
	private String telefoneResidencial = "";
	private String telefoneComercial = "";
	private String telefoneCelular = "";
	private ArrayList<String> estados = null;
	private String acaoForm = "";

	public String getAcaoForm() {
		return acaoForm;
	}

	public void setAcaoForm(String acaoForm) {
		this.acaoForm = acaoForm;
	}

	public ClienteDO getCliente() {
		ClienteDO cliente = new ClienteDO();

		if (codCliente != null && !codCliente.equals(""))
			cliente.setCodCliente(Integer.parseInt(codCliente));
		cliente.setNomeCliente(nomeCliente);
		cliente.setRgCliente(rgCliente);
		cliente.setEnderecoCliente(enderecoCliente);
		cliente.setBairroCliente(bairroCliente);
		cliente.setCidadeCliente(cidadeCliente);
		cliente.setEstadoCliente(estadoCliente);
		cliente.setCEPCliente(CEPCliente);
		cliente.setNascimentoCliente(converterStringParaDate(nascimentoCliente, FORMATODATA));
		cliente.setTelefoneResidencial(telefoneResidencial);
		cliente.setTelefoneComercial(telefoneComercial);
		cliente.setTelefoneCelular(telefoneCelular);

		return cliente;
	}

	public void setCliente(ClienteDO cliente) {
		codCliente = String.valueOf(cliente.getCodCliente());
		nomeCliente = cliente.getNomeCliente();
		rgCliente = cliente.getRgCliente();
		enderecoCliente = cliente.getEnderecoCliente();
		bairroCliente = cliente.getBairroCliente();
		cidadeCliente = cliente.getCidadeCliente();
		estadoCliente = cliente.getEstadoCliente();
		CEPCliente = cliente.getCEPCliente();
		nascimentoCliente = cliente.getNascimentoClienteFormatado();
		telefoneResidencial = cliente.getTelefoneResidencial();
		telefoneComercial = cliente.getTelefoneComercial();
		telefoneCelular = cliente.getTelefoneCelular();
	}

	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica o nome
		if (stringVazia(getNomeCliente())) {
			erros.add("nome", new ActionMessage("erro.campoFaltando", "Nome"));
		}
		if (stringVazia(getRgCliente())) {
			erros.add("rg", new ActionMessage("erro.campoFaltando", "RG"));
		}
		if (dataErrada(getNascimentoCliente())) {
			erros.add("nascimento", new ActionMessage("erro.campoIncorreto",
					"Data de Nascimento", "30/12/2008"));
		}
		if (stringVazia(getEnderecoCliente())) {
			erros.add("endereco", new ActionMessage("erro.campoFaltando",
					"Endereço"));
		}
		if (stringVazia(getBairroCliente())) {
			erros.add("bairro", new ActionMessage("erro.campoFaltando",
					"Bairro"));
		}
		if (stringVazia(getCidadeCliente())) {
			erros.add("cidade", new ActionMessage("erro.campoFaltando",
					"Cidade"));
		}
		if (stringVazia(getEstadoCliente())) {
			erros.add("estado", new ActionMessage("erro.campoFaltando",
					"Estado"));
		}
		if (stringVazia(getCEPCliente())) {
			erros.add("cep", new ActionMessage("erro.campoFaltando", "CEP"));
		} else if(cepInvalido(getCEPCliente())) {
			erros.add("cep", new ActionMessage("erro.campoIncorreto",
					"CEP", "99999-999"));
		}
		if (stringVazia(getTelefoneResidencial())) {
			erros.add("telefoneResidencial", new ActionMessage(
					"erro.campoFaltando", "Telefone Residencial"));
		} else if (telefoneErrado(getTelefoneResidencial())) {
			erros.add("telefoneResidencial", new ActionMessage(
					"erro.campoIncorreto", "Telefone Residencial",
					"(71) 3333-3333"));
		}
		if (telefoneErrado(getTelefoneComercial())) {
			erros.add("telefoneComercial", new ActionMessage(
					"erro.campoIncorreto", "Telefone Comercial",
					"(71) 3333-3333"));
		}
		if (telefoneErrado(getTelefoneCelular())) {
			erros.add("telefoneCelular",
					new ActionMessage("erro.campoIncorreto",
							"Telefone Celular", "(71) 3333-3333"));
		}
		return erros;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codCliente = "-1";
		nomeCliente = "";
		rgCliente = "";
		enderecoCliente = "";
		bairroCliente = "";
		cidadeCliente = "";
		estadoCliente = "";
		CEPCliente = "";
		nascimentoCliente = "";
		telefoneResidencial = "";
		telefoneComercial = "";
		telefoneCelular = "";
		estados = null;
		acaoForm = "";
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
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

	public String getNascimentoCliente() {
		return nascimentoCliente;
	}

	public void setNascimentoCliente(String nascimentoCliente) {
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

	public ArrayList<String> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<String> estados) {
		this.estados = estados;
	}
}