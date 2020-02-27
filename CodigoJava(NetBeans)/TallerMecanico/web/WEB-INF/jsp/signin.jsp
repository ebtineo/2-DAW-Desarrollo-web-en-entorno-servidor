<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contenido" value='<div class="col">'></c:set>
    <c:set var="contenido" value='${contenido}<div class="card">'></c:set>
        <c:set var="contenido" value='${contenido}
               <form action="signin" method="POST">
                    <label>Usuario: <input type="text" name="usuario"/></label>
                    <label>Contraseña: <input type="password" name="pass"/></label>
                    <input type="submit" value="Registrame"/>
               </form>
               '></c:set>
    <c:set var="contenido" value='${contenido}</div>'></c:set>
<c:set var="contenido" value='${contenido}</div>'></c:set>

<jsp:include page="base.jsp">
    <jsp:param name="contenido" 
        value="${contenido}"/>
</jsp:include>
