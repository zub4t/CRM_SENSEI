function getNewPass(){
    var form = document.getElementById("loginForm");
    form.action = "/CRM_SENSEI/EmployeeController?pwhat=forgotPass";
    form.submit();
}

