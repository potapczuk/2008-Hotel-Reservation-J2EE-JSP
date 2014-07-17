package com.diegoliveira.interdisciplinar4.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;

public class AbstractAction extends Action {
	protected int LIMITEPORPAGINA = 15;

	protected void checaPaginacao(HttpServletRequest request, String area) {
		if (request.getSession().getAttribute("areaAtual") == null
				|| (request.getSession().getAttribute("areaAtual") != null && !request
						.getSession().getAttribute("areaAtual").equals(area))) {
			request.getSession().setAttribute("areaAtual", area);
			request.getSession().setAttribute("pagina", "1");
		}

		if (request.getParameter("pagina") != null)
			request.getSession().setAttribute("pagina",
					request.getParameter("pagina"));
	}

	protected String paginacao(int pagina, int limitePorPagina, int totalregs, String area) {

		int totalpgs = Math.round(totalregs / limitePorPagina);
		if ((totalregs % limitePorPagina) > 0)
			totalpgs++;

		String paginacao = "";
		if (pagina > 1) {
			paginacao += "[ <b><a href=\""+area+".do?pagina=1\">Primeira Página</a></b> ] ";
			paginacao += "[ <b><a href=\""+area+".do?pagina=" + (pagina - 1)
					+ "\">Anterior</a></b> ] ";
		}

		if (pagina < totalpgs) {
			paginacao += "[ <b><a href=\""+area+".do?pagina=" + (pagina + 1)
					+ "\">Próxima</a></b> ] ";
			paginacao += "[ <b><a href=\""+area+".do?pagina=" + totalpgs
					+ "\">Ultima</a></b> ]";
		}

		return paginacao;
	}

	protected int convertID(String id) {
		int idNum = 0;
		if (id != null)// id should contain the id of the album to delete
			if (!id.equals(""))// then user is request to delete an album
			{
				// convert the String id to int id
				try {
					idNum = Integer.parseInt(id);
				} catch (NumberFormatException nfe) {
					// TODO Registrar mensagem de erro
					System.out.println(nfe.getLocalizedMessage());
				}
			}
		return idNum;
	}
}
