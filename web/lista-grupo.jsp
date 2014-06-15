<%-- 
    Document   : lista-grupo
    Created on : 06/06/2014, 20:02:29
    Author     : taiany.coelho
--%>

<%@page import="trabalho.lpo.classes.Grupo"%>
<%@page import="java.util.List"%>
<%
    List<Grupo> grupos = (List<Grupo>)request.getAttribute("grupos");
%>
<html lang="pt-BR">
    
    <head>
        <title>Lista Grupos - Trabalho LPO</title>
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
        
        <h1>Lista Grupos - Trabalho LPO</h1> <br>
        
        <table>
            
            <tr>
                <th>#</th>
                <th>Titulo</th>
                <th>Descricao</th>
                <th>Fase</th>
            </tr>
            <%
                for (Grupo grupo : grupos)
                {
            %>
            <tr>
                <td><%= grupo.getCodGrupo()%></td>
                <td><%= grupo.getTitulo()%></td>
                <td><%= grupo.getDescricao()%></td>
                <td><%= grupo.getFase()%></td>
                <td><a href='exclui-grupo.do?cod_grupo=<%= grupo.getCodGrupo()%>'>Excluir</a></td>
                <td><a href='edita-grupo.do?cod_grupo=<%= grupo.getCodGrupo()%>'>Editar</a></td>
            </tr>
            <%
                }
            %>
        </table>
        
        <p><a href='criar-grupo.html'>Cadastrar grupo</a></p>
            <a href="index.jsp">Home</a>
    
    </body>
    
</html>
