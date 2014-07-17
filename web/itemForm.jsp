<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function salva(){
    document.forms[0].acaoForm.value = 'salva';
    document.forms[0].submit();
}
function atualiza(){
    document.forms[0].acaoForm.value = 'atualiza';
    document.forms[0].submit();
}
function cancela(){
    document.forms[0].acaoForm.value = 'cancela';
    document.forms[0].submit();
}
-->
</script>
<c:if test="${param.acaoForm == 'novo' || param.acaoForm == 'salva'}">
	<h1>Novo Item</h1>
</c:if>
<c:if test="${param.acaoForm == 'altera' || param.acaoForm == 'atualiza'}">
	<h1>Alterar Item</h1>
</c:if>

<html:errors suffix="erro.erro2" prefix="erro.erro" />
<html:form action="/ItemGer" focus="nomeItem">
	<html:hidden property="acaoForm" />
	<html:hidden property="codItem" />
	<table cellpadding="2" width="70%" class="formulario">
		<tr>
			<td class="titulo">Nome do Item:</td>
			<td class="form"><html:text property="nomeItem"
				maxlength="255" size="35"></html:text></td>
		</tr>
		<tr>
		<tr>
			<td class="titulo" valign="top">Descrição do Item:</td>
			<td class="form"><html:textarea property="descricaoItem" rows="4" cols="34"></html:textarea></td>
		</tr>
		<tr>
			<td colspan="2" class="botoes">
			<div class="buttonwrapper">
			<div class="botoes"><c:choose>
				<c:when test="${param.codItem < 0}">
					<a href="javascript:salva();" class="ovalbutton"
						style="margin-right: 3px;"> <span>Salvar</span></a>
				</c:when>
				<c:otherwise>
					<a href="javascript:atualiza();" class="ovalbutton"
						style="margin-right: 3px;"> <span>Atualizar</span></a>
				</c:otherwise>
			</c:choose> <a href="javascript:cancela();" class="ovalbutton"
				style="margin-left: 10px;"> <span>Cancelar</span></a></div>
			</div>
			<td>
		</tr>
	</table>
</html:form>

</table>

<%@ include file="footer.jsp"%>