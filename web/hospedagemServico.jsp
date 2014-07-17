<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function remove(){
	if (confirm("Deseja realmente apagar este registro?")){
    for(i = 0; i < document.forms[0].codHospedagemServico.length; i++){
	    if (document.forms[0].codHospedagemServico[i].checked) {
	        break;
	    }
    }
    var idHospedagem = document.forms[0].codHospedagemServico[i].value;
    
    document.forms[1].codHospedagemServico.value = idHospedagem;
	document.forms[1].acaoForm.value = 'remove';
    document.forms[1].submit();
  }
}
function aplicaServico(){
    document.forms[1].acaoForm.value = 'aplicaServico';
    document.forms[1].submit();
}
-->
</script>
<h1>Serviços do cliente: ${hospedagem.nomeCliente}</h1>

<c:if test="${vazio}">
	<div class="erro">Nenhum serviço cadastrado.</div>
	<br />
	<br />
</c:if>

<html:errors suffix="erro.erro2" prefix="erro.erro-espacado" />

<div class="buttonwrapper" style="margin-top: -30px;">
<div style="float: right; margin-bottom: 6px;"><a
	href="javascript:aplicaServico();" class="ovalbutton" style="margin-right: 3px;"><span>Novo</span></a>
<a
	href="javascript:remove();" class="ovalbutton"><span>Apagar</span></a></div>
</div>
<html:form action="HospedagemServico">
	<html:hidden name="acao" property="acao" value="" />
	<table width="100%" border="0" cellpadding="2" cellspacing="1"
		class="tabelaDeDados">
		<tr>
			<th width="4%" scope="col">&nbsp;</th>
			<th width="30%" scope="col">Serviço</th>
			<th width="15%" scope="col">Data</th>
			<th width="10%" scope="col">Valor</th>
		</tr>
		<!-- for -->
		<c:forEach var="hospedagemServico" items="${hospedagemServicos}" varStatus="id">
			<tr <c:if test="${id.count % 2 != 0}"> class="impar"</c:if>>
				<td>
				<div align="center"><input type="radio" name="codHospedagemServico"
					id="codHospedagemServico" value="${hospedagemServico.codHospedagemServico}"
					<c:if test="${id.count == 1}"> CHECKED</c:if> /></div>
				</td>
				<td>${hospedagemServico.nomeServico}</td>
				<td><fmt:formatDate type="both" value="${hospedagemServico.dataServico}" /></td>
				<td>R$ <fmt:formatNumber value="${hospedagemServico.valorServico}" 
            type="currency" minFractionDigits="2" 
                        maxFractionDigits="2" currencySymbol="" /></td>
			</tr>
		</c:forEach>
	</table>
</html:form>
<br />
<center>${paginacao}</center>
<html:form action="HospedagemServico">
	<html:hidden property="codHospedagemServico" value="" />
	<html:hidden property="codHospedagem" value="${codHospedagem}" />
	<html:hidden property="acaoForm" value="" />
</html:form>
<%@ include file="footer.jsp"%>
