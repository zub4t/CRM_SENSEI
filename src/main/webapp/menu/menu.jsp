<%-- 
    Document   : menu
    Created on : 2/nov/2020, 0:19:04
    Author     : marco
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/CRM_SENSEI/menu/menu.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="/CRM_SENSEI/pagination/pagination.css">

<script src="/CRM_SENSEI/menu/menu.js"></script>
<script src="/CRM_SENSEI/pagination/pagination.js"></script>

<div class="menu-content">
    <c:forEach items="${structure}" var="s"   varStatus="loop">
        <div class="lvl-0">
            <div class="main-nme closed" onclick="openMenuTab(this)" id="${s.parent.getId()}">${s.parent.getNme()}</div>
            <c:forEach items="${s.getChildren()}" var="child">
                <a href="http://localhost:8084/CRM_SENSEI${child.getUrl()}"><div class="lvl-1 not-visible childOf-${child.getParent_id()}" id="${child.getId()}" >${child.getNme()}</div></a>
                </c:forEach>
        </div>
    </c:forEach>

    <div class="icon-home" onclick="window.location.href = '/CRM_SENSEI/main/main.jsp'">
        <img src="https://www.pngkey.com/png/full/241-2414822_home-icon-png-home-icon-svg-white.png" width="20px"/> 
    </div>
</div>