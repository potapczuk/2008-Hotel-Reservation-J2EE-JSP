<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function novo(){
    document.forms[1].codHospedagem.value = '-1';
    document.forms[1].acaoForm.value = 'novo';
    document.forms[1].submit();
}

function altera(){
    for(i = 0; i < document.forms[0].codHospedagem.length; i++){
	    if (document.forms[0].codHospedagem[i].checked) {
	        break;
	    }
    }
    var idHospedagem = document.forms[0].codHospedagem[i].value;
    
    document.forms[1].codHospedagem.value = idHospedagem;
    document.forms[1].acaoForm.value = 'altera';
    document.forms[1].submit();
}
function remove(){
	if (confirm("Deseja realmente apagar este registro?")){
    for(i = 0; i < document.forms[0].codHospedagem.length; i++){
	    if (document.forms[0].codHospedagem[i].checked) {
	        break;
	    }
    }
    var idHospedagem = document.forms[0].codHospedagem[i].value;
    
    document.forms[1].codHospedagem.value = idHospedagem;
	document.forms[1].acaoForm.value = 'remove';
    document.forms[1].submit();
  }
}

function encerra(){
    for(i = 0; i < document.forms[0].codHospedagem.length; i++){
        if (document.forms[0].codHospedagem[i].checked) {
            break;
        }
    }
    var idHospedagem = document.forms[0].codHospedagem[i].value;
    
    document.forms[1].codHospedagem.value = idHospedagem;
    document.forms[1].acaoForm.value = 'encerra';
    document.forms[1].submit();
}
function servicos(){
    for(i = 0; i < document.forms[0].codHospedagem.length; i++){
        if (document.forms[0].codHospedagem[i].checked) {
            break;
        }
    }
    var idHospedagem = document.forms[0].codHospedagem[i].value;
    
    document.forms[1].codHospedagem.value = idHospedagem;
    document.forms[1].acaoForm.value = 'servicos';
    document.forms[1].submit();
}
-->
</script>
<h1>Hospedagens</h1>

<c:if test="${vazio}">
	<div class="erro">Nenhuma hospedagem cadastrado.</div>
	<br />
	<br />
</c:if>

<html:errors suffix="erro.erro2" prefix="erro.erro-espacado" />

<div class="buttonwrapper" style="margin-top: -30px;">
<div style="float: right; margin-bottom: 6px;"><a
	href="javascript:novo();" class="ovalbutton" style="margin-right: 3px;"><span>Novo</span></a>
<a href="javascript:altera();" class="ovalbutton"
	style="margin-right: 3px;"><span>Editar</span></a> <a
	href="javascript:remove();" class="ovalbutton"><span>Apagar</span></a></div>
</div>
<html:form action="Hospedagem">
	<html:hidden name="acao" property="acao" value="" />
	<table width="100%" border="0" cellpadding="2" cellspacing="1"
		class="tabelaDeDados">
		<tr>
			<th width="4%" scope="col">&nbsp;</th>
			<th width="30%" scope="col">Cliente</th>
			<th width="15%" scope="col">Chalé</th>
			<th width="10%" scope="col">Estado</th>
			<th width="6%" scope="col">Início</th>
			<th width="6%" scope="col">Término</th>
			<th width="6%" scope="col">Pessoas</th>
		</tr>
		<!-- for -->
		<c:forEach var="hospedagem" items="${hospedagems}" varStatus="id">
			<tr <c:if test="${id.count % 2 != 0}"> class="impar"</c:if>>
				<td>
				<div align="center"><input type="radio" name="codHospedagem"
					id="codHospedagem" value="${hospedagem.codHospedagem}"
					<c:if test="${id.count == 1}"> CHECKED</c:if> /></div>
				</td>
				<td>${hospedagem.nomeCliente}</td>
				<td>${hospedagem.nomeChale}</td>
				<td>${hospedagem.tipoEstado}</td>
				<td>${hospedagem.dataInicioFormatado}</td>
				<td>${hospedagem.dataFimFormatado}</td>
				<td>${hospedagem.qtdPessoas}</td>
			</tr>
		</c:forEach>
	</table>
</html:form>
<br />
<div class="buttonwrapper" style="margin-top: -6px;">
<div style="float: right; margin-bottom: 6px;"><a
	href="javascript:servicos();" class="ovalbutton"
	style="margin-right: 3px;"><span>Serviços</span></a> <a
	href="javascript:encerra();" class="ovalbutton"
	style="margin-right: 3px;"><span>Encerrar hospedagem</span></a></div>
</div>
<center>${paginacao}</center>
<html:form action="HospedagemGer">
	<html:hidden property="codHospedagem" value="" />
	<html:hidden property="acaoForm" value="" />
</html:form>
<%@ include file="footer.jsp"%>
