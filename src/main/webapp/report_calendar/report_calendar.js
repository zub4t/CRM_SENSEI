/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



window.addEventListener("load", function (event) {
    $('select').multipleSelect()



    $(function () {
        $('.date-picker-year').datepicker({
            changeYear: true,
            showButtonPanel: true,
            dateFormat: 'yy',
            onClose: function (dateText, inst) {
                var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                $(this).datepicker('setDate', new Date(year, 1));
            }
        });
        $(".date-picker-year").focus(function () {
            $(".ui-datepicker-month").hide();
        });
    });

});
