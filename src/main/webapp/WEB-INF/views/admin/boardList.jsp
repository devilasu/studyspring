<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="section">
	<table>
		<thead>
			<tr align="center">
				<td style="width:10%;">게시판 번호</td>
				<td style="width:10%;">게시판 종류</td>
				<td style="width:20%;">제목</td>
				<td style="width:20%;">작성자</td>
				<td style="width:5%;">조회수</td>
				<td style="width:35%">내용</td>
				
			</tr>
		</thead>
		<c:forEach var="boardVO" items="${boardList}">
			<tr align="center" onclick="location.href='#'" style="cursor:pointer">
				<td>${boardVO.idx}</td>
				<td>${boardVO.type}</td>
				<td>${boardVO.title}</td>
				<td>${boardVO.writer}</td>
				<td>${boardVO.viewcount}</td>
				<td>${boardVO.content}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="#">prev</a>
	<a href="#">1</a>
	<a href="#">next</a>
	<button id="btn_insert_form">게시물 추가</button>
</section>

<script>
	$(document).ready(function(){
		$("#btn_insert_form").click(function(){
			$.ajax({
				url:"boards/insertForm",
				type:"POST",
				dataType:"",
				success:function(result){},
				error:function(){}
			});
		});
	});
</script>