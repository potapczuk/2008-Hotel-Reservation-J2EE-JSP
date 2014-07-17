package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hospedagemRelatorio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ferrors_005fsuffix_005fprefix_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ferrors_005fsuffix_005fprefix_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005ferrors_005fsuffix_005fprefix_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Sistema de Controle de Pousada</title>\r\n");
      out.write("<link href=\"estilo.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("  <div id=\"header\">\r\n");
      out.write("     \r\n");
      out.write("    <ul class=\"glossymenu\">\r\n");
      out.write("        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"><b>Hospedagens</b></a></li>\r\n");
      out.write("        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"><b>Clientes</b></a></li>\r\n");
      out.write("        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"><b>Chalés</b></a></li>\t\r\n");
      out.write("        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"><b>Itens</b></a></li>\t\r\n");
      out.write("        <li><a href=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"><b>Serviços</b></a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("     \r\n");
      out.write("  </div>\r\n");
      out.write("  <div id=\"mainContent\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h1>Relatório da Hospedagem</h1>\r\n");
      out.write("\r\n");
      if (_jspx_meth_html_005ferrors_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<table cellpadding=\"2\" width=\"100%\" class=\"relatorio\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"titulo\">Cliente:</td>\r\n");
      out.write("\t\t\t<td class=\"form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form.nomeCliente}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"titulo\">Chalé:</td>\r\n");
      out.write("\t\t\t<td class=\"form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form.nomeChale}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"titulo\">Data de Início:</td>\r\n");
      out.write("\t\t\t<td class=\"form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form.dataInicio}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"titulo\">Data de Término:</td>\r\n");
      out.write("\t\t\t<td class=\"form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form.dataFim}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"titulo\">Qtd. de pessoas:</td>\r\n");
      out.write("\t\t\t<td class=\"form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form.qtdPessoas}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"titulo\">Diária:</td>\r\n");
      out.write("            <td class=\"form\">R$ ");
      if (_jspx_meth_fmt_005fformatNumber_005f0(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"titulo\">Valor hospedagem:</td>\r\n");
      out.write("            <td class=\"form\">R$ ");
      if (_jspx_meth_fmt_005fformatNumber_005f1(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"titulo\">Serviços:</td>\r\n");
      out.write("            <td class=\"form\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"titulo\">Valor total:</td>\r\n");
      out.write("            <td class=\"form\">R$ ");
      if (_jspx_meth_fmt_005fformatNumber_005f3(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"titulo\">Desconto:</td>\r\n");
      out.write("            <td class=\"form\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form.desconto}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("%</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"titulo\">Valor a pagar:</td>\r\n");
      out.write("            <td class=\"form\">R$ ");
      if (_jspx_meth_fmt_005fformatNumber_005f4(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("    <div class=\"buttonwrapper\">\r\n");
      out.write("    <div class=\"botoes\"><a href=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\"\r\n");
      out.write("        class=\"ovalbutton\" style=\"margin-right: 3px;\"> <span>Continuar</span></a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("    <!-- end #mainContent --></div>\r\n");
      out.write("  <div id=\"footer\">\r\n");
      out.write("  <!-- end #footer --></div>\r\n");
      out.write("<!-- end #container --></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /header.jsp(15,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/Hospedagem.do");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /header.jsp(16,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/Cliente.do");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /header.jsp(17,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/Chale.do");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /header.jsp(18,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/Item.do");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /header.jsp(19,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/Servico.do");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_html_005ferrors_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:errors
    org.apache.struts.taglib.html.ErrorsTag _jspx_th_html_005ferrors_005f0 = (org.apache.struts.taglib.html.ErrorsTag) _005fjspx_005ftagPool_005fhtml_005ferrors_005fsuffix_005fprefix_005fnobody.get(org.apache.struts.taglib.html.ErrorsTag.class);
    _jspx_th_html_005ferrors_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005ferrors_005f0.setParent(null);
    // /hospedagemRelatorio.jsp(9,0) name = suffix type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ferrors_005f0.setSuffix("erro.erro2");
    // /hospedagemRelatorio.jsp(9,0) name = prefix type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ferrors_005f0.setPrefix("erro.erro");
    int _jspx_eval_html_005ferrors_005f0 = _jspx_th_html_005ferrors_005f0.doStartTag();
    if (_jspx_th_html_005ferrors_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ferrors_005fsuffix_005fprefix_005fnobody.reuse(_jspx_th_html_005ferrors_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ferrors_005fsuffix_005fprefix_005fnobody.reuse(_jspx_th_html_005ferrors_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f0.setParent(null);
    // /hospedagemRelatorio.jsp(33,32) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${form.diaria}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /hospedagemRelatorio.jsp(33,32) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setType("currency");
    // /hospedagemRelatorio.jsp(33,32) name = minFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setMinFractionDigits(2);
    // /hospedagemRelatorio.jsp(33,32) name = maxFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setMaxFractionDigits(2);
    // /hospedagemRelatorio.jsp(33,32) name = currencySymbol type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setCurrencySymbol("");
    int _jspx_eval_fmt_005fformatNumber_005f0 = _jspx_th_fmt_005fformatNumber_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f1.setParent(null);
    // /hospedagemRelatorio.jsp(39,32) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${valorHospedagem}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /hospedagemRelatorio.jsp(39,32) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f1.setType("currency");
    // /hospedagemRelatorio.jsp(39,32) name = minFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f1.setMinFractionDigits(2);
    // /hospedagemRelatorio.jsp(39,32) name = maxFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f1.setMaxFractionDigits(2);
    // /hospedagemRelatorio.jsp(39,32) name = currencySymbol type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f1.setCurrencySymbol("");
    int _jspx_eval_fmt_005fformatNumber_005f1 = _jspx_th_fmt_005fformatNumber_005f1.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /hospedagemRelatorio.jsp(46,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("servico");
    // /hospedagemRelatorio.jsp(46,16) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${servicos}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /hospedagemRelatorio.jsp(46,16) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("id");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${servico.nomeServico}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(" - R$ ");
          if (_jspx_meth_fmt_005fformatNumber_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("<br /> \r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /hospedagemRelatorio.jsp(47,48) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${servico.valorServico}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /hospedagemRelatorio.jsp(47,48) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f2.setType("currency");
    // /hospedagemRelatorio.jsp(47,48) name = minFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f2.setMinFractionDigits(2);
    // /hospedagemRelatorio.jsp(47,48) name = maxFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f2.setMaxFractionDigits(2);
    // /hospedagemRelatorio.jsp(47,48) name = currencySymbol type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f2.setCurrencySymbol("");
    int _jspx_eval_fmt_005fformatNumber_005f2 = _jspx_th_fmt_005fformatNumber_005f2.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f2);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f3 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f3.setParent(null);
    // /hospedagemRelatorio.jsp(55,32) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${valorTotal}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /hospedagemRelatorio.jsp(55,32) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f3.setType("currency");
    // /hospedagemRelatorio.jsp(55,32) name = minFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f3.setMinFractionDigits(2);
    // /hospedagemRelatorio.jsp(55,32) name = maxFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f3.setMaxFractionDigits(2);
    // /hospedagemRelatorio.jsp(55,32) name = currencySymbol type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f3.setCurrencySymbol("");
    int _jspx_eval_fmt_005fformatNumber_005f3 = _jspx_th_fmt_005fformatNumber_005f3.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f3);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f4 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f4.setParent(null);
    // /hospedagemRelatorio.jsp(65,32) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${valorFinal}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /hospedagemRelatorio.jsp(65,32) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f4.setType("currency");
    // /hospedagemRelatorio.jsp(65,32) name = minFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f4.setMinFractionDigits(2);
    // /hospedagemRelatorio.jsp(65,32) name = maxFractionDigits type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f4.setMaxFractionDigits(2);
    // /hospedagemRelatorio.jsp(65,32) name = currencySymbol type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f4.setCurrencySymbol("");
    int _jspx_eval_fmt_005fformatNumber_005f4 = _jspx_th_fmt_005fformatNumber_005f4.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_005fvalue_005ftype_005fminFractionDigits_005fmaxFractionDigits_005fcurrencySymbol_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /hospedagemRelatorio.jsp(73,33) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/Hospedagem.do");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }
}
