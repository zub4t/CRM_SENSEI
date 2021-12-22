/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function changeToOpenCss() {

    document.getElementById("open").classList.remove("inactive");
    document.getElementById("open").classList.add("active");


    document.getElementById("closed").classList.add("inactive");
    document.getElementById("closed").classList.remove("active");


    document.getElementById("order").classList.add("inactive");
    document.getElementById("order").classList.remove("active");


}
function changeToOpen(id) {

    fetch("/CRM_SENSEI/ProjectController", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        },
        body: "pwhat=changeStts&projectId=" + id + "&stts=1"
    }).then(function (data) {
        return data.json();

    }).then(function (data) {

        $("#modal_crm .modal-header").text(data.header);
        $("#modal_crm #modal_content").text(data.body);
        $("#modal_crm").show();
        changeToOpenCss();



    });
}
function changeToOrder(id) {

    fetch("/CRM_SENSEI/ProjectController", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        },
        body: "pwhat=changeStts&projectId=" + id + "&stts=2"
    }).then(function (data) {
        return data.json();

    }).then(function (data) {

        $("#modal_crm .modal-header").text(data.header);
        $("#modal_crm #modal_content").text(data.body);
        $("#modal_crm").show();
        changeToOrderCss();



    });
}

function changeToOrderCss() {

    document.getElementById("order").classList.remove("inactive");
    document.getElementById("order").classList.add("active");


    document.getElementById("open").classList.add("inactive");
    document.getElementById("open").classList.remove("active");


    document.getElementById("closed").classList.add("inactive");
    document.getElementById("closed").classList.remove("active");
}


function changeToClosedCss() {

    document.getElementById("closed").classList.remove("inactive");
    document.getElementById("closed").classList.add("active");


    document.getElementById("open").classList.add("inactive");
    document.getElementById("open").classList.remove("active");


    document.getElementById("order").classList.add("inactive");
    document.getElementById("order").classList.remove("active");
}
function changeToClosed(id) {


    fetch("/CRM_SENSEI/ProjectController", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        },
        body: "pwhat=changeStts&projectId=" + id + "&stts=0"
    }).then(function (data) {
        return data.json();

    }).then(function (data) {

        $("#modal_crm .modal-header").text(data.header);
        $("#modal_crm #modal_content").text(data.body);
        $("#modal_crm").show();
        changeToClosedCss();



    });

}
