/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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


        fetch("/CRM_SENSEI/AssingmentController", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            },
            body: $(".formnar").serialize() + "&pwhat=insert"}).then(function (data) {
            return data.json();

        }).then(function (data) {
            $("#modal_crm .modal-header").text(data.header);
            $("#modal_crm #modal_content").text(data.body);
            $("#modal_crm").show();
            setTimeout(location.reload(), 1000);


        });
    }

}



function update(id) {
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


        fetch("/CRM_SENSEI/AssingmentController", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            },
            body: $(".formnar").serialize() + "&pwhat=update&id="+id}).then(function (data) {
            return data.json();

        }).then(function (data) {
            $("#modal_crm .modal-header").text(data.header);
            $("#modal_crm #modal_content").text(data.body);
            $("#modal_crm").show();
            setTimeout(location.reload(), 1000);


        });
    }

}



function nnew() {
    document.getElementById("modal_crm").style.display = "block";


    fetch('/CRM_SENSEI/management/assingment/assingment_nar.jsp', {
        method: "GET",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
        return data.text();

    }).then(function (data) {
        //document.querySelector(".modal-content").innerHTML = data;
        $("#modal_crm #modal_content").html(data);

    });

}
function goToAssingment(id) {

    document.getElementById("modal_crm").style.display = "block";

    fetch('/CRM_SENSEI/AssingmentController', {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        },
        body: "pwhat=edit&id=" + id
    }).then(function (data) {
        return data.text();

    }).then(function (data) {
        //document.querySelector(".modal-content").innerHTML = data;
        $("#modal_crm #modal_content").html(data);

    });

}
function removeAssingment(id) {

    fetch('/CRM_SENSEI/AssingmentController?pwhat=delete&id=' + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
        location.reload();

    });


}
function saveOrder() {
    let aux = "{";
    $("#sortable div.values-table-content").each(function (k, v) {
        aux += '"' + k + '":"' + $(v).attr("task") + '",'
    });
    aux = aux.substring(0, aux.length - 1);
    aux += "}";
    let size = $("#sortable div.row").length;
    fetch("/CRM_SENSEI/AssingmentController?pwhat=saveOrder&size=" + size, {
        method: "POST",
        body: aux,
        headers: {
            "Content-Type": "application/json; charset=utf-8",
        }
    }).then(function (data) {
        console.log(data);
        return data.text();
    }).then(function (data) {
        alert(data);
    });

}