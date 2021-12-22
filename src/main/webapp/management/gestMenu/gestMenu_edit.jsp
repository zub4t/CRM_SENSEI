<%-- 
    Document   : gestMenu_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="">
    <div class="form">


        <form class="formnar" method="POST" action="/CRM_SENSEI/MenuController?pwhat=update">
            <input type="hidden" value="${model.id}" name="menuId"/>
            <div class="form__group">
                <div class="form_label">Nome: </div>
                <div class="form_item">
                    <input  type="text" value="${model.nme}" name="nme" placeholder="nome" class="form__input  item" />
                </div>
            </div>
            <div class="form__group">

                <div class="form_label">Nivel de usuario requerido para aceder a esse menu : </div>
                <div class="form_item">
                    <input    type="number" value="${model.userLevel}" name="userLevel" placeholder="level" class="form__input item" />
                </div>
            </div>
            <input type="hidden" name="pwhat" value="update">

        </form>
        <input class="btn-1" onclick="event.preventDefault();save()" value ="Editar Menu" type="button">

    </div>  
</div>
