<%-- 
    Document   : cadastro-oferta-resultado
    Created on : 03/06/2014, 20:01:10
    Author     : taianycoelho
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de grupos - Trabalho LPO-2014-1</title>
        
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
            
        </style>
        <!-- CSS -->
    </head>
    
    <body>
        <h1>Cadastro de Grupos</h1>
        <form action="" method="POST">
            
            <div>
                <label>Titulo</label>
                <input type="text" name="titulo" value="" />
            </div>
            <div>
                <label>Nome do grupo: </label>
                <input type="text" name="descricao" value="" />
            </div>
            <div>
                <input type="hidden" name="fase" value="1" />
            </div>
 
            <input type="submit" value="Enviar" class="btnForm btnFormEnviar" />            
            <input type="reset" value="Limpar" class="btnForm" />
            <a href="index.jsp">Home</a>
        
        </form>
    </body>
 
</html>
