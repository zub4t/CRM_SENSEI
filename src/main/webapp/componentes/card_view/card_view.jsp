<%-- 
    Document   : card_view
    Created on : 30/abr/2021, 12:17:50
    Author     : marco
--%>

<%@page import="menu.services.MenuServices"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    MenuServices menu_1 = new MenuServices();
%>

<c:forEach items="${projects_in_working}" var="item">
    <div class="card_content">
        <div>
            <div>
                <span class="label-question">Projeto:</span><br>
                <span class="label-answer"> ${item.title}</span>

            </div>
        </div>
        <div style="display: flex;justify-content: space-between">
            <div>
                <span class="label-question">Código:</span><br>
                <span class="label-answer"> ${item.cod}</span>
            </div>
            <div>
                <span class="label-question">Data Ínicio</span><br>
                <span class="label-answer"> ${item.start_date}</span>
            </div>
            <div>
                <span class="label-question">Data Entrega:</span><br>
                <span class="label-answer"> ${item.end_date}</span>
            </div>
        </div> 
        <div>
            <div style="margin-bottom: 25px"> <span class="label-question">Mapa de Horas:</span></div>
            <div>
                <div class="outside-circle">
                    <div class="middle-circle">
                        <div class="inside-white-circle"> <div class="percentage-text">${item.getFormatLabelTotalHour()}/${item.getFormatLabelWeekHour()}</div> </div>
                    </div>
                </div>


            </div>
            <div  style="margin-top:  25px">
                <div style="display: flex"> <div style="background-color: #31AABD; width: 10px;height: 10px"></div> <span class="label-answer">Horas feitas nesta semana.</span> </div>
                <div style="display: flex"> <div style="background-color: #3D8DAE; width: 10px;height: 10px"></div> <span class="label-answer">Somatoria das horas feitas no total.</span> </div>
            </div>
        </div>
        <div style="display:flex ; justify-content: space-around; margin-top: 30px;">
            <button class="btn-type-1"    <% if (menu_1.isVisible(request, 1)) { %> onclick=" window.location.href = '/CRM_SENSEI/project_view/project_view.jsp?project=${item.id}'" <%}%> > Abrir Projeto </button>
                <button class="btn-type-1" onclick="open_interventions_modal(${item.id})">Adicionar Horas</button>
        </div>

    </div>    
</c:forEach>
<script>

    function open_interventions_modal(id) {
        document.getElementById("modal_crm").style.display = "block";


        fetch('/CRM_SENSEI/interventions/interventions_nar.jsp?project=' + id, {
            method: "GET",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            }
        }).then(function (data) {
            return data.text();

        }).then(function (data) {
            $("#modal_crm #modal_content").html(data);

            //   document.querySelector(".modal-content").innerHTML = data;
        });
    }

    function save() {
        const button = document.querySelector('.btn-1');
        const form = document.querySelector('.formnar');
        let valid = true;
        document.querySelectorAll(".item").forEach(function (m) {
            if (m.value.length == 0) {
                valid = false;
            }
        });
        if (!valid) {

            form.classList.add('form--no');
            document.querySelector(".btn-1").style.backgroundColor = "red";
            setTimeout(function () {
                document.querySelector(".btn-1").style.backgroundColor = "var(--color-primary"
                form.classList.remove('form--no');
            }, 500);
        } else {
            fetch("/CRM_SENSEI/InterventionsController", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
                },
                body: $(".formnar").serialize()}).then(function (data) {
                return data.json();
            }).then(function (data) {

                if (data.redirect) {
                    window.location.href = "/CRM_SENSEI/interventions/interventions_psq.jsp"
                } else {
                    $("#modal_crm .modal-header").text(data.header);
                    $("#modal_crm #modal_content").text(data.body);
                    $("#modal_crm").show();
                }


            });
            //
        }
    }
</script>
<style>

    .card_content{
        position: relative;
        background-color: white;
        width: 350px;
        height: 473px;
        padding-left: 15px;
        padding-right:15px;
        padding-top: 30px;
        border-radius: 10px;
        margin: 30px;


    }
    .label-question{
        font-family: Roboto;
        font-style: normal;
        font-size: 14px;
        line-height: 16px;

    }
    .label-answer{
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 14px;
        line-height: 16px;
        color: #679596;
    }
    .percentage-text{
        padding-top: 25px;
        padding-left: 4px;
        color: #31AABD;
        font-size: 13px;
    }
    .inside-white-circle{
        width: 80px; height: 80px;
        background-color:white;
        border-radius: 50%;

        position: absolute;
        left: 10px;
        top: 10px;

    }
    .outside-circle {
        width: 120px; height: 120px;
        border-radius: 50%;
        background: #D6EEF2;
        background-image:
            linear-gradient(to right, transparent 50%, #3D8DAE 0);
        position: relative;
        left: 30%;
    }
    .outside-circle::before {
        content: '';
        display: block;
        margin-left: 50%;
        height: 100%;
        border-radius: 0 100% 100% 0 / 50%;
        background: #3D8DAE;
        transform-origin: left;
        transform: rotate(.1turn);
        <%-- after  50% change background to #3D8DAE and rotate reset to .1--%>
        <%-- before 50% change background to #D6EEF2 and rotate reset to .1--%>
    }
    .middle-circle {
        position: relative;
        top: -110px;
        left: 10px;
        width: 100px; height: 100px;
        border-radius: 50%;
        background: #D6EEF2;
        background-image:
            linear-gradient(to right, transparent 50%, #31AABD 0);

    }
    .middle-circle::before {
        content: '';
        display: block;
        margin-left: 50%;
        height: 100%;
        border-radius: 0 100% 100% 0 / 50%;
        background: #31AABD;
        transform-origin: left;
        transform: rotate(.1turn);
    }




</style>