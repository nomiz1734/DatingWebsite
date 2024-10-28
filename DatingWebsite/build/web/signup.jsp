<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />
<section id="hero" class="hero section dark-background">

    <div class="container">
        <div class="row gy-4">
            <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center" data-aos="zoom-out">
                <h2>Sign up</h2>
                <form action="signup" method="post">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter here">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter here">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter here">
                    </div>
                    <div class="form-group">
                        <label for="confirm-password">Confirm password</label>
                        <input type="password" class="form-control" id="confirm-password" name="confirm-password" placeholder="Enter here">
                    </div>
                    <div class="form-group" style="margin-top: 5px">
                        <button type="submit" class="btn btn-danger">SIGN UP</button>
                    </div>                    
                </form>
            </div>
            <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-out" data-aos-delay="200">
                <img src="img/home-couple.png" class="img-fluid animated" alt="">
            </div>
        </div>
    </div>

</section>
<jsp:include page="static/footer.jsp" />