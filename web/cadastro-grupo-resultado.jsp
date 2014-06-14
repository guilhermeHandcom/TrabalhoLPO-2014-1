<%-- 
    Document   : cadastro-grupo-resultado
    Author     : taiany.coelho
--%>

<%@page import="trabalho.lpo.classes.Grupo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Proposta: Resultado</title>
    </head>
    <body>
        
        <% 
            Grupo grupo = (Grupo)request.getAttribute("grupo");
        %>        
        
        <!-- Tela para exibir o resultado do cadastro da oferta -->
        <h1>Criar Proposta: Resultado</h1>
        
        <p>
            Novo Grupo: 
            usuário  <%= grupo.getDescricao()%> 
            do titulo: <%= grupo.getTitulo()%>
            da fase <%= grupo.getFase()%>
        </p>
        
    </body>
</html>