/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function openMenuTab(x) {
    if (x.classList.contains("closed")) {
        x.classList.remove("closed");
        x.classList.add("opened");
        let id = x.getAttribute("id");
        document.querySelectorAll(".childOf-" + id).forEach(function (elem) {
            elem.classList.remove("not-visible");
        });
    } else {
        x.classList.add("closed");
        x.classList.remove("opened");
        let id = x.getAttribute("id");
        document.querySelectorAll(".childOf-" + id).forEach(function (elem) {
            elem.classList.add("not-visible");
        });

    }

}
