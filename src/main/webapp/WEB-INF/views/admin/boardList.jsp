<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="section">
	<ul>
		<c:forEach var="leftMenu" items="${leftMenuList}" >
			<li>
				<a href="">
					${leftMenu.board_name}
				</a>
			</li>
		</c:forEach>
	</ul>
</section>