<%-- 
    Document   : cadastro-proposta-resultado
    Author     : LARISSA
--%>

<%@page import="trabalho.lpo.classes.Proposta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Proposta: Resultado</title>
    </head>
    <body>
        
        <% 
            Proposta proposta = (Proposta)request.getAttribute("proposta");
        %>        
        
        <!-- Tela para exibir o resultado do cadastro da oferta -->
        <h1>Criar Proposta: Resultado</h1>
        
        <p>
            Nova Proposta do 
            usuário  <%= proposta.getNome_user()%> 
            possui como desejo <%= proposta.getDesejo() %>.
        </p>
        
    </body>
</html>