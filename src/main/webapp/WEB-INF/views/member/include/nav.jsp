<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <nav class="nav">
            <ul>
            <c:forEach var="nav" items="${navList}">
                <li>
                    <a href="/home/${nav.type}">
                        ${nav.name}
                    </a>
                </li>
            </c:forEach>
            </ul>
        </nav>
