<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>

<%@page import="management.project.model.ProjectModel"%>
<%@page import="management.project.services.ProjectServices"%>
<%@page import="management.assingment.services.AssingmentServices"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AssingmentServices assingment = new AssingmentServices();
    assingment.setListOfAllAssingment(request, response);
    ProjectServices project = new ProjectServices();
    project.setListOfAllPrj(request, response);
%>

<script>

    $(document).ready(function () {

        document.querySelector("[name=project_id]").value = "${model.project_id}";


    <%
        if (request.getParameter("project") != null) {
            out.println(" document.querySelector('[name=project_id]').value = '" + request.getParameter("project") + "';");
            out.println(" $('[name=project_id] :not(:selected)').attr('disabled','disabled');");
        }
    %>

        document.querySelector("[name=assingment_id]").value = "${model.assingment_id}";
    <%if (request.getAttribute("edit") != null) {%>
        document.querySelector("[name=pwhat]").value = "update";
        $('[name=project_id] :not(:selected)').attr('disabled', 'disabled');

    <%}%>

    });
</script>


<div class="">
    <form class="formnar" method="POST" action="/CRM_SENSEI/InterventionsController">
        <div class="form">



            <%if (request.getAttribute("edit") != null) {%>
            <input type="hidden" name="id" value="${model.id}">
             <input type="hidden" name="pwhat" value="update">

            <%}else{%>
             <input type="hidden" name="pwhat" value="insert">
            <%}%>
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
                    <input name="spend_time" type="time" value="${model.getSpeend_time()}" class="form__input  item" placeholder="Tempo dedicado">
                </div>                  
            </div>  
            <div class="form__group">
                <div class="form_label">Descrição:</div>
                <div class="form_item">
                    <textarea  name="dsc" style="height: 300px" row="4" cols="50"  class="form__input  item" placeholder="Descrição">
                        ${model.dsc}
                    </textarea>                 

                </div>                 
            </div>

            <div class="form__group">
                <div class="form_label">Data:</div>
                <div class="form_item">
                    <input id="date_in"  name="date_in"  class="form__input  item"  type="date" value="${model.date}">
                </div>                 
            </div>

        </div>    
        <input type="button" onclick="event.preventDefault();save();" value="Gravar Intervenção" class="btn-1"  >
    </form>
</div>
