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
                        <li class="breadcrumb-item active" aria-current="page">User Profile</li>
                    </ol>
                </nav>
            </div>
        </div>
        <c:if test="${sessionScope.user.status == 'warning'}">
            <p class="text-muted mb-0">Your account is warning because ${sessionScope.reason}. Next time you're reported, this account will be banned.</p>
        </c:if>

        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="${pageContext.request.contextPath}/${sessionScope.user.avatar}" class="rounded-circle img-fluid" style="width: 150px;" alt="Avatar">
                        <h5 class="my-3">${sessionScope.user.username}</h5>
                        <p class="text-muted mb-1">${sessionScope.user.fullName}</p>
                        <p class="text-muted mb-4">${sessionScope.user.email}</p>
                        <div class="d-flex justify-content-center mb-2">
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="editprofile.jsp">Edit profile</a></button>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="allliked">Your liked</a></button>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="listlikeprf">Like your profile</a></button>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="matchlist">Your match</a></button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Full Name</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${sessionScope.user.fullName}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Email</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${sessionScope.user.email}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Gender</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">
                                    ${sessionScope.user.genderId == 1 ? 'Male' : 
                                      (sessionScope.user.genderId == 2 ? 'Female' : 
                                      (sessionScope.user.genderId == 3 ? 'Other' : ''))}
                                </p>


                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Bio</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${sessionScope.user.details}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Address</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${sessionScope.user.address}</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
<jsp:include page="static/footer.jsp" />