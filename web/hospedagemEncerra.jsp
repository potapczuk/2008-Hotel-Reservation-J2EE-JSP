<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function encerrada(){
    document.forms[0].acaoForm.value = 'encerrada';
    document.forms[0].submit();
}
function cancela(){
    document.forms[0].acaoForm.value = 'cancela';
    document.forms[0].submit();
}
-->
</script>
	<h1>Encerrar Hospedagem</h1>

<html:errors suffix="erro.erro2" prefix="erro.erro" />
<html:form action="/HospedagemEncerra" focus="desconto">
	<html:hidden property="acaoForm" />
	<html:hidden property="codHospedagem" />
	<html:hidden name="valorTotal" property="valorTotal" value="${valorTotal}" />
	<table cellpadding="2" width="70%" class="formulario">
		<tr>
			<td class="titulo">Cliente:</td>
			<td class="form">${form.nomeCliente}</td>
		</tr>
		<tr>
			<td class="titulo">Chalé:</td>
			<td class="form">${form.nomeChale}</td>
		</tr>
		<tr>
			<td class="titulo">Data de Início:</td>
			<td class="form">${form.dataInicio}</td>
		</tr>
		<tr>
			<td class="titulo">Data de Término:</td>
			<td class="form">${form.dataFim}</td>
		</tr>
		<tr>
			<td class="titulo">Quantidade de pessoas:</td>
			<td class="form">${form.qtdPessoas}</td>
		</tr>
        <tr>
            <td class="titulo">Diária:</td>
            <td class="form">R$ <fmt:formatNumber value="${form.diaria}" 
            type="currency" minFractionDigits="2" 
                        maxFractionDigits="2" currencySymbol="" /></td>
        </tr>
        <tr>
            <td class="titulo">Valor hospedagem:</td>
            <td class="form">R$ <fmt:formatNumber value="${valorHospedagem}" 
            type="currency" minFractionDigits="2" 
                        maxFractionDigits="2" currencySymbol="" /></td>
        </tr>
        <tr>
            <td class="titulo">Serviços:</td>
            <td class="form">
                <c:forEach var="servico" items="${servicos}" varStatus="id">
                    ${servico.nomeServico} - R$ <fmt:formatNumber value="${servico.valorServico}" 
            type="currency" minFractionDigits="2" 
                        maxFractionDigits="2" currencySymbol="" /><br /> 
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td class="titulo">Valor total:</td>
            <td class="form">R$ <fmt:formatNumber value="${valorTotal}" 
            type="currency" minFractionDigits="2" 
                        maxFractionDigits="2" currencySymbol="" /></td>
        </tr>
        <tr>
            <td class="titulo">Desconto:</td>
            <td class="form"><html:text property="desconto"
                maxlength="2" size="3"></html:text>%</td>
        </tr>
		<tr>
			<td colspan="2" class="botoes">
			<div class="buttonwrapper">
			<div class="botoes"><a href="javascript:encerrada();"
				class="ovalbutton" style="margin-right: 3px;"> <span>Encerrar</span></a>
			<a href="javascript:cancela();" class="ovalbutton"
				style="margin-left: 10px;"> <span>Cancelar</span></a></div>
			</div>
			<td>
		</tr>
	</table>
</html:form>

</table>

<%@ include file="footer.jsp"%>