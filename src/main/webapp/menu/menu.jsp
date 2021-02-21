<%-- 
    Document   : menu
    Created on : 2/nov/2020, 0:19:04
    Author     : marco
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script><script src="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
<script src="/CRM_SENSEI_EXTERNAL/menu/menu.js"></script>
<script src="/CRM_SENSEI_EXTERNAL/pagination/pagination.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;1,100;1,300;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.css">
<link rel="stylesheet" href="/CRM_SENSEI_EXTERNAL/menu/menu.css?v1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/CRM_SENSEI_EXTERNAL/pagination/pagination.css">
<%@include file="../modal/modal.jsp" %>


<div class="header">
    <div id="user_loggedIn"><%= session.getAttribute("username")%></div>
    <div class="logout_icon" onclick="window.location.href = '/CRM_SENSEI_EXTERNAL/MenuController?pwhat=logout'"><img src="/CRM_SENSEI_EXTERNAL/resources/logout.png" width="20"></div>
</div>
<div class="wall"></div>
<div class="menu-content">
    <c:forEach items="${structure}" var="s"   varStatus="loop">
        <div class="lvl-0">
            <div class="main-nme closed" onclick="openMenuTab(this)" id="${s.parent.getId()}">${s.parent.getNme()}</div>
            <c:forEach items="${s.getChildren()}" var="child">
                <a href="http://localhost:8084/CRM_SENSEI_EXTERNAL${child.getUrl()}"><div class="lvl-1 not-visible childOf-${child.getParent_id()}" id="${child.getId()}" >${child.getNme()}</div></a>
                </c:forEach>
        </div>
    </c:forEach>

    <div class="icon-home" onclick="window.location.href = '/CRM_SENSEI_EXTERNAL/main/main.jsp'">
        <img src="/CRM_SENSEI_EXTERNAL/resources/home-refresh.png" width="40px"/> 
    </div>
</div>
