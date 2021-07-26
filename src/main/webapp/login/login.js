var key;
function getNewPass() {
    let nick = document.querySelector("[name=nickname]").value;

    fetch("/CRM_SENSEI/PageDelivery", {
        method: "POST",
        body: "pwhat=forgotPass",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        }

    }).then((data) => {
        return  data.text();

    }).then((data) => {
        $("#modal_crm .modal-header").text("Recuperação de senha para o usuário  " + nick);
        $("#modal_crm #modal_content").html(data);
        $("#modal_crm").show();
    });
}
function checkPass(nick, pass) {
    fetch("/CRM_SENSEI/EmployeeController", {
        method: "POST",
        body: "pwhat=checkUserPass&nickname=" + nick + "&pass=" + pass,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        }

    }).then((data) => {
        return data.json();
    }).then((obj) => {
        if (obj.id != 0) {
            key = obj.key;
            $("#step_2").show();
            $("#step_1").hide();
        }

    });
}

function setNewPass(pass) {
    let nick = document.querySelector("[name=nickname]").value;
    let obj = {"nickname": nick, "pass": pass, "key": key};
    fetch("/CRM_SENSEI/EmployeeController?pwhat=updatePass", {
        method: "POST",
        body: JSON.stringify(obj),
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then((data) => {
        return data.json();
    }).then((obj) => {
        if (obj.res == "OK") {
            $("#modal_crm .modal-header").text("Sucesso  na alteração de senha para: ' " + nick + " '");
        } else if (obj.res = "KO") {
            $("#modal_crm .modal-header").text("Falha  na alteração de senha para: '" + nick + "'");
        } else {
            $("#modal_crm .modal-header").text("---");

        }
        $("#modal_crm #modal_content").html(obj.data);
    });
}
