<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />
<div class="tinder">
    <div class="tinder--status">
        <i class="fa fa-remove"></i>
        <i class="fa fa-heart"></i>
    </div>
    
    <div class="tinder--cards">
        <c:forEach var="user" items="${sessionScope.userList}">
            <div class="tinder--card" data-username="${user.username}" data-avatar="${user.avatar}">
                <img src="${user.avatar}" alt="${user.fullName}">
                <h3>${user.fullName}</h3>
                <p>${user.details}</p>
            </div>
        </c:forEach>
    </div>

    <div class="tinder--buttons">
        <button id="nope"><i class="fa fa-remove"></i></button>
        <button id="love"><i class="fa fa-heart"></i></button>
    </div>
</div>

<jsp:include page="static/footer.jsp" />