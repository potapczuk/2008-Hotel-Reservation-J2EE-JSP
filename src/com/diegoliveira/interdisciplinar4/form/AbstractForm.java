package com.diegoliveira.interdisciplinar4.form;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

import org.apache.struts.action.ActionForm;

public class AbstractForm extends ActionForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0L;
	public static final String FORMATODATA = "dd/MM/yyyy";

	protected boolean stringVazia(String valor) {
		return valor == null || valor.trim().length() == 0;
	}

	protected boolean dataErrada(String data) {
		if (!stringVazia(data)) {
			return !data.matches("(\\d\\d)/(\\d\\d)/([12]\\d\\d\\d)");
		}
		return false;
	}
	
	protected boolean intInvalido(String data) {
		if (!stringVazia(data)) {
			return !data.matches("\\d+");
		}
		return false;
	}
	
	protected boolean doubleInvalido(String data) {
		if (!stringVazia(data)) {
			return !data.matches("\\d+[.]?\\d*");
		}
		return false;
	}
	
	protected boolean currencyInvalido(String data) {
		if (!stringVazia(data)) {
			System.out.println(data);
			String regex = "([0-9]?[0-9]\\.[0-9][0-9][0-9]\\.[0-9][0-9][0-9]|[0-9]?[0-9]?[0-9]\\.[0-9][0-9][0-9]|[0-9]?[0-9]?[0-9])([,][0-9][0-9])?";
			System.out.println(regex);
			return !data.matches(regex);
		}
		return false;
	}	
	
	protected boolean cepInvalido(String data) {
		if (!stringVazia(data)) {
			return !data.matches("\\d(5)-\\d(3)");
		}
		return false;
	}
	
	protected boolean telefoneErrado(String telefone) {
		if (!stringVazia(telefone)) {
			return !telefone.matches("[(](\\d\\d)[)][ ](\\d\\d\\d\\d)-(\\d\\d\\d\\d)");
		}
		return false;
	}
	
	protected Date converterStringParaDate(String dataStr, String formatacao){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(formatacao);
		java.util.Date data = null;  
		
		try {  
			data = formato.parse(dataStr);
			return data;
		} catch (java.text.ParseException e) {  
			e.printStackTrace();  
		}
		return null;
	}
	
	public String converterDateParaString(Date data, String formatacao){
		java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat(formatacao);  

		return formato.format(data);
	}
	
	public String converteDoubleParaCurrency(String numero){
		DecimalFormat myformat = new DecimalFormat("###,###.###");
		myformat.setMinimumFractionDigits(2);  
		double valor = Double.parseDouble(numero);
		
		return myformat.format(valor);
	}
	
	public String converteCurrencyParaDouble(String numero) throws ParseException{
		DecimalFormat myformat = new DecimalFormat("###,###.###");
		myformat.setMinimumFractionDigits(2);
		
		double valor = myformat.parse(numero).doubleValue();
		return String.valueOf(valor);
	}
}