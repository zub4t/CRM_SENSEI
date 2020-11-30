function setCurrentProjectId(select){
    fetch("/CRM_SENSEI/ProjectController?pwhat=setCurProjectId&curProjectId=" + select.value);
}