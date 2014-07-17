package com.diegoliveira.interdisciplinar4.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

import com.diegoliveira.interdisciplinar4.DAO.HospedagemDAO;
import com.diegoliveira.interdisciplinar4.DAO.HospedagemServicoDAO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemServicoDO;

public class HospedagemServicoAction extends AbstractAction {
	private static final String AREA = "HospedagemServico";

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String acao = (String) ((DynaActionForm) form).get("acaoForm");
		int codHospedagem = Integer.parseInt((String)((DynaActionForm) form).get("codHospedagem"));

		if (acao.equals("remove")) {
			int id = convertID((String) request.getParameter("codHospedagemServico"));
			if (id > 0) {
				HospedagemServicoDAO dao = new HospedagemServicoDAO();
				HospedagemServicoDO hospedagem = new HospedagemServicoDO();
				hospedagem.setCodHospedagemServico(id);

				dao.remove(hospedagem);
			}

			return map.findForward("sucesso");
		} else if (acao.equals("aplicaServico")){
			
			return map.findForward("aplicaServico");
		} else {			
			HospedagemServicoDAO dao = new HospedagemServicoDAO();
			HospedagemDAO hdao = new HospedagemDAO();
			
			HospedagemDO hospedagem = hdao.procuraById((Integer) request.getSession().getAttribute("codHospedagem"));
			
			if(hospedagem.getEstado() != HospedagemDO.ATIVA){
				ActionErrors errors = new ActionErrors();
				errors.add("estado", new ActionMessage("erro.hospedagem.servicos.estado"));
				saveErrors(request, errors);
				return map.findForward("cancela");
			}
			
			request.setAttribute("hospedagem", hospedagem);

			checaPaginacao(request, AREA);

			int pagina = 1;
			if (request.getSession().getAttribute("pagina") != null)
				pagina = Integer.parseInt((String) request.getSession()
						.getAttribute("pagina"));

			int totalregs = dao.count("hospedagem_servico", codHospedagem);

			String paginacao = paginacao(pagina, LIMITEPORPAGINA, totalregs, AREA);
			request.setAttribute("paginacao", paginacao);

			List<HospedagemServicoDO> lista = dao.getListaPaginada(codHospedagem, (pagina - 1)
					* LIMITEPORPAGINA, LIMITEPORPAGINA);
			if (!lista.isEmpty()) {
				request.setAttribute("hospedagemServicos", lista);
				return map.findForward("lista");
			} else {
				request.setAttribute("vazio", true);
				return map.findForward("listaVazia");
			}
		}
	}
}