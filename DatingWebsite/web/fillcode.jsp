<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="static/header.jsp" />


<main class="main">

    <section id="hero" class="hero section dark-background">

        <div class="container">
            <div class="row gy-4">
                <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
                    <h3>Recover password</h3>
                    <form action="sendemail" method="post">
                        <div class="form-group">
                            <label for="code">Fill your code here:</label>
                            <input type="number" class="form-control" id="code" name="code" required>
                            <input type="hidden" name="email" value="${email}">
                        </div>
                        <button type="submit" class="btn btn-primary mt-1">Confirm</button>
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