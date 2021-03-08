/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var menu_mobile_status = 1;
var initial_menu_mobile_position = 38;
window.onload = function () {
    var isMobile = /iPhone|iPad|iPod|Android/i.test(navigator.userAgent);
    if (isMobile) {
        setUpMobile();
    }
    setUpMobile();
    window.addEventListener('resize', setUpMobile);
}




function setUpMobile() {
    if ($(window).width() <= 1500) {
        $("#13").hide();

        let header = new Array();
        $("#table tr:nth-of-type(1) td:not(:nth-of-type(1))").each(function (index, element) {
            header.push($(element).text())
        });

        $("#table tr:not(:nth-of-type(1)):not(:last) td:nth-of-type(1)").click(function (element) {
            if ($($(element.currentTarget.parentElement).next()[0]).find(".table-content-mobile").length > 0) {

                $($(element.currentTarget.parentElement).next()[0]).remove();
                return;
            }

            let div_content = document.createElement("div");
            let aux_height = header.length * 22;
            div_content.style.height = aux_height + "px";
            div_content.classList.add("table-content-mobile");
            let info_list = [];
            $(element.currentTarget.parentElement).find("td:not(:nth-of-type(1))").each(function (index, element) {
                let aux = "{\"" + header[index] + "\":\"" + $(element).text().replaceAll("\n", "").replaceAll(" ", "") + "\"}"

                let div_label = document.createElement("div");
                div_label.style.width = "50%";
                div_label.innerHTML = header[index];

                let div_value = document.createElement("div");
                div_value.style.width = "50%";
                div_value.classList.add("dots3");
                div_value.innerHTML = $(element).html();


                let div_row = document.createElement("div");
                div_row.style.width = "100%";
                div_row.style.display = "flex";
                div_row.style.borderBottom = "1px solid white";

                div_row.appendChild(div_label);
                div_row.appendChild(div_value);

                div_content.appendChild(div_row);

                info_list.push(JSON.parse(aux));
            });



            // console.log(info_list);
            let row = document.createElement("tr");
            let column = document.createElement("td");
            column.colspan = "10";
            column.appendChild(div_content);
            row.appendChild(column);
            $(element.currentTarget.parentElement).after(row);
        });

    } else {
        $("#table tr:not(:nth-of-type(1)):not(:last) td:nth-of-type(1)").unbind("click");
        $("#table_container").removeAttr("style");
        $(".table-content-mobile").parent().parent().remove();
        $("#13").removeAttr("style");
    }


}
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
function mobile_menu() {
    let c = 0;
    if (menu_mobile_status == 1) {

        menu_mobile_status = 0;
        $('.menu-mobile').animate({borderSpacing: 200}, {
            step: function (now, fx) {
                $(this).css('transform', 'rotate(' + now + 'deg)');

                $(".menu-content").css("left", now - 200);
            },
            duration: 'fast'
        }, 'linear');
    } else {
        menu_mobile_status = 1;
        $('.menu-mobile').animate({borderSpacing: 0}, {
            step: function (now, fx) {
                $(this).css('transform', 'rotate(' + now + 'deg)');


                $(".menu-content").css("left", now - 200);

            },
            duration: 'fast'
        }, 'linear');
    }
}