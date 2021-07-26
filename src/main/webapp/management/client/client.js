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
    if (valid) {
        if (document.querySelector("[name=tel]").value.length != 9) {
            valid = false;
        }
        if (document.querySelector("[name=email]").value.indexOf("@") == -1) {
            valid = false;
        }
        if (document.querySelectorAll("[name=pass]").length > 0) {
            if (document.querySelectorAll("[name=pass]")[0].value != document.querySelectorAll("[name=pass]")[1].value) {
                valid = false;
            }
        }

    }
    if (!valid) {

        form.classList.add('form--no');
        document.querySelector(".btn-1").style.backgroundColor = "red";
        setTimeout(function () {
            document.querySelector(".btn-1").style.backgroundColor = "var(--color-primary"
            form.classList.remove('form--no');
        }, 500);
    } else {
        fetch("/CRM_SENSEI/ClientController", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            },
            body: $(".formnar").serialize()}).then(function (data) {
            return data.json();

        }).then(function (data) {
            if (data.redirect) {
                window.location.href = "/CRM_SENSEI/management/client/client_psq.jsp"
            } else {
                $("#modal_crm .modal-header").text(data.header);
                $("#modal_crm #modal_content").text(data.body);
                $("#modal_crm").show();
                setTimeout(location.reload(), 1000);
            }
        });


    }
}
function nnew() {
    document.getElementById("modal_crm").style.display = "block";


    fetch('/CRM_SENSEI/management/client/client_nar.jsp', {
        method: "GET",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
        return data.text();

    }).then(function (data) {
        $("#modal_crm #modal_content").html(data);

        // document.querySelector(".modal-content").innerHTML = data;
    });

}
function goToEmployeeId(id) {
    document.getElementById("modal_crm").style.display = "block";
    fetch('/CRM_SENSEI/ClientController?pwhat=edit&id=' + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
        return data.text();

    }).then(function (data) {
        $("#modal_crm #modal_content").html(data);

        //document.querySelector(".modal-content").innerHTML = data;
    });


}

function removeEmployee(id) {
    fetch('/CRM_SENSEI/ClientController?pwhat=delete&id=' + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
        location.reload();

    });


}