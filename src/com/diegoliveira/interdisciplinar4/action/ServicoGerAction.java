package com.diegoliveira.interdisciplinar4.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diegoliveira.interdisciplinar4.DAO.ServicoDAO;
import com.diegoliveira.interdisciplinar4.DO.ServicoDO;
import com.diegoliveira.interdisciplinar4.form.ServicoForm;

public class ServicoGerAction extends AbstractAction {

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// determine the action. values can be null, ‘save’, ‘update’, or
		// ‘cancel’
		String acao = (String) ((ServicoForm) form).getAcaoForm();
		// action2 can be either null, empty or contain ‘view’ or ‘delete’
		// comes directly from musiclist
		String acao2 = (String) request.getParameter("acaoForm");

		if (acao2 != null)
			if (!acao2.equals(""))
				acao = acao2; // replace action with action2 if action2 is not
								// empty

		// Cria um novo servico
		if (acao == null | acao.equals("novo")) {

			return map.findForward("novo");

			// Altera um servico ja existente
		} else if (acao.equals("altera")) {
			int id = convertID((String) request.getParameter("codServico"));
			if (id > 0) {
				ServicoDAO dao = new ServicoDAO();
				ServicoDO servico = dao.procuraById(id);

				((ServicoForm) form).setServico(servico);
				((ServicoForm) form).setAcaoForm(acao);
			}

			return map.findForward("novo");

			// Remove um servico
		} else if (acao.equals("remove")) {
			int id = convertID((String) request.getParameter("codServico"));
			if (id > 0) {
				ServicoDAO dao = new ServicoDAO();
				ServicoDO servico = new ServicoDO();
				servico.setCodServico(id);

				dao.remove(servico);
			}

			return map.findForward("sucesso");

			// Cancela a criacao ou alteracao de um servico
		} else if (acao.equals("cancela")) {

			return map.findForward("cancela");

			// Salva ou atualiza um servico
		} else if (acao.equals("salva") | acao.equals("atualiza")) {
			ActionErrors errors = ((ServicoForm) form).validate(map, request);

			if (errors.isEmpty()) {
				ServicoForm formulario = ((ServicoForm) form);
				ServicoDO servico = formulario.getServico();

				ServicoDAO dao = new ServicoDAO();
				if (acao.equals("atualiza")) {
					dao.atualiza(servico);
				} else {
					dao.salva(servico);
				}

				return map.findForward("sucesso");
			} else {
				saveErrors(request, errors);
				return map.findForward("falha");
			}
		}

		return map.findForward("novo");
	}
}