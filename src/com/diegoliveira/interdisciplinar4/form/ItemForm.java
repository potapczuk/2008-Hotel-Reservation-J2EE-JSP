package com.diegoliveira.interdisciplinar4.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DO.ItemDO;

public class ItemForm extends AbstractForm {
	private static final long serialVersionUID = 7273360460988432141L;
	private String codItem = "-1";
	private String nomeItem;
	private String descricaoItem;
	private String acaoForm = "";

	public String getAcaoForm() {
		return acaoForm;
	}

	public void setAcaoForm(String acaoForm) {
		this.acaoForm = acaoForm;
	}

	public ItemDO getItem() {
		ItemDO item = new ItemDO();

		if (codItem != null && !codItem.equals(""))
			item.setCodItem(Integer.parseInt(codItem));
		item.setNomeItem(nomeItem);
		item.setDescricaoItem(descricaoItem);

		return item;
	}

	public void setItem(ItemDO item) {
		codItem = String.valueOf(item.getCodItem());
		nomeItem = item.getNomeItem();
		descricaoItem = item.getDescricaoItem();
	}

	@Override
	public ActionErrors validate(ActionMapping map, HttpServletRequest req) {
		ActionErrors erros = new ActionErrors();
		// verifica o nome
		if (stringVazia(getNomeItem())) {
			erros.add("nomeItem", new ActionMessage("erro.campoFaltando",
					"Nome do Item"));
		}
		if (stringVazia(getDescricaoItem())) {
			erros.add("descricaoItem", new ActionMessage("erro.campoFaltando",
					"Descrição do Item"));
		}
		return erros;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		codItem = "-1";
		nomeItem = "";
		descricaoItem = "";
		acaoForm = "";
	}

	public String getCodItem() {
		return codItem;
	}

	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

}