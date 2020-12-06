/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("load", function (event) {

    const button = document.querySelector('.btn');
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
                document.querySelector(".btn").style.backgroundColor = "red";
                setTimeout(function () {
                    document.querySelector(".btn").style.backgroundColor = "var(--color-primary"
                    form.classList.remove('form--no');
                }, 500);
            } else {
                document.querySelector(".form").submit();
            }
        });
});

function goToProjectId(projectId){
    var form = document.getElementById("goToProject");
    document.querySelector("[name=projectId]").value = projectId;
    form.action = "/CRM_SENSEI/ProjectController";
    form.submit();
}


function removeProject(projectId){
    var form = document.getElementById("goToProject");
    document.querySelector("[name=projectId]").value = projectId;
    document.querySelector("[name=pwhat]").value = "delete";
    form.action = "/CRM_SENSEI/ProjectController";
    form.submit();
}