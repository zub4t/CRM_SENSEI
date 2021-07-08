<%-- 
    Document   : modal_add_hour
    Created on : May 17, 2021, 10:26:59 AM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="modal-background" onclick="$('.modal-background').hide();">
    <div class="modal-content-interventions">
        <div > <h2 class="header-modal-content-interventions">Adicionar Horas</h2></div>
        <div style="display: flex;flex-flow: row;">
            <div style="width:50%">
                <div >
                    <div class="label-modal-content-interventions">
                        Tarefa Realizada
                    </div>
                    <div>
                        <select class="input-modal-content-interventions"></select>
                    </div>
                </div>
                <div >
                    <div class="label-modal-content-interventions">Horas Realizadas (h/m/s)</div>
                    <div style="display: flex">
                        <select style="width:80px;margin-right:10px" class="input-modal-content-interventions"></select>
                        <select style="width:80px;margin-right:10px" class="input-modal-content-interventions"></select>
                        <select style="width:80px;margin-right:10px" class="input-modal-content-interventions"></select>

                    </div>
                </div>
                <div>
                    <div class="label-modal-content-interventions">
                        Data da Tarefa
                    </div>
                    <div>
                        <input type="data" class="input-modal-content-interventions">
                    </div>
                </div>
            </div>
            <div style="width:50%;padding-left: 20px;">
                <div class="label-modal-content-interventions">Observações:</div>
                <div >
                    <textarea></textarea>
                </div>
            </div>
        </div>
        <div style="display: flex; justify-content: space-around;padding-left: 10px;padding-right: 10px">           
            <button class="btn-type-1">Cancelar</button>
            <button class="btn-type-1" >Adicionar</button>
        </div>
    </div>
</div>
<style>
    .modal-background{
        background-color: rgba(0, 0, 0, 0.68);
        width: 100%;
        height: 100%;
        position: fixed;
        display: none;
    }
    .modal-content-interventions{

        position: fixed;
        left: 30%;
        top: 20%;
        visibility: none;
        background: #FFFFFF;
        border: 1px solid #E5E5E5;
        border-radius: 10px;
        width: 620px;
        height: 427px;
        padding:20px;
    }
    .modal-content-interventions div{
        margin-bottom: 15px;
    }
    .header-modal-content-interventions{

        width: 130px;
        height: 21px;
        font-family: Roboto;
        font-style: normal;
        font-weight: 500;
        font-size: 18px;
        line-height: 21px;
        color: #18494D;

    }
    .label-modal-content-interventions{

        font-family: Roboto;
        font-style: normal;
        font-weight: 500;
        font-size: 14px;
        line-height: 16px;

        color: #18494D
    }
    .input-modal-content-interventions{
        width: 260px;
        height: 40px;
        background: #FFFFFF;
        border: 1px solid #E5E5E5;
        box-sizing: border-box;
        border-radius: 10px;
    }
</style>