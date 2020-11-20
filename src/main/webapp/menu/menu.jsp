<%-- 
    Document   : menu
    Created on : 2/nov/2020, 0:19:04
    Author     : marco
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/CRM_SENSEI/menu/menu.css">
<script src="/CRM_SENSEI/menu/menu.js"></script>
<div class="menu-content">
    <c:forEach items="${structure}" var="s"   varStatus="loop">
        <div class="lvl-0">
            <div class="main-nme closed" onclick="openMenuTab(this)" id="${s.parent.getId()}">${s.parent.getNme()}</div>
            <c:forEach items="${s.getChildren()}" var="child">
                <div class="lvl-1 not-visible childOf-${child.getParent_id()}" id="${child.getId()}" >${child.getNme()}</div>
            </c:forEach>
        </div>
    </c:forEach>
</div>