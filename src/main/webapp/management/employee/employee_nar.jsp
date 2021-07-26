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
        <form class="formnar" method="POST" action="/CRM_SENSEI/EmployeeController?pwhat=insert">
            <div class="form__group">
                <div class="form_label">Nome :</div>
                <div class="form_item">
                    <input  type="text" name="nme" placeholder="nome" class="form__input  item" />
                </div>
            </div>

            <div class="form__group">
                <div class="form_label">Telefone :</div>
                <div class="form_item">
                    <input   type="tel" name="tel" placeholder="913648628" class="form__input item"  pattern="[0-9]{9}" />
                </div>
            </div>

            <div class="form__group">
                <div class="form_label">Email:</div>
                <div class="form_item">
                    <input   type="email" name="email" placeholder="seuemail@gmail.com" class="form__input item item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Salário:</div>
                <div class="form_item">
                    <input    type="number" name="salary" placeholder="salary" class="form__input item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Nivel de Acesso </div>
                <div class="form_item">
                    <input    type="number" name="userLevel" placeholder="nivel do user (0 é o mais prioritário)" class="form__input item" />
                </div>

            </div>
            <div class="form__group">
                <div class="form_label">Nome  de acesso </div>
                <div class="form_item">
                    <input    type="text" name="nickname" placeholder="nickname" class="form__input item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Senha de acesso  </div>
                <div class="form_item">
                    <input    type="password" name="pass" placeholder="senha" class="form__input  item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Confirmação da senha de acesso </div>
                <div class="form_item">
                    <input    type="password" name="pass" placeholder="confirmar senha" class="form__input item" />
                </div>
            </div>
            <input type="hidden" name="pwhat" value="insert">
        </form>
        <input class="btn-1" onclick="event.preventDefault();save()" value ="Registrar Funcionário" type="button">

    </div>
</div>        
