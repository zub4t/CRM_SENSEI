<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="">
    <div class="form">

        <form class="formnar" method="POST" action="/CRM_SENSEI/EmployeeController?pwhat=update">
            <input type="hidden" value="${model.id}" name="empId"/>
            <div class="form__group">
                <div class="form_label">Nome :</div>
                <div class="form_item">
                    <input  type="text" value="${model.nme}" name="nme" placeholder="nome" class="form__input  item" />
                </div>
            </div>

            <div class="form__group">
                <div class="form_label">Telefone :</div>
                <div class="form_item">
                    <input   type="tel" value="${model.tel}" name="tel" placeholder="913648628" class="form__input item"  pattern="[0-9]{9}" />
                </div>
            </div>

            <div class="form__group">
                <div class="form_label">Email :</div>
                <div class="form_item">
                    <input   type="email" value="${model.email}" name="email" placeholder="seuemail@gmail.com" class="form__input item item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Salário :</div>
                <div class="form_item">
                    <input    type="number" value="${model.salary}" name="salary" placeholder="salary" class="form__input item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Nivel de Acesso :</div>
                <div class="form_item">
                    <input    type="number" value="${model.userLevel}" name="userLevel" placeholder="nivel do user (0 é o mais prioritário)" class="form__input item" />
                </div>
            </div>
            <input type="hidden" name="pwhat" value="update">
        </form>
        <input class="btn-1" onclick="event.preventDefault();save()" value ="Editar Funcionário" type="button">

    </div> 
</div>
