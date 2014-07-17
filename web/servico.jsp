<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function novo(){
    document.forms[1].codServico.value = '-1';
    document.forms[1].acaoForm.value = 'novo';
    document.forms[1].submit();
}

function altera(){
    for(i = 0; i < document.forms[0].codServico.length; i++){
	    if (document.forms[0].codServico[i].checked) {
	        break;
	    }
    }
    var idServico = document.forms[0].codServico[i].value;
    
    document.forms[1].codServico.value = idServico;
    document.forms[1].acaoForm.value = 'altera';
    document.forms[1].submit();
}
function remove(){
	if (confirm("Deseja realmente apagar este registro?")){
    for(i = 0; i < document.forms[0].codServico.length; i++){
	    if (document.forms[0].codServico[i].checked) {
	        break;
	    }
    }
    var idServico = document.forms[0].codServico[i].value;
    
    document.forms[1].codServico.value = idServico;
	document.forms[1].acaoForm.value = 'remove';
    document.forms[1].submit();
  }
}
-->
</script>
<h1>Serviços</h1>

<c:if test="${vazio}">
	<div class="erro">Nenhum serviço cadastrado.</div>
	<br />
	<br />
</c:if>
<c:if test="${!vazio}">
<html:errors suffix="erro.erro2" prefix="erro.erro-espacado" />

<div class="buttonwrapper" style="margin-top: -30px;">
<div style="float: right; margin-bottom: 6px;"><a
	href="javascript:novo();" class="ovalbutton"
	style="margin-right: 3px;"><span>Novo</span></a> <a
	href="javascript:altera();" class="ovalbutton"
	style="margin-right: 3px;"><span>Editar</span></a> <a
	href="javascript:remove();" class="ovalbutton"><span>Apagar</span></a></div>
</div>
<html:form action="Servico">
	<html:hidden name="acao" property="acao" value="" />
	<table width="100%" border="0" cellpadding="2" cellspacing="1"
		class="tabelaDeDados">
		<tr>
			<th width="4%" scope="col">&nbsp;</th>
			<th width="10%" scope="col">Código</th>
			<th width="70%" scope="col">Nome do serviço</th>
			<th width="20%" scope="col">Valor</th>
		</tr>
		<!-- for -->
		<c:forEach var="servico" items="${servicos}" varStatus="id">
			<tr <c:if test="${id.count % 2 != 0}"> class="impar"</c:if>>
				<td>
				<div align="center"><input type="radio"
					name="codServico" id="codServico"
					value="${servico.codServico}"
					<c:if test="${id.count == 1}"> CHECKED</c:if> /></div>
				</td>
				<td>${servico.codServico}</td>
				<td>${servico.nomeServico}</td>
				<td>R$ <fmt:formatNumber value="${servico.valorServico}" 
            type="currency" minFractionDigits="2" 
                        maxFractionDigits="2" currencySymbol="" /></td>
			</tr>
		</c:forEach>
	</table>
</html:form>
<br />
<center>${paginacao}</center>
<html:form action="ServicoGer">
<html:hidden property="codServico" value=""/>
<html:hidden property="acaoForm" value=""/>
</html:form>
</c:if>
<%@ include file="footer.jsp"%>
