<%--
  Created by IntelliJ IDEA.
  User: youndzofrancine
  Date: 11.11.19
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User </title>
</head>
<body>
<form class="form-horizontal" action="/gestionCours/usr/add" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Add User</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Username">Username</label>
            <div class="col-md-4">
                <input id="Username" name="Username" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Firstname">Firstname</label>
            <div class="col-md-4">
                <input id="Firstname" name="Firstname" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Lastname">Lastname</label>
            <div class="col-md-4">
                <input id="LastName" name="Lastname" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password </label>
            <div class="col-md-4">
                <input id="password" name="Password" type="password" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Role">User Role</label>
            <div class="col-md-4">
                <select id="Role" name="Role" class="form-control">
                    <option value="1">Admin</option>
                    <option value="2">Teacher</option>
                    <option value="3">Student</option>
                </select>
            </div>
        </div>
    </fieldset>

    <input type="submit" value = "Submit user"/>
</form>
</body>
</html>
