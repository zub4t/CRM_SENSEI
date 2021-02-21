function getNewPass() {
    let nick = document.querySelector("[name=nickname]").value;
    if (nick.length > 0) {

        fetch("/CRM_SENSEI_EXTERNAL/EmployeeController?pwhat=forgotPass", {
            method: "POST",
            body: JSON.stringify({"nickname": nick}),
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            }
        }).then((data) => {
            return data.text();
        }).then((data) => {
            alert(data);
        });
    } else {
        alert("Não é possível recuperar a senha com o campo de Username vazio.");
        document.querySelector("[name=nickname]").focus();
    }
}

