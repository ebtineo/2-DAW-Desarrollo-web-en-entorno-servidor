<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contenido" value='<div class="col">'></c:set>
    <c:set var="contenido" value='${contenido}<p class="card">'></c:set>
        <c:set var="contenido" value='${contenido}Autor: Castañeda'></c:set>
    <c:set var="contenido" value='${contenido}</p>'></c:set>
<c:set var="contenido" value='${contenido}</div>'></c:set>

<jsp:include page="base.jsp">
    <jsp:param name="contenido" 
        value="${contenido}"/>
</jsp:include>