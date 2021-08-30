<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <nav class="nav">
            <ul>
            <c:forEach var="nav" items="${navList}">
                <li class="navVal">
                    <span style="cursor:pointer;">
                        ${nav.name}
                    </span>
                </li>
            </c:forEach>
            </ul>
        </nav>
        
<script>
$(document).ready(function(){
	$(".navVal").click(function(){
		$.ajax({
			url:"/admin/boards?type=&page=1&searchKeyword=&searchType=",
			type:"GET",
			datatype:"text",
			success:function(result){
					$("section").html(result);
			},
			error:function(){
				alert("서버 전송에 실패했습니다.");
			}
			
		});
	})
});
</script>
