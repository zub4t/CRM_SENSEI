<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("username")!= null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intervenções Resposta</title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
        %>
        <link href="/CRM_SENSEI/interventions/interventions.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>
        <div class="main_label ">
            <h1> Tarefa registrada com sucesso!!</h1>
            <a href="/CRM_SENSEI/interventions/interventions_psq.jsp">
                <div class="box-3">
                    <div class="btn-1 btn-three">
                        <span>Voltar</span>
                    </div>
                </div>
            </a>
        </div>
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>