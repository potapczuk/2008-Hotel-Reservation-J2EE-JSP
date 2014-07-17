<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function novo(){
    document.forms[1].codItem.value = '-1';
    document.forms[1].acaoForm.value = 'novo';
    document.forms[1].submit();
}

function altera(){
    for(i = 0; i < document.forms[0].codItem.length; i++){
	    if (document.forms[0].codItem[i].checked) {
	        break;
	    }
    }
    var idItem = document.forms[0].codItem[i].value;
    
    document.forms[1].codItem.value = idItem;
    document.forms[1].acaoForm.value = 'altera';
    document.forms[1].submit();
}
function remove(){
	if (confirm("Deseja realmente apagar este registro?")){
    for(i = 0; i < document.forms[0].codItem.length; i++){
	    if (document.forms[0].codItem[i].checked) {
	        break;
	    }
    }
    var idItem = document.forms[0].codItem[i].value;
    
    document.forms[1].codItem.value = idItem;
	document.forms[1].acaoForm.value = 'remove';
    document.forms[1].submit();
  }
}
-->
</script>
<h1>Itens</h1>

<c:if test="${vazio}">
	<div class="erro">Nenhum item cadastrado.</div>
	<br />
	<br />
</c:if>

<html:errors suffix="erro.erro2" prefix="erro.erro-espacado" />

<div class="buttonwrapper" style="margin-top: -30px;">
<div style="float: right; margin-bottom: 6px;"><a
	href="javascript:novo();" class="ovalbutton"
	style="margin-right: 3px;"><span>Novo</span></a> <a
	href="javascript:altera();" class="ovalbutton"
	style="margin-right: 3px;"><span>Editar</span></a> <a
	href="javascript:remove();" class="ovalbutton"><span>Apagar</span></a></div>
</div>
<html:form action="Item">
	<html:hidden name="acao" property="acao" value="" />
	<table width="100%" border="0" cellpadding="2" cellspacing="1"
		class="tabelaDeDados">
		<tr>
			<th width="4%" scope="col">&nbsp;</th>
			<th width="10%" scope="col">Código</th>
			<th width="80%" scope="col">Nome do item</th>
		</tr>
		<!-- for -->
		<c:forEach var="item" items="${items}" varStatus="id">
			<tr <c:if test="${id.count % 2 != 0}"> class="impar"</c:if>>
				<td>
				<div align="center"><input type="radio"
					name="codItem" id="codItem"
					value="${item.codItem}"
					<c:if test="${id.count == 1}"> CHECKED</c:if> /></div>
				</td>
				<td>${item.codItem}</td>
				<td>${item.nomeItem}</td>
			</tr>
		</c:forEach>
	</table>
</html:form>
<br />
<center>${paginacao}</center>
<html:form action="ItemGer">
<html:hidden property="codItem" value=""/>
<html:hidden property="acaoForm" value=""/>
</html:form>
<%@ include file="footer.jsp"%>
