<footer id="footer" class="footer">
    <div class="container footer-top">
        <div class="row gy-4">
            <div class="col-lg-4 col-md-6 footer-about">
                <a href="index.html" class="d-flex align-items-center">
                    <span class="sitename">Do for love</span>
                </a>
                <div class="footer-contact pt-3">
                    <p>FPT</p>
                    <p>Da nang</p>
                </div>
            </div>

            <div class="col-lg-2 col-md-3 footer-links">
                <h4>About us</h4>
                <ul>
                    <li><i class="bi bi-chevron-right"></i> <a href="#">Home</a></li>
                    <li><i class="bi bi-chevron-right"></i> <a href="#">About us</a></li>
                    <li><i class="bi bi-chevron-right"></i> <a href="#">Services</a></li>
                    <li><i class="bi bi-chevron-right"></i> <a href="#">Terms of service</a></li>
                </ul>
            </div>

        </div>
    </div>

</footer>

<!-- Scroll Top -->
<a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Preloader -->
<div id="preloader"></div>

<!-- Vendor JS Files -->
<script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="./vendor/aos/aos.js"></script>
<script src="./vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="./js/swipecard.js"></script>
<script src="https://hammerjs.github.io/dist/hammer.min.js"></script>
<!-- Main JS File -->
<script>
    $(document).ready(function () {
        $(".like").click(function () {
            $(".card").addClass("animate-left");
        });
        $(".dislike").click(function () {
            $(".card").addClass("animate-right");
        });
    });
</script>
<script src="./js/main.js"></script>

</body>

</html>