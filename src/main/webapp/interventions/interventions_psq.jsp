<%-- 
    Document   : assingment_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@page import="management.assingment.services.AssingmentServices"%>
<%@page import="management.employee.services.EmployeeServices"%>
<%@page import="util.Util"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("username")!= null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intervenções Pesquisar </title>
        <%
        MenuServices menu = new MenuServices();
        menu.setMenu(request, response);
        
        AssingmentServices assingment = new AssingmentServices();
        assingment.setListOfAllAssingment(request, response);

 
        EmployeeServices employeeServices = new EmployeeServices();
        employeeServices.setListOfAllEmployes(request,response);
            
    
              
        String[] employee_selected = (String[]) session.getAttribute("employee_selected");
        String assingment_id = null;
        if (session.getAttribute("assingment_id") != null) {
            assingment_id = ((String[]) session.getAttribute("assingment_id"))[0];

        }
        String date_filter_in = null;
        if (session.getAttribute("date_filter_in") != null) {
            date_filter_in = ((String[]) session.getAttribute("date_filter_in"))[0];
            if (date_filter_in.length() < 2) {
                date_filter_in = null;

            }
        }
        String date_filter_out = null;
        if (session.getAttribute("date_filter_out") != null) {
            date_filter_out = ((String[]) session.getAttribute("date_filter_out"))[0];
            if (date_filter_out.length() < 2) {
                date_filter_out = null;

            }
        }
           
             
             
             
        
        %>
        <script src="/CRM_SENSEI/interventions/interventions.js"></script>
        <link href="/CRM_SENSEI/interventions/interventions.css" rel="stylesheet"/>
        <style>
            .table_ccontainer{
                top:250px !important;
            }
        </style>
    </head>
    <body>

        <%@include file="../../menu/menu.jsp" %>

        <form id="formId" method="GET" action="">
            <input type="hidden" name="pwhat" value="edit">
            <input type="hidden" name="id" value="">
        </form>
        <form id="searchform" method="GET" action="/CRM_SENSEI/InterventionsController"
               style="display: flex; justify-content: center;align-items: flex-start; flex-direction: column; margin-top: 25px;margin-left: 50%;width: 620px;border: 1px solid black;padding: 10px;position: absolute">
            <input type="hidden" name="pwhat" value="search">
            <div> 
                <div style="display: flex;">
                    <div style="margin-right: 50px; width: 150px">Funcionário</div>
                    <div>
                        <select  name="employee_selected" id="employee_slct" multiple="multiple">
                            <c:forEach items="${list}" var="item"   varStatus="loop">
                                <option id="employee_${item.id}" value="${item.id}">${item.nme}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div style="display: flex;">
                    <div  style="margin-right: 50px;width: 150px">Tarefa </div>
                    <div>
                        <select id="assingment_id" name="assingment_id"  class="form__input  item">
                            <option value="-1">All</option>
                            <c:forEach items="${list_assng}" var="item">
                                <option value="${item.getId()}">${item.getDsc()}</option>
                            </c:forEach>

                        </select>
                    </div>

                </div>
                <div style="display: flex;">
                    <div  style="margin-right: 50px;width: 150px">Data</div>
                    <div style="display: flex">
                        <input id="date_filter_in"  name="date_filter_in"  class="form__input  item"  type="date" value="">
                        <input id="date_filter_out"  name="date_filter_out"  class="form__input  item"  type="date" value="">

                    </div>

                </div>
                <div style="margin-top: 5px;width: 600px;">
                    <button onclick="event.preventDefault();search();" class="btn-1" type="button">Pesquisar</button>
                </div>
            </div>
        </form>

        <div id="table_container" class="table_ccontainer">
            <% if(menu.isVisible(request, 11)){ %>
            <span class="plusButton" onclick="nnew()"><img  src="/CRM_SENSEI/resources/plus-sign.png" width="20px"/></span>
                <% } %>
            <div class="table_header"></div>
            <div id="table">
                <%@include file="interventions_table.jsp" %>
            </div>
            <div class="table_footer"></div>

        </div>
        <script> $('#employee_slct').multipleSelect();</script>
        <script>

            window.onload = function () {

                let employee_selected = <%= Util.toJavascriptArray(employee_selected) %>;
                let assingment_id = '<%=assingment_id%>';
                let date_filter_in = '<%=date_filter_in%>';
                let date_filter_out = '<%=date_filter_out%>';
                $("#date_filter_in").val(date_filter_in);
                $("#date_filter_out").val(date_filter_out);
                $("#assingment_id").val(assingment_id);
                for (let employee of employee_selected) {
                    $("[type=checkbox][value=" + employee + "]").click();
                }

            };
        </script>
    </body>
</html>

<%}else{out.print("Usuario não está logado");}%>