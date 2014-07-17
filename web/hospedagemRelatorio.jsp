<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%@ include file="header.jsp"%>

	<h1>Relatório da Hospedagem</h1>

<html:errors suffix="erro.erro2" prefix="erro.erro" />
	<table cellpadding="2" width="100%" class="relatorio">
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
			<td class="titulo">Qtd. de pessoas:</td>
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
            <td class="form">${form.desconto}%</td>
        </tr>
        <tr>
            <td class="titulo">Valor a pagar:</td>
            <td class="form">R$ <fmt:formatNumber value="${valorFinal}" 
            type="currency" minFractionDigits="2" 
                        maxFractionDigits="2" currencySymbol="" /></td>
        </tr>
	</table>
	<br />
	<br />
    <div class="buttonwrapper">
    <div class="botoes"><a href="<c:url value="/Hospedagem.do" />"
        class="ovalbutton" style="margin-right: 3px;"> <span>Continuar</span></a>
        </div>
    </div>

</table>

<%@ include file="footer.jsp"%>