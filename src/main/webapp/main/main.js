function setCurrentProjectId(select){
    var form = document.getElementById("changeChart");
    document.querySelector("[name=curProjectId]").value = select.value;
    form.action = "/CRM_SENSEI_EXTERNAL/ProjectController";
    form.submit();
}