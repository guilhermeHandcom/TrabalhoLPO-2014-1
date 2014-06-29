<%-- 
    Author     : LARISSA
--%>
<%@page import="java.util.List"%>
<%@page import="trabalho.lpo.classes.Proposta"%>
<%

List<Proposta> propostas = (List<Proposta>)request.getAttribute("propostas");
%>
<html lang="pt-BR">
    
    <head>
        <title>Lista Propostas - Trabalho LPO</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- CSS -->
        <style>
            
            body
            {
                background-color: #f1f1f1;
                font: 16px arial;
            }
            
            h1
            {
                color: #444;
                float: left;
                font:30px arial;
                text-align: left;
                width: 100%;
            }
            
            a
            {
                background-color: #D3D3D3;
                border: 1px solid #000000;
                border-radius: 5px;
                color: #323232;
                float: left;
                padding: 5px 10px;
                text-decoration: none;
            }
            
            a:hover
            {
                background-color: #fff;
            }
            
            
            
        </style>
        <!-- CSS -->
    </head>
    
    <body>
        
        <h1>Lista Propostas:</h1> <br>
        
        <table>
            
            <tr>
                <th>#</th>
                <th>Usuario</th>
                <th>Desejo</th>
            </tr>
            <%
                for (Proposta proposta : propostas)//individuo : coletivo
                {
            %>
            <tr>
                <td><%= proposta.getCod_proposta() %></td>
                <td><%= proposta.getNome_user() %></td>
                <td><%= proposta.getDesejo() %></td>
                <td><a href='exclui-proposta.do?cod_proposta=<%= proposta.getCod_proposta() %>'>Excluir</a></td>
                <td><a href='editar-proposta.do?cod_proposta=<%= proposta.getCod_proposta() %>'>Editar</a></td>
            </tr>
            <%
                }
            %>
        </table>
        
        <p><a href='criar-oferta.html'>Cadastrar oferta</a></p>
        <p><a href='criar-proposta.html'>Cadastrar proposta</a></p>
            <a href="index.jsp">Home</a>
    
    </body>
    
</html>