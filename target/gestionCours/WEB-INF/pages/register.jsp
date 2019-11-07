<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="icon" type="image/png" href="./assets/paper_img/favicon.ico">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

  <title>Registration page</title>

  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
  <meta name="viewport" content="width=device-width" />

  <base href="${pageContext.request.contextPath}/"/>

  <link href="./bootstrap3/css/bootstrap.css" rel="stylesheet" />
  <link href="./assets/css/ct-paper.css" rel="stylesheet"/>
  <link href="./assets/css/demo.css" rel="stylesheet" />
  <link href="./assets/css/examples.css" rel="stylesheet" />
  <link href="./assets/css/registration1.css" rel="stylesheet" />
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

  <!--     Fonts and icons     -->
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>

</head>
<body>
<nav class="navbar navbar-ct-transparent navbar-fixed-top" role="navigation-demo" id="register-navbar">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
  </div><!-- /.container-->
</nav>

<div class="wrapper">
  <div class="register-background">
    <div class="filter-black"></div>

    <div class="container" style="margin-top:40px">
      <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <strong> Sign in to continue</strong>
            </div>
            <div class="panel-body">
              <form role="form" action="#" method="POST">
                <fieldset>
                  <div class="row">
                    <div class="center-block">
                      <img class="profile-img"
                           src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120" alt="">
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                      <div class="form-group">
                        <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span>
                          <input class="form-control" placeholder="Username" name="loginname" type="text" autofocus>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
                          <input class="form-control" placeholder="Password" name="password" type="password" value="">
                        </div>
                      </div>
                      <div class="form-group">
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
                      </div>
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>
            <div class="panel-footer ">
              Don't have an account! <a href="#" onClick=""> Sign Up Here </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
    <div class="footer register-footer text-center">
    </div>
  </div>
</div>

</body>

<script src="./assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="./assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

<script src="./bootstrap3/js/bootstrap.js" type="text/javascript"></script>

<!--  Plugins -->
<script src="./assets/js/ct-paper-checkbox.js"></script>
<script src="./assets/js/ct-paper-radio.js"></script>
<script src="./assets/js/bootstrap-select.js"></script>
<script src="./assets/js/bootstrap-datepicker.js"></script>
<script src="./assets/js/registration1.js"></script>
<script src="./assets/js/ct-paper.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</html>