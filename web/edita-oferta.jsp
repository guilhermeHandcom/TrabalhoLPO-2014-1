<%-- 
    Document   : cadastro-oferta
    Created on : 13/05/2014, 23:26:56
    Author     : guilhermecortes
--%>

<%@page import="trabalho.lpo.classes.Oferta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de ofertas - Trabalho LPO-2014-1</title>
        
        <!-- CSS -->
        <style>
            
            body
            {
                background-color: #f1f1f1;
            }
            
            h1
            {
                color: #444;
                float: left;
                font:30px arial;
                text-align: center;
                width: 100%;
            }
            
            form
            {
                margin: 0 auto;
                width: 460px;
            }
            
            div
            {
                float: left;
                margin: 10px 0;
                width: 100%;
            }
            
            div label
            {
                color: #666666;
                float: left;
                font: 16px arial;
                margin: 7px 10px 0 0;
                text-align: right;
                width: 125px;
            }
            
            div input
            {
                border: 1px solid #e7e7e7;
                color: #666;
                float: left;
                font: 16px arial;
                padding: 8px 7px;
                transition: all 0.3s ease 0s;
                width: 300px;
            }
            
            div input:hover
            {
                border-color: #d5d5d5;
            }
            
            div input:focus
            {
                border-color: #bcbcbc;
                border-radius: 5px;
                box-shadow: 0 0 3px #999;
            }
            
            input.btnForm
            {
                background-color: #8F8F8F;
                border: medium none;
                border-radius: 5px;
                color: #FFFFFF;
                cursor: pointer;
                float: right;
                margin: 10px;
                padding: 8px;
                width: 100px;
            }
            
            input.btnForm:hover
            {
                background-color: #7B7A7A;
            }
            
            input.btnFormEnviar
            {
                background-color: #127E26;
            }
            
            input.btnFormEnviar:hover
            {
                background-color: #0C631C;
            }
            
            a
            {
                background-color: #6D6C6C;
                border-radius: 5px;
                color: #fff;
                float: right;
                font: 12px arial;
                margin: 10px 10px 0 0;
                padding: 7px 35px 8px;
                text-decoration: none;
            }
            
            a:hover
            {
                background-color: #868585;
            }
            
        </style>
        <!-- CSS -->
        
    </head>
    <body>
        <% 
            Oferta oferta = (Oferta)request.getAttribute("oferta");
        %>       
        <h1>Cadastro de ofertas</h1>
        <form action="salvar.do" method="POST">
            <input type="hidden" name="cod_oferta" value="<%= oferta.getCod_oferta() %>" />
            <div>
                <label>Usuário:</label>
                <input type="text" name="nome_usuario" value="<%= oferta.getNome_usuario() %>" />
            </div>
            <div>
                <label>Nome da oferta: </label>
                <input type="text" name="nome_oferta" value="<%= oferta.getNome_oferta() %>" />
            </div>
            <div>
                <label>Produto: </label>
                <input type="text" name="nome_produto" value="<%= oferta.getNome_produto() %>" />
            </div>
            <div>
                <label>Desejo: </label>
                <input type="text" name="desejo" value="<%= oferta.getDesejo() %>" />
            </div>
            
            <input type="submit" value="Salvar" class="btnForm btnFormEnviar" />
            <a href="lista-oferta.html">Voltar</a>
        
        </form>
            
            
    </body>
</html>
