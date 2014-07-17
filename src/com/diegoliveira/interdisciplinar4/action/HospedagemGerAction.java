package com.diegoliveira.interdisciplinar4.action;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.diegoliveira.interdisciplinar4.DAO.ChaleDAO;
import com.diegoliveira.interdisciplinar4.DAO.ClienteDAO;
import com.diegoliveira.interdisciplinar4.DAO.HospedagemDAO;
import com.diegoliveira.interdisciplinar4.DAO.HospedagemDAO.Estado;
import com.diegoliveira.interdisciplinar4.DO.ChaleDO;
import com.diegoliveira.interdisciplinar4.DO.ClienteDO;
import com.diegoliveira.interdisciplinar4.DO.HospedagemDO;
import com.diegoliveira.interdisciplinar4.form.HospedagemForm;

public class HospedagemGerAction extends AbstractAction {

	public ActionForward execute(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// determine the action. values can be null, ‘save’, ‘update’, or
		// ‘cancel’
		String acao = (String) ((HospedagemForm) form).getAcaoForm();
		// action2 can be either null, empty or contain ‘view’ or ‘delete’
		// comes directly from musiclist
		String acao2 = (String) request.getParameter("acaoForm");

		if (acao2 != null)
			if (!acao2.equals(""))
				acao = acao2; // replace action with action2 if action2 is not
		// empty

		// Cria um novo hospedagem
		if (acao == null | acao.equals("novo")) {
			HospedagemDAO dao = new HospedagemDAO();
			ClienteDAO clienteDao = new ClienteDAO();
			ChaleDAO chaleDao = new ChaleDAO();

			// ((HospedagemForm) form).setClientes((ArrayList<ClienteDO>)
			// clienteDao.getLista());
			// ((HospedagemForm) form).setChales((ArrayList<ChaleDO>)
			// chaleDao.getLista());
			// ((HospedagemForm) form).setEstados((ArrayList<Estado>)
			// dao.getEstados());

			request.setAttribute("clientes", (ArrayList<ClienteDO>) clienteDao
					.getLista());
			request.setAttribute("chales", (ArrayList<ChaleDO>) chaleDao
					.getLista());
			request.setAttribute("estados", (ArrayList<Estado>) dao
					.getEstados());
			return map.findForward("novo");

		} else if (acao.equals("servicos")) {
			int id = convertID((String) request.getParameter("codHospedagem"));
			request.getSession().setAttribute("codHospedagem", id);

			return map.findForward("servicos");

			// Altera um hospedagem ja existente
		} else if (acao.equals("altera")) {
			int id = convertID((String) request.getParameter("codHospedagem"));
			if (id > 0) {
				HospedagemDAO dao = new HospedagemDAO();
				ClienteDAO clienteDao = new ClienteDAO();
				ChaleDAO chaleDao = new ChaleDAO();
				HospedagemDO hospedagem = dao.procuraById(id);

				if (hospedagem.getEstado() == HospedagemDO.ENCERRADA) {
					ActionErrors errors = new ActionErrors();
					errors.add("estado", new ActionMessage(
							"erro.hospedagem.altera.encerrada"));
					saveErrors(request, errors);

					return map.findForward("cancela");
				}

				((HospedagemForm) form).setHospedagem(hospedagem);
				request.setAttribute("clientes",
						(ArrayList<ClienteDO>) clienteDao.getLista());
				request.setAttribute("chales", (ArrayList<ChaleDO>) chaleDao
						.getLista());
				request.setAttribute("estados", (ArrayList<Estado>) dao
						.getEstados());
				// ((HospedagemForm) form).setClientes((ArrayList<ClienteDO>)
				// clienteDao.getLista());
				// ((HospedagemForm) form).setChales((ArrayList<ChaleDO>)
				// chaleDao.getLista());
				// ((HospedagemForm) form).setEstados((ArrayList<String>)
				// dao.getEstados());
				((HospedagemForm) form).setAcaoForm(acao);
			}

			return map.findForward("novo");

			// Remove um hospedagem
		} else if (acao.equals("remove")) {
			int id = convertID((String) request.getParameter("codHospedagem"));
			if (id > 0) {
				HospedagemDAO dao = new HospedagemDAO();
				HospedagemDO hospedagem = new HospedagemDO();
				hospedagem.setCodHospedagem(id);

				dao.remove(hospedagem);
			}

			return map.findForward("sucesso");

			// Cancela a criacao ou alteracao de um hospedagem
		} else if (acao.equals("encerra")) {

			return map.findForward("encerra");

		} else if (acao.equals("cancela")) {

			return map.findForward("cancela");

			// Salva ou atualiza um hospedagem
		} else if (acao.equals("salva") | acao.equals("atualiza")) {
			ActionErrors errors = ((HospedagemForm) form)
					.validate(map, request);

			if (errors.isEmpty()) {
				HospedagemDAO dao = new HospedagemDAO();
				HospedagemForm formulario = ((HospedagemForm) form);
				HospedagemDO hospedagem = formulario.getHospedagem();

				ChaleDAO cdao = new ChaleDAO();
				ChaleDO chale = cdao.procuraById(hospedagem.getCodChale());

				if (hospedagem.getEstacao() == HospedagemDO.BAIXAESTACAO)
					hospedagem.setDiaria(chale.getValorBaixaEstacao());
				else
					hospedagem.setDiaria(chale.getValorAltaEstacao());

				if (acao.equals("atualiza")) {
					HospedagemDO hospedagemAntiga = dao.procuraById(hospedagem
							.getCodHospedagem());
					if (hospedagemAntiga.getEstado() == HospedagemDO.ATIVA
							&& hospedagem.getEstado() == HospedagemDO.RESERVA) {
						errors = new ActionErrors();
						errors.add("estado", new ActionMessage(
								"erro.hospedagem.altera.estado"));

						return retornaFalha(map, request, errors);
					}
					if (dao.dataInvalidaExistente(hospedagem.getDataInicio(),
							hospedagem.getDataFim(), hospedagem.getCodChale(),
							hospedagem.getCodHospedagem())) {
						errors.add("dataInicio", new ActionMessage(
								"erro.hospedagem.dataInvalida"));

						return retornaFalha(map, request, errors);
					}
					dao.atualiza(hospedagem);
				} else {
					if (dao.dataInvalida(hospedagem.getDataInicio(), hospedagem
							.getDataFim(), hospedagem.getCodChale())) {
						errors.add("dataInicio", new ActionMessage(
								"erro.hospedagem.dataInvalida"));

						return retornaFalha(map, request, errors);
					}
					dao.salva(hospedagem);
				}

				return map.findForward("sucesso");
			} else {
				return retornaFalha(map, request, errors);
			}
		}

		return map.findForward("novo");
	}

	private ActionForward retornaFalha(ActionMapping map,
			HttpServletRequest request, ActionErrors errors)
			throws SQLException {
		saveErrors(request, errors);

		HospedagemDAO dao = new HospedagemDAO();
		ClienteDAO clienteDao = new ClienteDAO();
		ChaleDAO chaleDao = new ChaleDAO();

		request.setAttribute("clientes", (ArrayList<ClienteDO>) clienteDao
				.getLista());
		request
				.setAttribute("chales", (ArrayList<ChaleDO>) chaleDao
						.getLista());
		request.setAttribute("estados", (ArrayList<Estado>) dao.getEstados());
		return map.findForward("falha");
	}
}