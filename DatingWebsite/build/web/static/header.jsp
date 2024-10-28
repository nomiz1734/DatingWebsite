<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.userAccount" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title>Do For Love</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <link href="https://fonts.googleapis.com" rel="preconnect">
        <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Jost:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
        <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="./vendor/aos/aos.css" rel="stylesheet">
        <link href="./css/main.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://hammerjs.github.io/dist/hammer.min.js"></script>

    </head>

    <body class="index-page">

        <header id="header" class="header d-flex align-items-center fixed-top">
            <div class="container-fluid container-xl position-relative d-flex align-items-center">

                <a href="home.jsp" class="logo d-flex align-items-center me-auto">
                    <h1 class="sitename">DFLove</h1>
                </a>

                <nav id="navmenu" class="navmenu">
                    <ul>
                        <li><a href="home.jsp" class="active">Home</a></li>
                        <li><a href="findlove">Find love</a></li>
                        <li>
                            <form class="form-inline">
                                <input type="text" class="form-control" placeholder="Search user" aria-label="Search" aria-describedby="search-button">
                            </form>
                        </li>
                        <li><a href="#footer">Contact</a></li>
                    </ul>
                    <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
                </nav>


                <%
                userAccount loggedInUser = (userAccount) session.getAttribute("user");
                if (loggedInUser == null) {
                %>
                <a class="btn-getstarted" href="signup.jsp">Sign up</a>
                <a class="btn-getstarted" href="login.jsp">Log in</a>
                <%
                } else if (loggedInUser.getUserTypeId() == 0){
                %>
                <div class="dropdown" style="margin-left: 300px">
                    <button class="btn btn-danger dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <strong><%= loggedInUser.getUsername() %></strong>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
                        <li><a class="dropdown-item" href="allliked">List you liked</a></li>
                        <li><a class="dropdown-item" href="listlikeprf">List like your profile</a></li>
                        <li><a class="dropdown-item" href="matchlist">Your matched people</a></li>
                        <li><a class="dropdown-item" href="report">Reported list</a></li>
                        <li><a class="dropdown-item" href="chatlist">Message</a></li>
                        <li><a class="dropdown-item" href="logout">Log out</a></li>
                    </ul>
                </div>
                <%
                } else if (loggedInUser.getUserTypeId() == 1){
                %>
                <div class="dropdown" style="margin-left: 300px">
                    <button class="btn btn-danger dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <strong><%= loggedInUser.getUsername() %></strong>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
                        <li><a class="dropdown-item" href="dashboard">Dashboard</a></li>
                        <li><a class="dropdown-item" href="report">Report manage</a></li>
                        <li><a class="dropdown-item" href="logout">Log out</a></li>
                    </ul>
                </div>
                <%
                } 
                %>
            </div>
        </header>