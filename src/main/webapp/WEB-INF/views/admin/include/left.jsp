<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside class="aside">
	<ul>
		<c:forEach var="leftMenu" items="${leftMenuList}" >
			<li>
				<span class="leftMenu" id="${leftMenu.type}" style="cursor:pointer;">
					${leftMenu.name}
				</span>
			</li>
		</c:forEach>
	</ul>
</aside>
            
<script>
	$(document).ready(function(){
		$(".leftMenu").click(function(){
			$.ajax({
				url:"/admin/boards/"+$(this).attr("id")+"?page=1&searchKeyword="+"&searchType=",
				type:"GET",
				datatype:"html",
				success:function(result){
					$("section").parent().html(result);
					
				},
				error:function(){
					alert("서버 전송에 실패했습니다.");
				}
				
			});
		});
	});
</script>
            