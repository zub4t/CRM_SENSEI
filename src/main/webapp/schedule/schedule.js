/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let calendar = null;
function editEvent(event) {
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
    const text = await jr.color;

    return text;
}
async function saveEvent() {
    let project_id = $('#event-modal [name="prjct_selected"]').val();
    let project_name = $('#event-modal [name="prjct_selected"] option[value=' + project_id + ']').text();
    let assignment_id = $('#event-modal [name="assingment_id"]').val();
    let assignment_name = $('#event-modal [name="prjct_selected"] option[value=' + assignment_id + ']').text();
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
        endDate: endDate
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

$(function () {

    calendar = new Calendar('#calendar', {
        enableContextMenu: true,
        enableRangeSelection: true,
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
            editEvent({startDate: e.startDate, endDate: e.endDate});
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
});

