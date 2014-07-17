package com.diegoliveira.interdisciplinar4.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diegoliveira.interdisciplinar4.DAO.ItemDAO;
import com.diegoliveira.interdisciplinar4.DO.ItemDO;
import com.diegoliveira.interdisciplinar4.form.ItemForm;

public class ItemGerAction extends AbstractAction {

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// determine the action. values can be null, ‘save’, ‘update’, or
		// ‘cancel’
		String acao = (String) ((ItemForm) form).getAcaoForm();
		// action2 can be either null, empty or contain ‘view’ or ‘delete’
		// comes directly from musiclist
		String acao2 = (String) request.getParameter("acaoForm");

		if (acao2 != null)
			if (!acao2.equals(""))
				acao = acao2; // replace action with action2 if action2 is not
								// empty

		// Cria um novo item
		if (acao == null | acao.equals("novo")) {

			return map.findForward("novo");

			// Altera um item ja existente
		} else if (acao.equals("altera")) {
			int id = convertID((String) request.getParameter("codItem"));
			if (id > 0) {
				ItemDAO dao = new ItemDAO();
				ItemDO item = dao.procuraById(id);

				((ItemForm) form).setItem(item);
				((ItemForm) form).setAcaoForm(acao);
			}

			return map.findForward("novo");

			// Remove um item
		} else if (acao.equals("remove")) {
			int id = convertID((String) request.getParameter("codItem"));
			if (id > 0) {
				ItemDAO dao = new ItemDAO();
				ItemDO item = new ItemDO();
				item.setCodItem(id);

				dao.remove(item);
			}

			return map.findForward("sucesso");

			// Cancela a criacao ou alteracao de um item
		} else if (acao.equals("cancela")) {

			return map.findForward("cancela");

			// Salva ou atualiza um item
		} else if (acao.equals("salva") | acao.equals("atualiza")) {
			ActionErrors errors = ((ItemForm) form).validate(map, request);

			if (errors.isEmpty()) {
				ItemForm formulario = ((ItemForm) form);
				ItemDO item = formulario.getItem();

				ItemDAO dao = new ItemDAO();
				if (acao.equals("atualiza")) {
					dao.atualiza(item);
				} else {
					dao.salva(item);
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