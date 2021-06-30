<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <aside class="aside">
				<ul>
					<c:forEach var="leftMenu" items="${leftMenuList}" >
						<li>
							<a href="${leftMenu.type}">
								${leftMenu.name}
							</a>
						</li>
					</c:forEach>
				</ul>
            </aside>
