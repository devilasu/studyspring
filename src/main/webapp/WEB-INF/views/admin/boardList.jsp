<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="section">
	<table>
		게시판 목록
		<thead>
			<tr align="center">
				<td>게시판 번호</td>
				<td>게시판 종류</td>
				<td>제목</td>
				<td>내용</td>
				<td>작성자</td>
				<td>조회수</td>
				
			</tr>
		</thead>
		<c:forEach var="boardVO" items="${boardList}">
			<tr align="center">
				<td>${boardVO.idx}</td>
				<td>${boardVO.board_type}</td>
				<td>${boardVO.title}</td>
				<td>${boardVO.content}</td>
				<td>${boardVO.writer}</td>
				<td>${boardVO.viewcount}</td>
			</tr>
		</c:forEach>
	</table>
	<button id="btn_insert_form">게시물 추가</button>
</section>

<script>
	$(document).ready(function(){
		$("#btn_insert_form").click(function(){
			$.ajax({
				url:"",
				type:"",
				dataType:"",
				success:function(result){},
				error:function(){}
			});
		});
	});
</script>