package com.diegoliveira.interdisciplinar4.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.diegoliveira.interdisciplinar4.DAO.ChaleDAO;
import com.diegoliveira.interdisciplinar4.DAO.ChaleItemDAO;
import com.diegoliveira.interdisciplinar4.DAO.ItemDAO;
import com.diegoliveira.interdisciplinar4.DO.ChaleDO;
import com.diegoliveira.interdisciplinar4.DO.ItemDO;
import com.diegoliveira.interdisciplinar4.form.ChaleForm;

public class ChaleGerAction extends AbstractAction {

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// determine the action. values can be null, ‘save’, ‘update’, or
		// ‘cancel’
		String acao = (String) ((ChaleForm) form).getAcaoForm();
		// action2 can be either null, empty or contain ‘view’ or ‘delete’
		// comes directly from musiclist
		String acao2 = (String) request.getParameter("acaoForm");

		if (acao2 != null)
			if (!acao2.equals(""))
				acao = acao2; // replace action with action2 if action2 is not
								// empty

		// Cria um novo chale
		if (acao == null | acao.equals("novo")) {
			
			ItemDAO ItemDao = new ItemDAO();
			
			request.setAttribute("itensChale", new ArrayList<ItemDO>());
			request.setAttribute("itensNaoChale", (ArrayList<ItemDO>) ItemDao.getLista());

			return map.findForward("novo");

			// Altera um chale ja existente
		} else if (acao.equals("altera")) {
			int id = convertID((String) request.getParameter("codChale"));
			if (id > 0) {
				ChaleDAO dao = new ChaleDAO();
				ChaleDO chale = dao.procuraById(id);
				
				ItemDAO ItemDao = new ItemDAO();
				request.setAttribute("itensChale", (ArrayList<ItemDO>) ItemDao.getListaItensNoChale(id));
				request.setAttribute("itensNaoChale", (ArrayList<ItemDO>) ItemDao.getListaItensForaDoChale(id));

				((ChaleForm) form).setChale(chale);
				((ChaleForm) form).setAcaoForm(acao);
			}

			return map.findForward("novo");

			// Remove um chale
		} else if (acao.equals("remove")) {
			int id = convertID((String) request.getParameter("codChale"));
			if (id > 0) {
				ChaleDAO dao = new ChaleDAO();
				ChaleDO chale = new ChaleDO();
				chale.setCodChale(id);
				
				ChaleItemDAO cdao = new ChaleItemDAO();
				cdao.removeByChale(id);

				dao.remove(chale);
			}

			return map.findForward("sucesso");

			// Cancela a criacao ou alteracao de um chale
		} else if (acao.equals("cancela")) {

			return map.findForward("cancela");

			// Salva ou atualiza um chale
		} else if (acao.equals("salva") | acao.equals("atualiza")) {
			ActionErrors errors = ((ChaleForm) form).validate(map, request);

			if (errors.isEmpty()) {
				ChaleForm formulario = ((ChaleForm) form);
				ChaleDO chale = formulario.getChale();
				ChaleItemDAO cdao = new ChaleItemDAO();

				ChaleDAO dao = new ChaleDAO();
				if (acao.equals("atualiza")) {
					cdao.removeByChale(chale.getCodChale());
					dao.atualiza(chale);
				} else {
					dao.salva(chale);
					chale.setCodChale(dao.getLastID());
				}
				if(formulario.getCodItens() != null){
					for(String codItemStr : formulario.getCodItens()){
						cdao.salva(chale.getCodChale(), Integer.parseInt(codItemStr));
					}
				}

				return map.findForward("sucesso");
			} else {
				saveErrors(request, errors);
				
				ItemDAO ItemDao = new ItemDAO();
				
				if (acao.equals("atualiza")) {
					ChaleForm formulario = ((ChaleForm) form);
					ChaleDO chale = formulario.getChale();
					
					int id = chale.getCodChale();
					
					request.setAttribute("itensChale", (ArrayList<ItemDO>) ItemDao.getListaItensNoChale(id));
					request.setAttribute("itensNaoChale", (ArrayList<ItemDO>) ItemDao.getListaItensForaDoChale(id));
				} else {
					request.setAttribute("itensChale", new ArrayList<ItemDO>());
					request.setAttribute("itensNaoChale", (ArrayList<ItemDO>) ItemDao.getLista());
				}
				
				return map.findForward("falha");
			}
		}

		return map.findForward("novo");
	}
}