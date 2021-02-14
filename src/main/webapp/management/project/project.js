/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("load", function (event) {

    const button = document.querySelector('.btn-1');
    const form = document.querySelector('.form');
    if (button != null)
        button.addEventListener('click', function () {
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
                fetch("/CRM_SENSEI/ProjectController", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
                    },
                    body: $(".form").serialize()}).then(function (data) {

                    window.location.href = "/CRM_SENSEI/management/project/project_psq.jsp"

                });
            }
        });
});

function goToProjectId(projectId) {
    var form = document.getElementById("goToProject");
    document.querySelector("[name=projectId]").value = projectId;
    form.action = "/CRM_SENSEI/ProjectController";
    form.submit();
}


function removeProject(projectId) {
    var form = document.getElementById("goToProject");
    document.querySelector("[name=projectId]").value = projectId;
    document.querySelector("[name=pwhat]").value = "delete";
    form.action = "/CRM_SENSEI/ProjectController";
    form.submit();
}