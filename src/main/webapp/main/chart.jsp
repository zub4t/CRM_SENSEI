<%@page import="java.util.List"%>
<%@page import="management.project.model.ProjectEmployeeTime"%>
<%@page import="management.project.services.ProjectServices"%>
<%
    String id = (session.getAttribute("curProjectId") == null) ? "1" : session.getAttribute("curProjectId").toString();
    List<ProjectEmployeeTime> projectEmployeeTimeList = projectServices.getProjectEmployees(id);
    String employees = "[";
    String data = "[";
    String backgroundColor = "[";
    for(ProjectEmployeeTime projectEmployeeTime : projectEmployeeTimeList){
        employees += "'" + projectEmployeeTime.getEmployee() + "'" + ",";
        data += + projectEmployeeTime.getTime_spent()+ ",";
        backgroundColor +=  "'rgba(255, 99, 132, 0.8)',";
    }
    employees = employees.substring(0, employees.length() - 1);
    data = data.substring(0, data.length() - 1);
    backgroundColor = backgroundColor.substring(0, backgroundColor.length() - 1);
    employees += "]";
    data += "]";
    backgroundColor += "]";
%>

<script>
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