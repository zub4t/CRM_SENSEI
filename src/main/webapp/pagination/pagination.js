/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function next() {
    page++;
    //window.location.href=url+"&page="+page;
    fetch(url + "&page=" + page, {
        method: "post"
    }).then(function (response) {
        return response.text();
    }).then(function (data) {
        document.getElementById("table").innerHTML = data;

    });


}
function previus() {
    page--;

    //window.location.href=url+"&page="+page;
    fetch(url + "&page=" + page, {
        method: "post"
    }).then(function (response) {
        return response.text();
    }).then(function (data) {
        document.getElementById("table").innerHTML = data;

    });


}