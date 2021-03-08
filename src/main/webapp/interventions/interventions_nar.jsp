<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.project.services.ProjectServices"%>
<%@page import="management.assingment.services.AssingmentServices"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%
 // returns null if no session or session is invalid
if(session.getAttribute("username")!= null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intervenções Criar</title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
            AssingmentServices assingment = new AssingmentServices();
            assingment.setListOfAllAssingment(request, response);
            ProjectServices project = new ProjectServices();
            project.setListOfAllPrj(request, response);
        %>
        <script src="/CRM_SENSEI_EXTERNAL/interventions/interventions.js?v1"></script>
        <link href="/CRM_SENSEI_EXTERNAL/interventions/interventions.css" rel="stylesheet"/>
        <script>
            window.addEventListener("load", function (event) {
                document.querySelector("[name=project_id]").value = "${model.project_id}";
                document.querySelector("[name=assingment_id]").value = "${model.assingment_id}";
            <%if(request.getAttribute("edit") != null){%>
                document.querySelector("[name=pwhat]").value = "update";

            <%}%>

            });
        </script>
    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>
        <div class="main-content">
            <div class="form">

                <form class="formnar" method="POST" action="/CRM_SENSEI_EXTERNAL/InterventionsController">

                    <%if(request.getAttribute("edit") != null){%>
                    <input type="hidden" name="id" value="${model.id}">

                    <%}%>
                    <input type="hidden" name="pwhat" value="insert">
                    <div class="form__group">

                        <div class="form_label">Projeto:</div>
                        <div class="form_item">
                            <select name="project_id"   class="form__input  item">
                                <c:forEach items="${projectList}" var="item">
                                    <option value="${item.getId()}">${item.getN_process()} | ${item.getCustomer_nme()} </option>
                                </c:forEach>

                            </select>
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">Tarefa realizada:</div>
                        <div class="form_item">
                            <select name="assingment_id"  class="form__input  item">
                                <c:forEach items="${list_assng}" var="item">
                                    <option value="${item.getId()}">${item.getDsc()}</option>
                                </c:forEach>

                            </select>
                        </div>
                    </div>

                    <div class="form__group">
                        <div class="form_label">Tempo Gasto:</div>
                        <div class="form_item">
                            <input name="spend_time" type="time"  class="form__input  item" placeholder="Tempo dedicado">
                        </div>                  
                    </div>  
                    <div class="form__group">
                        <div class="form_label">Descrição:</div>
                        <div class="form_item">
                            <input name="dsc" type="text"  value="${model.dsc}" class="form__input  item" placeholder="Descrição" />
                        </div>                 
                    </div>

                    <div class="form__group">
                        <div class="form_label">Data:</div>
                        <div class="form_item">
                            <input id="date_in"  name="date_in"  class="form__input  item"  type="date" value="">
                        </div>                 
                    </div>
                </form>
            </div>    
            <button onclick="event.preventDefault();" class="btn-1" type="button" >Gravar</button>

        </div>
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>