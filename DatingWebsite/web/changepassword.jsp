<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />


<main class="main">

    <section id="hero" class="hero section dark-background">

        <div class="container">
            <div class="row gy-4">
                <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
                    <h3>Recover password</h3>
                    <form action="changepassword" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" name="email" value="${email}" >
                        </div>
                        <div class="form-group">
                            <label for="newPassword">New Password</label>
                            <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="Enter new password">
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Confirm New Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm new password">
                        </div>
                        <button type="submit" class="btn btn-primary mt-3">Change Password</button>
                    </form>
                </div>
                <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-out" data-aos-delay="200">
                    <img src="img/home-couple.png" class="img-fluid animated" alt="">
                </div>
            </div>
        </div>

    </section>

</main>

<jsp:include page="static/footer.jsp" />