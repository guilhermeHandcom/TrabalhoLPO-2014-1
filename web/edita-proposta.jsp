<%-- 
    Author     : LARISSA
--%>

<%@page import="trabalho.lpo.classes.Proposta"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Propostas - Trabalho LPO-2014-1</title>
        
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
            Proposta proposta = (Proposta)request.getAttribute("proposta");
        %>       
        <h1>Cadastro de Propostas</h1>
        <form action="salvar-proposta.do" method="POST">
            <input type="hidden" name="cod_proposta" value="<%= proposta.getCod_proposta() %>" />
            <div>
                <label>Usuário:</label>
                <input type="text" name="nome_user" value="<%= proposta.getNome_user() %>" />
            </div>
            <div>
                <label>Desejo: </label>
                <input type="text" name="desejo" value="<%= proposta.getDesejo()%>" />
            </div>
            
            <input type="submit" value="Salvar" class="btnForm btnFormEnviar" />
            <a href="lista-proposta.html">Voltar</a>
        
        </form>      
    </body>
</html>
