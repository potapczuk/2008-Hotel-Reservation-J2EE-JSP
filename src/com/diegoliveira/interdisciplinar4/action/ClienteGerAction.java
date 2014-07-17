package com.diegoliveira.interdisciplinar4.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diegoliveira.interdisciplinar4.DAO.ClienteDAO;
import com.diegoliveira.interdisciplinar4.DO.ClienteDO;
import com.diegoliveira.interdisciplinar4.form.ClienteForm;

public class ClienteGerAction extends AbstractAction {

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// determine the action. values can be null, ‘save’, ‘update’, or
		// ‘cancel’
		String acao = (String) ((ClienteForm) form).getAcaoForm();
		// action2 can be either null, empty or contain ‘view’ or ‘delete’
		// comes directly from musiclist
		String acao2 = (String) request.getParameter("acaoForm");

		if (acao2 != null)
			if (!acao2.equals(""))
				acao = acao2; // replace action with action2 if action2 is not
								// empty

		// Cria um novo cliente
		if (acao == null | acao.equals("novo")) {
			ClienteDAO dao = new ClienteDAO();
			((ClienteForm) form).setEstados((ArrayList<String>) dao.getEstados());
			
			return map.findForward("novo");

			// Altera um cliente ja existente
		} else if (acao.equals("altera")) {
			int id = convertID((String) request.getParameter("codCliente"));
			if (id > 0) {
				ClienteDAO dao = new ClienteDAO();
				ClienteDO cliente = dao.procuraById(id);

				((ClienteForm) form).setCliente(cliente);
				((ClienteForm) form).setEstados((ArrayList<String>) dao.getEstados());
				((ClienteForm) form).setAcaoForm(acao);
			}

			return map.findForward("novo");

			// Remove um cliente
		} else if (acao.equals("remove")) {
			int id = convertID((String) request.getParameter("codCliente"));
			if (id > 0) {
				ClienteDAO dao = new ClienteDAO();
				ClienteDO cliente = new ClienteDO();
				cliente.setCodCliente(id);

				dao.remove(cliente);
			}

			return map.findForward("sucesso");

			// Cancela a criacao ou alteracao de um cliente
		} else if (acao.equals("cancela")) {

			return map.findForward("cancela");

			// Salva ou atualiza um cliente
		} else if (acao.equals("salva") | acao.equals("atualiza")) {
			ActionErrors errors = ((ClienteForm) form).validate(map, request);

			if (errors.isEmpty()) {
				ClienteForm formulario = ((ClienteForm) form);
				ClienteDO cliente = formulario.getCliente();

				ClienteDAO dao = new ClienteDAO();
				if (acao.equals("atualiza")) {
					dao.atualiza(cliente);
				} else {
					dao.salva(cliente);
				}

				return map.findForward("sucesso");
			} else {
				ClienteDAO dao = new ClienteDAO();
				((ClienteForm) form).setEstados((ArrayList<String>) dao.getEstados());
				
				saveErrors(request, errors);
				return map.findForward("falha");
			}
		}

		return map.findForward("novo");
	}
}