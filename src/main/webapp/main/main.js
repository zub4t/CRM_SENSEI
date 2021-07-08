function setCurrentProjectId(select) {
    var form = document.getElementById("changeChart");
    document.querySelector("[name=curProjectId]").value = select.value;
    form.action = "/CRM_SENSEI/ProjectController";
    form.submit();
}

function open_interventions_modal() {
    $(".modal-background").show();

}
window.onload = function () {
 
};