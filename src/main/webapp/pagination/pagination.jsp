<%-- 
    Document   : pagination
    Created on : 8/dez/2020, 14:42:49
    Author     : marco
--%>
<script>
    var page = ${pagination.page};
    var url = "${pagination.url}"
</script>
<div class="pagination-content">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link"  onclick="previus()" >Previous</a></li>
            <li class="page-item">  <input class="display-n" type="text" disabled="" value="${pagination.page +1}"></li>

            <li class="page-item"><a class="page-link" onclick="next()">Next</a></li>
        </ul>
    </nav>
</div>