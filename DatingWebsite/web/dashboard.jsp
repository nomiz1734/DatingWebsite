<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />
<section>
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-body-tertiary rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center"> 
                        <h5 class="my-3">Web management</h5>
                        <div class="row">
                            <div class="col-sm-6">
                                <p class="mb-0">Number of user</p>
                            </div>
                            <div class="col-sm-6">
                                <c:if test="${not empty sessionScope.userList}">
                                    <p class="text-muted mb-0">${fn:length(sessionScope.userList)}</p>                                    
                                </c:if>                                
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="d-flex justify-content-center mb-2">
                                <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="dashboard">Dashboard</a></button>
                                <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="report">Report manage</a></button>
                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <h4 class="text-center">List user</h4>
                        <c:forEach var="user" items="${sessionScope.userList}">
                            <div class="row">
                                <div class="col-sm-2">
                                    <p class="mb-0">Full Name</p>
                                </div>
                                <div class="col-sm-4">
                                    <p class="text-muted mb-0">${user.fullName}</p>
                                </div>
                                <div class="col-sm-3">    
                                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                        Warning user
                                    </button>
                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Warning!</h1>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    Warning this user?
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                    <a class="btn btn-warning" href="warninguser?userwa=${user.username}">Warning user</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">   
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal1">
                                        Delete user
                                    </button>
                                    <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h1 class="modal-title fs-5" id="exampleModalLabel1">Delete!</h1>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    Delete this user?
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                    <a class="btn btn-danger" href="deleteuser?userdel=${user.username}">Delete user</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
<jsp:include page="static/footer.jsp" />