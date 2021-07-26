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

    }
    if (!valid) {

        form.classList.add('form--no');
        document.querySelector(".btn-1").style.backgroundColor = "red";
        setTimeout(function () {
            document.querySelector(".btn-1").style.backgroundColor = "var(--color-primary"
            form.classList.remove('form--no');
        }, 500);
    } else {
        fetch("/CRM_SENSEI/MenuController", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            },
            body: $(".formnar").serialize()}).then(function (data) {
            return data.json();

        }).then(function (data) {
            if (data.redirect) {
                window.location.href = "/CRM_SENSEI/management/gestMenu/gestMenu_psq.jsp";
            } else {
                $("#modal_crm .modal-header").text(data.header);
                $("#modal_crm #modal_content").text(data.body);
                $("#modal_crm").show();
                setTimeout(location.reload(), 1000);

            }


        });

    }
}
function goToMenuId(menuId) {
    document.getElementById("modal_crm").style.display = "block";
    fetch('/CRM_SENSEI/MenuController?pwhat=edit&menuId=' + menuId, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
        return data.text();

    }).then(function (data) {
        document.querySelector(".modal-content").innerHTML = data;
    });


}
