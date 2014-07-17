<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%@ include file="header.jsp"%>
<script language="javascript" type="text/javascript">
<!--
function salva(){
    preparaItenParaEnvio();
    document.forms[0].acaoForm.value = 'salva';
    document.forms[0].submit();
}
function atualiza(){
    preparaItenParaEnvio();
    document.forms[0].acaoForm.value = 'atualiza';
    document.forms[0].submit();
}

function preparaItenParaEnvio() {
    var fonte = document.getElementById('codItens');

    for(i = 0; i < fonte.length; i++) {
        fonte[i].selected = true;
    }
}

function cancela(){
    document.forms[0].acaoForm.value = 'cancela';
    document.forms[0].submit();
}
function adicionaItem(){
    trocaItens('codTodosItens', 'codItens');
}

function removeItem(){
    trocaItens('codItens', 'codTodosItens');
}

function trocaItens(ini, fim){
    var fonte = document.getElementById(ini);
    var destino = document.getElementById(fim);

    for(i = 0; i < fonte.length; i++) {
        if(fonte[i].selected){
            var y=document.createElement('option');
            y.text  = fonte[i].text;
            y.value = fonte[i].value;  
            
            destino.add(y, null);
        }
    }
    
    for(i = fonte.length - 1; i >= 0; i--) {
        if(fonte[i].selected){
            fonte.remove(i);
        }
    }  
}
-->
</script>
<c:if test="${param.acaoForm == 'novo' || param.acaoForm == 'salva'}">
	<h1>Novo Chalé</h1>
</c:if>
<c:if test="${param.acaoForm == 'altera' || param.acaoForm == 'atualiza'}">
	<h1>Alterar Chalé</h1>
</c:if>

<html:errors suffix="erro.erro2" prefix="erro.erro" />
<html:form action="/ChaleGer" focus="nomeChale">
	<html:hidden property="acaoForm" />
	<html:hidden property="codChale" />
	<table cellpadding="2" width="70%" class="formulario">
		<tr>
			<td class="titulo">Localização:</td>
			<td class="form"><html:text property="localizacao"
				maxlength="150" size="35"></html:text></td>
		</tr>
		<tr>
		<tr>
			<td class="titulo">Capacidade:</td>
			<td class="form"><html:text property="capacidade" maxlength="5"
				size="5"></html:text></td>
		</tr>
        <tr>
            <td class="titulo"><strong>Itens do chalé:</strong><br />
                <html:select property="codItens" multiple="multiple" styleId="codItens" size="6">
                    <html:options collection="itensChale" property="codItem" labelProperty="nomeItem" />
                </html:select>
                
            <div class="buttonwrapper">
            <div style="float: right;">
                    <a href="javascript:removeItem();" class="ovalbutton"
                        style="margin-right: 3px;"> <span>---></span></a>
                        </div>
            </div>
                
            </td>
            <td class="form"><strong>Outros Itens:</strong><br />
                <html:select property="codTodosItens" multiple="multiple" styleId="codTodosItens" size="6">
                    <html:options collection="itensNaoChale" property="codItem" labelProperty="nomeItem" />
                </html:select>
                
            <div class="buttonwrapper">
                    <a href="javascript:adicionaItem();" class="ovalbutton"
                        style="margin-right: 3px;"> <span><---</span></a>
            </div>
            
            </td>
        </tr>
		<tr>
			<td class="titulo">Valor alta estação:</td>
			<td class="form">R$ <html:text property="valorAltaEstacao"
				maxlength="10" size="10"></html:text></td>
		</tr>
		<tr>
			<td class="titulo">Valor baixa estação:</td>
			<td class="form">R$ <html:text property="valorBaixaEstacao"
				maxlength="10" size="10"></html:text></td>
		</tr>
		<tr>
			<td colspan="2" class="botoes">
			<div class="buttonwrapper">
			<div class="botoes"><c:choose>
				<c:when test="${param.codChale < 0}">
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