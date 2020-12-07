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
function goToInterventionId(id){
    var form = document.getElementById("formId");
    document.querySelector("[name=id]").value = id;
    form.action = "/CRM_SENSEI/InterventionsController";
    form.submit();
}


function removeIntervention(id){
    var form = document.getElementById("formId");
    document.querySelector("[name=id]").value = id;
    document.querySelector("[name=pwhat]").value = "delete";
    form.action = "/CRM_SENSEI/InterventionsController";
    form.submit();
}