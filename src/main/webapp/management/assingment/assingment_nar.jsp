<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page pageEncoding="UTF-8"%>



<div class="">
    <div class="form">
        <form class="formnar">
            <div class="form__group">
                <div class="form_label">Descrição da Tarefa:</div>

                <div class="form_item">
                    <input  type="text" name="dsc" placeholder="Descrição da Tarefa" class="form__input  item" />
                </div>
            </div>
            <input type="hidden" name="pwhat" value="insert">
        </form>
        <input class="btn-1" onclick="event.preventDefault();save()" value ="Gravar Tarefa" type="button">

    </div>
</div>        
