<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function aplicar(){
    document.forms[0].acaoForm.value = 'aplicado';
    document.forms[0].submit();
}
function cancela(){
    document.forms[0].acaoForm.value = 'cancela';
    document.forms[0].submit();
}
-->
</script>
<h1>Aplicar Serviço</h1>

<html:errors suffix="erro.erro2" prefix="erro.erro" />
<html:form action="/HospedagemServicoAplica" focus="codServico">
	<html:hidden property="acaoForm" />
	<html:hidden property="codHospedagem" />
	<table cellpadding="2" width="70%" class="formulario">
		<tr>
			<td class="titulo">Cliente:</td>
			<td class="form">${cliente.nomeCliente}</td>
		</tr>
		<tr>
			<td class="titulo">Chalé:</td>
			<td class="form">Chalé ${chale.codChale}</td>
		</tr>
		<tr>
			<td class="titulo">Serviço:</td>
			<td class="form"><html:select property="codServico">
				<html:options collection="servicos" property="codServico"
					labelProperty="nomeServico" />
			</html:select></td>
		</tr>
		<tr>
			<td colspan="2" class="botoes">
			<div class="buttonwrapper">
			<div class="botoes"><a href="javascript:aplicar();"
				class="ovalbutton" style="margin-right: 3px;"> <span>Aplicar</span></a>

			<a href="javascript:cancela();" class="ovalbutton"
				style="margin-left: 10px;"> <span>Cancelar</span></a></div>
			</div>
			<td>
		</tr>
	</table>
</html:form>

</table>

<%@ include file="footer.jsp"%>