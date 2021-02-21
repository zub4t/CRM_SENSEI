<%@page import="java.util.List"%>
<%@page import="management.project.model.ProjectEmployeeTime"%>
<%@page import="management.project.services.ProjectServices"%>
<%
    String id = (session.getAttribute("curProjectId") == null) ? "1" : session.getAttribute("curProjectId").toString();
    List<ProjectEmployeeTime> projectEmployeeTimeList = projectServices.getProjectEmployees(id);
    String employees = "[";
    String data = "[";
    String backgroundColor = "[";
    int max = 255;
    int min = 0;
    boolean flag = false;
    int c = 0;
    for (ProjectEmployeeTime projectEmployeeTime : projectEmployeeTimeList) {
        flag = true;
        employees += "'" + projectEmployeeTime.getEmployee() + "'" + ",";
        data += +projectEmployeeTime.getTime_spent() + ",";
        if (c % 2 == 0) {
            backgroundColor += "'#7b9696',";
        } else {
            backgroundColor += "'#566b6b',";

        }
    }
    if (flag) {
        employees = employees.substring(0, employees.length() - 1);
        data = data.substring(0, data.length() - 1);
        backgroundColor = backgroundColor.substring(0, backgroundColor.length() - 1);

    }
    employees += "]";
    data += "]";
    backgroundColor += "]";
%>

<script>
    var arr_worked_hours = <%=data.length() > 0 ? data : "[]"%>;
    var total_worked_hours = 0;
    for (let hours of arr_worked_hours) {
        total_worked_hours += hours;
    }
    window.addEventListener("load", function (event) {
        $("#total_hours").text(total_worked_hours);

        var idSelected = "<%=id%>";
        if (document.getElementById("projeto_" + idSelected) != null)
            document.getElementById("projeto_" + idSelected).setAttribute("selected", "");
    });

    var employees = <%=employees%>;
    window.addEventListener("load", function (event) {
        const ctx = document.getElementById('myChart').getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: employees,
                datasets: [{
                        label: 'Horas trabalhadas',
                        data: <%=data%>,
                        backgroundColor: <%=backgroundColor%>,
                        borderColor: <%=backgroundColor%>,
                        borderWidth: 1
                    }]
            },
            options: {
                responsive: true,
                responsiveAnimationDuration: 2000,
                maintainAspectRatio: false,
                layout: {
                    /* padding: {
                     left: 50,
                     right: 0,
                     top: 0,
                     bottom: 0
                     }*/
                },

                scales: {
                    yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                }
            }
        });
    });
</script>