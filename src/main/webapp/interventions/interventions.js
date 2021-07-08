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
        fetch("/CRM_SENSEI/InterventionsController", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            },
            body: $(".formnar").serialize()}).then(function (data) {
            return data.json();

        }).then(function (data) {

            if (data.redirect) {
                window.location.href = "/CRM_SENSEI/interventions/interventions_psq.jsp"
            } else {
                $("#modal_crm .modal-header").text(data.header);
                $("#modal_crm #modal_content").text(data.body);
                $("#modal_crm").show();
                setTimeout(location.reload(), 1000);
            }


        });
        //
    }
}
function nnew() {
    document.getElementById("modal_crm").style.display = "block";


    fetch('/CRM_SENSEI/interventions/interventions_nar.jsp', {
        method: "GET",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
        return data.text();

    }).then(function (data) {
        $("#modal_crm #modal_content").html(data);

        //   document.querySelector(".modal-content").innerHTML = data;
    });

}



function goToInterventionId(id) {
    document.getElementById("modal_crm").style.display = "block";
    fetch('/CRM_SENSEI/InterventionsController?pwhat=edit&id=' + id, {
        method: "POST",
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


function removeIntervention(id) {

    fetch('/CRM_SENSEI/InterventionsController?pwhat=delete&id=' + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        }
    }).then(function (data) {
           location.reload();

    });





}