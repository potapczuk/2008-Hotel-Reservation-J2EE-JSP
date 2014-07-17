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
	<h1>Nova Hospedagem</h1>
</c:if>
<c:if test="${param.acaoForm == 'altera' || param.acaoForm == 'atualiza'}">
	<h1>Alterar Hospedagem</h1>
</c:if>

<html:errors suffix="erro.erro2" prefix="erro.erro" />
<html:form action="/HospedagemGer" focus="nomeHospedagem">
	<html:hidden property="acaoForm" />
	<html:hidden property="codHospedagem" />
	<table cellpadding="2" width="70%" class="formulario">
		<tr>
			<td class="titulo">Cliente:</td>
			<td class="form">
                <html:select property="codCliente" >
                    <html:options collection="clientes" property="codCliente" labelProperty="nomeCliente" />
                </html:select>
            </td>
		</tr>
		<tr>
			<td class="titulo">Chalé:</td>
			<td class="form">
                <html:select property="codChale">
                    <html:options collection="chales" property="codChale" labelProperty="nomeChale" />
                </html:select>
            </td>
		</tr>
    <tr>
        <td class="titulo">Estado:</td>
        <td class="form">
            <html:select property="estado">
                    <html:options collection="estados" property="id" labelProperty="tipo" />
                </html:select>
        </td>
    </tr>
    <tr>
        <td class="titulo">Data de Início:</td>
        <td class="form"><html:text property="dataInicio" maxlength="10" size="10"></html:text> ex. 30/12/2008</td>
    </tr>
    <tr>
        <td class="titulo">Data de Término:</td>
        <td class="form"><html:text property="dataFim" maxlength="10" size="10"></html:text> ex. 30/12/2008</td>
    </tr>
    <tr>
        <td class="titulo">Quantidade de pessoas:</td>
        <td class="form"><html:text property="qtdPessoas" maxlength="5" size="5"></html:text></td>
    </tr>
		<tr>
			<td colspan="2" class="botoes">
			<div class="buttonwrapper">
			<div class="botoes"><c:choose>
				<c:when test="${param.codHospedagem < 0}">
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