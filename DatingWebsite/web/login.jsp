<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />
<section id="hero" class="hero section dark-background">

    <div class="container">
        <div class="row gy-4">
            <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center" data-aos="zoom-out">
                <h2>Log in</h2>
                <form action="login"> 
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Enter here">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter here">
                    </div>
                    <div class="col-12 my-3 row">
                        <div class="col-6 text-start">
                            <input type="checkbox" name="remember"/>
                            <span>Remember me?</span>
                        </div>
                        <div class="col-6 text-end">
                            <a href="forgotpassword.jsp" class="link-dark text-end">
                                <span class="">Forgot password?</span>
                            </a>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 5px">
                        <button type="submit" class="btn btn-danger">LOG IN</button>
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