/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function next() {
    page = parseInt($(".display-n").val()) - 1;
    //window.location.href=url+"&page="+page;
    page++;
    fetch(url + "&page=" + page, {
        method: "post"
    }).then(function (response) {
        return response.text();
    }).then(function (data) {

        document.getElementById("table").innerHTML = data;

    });


}
function previus() {
    page = parseInt($(".display-n").val()) - 1;
    if (page > 0) {
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


}