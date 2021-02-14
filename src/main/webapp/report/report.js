/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener("load", function (event) {
    $('select').multipleSelect()

    let todaydate = new Date();
    let day = todaydate.getDate();
    let month = todaydate.getMonth() + 1;
    let year = todaydate.getFullYear();
    let todayValue = year + "-" + (month > 10 ? month : "0" + month) + "-" + (day > 10 ? day : "0" + day);
    let fstdayValue = year + "-" + (month > 10 ? month : "0" + month) + "-0" + 1;

    document.getElementById("date_out").value = todayValue;
    document.getElementById("date_in").value = fstdayValue;

});
