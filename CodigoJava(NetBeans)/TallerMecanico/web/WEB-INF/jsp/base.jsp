<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! String contenido = "";%>

<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Taller mecanico</title>
        <link href='<c:url value="/resources/css/bootstrap.min.css"/>' type="text/css" rel="stylesheet" />
</head>

<body>
    
    <div class="container-fluid">
        
        <div class="row card-header">
            
            <div class="col-auto">
                
                <a href="index" class="btn btn-primary">Index</a> 
            </div>
            
            <div class="col-auto">
                
                <a href="login" class="btn btn-primary">Iniciar sesion</a> 
                
            </div>
            
            <div class="col-auto">
                
                <a href="signin" class="btn btn-primary">Registrarse</a> 
                
            </div>
            
            <div class="col-auto">
                
                <a href="acercaDe" class="btn btn-primary">Acerca de</a> 
                
            </div>
            
        </div>
        
    </div>
    
    <div class="container-fluid">
        
        <div class="row">
            ${param.contenido}
        </div>
        
    </div>
    
    <footer>
        
    </footer>
                
    <script src='<c:url value="/resources/js/jquery-3.4.1.min.js"/>'></script>
    <script src='<c:url value="/resources/js/bootstrap.bundle.min.js"/>'></script>
    
    <!-- 
        Formas de obtener lo que viene de los templates
            
        % contenido = request.getParameter("contenido"); %>
        %= request.getParameter("contenido") %>
            
        $param.contenido}
            
        %= contenido %>
    -->
</body>
</html>