/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var calendar = new Object();
function editEvent(event) {
    if (event.name) {
        $("#prj_slct option").each((index, op) => {
            if ($(op).text().replaceAll(' ', '') == (event.name.replaceAll(' ', ''))) {
                $("#prj_slct").val($(op).val())

            }
        })
    }
    if (event.assignment) {
        $("[name='assingment_id'] option").each((index, op) => {
            if ($(op).text().replaceAll(' ', '') == (event.assignment.replaceAll(' ', ''))) {
                $("[name='assingment_id']").val($(op).val())
                console.log($(op).text())

            }
        })
    }

    $('#event-modal input[name="event-index"]').val(event ? event.id : '');
    $('#event-modal input[name="event-name"]').val(event ? event.name : '');
    $('#event-modal input[name="event-location"]').val(event ? event.location : '');
    $('#event-modal input[name="event-start-date"]').datepicker('update', event ? event.startDate : '');
    $('#event-modal input[name="event-end-date"]').datepicker('update', event ? event.endDate : '');
    $('#event-modal').modal();
}

function deleteEvent(event) {
    var dataSource = calendar.getDataSource();


    fetch('/CRM_SENSEI/ScheduleController', {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        },
        body: "pwhat=delete&id=" + event.id
    }).then(function () {
        calendar.setDataSource(dataSource.filter(item => item.id != event.id));

    });



}
async function getColorByAssignment(assignment) {

    const response = await   fetch('/CRM_SENSEI/AssingmentController', {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
        },
        body: "pwhat=getColor&id=" + assignment
    });
    const jr = await response.json();
    const text = await jr.colors;

    return text;
}
async function saveEvent() {
    let project_id = $('#event-modal [name="prjct_selected"]').val();
    let project_name = $('#event-modal [name="prjct_selected"] option[value=' + project_id + ']').text();
    let assignment_id = $('#event-modal [name="assingment_id"]').val();
    let assignment_name = $('#event-modal [name="assingment_id"] option[value=' + assignment_id + ']').text();
    let dsc = $('#event-modal [name="dsc"]').val();
    let startDate = $('#event-modal input[name="event-start-date"]').datepicker('getDate');
    let endDate = $('#event-modal input[name="event-end-date"]').datepicker('getDate');
    let updateId = $('#event-modal input[name="event-index"]').val();
    let id = -1;
    let color = await getColorByAssignment(assignment_id);


    var event = {
        id: id,
        name: project_name,
        location: dsc,
        color: color,
        startDate: startDate,
        endDate: endDate,
        assignment: assignment_name
    };

    var dataSource = calendar.getDataSource();

    if (updateId) {

        for (var i in dataSource) {
            if (dataSource[i].id == updateId) {

                fetch('/CRM_SENSEI/ScheduleController', {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
                    },
                    body: $(".form-horizontal").serialize() + "&pwhat=update&id=" + updateId
                }).then(function () {

                });
                dataSource[i].name = event.name;
                dataSource[i].location = event.location;
                dataSource[i].startDate = event.startDate;
                dataSource[i].endDate = event.endDate;
                dataSource[i].color = await getColorByAssignment(assignment_id);
                calendar.setDataSource(dataSource);


            }
        }
    } else
    {
        fetch('/CRM_SENSEI/ScheduleController', {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded; charset=utf-8",
            },
            body: $(".form-horizontal").serialize() + "&pwhat=insert"
        }).then(function (data) {
            return data.json();

        }).then(function (data) {
            // $("#modal_crm #modal_content").html(data);

            event.id = data.id;
            dataSource.push(event);
            calendar.setDataSource(dataSource);
            //   document.querySelector(".modal-content").innerHTML = data;
        });


    }


    $('#event-modal').modal('hide');

}

function getData(year) {


    fetch(`/CRM_SENSEI/ScheduleController?pwhat=calendar&year=${year}`)
            .then(function (response) {
                return response.json();
            }).then(function (data_incoming) {
        for (let data_aux of data_incoming) {
            data_aux.startDate = new Date(year, data_aux.startMonth, data_aux.startDay)
            data_aux.endDate = new Date(year, data_aux.endMonth, data_aux.endDay)
        }

        data = data_incoming
        setSundayAndSaturdays(year)
        calendar.setDataSource(data);
    })

}
function setSundayAndSaturdays(current_year) {
    for (let month in [...Array(12).keys()]) {
        sundaysInMonth((parseInt(month)), current_year).map((day) => {

            data.push({id: "",
                name: "DOMINGO",
                color: "rgba(255,0,0,0.3)",
                location: "DOMINGO",
                assignment: "DOMINGO",
                startDate: new Date(current_year, month, day),
                endDate: new Date(current_year, month, day),
            })



            data.push({id: "",
                name: "SABADO",
                color: "rgba(255,0,0,0.3)",
                location: "SABADO",
                assignment: "SABADO",
                startDate: new Date(current_year, month, day - 1),
                endDate: new Date(current_year, month, day - 1),
            })

        })
    }
}
$(document).ready(function () {
    let current_year = new Date().getFullYear();
    init(current_year)
    document.querySelector('#calendar').addEventListener('yearChanged', function (e) {
        getData(e.currentYear)
    });
})

function init(current_year) {
    setSundayAndSaturdays(current_year);
    calendar = new Calendar('#calendar', {
        enableContextMenu: true,
        enableRangeSelection: true,
        style: 'background',
        language: 'pt',
        contextMenuItems: [
            {
                text: 'Atualizar',
                click: editEvent
            },
            {
                text: 'Remover',
                click: deleteEvent
            }
        ],
        selectRange: function (e) {
            editEvent({name: e.events[0].name, assignment: e.events[0].assignment, startDate: e.startDate, endDate: e.endDate});
        },
        mouseOnDay: function (e) {
            if (e.events.length > 0) {
                var content = '';

                for (var i in e.events) {
                    content += '<div class="event-tooltip-content">'
                            + '<div class="event-name" style="color:' + e.events[i].color + '" ><b>' + e.events[i].name + '</b></div>'
                            + '<div class="event-location">' + e.events[i].assignment + '</div>'

                            + '</div>';
                }

                $(e.element).popover({
                    trigger: 'manual',
                    container: 'body',
                    html: true,
                    content: content
                });

                $(e.element).popover('show');
            }
        },
        mouseOutDay: function (e) {
            if (e.events.length > 0) {
                $(e.element).popover('hide');
            }
        },
        dayContextMenu: function (e) {
            $(e.element).popover('hide');
        },
        dataSource: data
    });

    $('#save-event').click(function () {
        saveEvent();
    });

}

function daysInMonth(month, year) {
    return new Date(year, month, 0).getDate();
}
function sundaysInMonth(m, y) {
    var getTot = daysInMonth(y, m); //Get total days in a month
    var d = new Date(y, m, 1)
    var sat = new Array();   //Declaring array for inserting Saturdays
    var sun = new Array();   //Declaring array for inserting Sundays

    for (var i = 1; i <= getTot; i++) {    //looping through days in month
        var newDate = new Date(d.getFullYear(), d.getMonth(), i)
        if (newDate.getDay() == 0) {   //if Sunday
            sun.push(i);
        }
        if (newDate.getDay() == 6) {   //if Saturday
            sat.push(i);
        }

    }

    return sun;
}
window.onload = function () {
    $('[name=event-start-date]').datepicker();
    $('[name=event-end-date]').datepicker();
}