<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

    <h1> Erro</h1>
    Houve um erro:<br/>
    <textarea readonly="readonly" cols="89" rows="14">
    ${pageContext.errorData.throwable}
    ${pageContext.errorData.throwable.cause}
    </textarea>
    
<%@ include file="footer.jsp" %>