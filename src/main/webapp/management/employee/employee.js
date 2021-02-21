/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("load", function (event) {

    const button = document.querySelector('.btn-1');
    const form = document.querySelector('.formnar');
    if (button != null)
        button.addEventListener('click', function () {
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
                fetch("/CRM_SENSEI/EmployeeController", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
                    },
                    body: $(".formnar").serialize()}).then(function (data) {
                    return data.json();

                }).then(function (data) {
                    $("#modal_crm .modal-header").text(data.header);
                    $("#modal_crm #modal_content").text(data.body);
                    $("#modal_crm").show();



                });


            }
        });
});

function goToEmployeeId(employeeId) {
    var form = document.getElementById("goToEmployee");
    document.querySelector("[name=empId]").value = employeeId;
    form.action = "/CRM_SENSEI/EmployeeController";
    form.submit();
}

function removeEmployee(employeeId) {
    var form = document.getElementById("goToEmployee");
    document.querySelector("[name=empId]").value = employeeId;
    document.querySelector("[name=pwhat]").value = "delete";
    form.action = "/CRM_SENSEI/EmployeeController";
    form.submit();
}