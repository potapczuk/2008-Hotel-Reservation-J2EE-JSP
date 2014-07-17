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
	<h1>Novo Cliente</h1>
</c:if>
<c:if test="${param.acaoForm == 'altera' || param.acaoForm == 'atualiza'}">
	<h1>Alterar Cliente</h1>
</c:if>

<html:errors suffix="erro.erro2" prefix="erro.erro" />
<html:form action="/ClienteGer" focus="nomeCliente">
	<html:hidden property="acaoForm" />
	<html:hidden property="codCliente" />
	<table cellpadding="2" width="70%" class="formulario">
		<tr>
			<td class="titulo">Nome:</td>
			<td class="form"><html:text property="nomeCliente"
				maxlength="100" size="35"></html:text></td>
		</tr>
		<tr>
		<tr>
			<td class="titulo">RG:</td>
			<td class="form"><html:text property="rgCliente" maxlength="16"
				size="16"></html:text></td>
		</tr>
		<tr>
			<td class="titulo">Data de Nascimento:</td>
			<td class="form"><html:text property="nascimentoCliente"
				maxlength="10" size="10"></html:text> ex. 30/12/2008</td>
		</tr>
		<tr>
			<td class="titulo">Endereço:</td>
			<td class="form"><html:text property="enderecoCliente"
				maxlength="150" size="35"></html:text></td>
		</tr>
		<tr>
			<td class="titulo">Bairro:</td>
			<td class="form"><html:text property="bairroCliente"
				maxlength="100" size="35"></html:text></td>
		</tr>
		<tr>
			<td class="titulo">Cidade:</td>
			<td class="form"><html:text property="cidadeCliente"
				maxlength="100" size="35"></html:text></td>
		</tr>
		<tr>
			<td class="titulo">Estado:</td>
			<td class="form"><html:select property="estadoCliente">
                    <html:options property="estados" />
                </html:select></td>
		</tr>
		<tr>
			<td class="titulo">CEP:</td>
			<td class="form"><html:text property="CEPCliente" maxlength="9"
				size="10"></html:text> ex. 99999-999</td>
		</tr>
		<tr>
			<td class="titulo">Telefone Residencial:</td>
			<td class="form"><html:text property="telefoneResidencial"
				maxlength="14" size="14"></html:text> ex. (71) 3333-3333</td>
		</tr>
		<tr>
			<td class="titulo">Telefone Comercial:</td>
			<td class="form"><html:text property="telefoneComercial"
				maxlength="14" size="14"></html:text> ex. (71) 3333-3333</td>
		</tr>
		<tr>
			<td class="titulo">Telefone Celular:</td>
			<td class="form"><html:text property="telefoneCelular"
				maxlength="14" size="14"></html:text> ex. (71) 3333-3333</td>
		</tr>
		<tr>
			<td colspan="2" class="botoes">
			<div class="buttonwrapper">
			<div class="botoes"><c:choose>
				<c:when test="${param.codCliente < 0}">
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