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

        <form class="formnar" method="POST" action="/CRM_SENSEI/ClientController?pwhat=update">
            <input type="hidden" value="${model.id}" name="id"/>
            <div class="form__group">
                <div class="form_label">Nome :</div>
                <div class="form_item">
                    <input  type="text" value="${model.name}" name="name" placeholder="nome" class="form__input  item" />
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
                <div class="form_label">Nº de Contribuinte: :</div>
                <div class="form_item">
                    <input    type="text" value="${model.num_contribuinte}" name="num_contribuinte" placeholder="" class="form__input item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Localidade</div>
                <div class="form_item">
                    <input    type="text" value="${model.location}" name="location" placeholder="porto" class="form__input item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Endereço</div>
                <div class="form_item">
                    <input    type="text" value="${model.address}" name="address" placeholder="R. dos Merenses 441 1fst andar Vila Chã" class="form__input item" />
                </div>
            </div>
            <input type="hidden" name="pwhat" value="update">
        </form>
        <input class="btn-1" onclick="event.preventDefault();save()" value ="Editar Cliente" type="button">

    </div> 
</div>
