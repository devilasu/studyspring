<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
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
	<div id="paging" align="center">
		<button value="${searchVO.pageVO.startPageNum-1}" id="btn_paging_prev" ${(searchVO.pageVO.prev)?'':'disabled'}>prev</button>
		<c:forEach begin="${searchVO.pageVO.startPageNum}" end="${searchVO.pageVO.endPageNum}" step="1" var="pageNum">
			<a href="#">${pageNum}</a>
		</c:forEach>
		<button value="${searchVO.pageVO.endPageNum+1}" id="btn_paging_next" ${(searchVO.pageVO.next)?'':'disabled'}>next</button>
	</div>
	<br>
	<select id="searchType" >
		<option value="all" selected="selected">전체</option>
		<option value="title" >제목</option>
		<option value="content" >내용</option>
	</select>
	<input type="text" id="searchKeyword">
	<button id="btn_search">검색</button>
	
	<!-- <button id="btn_insert_form">게시물 추가</button> -->
	
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
		$("#btn_paging_prev").click(function(){
			$.ajax({
				url:"/admin/boards/${searchVO.type}?page="+$(this).val()+"&searchKeyword="+"&searchType=",
				type:"GET",
				dataType:"",
				success:function(result){
					$("section").parent().html(result);
					},
				error:function(){alert("서버 전송에 실패했습니다.");}
			});
		});
		$("#btn_paging_next").click(function(){
			$.ajax({
				url:"/admin/boards/${searchVO.type}?page="+$(this).val()+"&searchKeyword="+"&searchType=",
				type:"GET",
				dataType:"",
				success:function(result){ 
					$("section").parent().html(result);
					},
				error:function(){alert("서버 전송에 실패했습니다.");}
			});
		});
		$("#btn_search").click(function(){
			$.ajax({
				url:"${url}&page=${searchVO.pageVO.page}",
				type:"GET",
				dataType:"",
				success:function(result){ 
					alert(keyword);
					$("section").parent().html(result);
					},
				error:function(){}
			});
		});
	});
</script>