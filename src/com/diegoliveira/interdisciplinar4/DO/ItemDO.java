package com.diegoliveira.interdisciplinar4.DO;

public class ItemDO {
	private Long id;
	private int codItem;
	private String nomeItem;
	private String descricaoItem;

	public int getCodItem() {
		return codItem;
	}

	public void setCodItem(int codItem) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
