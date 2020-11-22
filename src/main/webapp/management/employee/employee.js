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
            if (valid) {
                if (document.querySelector("[name=tel]").value.length != 9) {
                    valid = false;
                }
                if (document.querySelector("[name=email]").value.indexOf("@") == -1) {
                    valid = false;
                }
                if (document.querySelectorAll("[name=pass]")[0].value != document.querySelectorAll("[name=pass]")[1].value) {
                    valid = false;
                }
            }
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
