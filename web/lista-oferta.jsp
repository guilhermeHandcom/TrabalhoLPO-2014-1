<%-- 
    Document   : lista-oferta
    Created on : 13/05/2014, 23:27:23
    Author     : guilhermecortes
--%>
<%@page import="trabalho.lpo.classes.Oferta"%>
<%@page import="java.util.List"%>
<%
    List<Oferta> ofertas = (List<Oferta>)request.getAttribute("ofertas");
%>
<html lang="pt-BR">
    
    <head>
        <title>Lista Ofertas - Trabalho LPO</title>
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
        
        <h1>Lista Ofertas - Trabalho LPO</h1> <br>
        
        <table>
            
            <tr>
                <th>#</th>
                <th>Usuario</th>
                <th>Oferta</th>
                <th>Produto</th>
                <th>Desejo</th>
            </tr>
            <%
                for (Oferta oferta : ofertas)//individuo : coletivo
                {
            %>
            <tr>
                <td><%= oferta.getCod_oferta() %></td>
                <td><%= oferta.getNome_usuario() %></td>
                <td><%= oferta.getNome_oferta() %></td>
                <td><%= oferta.getNome_produto() %></td>
                <td><%= oferta.getDesejo() %></td>
                <td><a href='exclui.do?cod_oferta=<%= oferta.getCod_oferta() %>'>Excluir</a></td>
                <td><a href='edita-oferta.do?cod_oferta=<%= oferta.getCod_oferta() %>'>Editar</a></td>
            </tr>
            <%
                }
            %>
        </table>
        
        <p><a href='criar-oferta.html'>Cadastrar oferta</a></p>
            <a href="index.jsp">Home</a>
    
    </body>
    
</html>
