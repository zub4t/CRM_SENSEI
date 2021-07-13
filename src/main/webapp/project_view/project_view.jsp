<%-- 
    Document   : main
    Created on : 2/nov/2020, 0:18:28
    Author     : marco
--%>
<%@page import="management.client.model.ClientModel"%>
<%@page import="management.client.service.ClientService"%>
<%@page import="management.project.model.ProjectModel"%>
<%@page import="management.project.services.ProjectServices"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("username") != null) {
        ProjectServices projectServices = new ProjectServices();
        int p_id = Integer.parseInt(request.getParameter("project"));
        ProjectModel project_model = projectServices.getById(p_id);
        request.setAttribute("project_model", project_model);
        request.setAttribute("list", projectServices.getAllEmployeeByProject(p_id));
        request.setAttribute("set", projectServices.getAllEmployeeByProjectSet(p_id));

        ClientService clientService = new ClientService();
        ClientModel client_model = clientService.getById(String.valueOf(project_model.getClient_id()));
        if (client_model == null) {
            client_model = new ClientModel();
        }
        request.setAttribute("client_model", client_model);

%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRM</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha256-4+XzXVhsDmqanXGHaHvgh2gMQKX40OUvDEBTu8JcmNs=" crossorigin="anonymous"></script>

        <link href="/CRM_SENSEI/main/main.css" rel="stylesheet"/>
        <style>

            .label-question{
                margin-left: 10px;
                color: #18494D;
            }
            .label-answer{
                color: #679596;

            }
            input[disabled]{
                width: 237px;
                height: 40px;
                margin: 10px;
                background: #FFFFFF;
                border: 1px solid #E5E5E5;
                box-sizing: border-box;
                border-radius: 10px;
                padding-left: 10px;
            }
            .project-info,.client-info{
                margin:50px;
                width:800px;
                padding: 10px;
                background: #FFFFFF;
                border: 1px solid #E5E5E5;
                border-radius: 10px;
            }
            .lists{
                margin:50px;

                padding: 10px;
                background: #FFFFFF;
                border: 1px solid #E5E5E5;
                border-radius: 10px;
            }
            .active{
                width: 119px;
                height: 40px;
                background: #679596;
                border: 1px solid #E5E5E5;
                box-sizing: border-box;
                border-radius: 10px;
                text-align: center;
                padding-top: 5px;
            }
            .inactive{
                width: 119px;
                height: 40px;
                text-align: center;
                padding-top: 5px;

                background: #F9F9F9;
                border: 1px solid #E5E5E5;
                box-sizing: border-box;
                border-radius: 10px;
            }
            table tr{
                text-align: center;
            }
            table tr:nth-of-type(2n){
                background-color: #f4f4f4;
            }
        </style>

    </head>
    <%        MenuServices menu = new MenuServices();
        menu.setMenu(request, response);

    %>
    <body>

        <%@include file="../menu/menu.jsp" %>

        <div class="main-content" style="display: flex">
            <div >
                <div class="client-info" >
                    <h2 class="label-question">Informações Cliente</h2>
                    <div style="display: flex;">
                        <div>

                            <div>
                                <div class="label-question">Nome</div>
                                <div> <input  class="label-answer" type="text" disabled value="${client_model.name}"> </div>
                            </div>
                            <div>
                                <div  class="label-question">Email</div>
                                <div> <input  class="label-answer" type="text" disabled value="${client_model.email}"> </div>
                            </div>
                        </div>

                        <div>

                            <div>
                                <div  class="label-question">Nº de Contribuinte </div>
                                <div> <input  class="label-answer" type="text" disabled value="${client_model.num_contribuinte}"> </div>
                            </div>

                            <div style="display: flex">
                                <div>
                                    <div  class="label-question">Telefone</div>
                                    <div> <input  class="label-answer" type="text" disabled value="${client_model.tel}"> </div>
                                </div>
                                <div>
                                    <div  class="label-question">Localidade</div>
                                    <div> <input class="label-answer"  type="text" disabled value="${client_model.location}"> </div>
                                </div>
                            </div>

                        </div>

                    </div>
                    <div>
                        <div  class="label-question">Morada</div>
                        <div><input  type="text" style="width: 500px" disabled class="label-answer" value="${client_model.address}"></div>
                    </div>

                </div>



                <div class="project-info">
                    <h2 class="label-question">Informações Projeto</h2>
                    <div  class="label-question">Nome do projeto</div>
                    <div><input  type="text" disabled style="width: 500px" class="label-answer" value="${project_model.customer_nme}"></div>
                    <div style="display: flex">
                        <div>
                            <div  class="label-question">Código </div>
                            <div><input  type="text" class="label-answer" disabled value="${project_model.n_process}"></div>

                        </div>

                        <div>
                            <div  class="label-question">Data início </div>
                            <div><input  type="data" disabled value="${project_model.ctr_date}"></div>

                        </div>


                    </div>


                    <div style="display: flex">
                        <div>
                            <div  class="label-question">Venda esperada</div>
                            <div><input type="text" class="label-answer" value="<fmt:formatNumber value="${project_model.expected_sale}" type="currency"/>  " disabled></div>
                        </div>
                        <div>
                            <div  class="label-question">Venda efetiva</div>
                            <div><input type="text" class="label-answer" value="<fmt:formatNumber value="${project_model.effective_sale}" type="currency"/>" disabled></div>
                        </div>
                    </div>

                    <div style="display: flex">
                        <div>
                            <div  class="label-question">Compra esperada</div>
                            <div><input type="text" class="label-answer"  value="<fmt:formatNumber value="${project_model.expected_purchase}" type="currency"/> "disabled></div>
                        </div>
                        <div>
                            <div  class="label-question">Compra efetiva</div>
                            <div><input type="text" class="label-answer" value="<fmt:formatNumber value="${project_model.effective_purchase}" type="currency"/> " disabled></div>
                        </div>
                    </div>
                    <!--                    <div>
                                            <div  class="label-question">Status</div>
                                            <div style="display: flex"> <div onclick="change()" class="active">Aberto</div> <div onclick="change()" class="inactive">Fechado</div></div>
                                        </div>-->
                </div>

            </div>
            <div>
                <div class="lists">
                    <h2 class="label-question" style="text-align: center">Associados ao projeto</h2>

                    <table width="100%">
                        <c:forEach items="${set}" var="item"   varStatus="loop">
                            <tr>
                                <td>${item} </td>    
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="lists" style="height: 500px; overflow-y:scroll ">
                    <h2 class="label-question">Tarefas realizadas recentemente</h2>

                    <table  width="100%">
                        <c:forEach items="${list}" var="item"   varStatus="loop">
                            <tr >
                                <td>${item[0]} </td>    <td>${item[1]}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>


            </div>
        </div>


    </body>
</html>
<%} else {
        out.print("Usuario não está logado");
    }%>