<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- 게시물 생성 폼 -->
<section>
	<form id="boardWrite" name="boardWrite" method="post">
		<br>
		<select id="type" name="type">
		    <option> 게시판 종류</option>
		    <c:forEach var="board" items="${boardType}">
		    <option value="${board.type}" ${(board.type==type)?'selected':''}>${board.name}</option>
		    </c:forEach>
		</select>
		<br>
		제목 <input type="text" name="title">
		<br>
		내용 <input type="text" name="content">
		<br>
		작성자 <input readonly type="text" name="writer">
		<br>
		<button type="button"  id="btn_write">글쓰기</button>
		<button type="button" id="btn_list">목록</button>
	</form>
</section>

<script>
	$(document).ready(function(){
		$("#btn_list").click(function(){
			history.go(-1);
		});
		
		$("#btn_write").click(function(){
			$("form[name='boardWrite']").attr("action","/admin/boards/"+$("#type").val()+"/write");
			$("form[name='boardWrite']").submit();
		});
	});
</script>