/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target.id == "modal_crm") {
        document.getElementById("modal_crm").style.display = "none";
    }
}
