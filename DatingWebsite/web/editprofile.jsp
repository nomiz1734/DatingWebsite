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
                        <li class="breadcrumb-item active" aria-current="page">Edit Profile</li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="${sessionScope.user.avatar}" alt="avatar"
                             class="rounded-circle img-fluid" style="width: 150px;">
                        <h5 class="my-3">${sessionScope.user.username}</h5>
                        <p class="text-muted mb-1">${sessionScope.user.fullName}</p>
                        <p class="text-muted mb-4">${sessionScope.user.email}</p>
                        <div class="d-flex justify-content-center mb-2">
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="editprofile.jsp">Edit profile</a></button>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="likelist.jsp">Your liked</a></button>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="matchlist.jsp">Your match</a></button>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="listlikeprf">Like your profile</a></button>
                            <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1"><a href="report">Reported List</a></button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2>Edit your profile</h2>
                        <form action="editprofile" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Avatar</p>
                                </div>
                                <div class="col-sm-9">
                                    <input type="file" name="avatar" class="form-control" required>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Full Name</p>
                                </div>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="fullname" value="${sessionScope.user.fullName}" required>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Gender</p>
                                </div>
                                <div class="col-sm-9">
                                    <select name="genderId" class="form-control" required>
                                        <option value="1" ${sessionScope.user.genderId == 1 ? 'selected' : ''}>Male</option>
                                        <option value="2" ${sessionScope.user.genderId == 2 ? 'selected' : ''}>Female</option>
                                        <option value="3" ${sessionScope.user.genderId == 3 ? 'selected' : ''}>Other</option>
                                    </select>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Bio</p>
                                </div>
                                <div class="col-sm-9">
                                    <input type="text" name="details" class="form-control" value="${sessionScope.user.details}" required>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Address</p>
                                </div>
                                <div class="col-sm-9">
                                    <input type="text" name="address" class="form-control" value="${sessionScope.user.address}" required>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Facebook</p>
                                </div>
                                <div class="col-sm-9">
                                    <input type="text" name="facebook" class="form-control" value="${sessionScope.user.facebook}" required>
                                </div>
                            </div>
                            <hr>
                            <button type="submit" class="btn btn-primary">Save Changes</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="static/footer.jsp" />