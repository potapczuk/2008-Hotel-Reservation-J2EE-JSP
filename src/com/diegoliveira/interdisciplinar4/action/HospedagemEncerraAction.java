package com.diegoliveira.interdisciplinar4.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DAO.HospedagemDAO;
import com.diegoliveira.interdisciplinar4.DAO.HospedagemServicoDAO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemServicoDO;
import com.diegoliveira.interdisciplinar4.form.HospedagemEncerraForm;

public class HospedagemEncerraAction extends AbstractAction {

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// determine the action. values can be null, ‘save’, ‘update’, or
		// ‘cancel’
		String acao = (String) ((HospedagemEncerraForm) form).getAcaoForm();
		// action2 can be either null, empty or contain ‘view’ or ‘delete’
		// comes directly from musiclist
		String acao2 = (String) request.getParameter("acaoForm");

		if (acao2 != null)
			if (!acao2.equals(""))
				acao = acao2; // replace action with action2 if action2 is not
								// empty
		if (acao.equals("encerra")) {
				return carregaForm(map, form, request, acao, false);				
			
		} else if (acao.equals("encerrada")) {
			ActionErrors errors = ((HospedagemEncerraForm) form).validate(map, request);

			if (errors.isEmpty()) {
				HospedagemDAO dao = new HospedagemDAO();
				HospedagemEncerraForm formulario = ((HospedagemEncerraForm) form);
				HospedagemDO hospedagem = dao.procuraById(Integer.parseInt(formulario.getCodHospedagem())); 

				formulario.getHospedagem(hospedagem);
				
				dao.atualiza(hospedagem);
				
				carregaForm(map, form, request, acao, true);

				return map.findForward("sucesso");
			} else {				
				saveErrors(request, errors);
				
				carregaForm(map, form, request, acao, false);
				
				return map.findForward("falha");
			}
		} else if (acao.equals("cancela")) {

			return map.findForward("cancela");

			// Salva ou atualiza um hospedagem
		}

		return map.findForward("novo");
	}

	private ActionForward carregaForm(ActionMapping map, ActionForm form,
			HttpServletRequest request, String acao, boolean relatorio) throws SQLException{
		int id = convertID((String) request.getParameter("codHospedagem"));
		if (id > 0) {
			HospedagemDAO dao = new HospedagemDAO();
			HospedagemDO hospedagem = dao.procuraById(id);
			
			if(!relatorio){
				if(hospedagem.getEstado() == HospedagemDO.RESERVA){
					ActionErrors errors = new ActionErrors();
					errors.add("estado", new ActionMessage("erro.hospedagem.encerra.estado"));
					saveErrors(request, errors);
					return map.findForward("cancela");
				}
			}
				
	
			((HospedagemEncerraForm) form).setHospedagem(hospedagem);
			((HospedagemEncerraForm) form).setAcaoForm(acao);
			
			double diaria = hospedagem.getDiaria();
			double calcDias = ((double)(new Date().getTime() - hospedagem.getDataInicio().getTime())) / 1000 / 60 / 60 / 24;
			int dias = (int)Math.ceil(calcDias);
			
			if(dias < 1){
				ActionErrors errors = new ActionErrors();
				errors.add("dataInicio", new ActionMessage("erro.hospedagem.encerra.dataInicio"));
				saveErrors(request, errors);
				return map.findForward("cancela");
			}
			
			double valorHospedagem = diaria * dias;
			
			HospedagemServicoDAO sdao = new HospedagemServicoDAO();
			ArrayList<HospedagemServicoDO> servicos = sdao.procuraByHospedagem(hospedagem.getCodHospedagem());
			
			double valorServico = 0;
			for(HospedagemServicoDO servico : servicos){
				valorServico += servico.getValorServico();
			}
			
			double valorTotal = valorHospedagem + valorServico;

			request.setAttribute("servicos", servicos);
			request.setAttribute("valorTotal", valorTotal);
			request.setAttribute("valorHospedagem", valorHospedagem);
			request.setAttribute("form", form);
			
			if (hospedagem.getEstado() == HospedagemDO.ENCERRADA){
				request.setAttribute("valorFinal", valorTotal * (double)(1 - (double)hospedagem.getDesconto() / 100));
				return map.findForward("sucesso");
			}
			
			return map.findForward("encerra");
		} else {
			return map.findForward("falha");
		}
	}
}