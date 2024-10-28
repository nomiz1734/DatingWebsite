<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />


<main class="main">

    <section id="hero" class="hero section dark-background">

        <div class="container">
            <div class="row gy-4">
                <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
                    <h3>Recover password</h3>
                    <form action="sendemail" method="get">
                        <div class="form-group">
                            <label for="code">Fill your email:</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <button type="submit" class="btn btn-primary mt-2">Submit</button>
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