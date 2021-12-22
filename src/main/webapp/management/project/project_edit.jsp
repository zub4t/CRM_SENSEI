<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.employee.services.EmployeeServices"%>
<%@page import="management.client.service.ClientService"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ClientService client = new ClientService();
    client.setAll(request, response);
    EmployeeServices employeeServices = new EmployeeServices();
    employeeServices.setListOfAllEmployes(request, response);
%>

<script>
    function setUpEdit() {
        document.querySelector("[name=client_id]").value = "${model.client_id}";
        document.querySelector("[name=employee_selected]").value = "${model.owner_id}";
    }
</script>
<div class="form">

    <form class="formnar" method="POST" action="/CRM_SENSEI/ProjectController?pwhat=update">
        <input type="hidden" value="${model.id}" name="projectId"/>


        <div class="form__group">
            <div class="form_label">Cliente</div>
            <div class="form_item">
                <select name="client_id"  class="form__input  item">
                    <c:forEach items="${clientListAll}" var="item">
                        <option value="${item.getId()}">${item.getName()}</option>
                    </c:forEach>
                </select>
            </div>                   
        </div>

        <div class="form__group">
            <div class="form_label">Responsável pelo projeto</div>
            <div class="form_item">
                <select  name="employee_selected"  class="form__input  item" id="employee_slct" >
                    <c:forEach items="${list}" var="item"   varStatus="loop">
                        <option id="employee_${item.id}" value="${item.id}">${item.nme}</option>
                    </c:forEach>
                </select>
            </div>                   
        </div>

        <div class="form__group">

            <div class="form_label">Numero do processo:</div>
            <div class="form_item">
                <input  type="text" name="n_process" value="${model.n_process}" placeholder="Numero do processo" class="form__input  item" />
            </div>
        </div>
        <div class="form__group">

            <div class="form_label">Nome do Cliente:</div>
            <div class="form_item">
                <input  type="text" name="nme" value="${model.customer_nme}" placeholder="Nome do Cliente" class="form__input  item" />
            </div>
        </div>

        <div class="form__group">
            <div class="form_label">Data de previsão para a finalização</div>
            <div class="form_item">
                <input id="date"  name="date"  class="form__input  item"  type="date" value="${model.end_date}">
            </div>                 
        </div>

        <div class="form__group">     
            <div class="form_label">Venda Prevista:</div>
            <div class="form_item">
                <input  type="number" step="0.01" value="${model.expected_sale}" name="expected_sale" placeholder="Venda Prevista" class="form__input item"  />
            </div>
        </div>
        <div class="form__group">
            <div class="form_label">Venda Efetiva:</div>
            <div class="form_item">
                <input  type="number" step="0.01" value="${model.effective_sale}" name="effective_sale" placeholder="Venda Efetiva" class="form__input item"  />
            </div>
        </div>
        <div class="form__group">
            <div class="form_label">Compra Prevista:</div>
            <div class="form_item">
                <input  type="number" step="0.01" name="expected_purchase" value="${model.expected_purchase}" placeholder="Compra Prevista" class="form__input item"  />
            </div>
        </div>
        <div class="form__group">
            <div class="form_label">Compra Efetiva:</div>
            <div class="form_item">
                <input  type="number" step="0.01" value="${model.effective_purchase}" name="effective_purchase" placeholder="Compra Efetiva" class="form__input item"  />
            </div>
        </div>
        <div class="form__group">
            <div class="form_label">honorários</div>
            <div class="form_item">
                <input  type="number" step="0.01" name="honorary" value="${model.honorary}"" placeholder="honorários" class="form__input item"  />
            </div>    
        </div>
        <input type="hidden" name="pwhat" value="update">

    </form>
    <input class="btn-1" onclick="event.preventDefault(); save()" value ="Editar Projeto" type="button">

</div>  
