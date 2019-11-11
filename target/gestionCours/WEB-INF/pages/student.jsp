<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="./assets/paper_img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <base href="${pageContext.request.contextPath}/"/>

    <link href="./assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="./assets/css/demo.css" rel="stylesheet" />
    <link href="./assets/css/examples.css" rel="stylesheet" />
    <link href="./assets/css/registration1.css" rel="stylesheet" />
    <link href="./assets/css/coming-sssoon.css" rel="stylesheet" />
    <link href="./assets/css/profile1.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <link href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link rel=”stylesheet” href=”css/datatables/datatables.css”>
    <!--  fonts for list -->

    <title>Registration page</title>
</head>
<body>
<div class="register-background">
    <!-- Collect the nav links, forms, and other content for toggling -->
    <nav class="mb-1 navbar navbar-expand-lg navbar-dark default-color">
        <a class="navbar-brand" href="#">GC</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
                aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
    <div>
        <div class="container-fluid emp-profile">
            <div class="row">
                <div class="col col-sm-2">
                    <div class="profile-head">
                        <h5 v-show="user.first_name">
                            Profil de: ${users.first_name}
                        </h5>
                    </div>
                </div>
                <div class="col col-sm-2">
                    <i class="fa fa-sign-out fa-2x"></i>
                </div>
            </div>
            <div class="row">
                <div class="col col-sm-2">
                    <div class="profile-img">
                        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="tab-content profile-tab" id="myTabContent">
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>UserName</label>
                                </div>
                                <div class="col-sm-4">
                                    <p> ${users.username} </p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>FirstName</label>
                                </div>
                                <div class="col-sm-4">
                                    <p>${users.first_name}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>LastName</label>
                                </div>
                                <div class="col-sm-4">
                                    <p>${users.last_name}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label>Role</label>
                                </div>
                                <div class="col-sm-4">
                                    <p>${users.usr_role}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="row">
                <div class="col-sm">
                    <div class="profile-work">
                        <h2 class="">Mes cours</h2>
                        <table class="table table-dark table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Nom</th>
                                    <th>ECTS</th>
                                    <th>Professeur</th>
                                    <th>Nombre Inscrit</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="specialcourse" items="${coursesFollowed}">
                                    <tr>
                                        <td>${specialcourse.course.course_name}</td>
                                        <td class="text-center">${specialcourse.course.credit_etcs}</td>
                                        <td>Pr. ${specialcourse.prof.first_name} ${specialcourse.prof.last_name} (${specialcourse.prof.username})</td>
                                        <td class="text-center">${specialcourse.nb_std}</td>
                                        <td class="text-center"><span style="color: tomato"> <i class="fa fa-trash-o red"></i> </span></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script src="./assets/js/ct-paper-checkbox.js"></script>
<script src="./assets/js/pagination.js"></script>
<script src="./assets/js/ct-paper-radio.js"></script>
<script src="./assets/js/bootstrap-select.js"></script>
<script src="./assets/js/bootstrap-datepicker.js"></script>
<script src="./assets/js/student.js"></script>
<script src="./assets/js/ct-paper.js"></script>

<script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>
</html>