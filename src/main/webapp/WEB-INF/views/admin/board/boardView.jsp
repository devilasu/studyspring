<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- 게시물 뷰 -->
<section>
	<form id="boardView" name="boardView" method="get">
		<br>
		<c:out value="${boardVO.type}" />
		<br>
		제목 <input type="text" name="title" value="${boardVO.title}">
		<br>
		내용 <input type="text" name="content" value="${boardVO.content}">
		<br>
		작성자 <input readonly type="text" name="writer" value="${boardVO.writer}">
		<br>
		<button type="button"  id="btn_update">수정</button>
		<button type="button"  id="btn_delete">삭제</button>
		<button type="button" id="btn_list">목록</button>
	</form>
</section>

<script>
	$(document).ready(function(){
		$("#btn_list").click(function(){
			history.go(-1);
		});
		
		$("#btn_update").click(function(){
			$("form[name='boardView']").attr("action","/admin/boards/");
			$("form[name='boardView']").submit();
		});
		
		$("#btn_delete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				$.ajax({
					url:"/admin/boards/${boardVO.type}/${boardVO.idx}",
					type:"delete"
				});
			}
		});
	});
</script>