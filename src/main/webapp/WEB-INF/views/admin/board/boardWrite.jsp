<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 게시물 생성 폼 -->
 <select id="type">
     <option> 게시판 종류
 </select>
 제목 <input type="text" name="title">
 내용 <input type="text" name="content">
 작성자 <input readonly type="text" name="writer">
 <button type="button" id="btn_insert">글쓰기</button>
 <button type="button" id="btn_list">목록</button>
