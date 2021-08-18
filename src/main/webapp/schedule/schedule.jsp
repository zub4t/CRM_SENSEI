<%-- 
    Document   : schedule
    Created on : 17/ago/2021, 21:19:53
    Author     : Marco
--%>

<%@page import="management.assingment.model.AssingmentModel"%>
<%@page import="management.assingment.services.AssingmentServices"%>
<%@page import="management.project.services.ProjectServices"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="schedule.services.ScheduleService"%>
<%@page import="schedule.model.ScheduleModel"%>
<%@page import="util.Util"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <script src="https://unpkg.com/js-year-calendar@latest/dist/js-year-calendar.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link rel="stylesheet" type="text/css" href="https://unpkg.com/js-year-calendar@latest/dist/js-year-calendar.min.css" />
        <link rel="stylesheet" type="text/css" href="schedule.css" />
        <script src="schedule.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShiSchedule</title>
    </head>
    <body>
        <%
            // returns null if no session or session is invalid
            if (session.getAttribute("username") != null) {

                ProjectServices projectServices = new ProjectServices();
                projectServices.setListOfAllPrj(request, response);
                AssingmentServices assingment = new AssingmentServices();
                assingment.setListOfAllAssingment(request, response);

                ScheduleService service = new ScheduleService();
                int year = Calendar.getInstance().get(Calendar.YEAR);

                List<ScheduleModel> list = service.getByYear(year);
                String jsonData = "[";
                for (ScheduleModel model : list) {

                    String strDateDay = model.getStr_dte().split("-")[2];
                    String strDateMonth = model.getStr_dte().split("-")[1];

                    String endDateDay = model.getEnd_dte().split("-")[2];
                    String endDateMonth = model.getEnd_dte().split("-")[1];
                    int endDateMonthInt = Integer.parseInt(endDateMonth) - 1;
                    int strDateMonthInt = Integer.parseInt(strDateMonth) - 1;
                    AssingmentModel assinmentModel = assingment.getById(model.getAssignment_id());
                    String event = "{id:" + model.getId()
                            + ",name:'" + model.getProject_name() + "'"
                            + ",color:'" + assinmentModel.getColor() + "'"
                            + ",location:'" + model.getDsc() + "'"
                            + ",assignment:' " + model.getAssignment_name() + "'"
                            + ",startDate: new Date(currentYear, " + strDateMonthInt + ", " + strDateDay + ")"
                            + ",endDate: new Date(currentYear, " + endDateMonthInt + ", " + endDateDay + ")"
                            + "},";
                    jsonData += event;

                }
                jsonData += "{}]";
        %>
        <script>
            var currentYear = new Date().getFullYear();
            var data = <%=jsonData%>;
            /*
             var data = [
             {
             id: 0,
             name: 'Google I/O',
             color: '#FF0000',
             location: 'San Francisco, CA',
             startDate: new Date(currentYear, 4, 28),
             endDate: new Date(currentYear, 4, 29)
             },
             ];
             */
        </script>
        <div id="calendar"></div>

        <div class="modal fade" id="event-modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Event</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="event-index">
                        <form class="form-horizontal">

                            <div class="form-group row">
                                <label for="prjct_selected" class="col-sm-4 control-label">Projeto:</label>
                                <div class="col-sm-10">

                                    <select  name="prjct_selected" id="prj_slct" >
                                        <c:forEach items="${projectList}" var="item"   varStatus="loop">
                                            <option id="projeto_${item.id}" value="${item.id}"> ${item.customer_nme}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="assingment_id" class="col-sm-4 control-label">Tarefa realizada:</label>
                                <div class="col-sm-10">
                                    <select name="assingment_id"  class="form__input  item">
                                        <c:forEach items="${list_assng}" var="item">
                                            <option value="${item.getId()}">${item.getDsc()}</option>
                                        </c:forEach>

                                    </select>


                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="dsc" class="col-sm-6 control-label">Informação adicional:</label>
                                <div class="col-sm-10">
                                    <input name="dsc" type="text" class="form-control">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="min-date" class="col-sm-4 control-label">Datas</label>
                                <div class="col-sm-8">
                                    <div class="input-group input-daterange" data-provide="datepicker">
                                        <input id="min-date" name="event-start-date" type="text" class="form-control">
                                        <div class="input-group-prepend input-group-append">
                                            <div class="input-group-text">to</div>
                                        </div>
                                        <input name="event-end-date" type="text" class="form-control">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" id="save-event">
                            Save
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div id="context-menu">
        </div>

    </div>
    <%} else {
            out.print("Usuario não está logado");
        }%>
</body>
</html>
