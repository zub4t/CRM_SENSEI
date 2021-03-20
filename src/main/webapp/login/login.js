function getNewPass() {
    let nick = document.querySelector("[name=nickname]").value;

    $("#modal_crm .modal-header").text("Recuperação de senha para o usuário  " + nick);
    $("#modal_crm #modal_content").html('<div><div>Porfavor forneça as credencias de de uma conta administradora</div><div id="input-group"><div class="group"><input type="text" name="nickname_admin" required><span class="highlight"></span><span class="bar"></span><label>Username</label></div><div class="group"><input type="password" name="pass_admin" required><span class="highlight"></span><span class="bar"></span><label>Password</label></div><div class="group"><input style="cursor:pointer" type="button" onclick="event.preventDefault();" value="Prosseguir"></div><div class="group"></div></div></div>');
    $("#modal_crm").show();

    /*
     if (nick.length > 0) {
     
     fetch("/CRM_SENSEI/EmployeeController?pwhat=forgotPass", {
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
     }*/


}

