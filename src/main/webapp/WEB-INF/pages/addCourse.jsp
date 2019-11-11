<%--
  Created by IntelliJ IDEA.
  User: youndzofrancine
  Date: 11.11.19
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
</head>
<body>
<form class="form-horizontal" action="/gestionCours/course/add" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Add Course</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Coursename">Coursename</label>
            <div class="col-md-4">
                <input id="Coursename" name="Coursename" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Credits">Credits</label>
            <div class="col-md-4">
                <input id="Credits" name="Credits" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Button -->

        <input type="submit" value = "Submit Course"/>
    </fieldset>

</form>
</body>
</html>
