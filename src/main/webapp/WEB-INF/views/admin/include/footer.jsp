<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(document).ready(function(){
		$(".leftMenu").click(function(){
			$.ajax({
				url:"board/"+$(this).attr("id"),//+"/page/keyword",
				type:"GET",
				datatype:"html",
				success:function(result){
					alert("성공");
				},
				error:function(){
					alert("실패");
				}
				
			});
		});
	});
</script>