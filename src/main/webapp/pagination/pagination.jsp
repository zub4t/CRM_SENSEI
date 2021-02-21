<%-- 
    Document   : pagination
    Created on : 8/dez/2020, 14:42:49
    Author     : marco
--%>
<script>
    var page = ${pagination.page};
    var max_page = ${pagination.max_page};

    var url = "${pagination.url}"
</script>
<div class="pagination-content">
    <ul class="pagination">
        <li class="page-item"><a class="page-link"  onclick="previus()" ><</a></li>
        <li class="page-item">  <input class="display-n" type="text" disabled="" value="${pagination.page }/${pagination.max_page}"></li>
        <li class="page-item"><a class="page-link" onclick="next()">></a></li>
    </ul>
</nav>
</div>