<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <nav class="nav">
            <ul>
            <c:forEach var="homeMenuVO" items="${homeMenuList}">
                <li>
                    <a href="/home/${homeMenuVO.type}">
                        ${homeMenuVO.name}
                    </a>
                </li>
            </c:forEach>
            </ul>
        </nav>
