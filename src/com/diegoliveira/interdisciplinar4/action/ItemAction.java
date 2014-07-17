package com.diegoliveira.interdisciplinar4.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.diegoliveira.interdisciplinar4.DAO.ItemDAO;
import com.diegoliveira.interdisciplinar4.DO.ItemDO;

public class ItemAction extends AbstractAction {
	private static final String AREA = "Item";

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String acao = (String) ((DynaActionForm) form).get("acao");

		if (acao.equals("novo")) {

			return map.findForward("novo");

			// Altera um item ja existente
		} else {

			ItemDAO dao = new ItemDAO();

			checaPaginacao(request, AREA);

			int pagina = 1;
			if (request.getSession().getAttribute("pagina") != null)
				pagina = Integer.parseInt((String) request.getSession()
						.getAttribute("pagina"));

			int totalregs = dao.count();

			String paginacao = paginacao(pagina, LIMITEPORPAGINA, totalregs, AREA);
			request.setAttribute("paginacao", paginacao);

			List<ItemDO> lista = dao.getListaPaginada((pagina - 1)
					* LIMITEPORPAGINA, LIMITEPORPAGINA);
			if (!lista.isEmpty()) {
				request.setAttribute("items", lista);
				return map.findForward("lista");
			} else {
				request.setAttribute("vazio", true);
				return map.findForward("listaVazia");
			}
		}
	}
}