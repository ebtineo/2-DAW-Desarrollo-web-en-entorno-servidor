<%-- 
    Document   : cerrarSesion
    Created on : 20-ene-2019, 23:22:17
    Author     : jose
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${pageContext.session.invalidate()}
<c:redirect url="login.jsp"/>
