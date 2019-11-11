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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="./bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="./assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="./assets/css/demo.css" rel="stylesheet" />
    <link href="./assets/css/examples.css" rel="stylesheet" />
    <link href="./assets/css/registration1.css" rel="stylesheet" />
    <link href="./assets/css/coming-sssoon.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <link rel=”stylesheet” href=”//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css”>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link rel=”stylesheet” href=”css/datatables/datatables.css”>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
        <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-user"> Login </i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-default"
                         aria-labelledby="navbarDropdownMenuLink-333">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <div>
        <div class="container">
            <table id="example" class="table table1 paging_full_numbers table-dark table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Cours_name</th>
                    <th>credits_cts</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${usrs}" var="usr">
                    <tr>
                        <td> ${usr.course_name}</td>
                        <td> ${usr.credit_etcs}</td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <th>Cours_name</th>
                    <th>credits_cts</th>
                </tr>
                </tfoot>
            </table>
        </div>

    </div>
</div>
</body>
    <script src="./assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="./assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

<script src="./bootstrap3/js/bootstrap.js" type="text/javascript"></script>

<!--  Plugins -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./assets/js/ct-paper-checkbox.js"></script>
<script src="./assets/js/pagination.js"></script>
<script src="./assets/js/ct-paper-radio.js"></script>
<script src="./assets/js/bootstrap-select.js"></script>
<script src="./assets/js/bootstrap-datepicker.js"></script>
<script src="./assets/js/registration1.js"></script>
<script src="./assets/js/ct-paper.js"></script>
<script src="./assets/js/jquery.js" type="text/javascript"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>

<script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>
</html>