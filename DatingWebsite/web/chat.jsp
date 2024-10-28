<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />
<section id="hero" class="hero section dark-background">
    <div class="container">
        <div class="row clearfix">
            <div class="col-lg-12">
                <div class="card chat-app">
                    <div id="plist" class="people-list">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-search"></i></span>
                            </div>
                            <input type="text" class="form-control" placeholder="Search...">
                        </div>
                        <ul class="list-unstyled chat-list mt-2 mb-0">
                            <c:forEach var="userchat" items="${sessionScope.userforchat}">
                                <li class="clearfix active">
                                    <img src="${pageContext.request.contextPath}/${userchat.avatar}" alt="avatar">
                                    <div class="about">
                                        <div class="name">${userchat.fullName}</div>
                                        <div class="status"> <i class="fa fa-circle online"></i> online </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="chat">
                        <div class="chat-header clearfix">
                            <div class="row">
                                <div class="col-lg-6">

                                    <a href="javascript:void(0);" data-toggle="modal" data-target="#view_info">
                                        <img src="${personchat.avatar}" alt="avatar">
                                    </a>
                                    <div class="chat-about">
                                        <h6 class="m-b-0">${personchat.fullName}</h6>
                                        <small>Last seen: 2 hours ago</small>
                                    </div>
                                        
                                        
                                </div>
                                <div class="col-lg-6 hidden-sm text-right">
                                    <a href="javascript:void(0);" class="btn btn-outline-secondary"><i class="fa fa-camera"></i></a>
                                    <a href="javascript:void(0);" class="btn btn-outline-primary"><i class="fa fa-image"></i></a>
                                    <a href="javascript:void(0);" class="btn btn-outline-info"><i class="fa fa-cogs"></i></a>
                                    <a href="report?action=form&user2=" class="btn btn-outline-warning"><i class="fa fa-question"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="chat-history">
                            <ul class="m-b-0">
                                <c:forEach var="messend" items="${sessionScope.mesSendList}">
                                    <c:forEach var="mesrei" items="${sessionScope.mesReceivedList}">
                                        <c:choose>
                                            <c:when test="${messend.timestamp lt mesrei.timestamp}">
                                                <li class="clearfix">
                                                    <div class="message-data text-right">
                                                        <span class="message-data-time">${messend.timestamp}</span>
                                                    </div>
                                                    <div class="message my-message float-right">${messend.content}</div>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="clearfix">
                                                    <div class="message-data">
                                                        <span class="message-data-time">${mesrei.timestamp}</span>
                                                    </div>
                                                    <div class="message other-message">${mesrei.content}</div>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="chat-message clearfix">
                            <div class="input-group mb-0">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-send"></i></span>
                                </div>
                                <form action="sendmessage" method="post" class="form-control">
                                    <input type="hidden" name="personchatwith" value="${personchat.username}">
                                    <input type="text" class="form-control" name="content" placeholder="Enter text here...">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
<jsp:include page="static/footer.jsp" />