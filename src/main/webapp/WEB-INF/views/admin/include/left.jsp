<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <aside class="aside">
				<ul>
					<c:forEach var="leftMenu" items="${leftMenuList}" >
						<li>
							<span class="leftMenu" id="${leftMenu.type}" style="cursor:pointer;">
								${leftMenu.name}
							</span>
						</li>
					</c:forEach>
				</ul>
            </aside>