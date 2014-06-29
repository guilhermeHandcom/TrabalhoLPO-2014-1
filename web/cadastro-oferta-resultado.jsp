<%-- 
    Document   : cadastro-oferta-resultado
    Created on : 13/05/2014, 23:27:11
    Author     : guilhermecortes
--%>

<%@page import="trabalho.lpo.classes.Oferta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Oferta: Resultado</title>
    </head>
    <body>
        
        <% 
            Oferta oferta = (Oferta)request.getAttribute("oferta");
        %>        
        
        <!-- Tela para exibir o resultado do cadastro da oferta -->
        <h1>Criar Oferta: Resultado</h1>
        
        <p>
            Nova oferta do 
            usuário Fulano <%= oferta.getNome_usuario() %> 
            do produto <%= oferta.getNome_produto() %>, possui como desejo <%= oferta.getDesejo() %>.
            Nome da oferta: <%= oferta.getNome_oferta() %>.
        </p>
        
    </body>
</html>