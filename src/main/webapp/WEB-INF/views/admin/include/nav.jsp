<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <nav class="nav">
            <ul>
            <c:forEach var="adminMenuVO" items="${adminMenuList}">
                <li>
                    <a href="/admin/${adminMenuVO.type}s">
                        ${adminMenuVO.name}
                    </a>
                </li>
            </c:forEach>
            </ul>
        </nav>
