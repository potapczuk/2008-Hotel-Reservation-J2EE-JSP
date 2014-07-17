package com.diegoliveira.interdisciplinar4.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

import com.diegoliveira.interdisciplinar4.DAO.ChaleDAO;
import com.diegoliveira.interdisciplinar4.DAO.ClienteDAO;
import com.diegoliveira.interdisciplinar4.DAO.HospedagemDAO;
import com.diegoliveira.interdisciplinar4.DAO.HospedagemServicoDAO;
import com.diegoliveira.interdisciplinar4.DAO.ServicoDAO;
import com.diegoliveira.interdisciplinar4.DO.ChaleDO;
import com.diegoliveira.interdisciplinar4.DO.ClienteDO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemServicoDO;
import com.diegoliveira.interdisciplinar4.DO.ServicoDO;

public class HospedagemServicoAplicaAction extends AbstractAction {

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// determine the action. values can be null, ‘save’, ‘update’, or
		// ‘cancel’
		String acao = (String) ((DynaActionForm) form).get("acaoForm");
		// action2 can be either null, empty or contain ‘view’ or ‘delete’
		// comes directly from musiclist
		String acao2 = (String) request.getParameter("acaoForm");

		if (acao2 != null)
			if (!acao2.equals(""))
				acao = acao2; // replace action with action2 if action2 is not
								// empty
		if (acao.equals("aplicaServico")) {
			int id = convertID((String) request.getParameter("codHospedagem"));
			if (id > 0) {
				HospedagemDAO dao = new HospedagemDAO();
				ClienteDAO clienteDao = new ClienteDAO();
				ChaleDAO chaleDao = new ChaleDAO();
				ServicoDAO servicoDao = new ServicoDAO();
				HospedagemDO hospedagem = dao.procuraById(id);
				
				if(hospedagem.getEstado() != HospedagemDO.ATIVA){
					ActionErrors errors = new ActionErrors();
					errors.add("estado", new ActionMessage("erro.hospedagem.aplica.estado"));
					saveErrors(request, errors);
					return map.findForward("cancela");
				}
				
				((DynaActionForm) form).set("acaoForm", acao);
				((DynaActionForm) form).set("codHospedagem", String.valueOf(id));
				
				request.setAttribute("cliente", (ClienteDO) clienteDao.procuraById(hospedagem.getCodCliente()));
				request.setAttribute("chale", (ChaleDO) chaleDao.procuraById(hospedagem.getCodChale()));
				request.setAttribute("servicos", (ArrayList<ServicoDO>) servicoDao.getLista());
				
				return map.findForward("aplicaServico");
			}

			return map.findForward("cancela");
		} else if (acao.equals("aplicado")) {

			HospedagemServicoDAO hdao = new HospedagemServicoDAO();
			ServicoDAO sdao = new ServicoDAO();
			
			DynaActionForm formulario = ((DynaActionForm) form);
			int codHospedagem = Integer.parseInt(formulario.getString("codHospedagem"));
			ServicoDO servico = sdao.procuraById(Integer.parseInt(formulario.getString("codServico")));
			
			HospedagemServicoDO hospServico = new HospedagemServicoDO();
			
			hospServico.setCodHospedagem(codHospedagem);
			hospServico.setCodServico(servico.getCodServico());
			hospServico.setValorServico(servico.getValorServico());
			hospServico.setDataServico(new Date());
			
			hdao.salva(hospServico);

			return map.findForward("sucesso");
		} else if (acao.equals("cancela")) {

			return map.findForward("cancela");

			// Salva ou atualiza um hospedagem
		}

		return map.findForward("novo");
	}
}