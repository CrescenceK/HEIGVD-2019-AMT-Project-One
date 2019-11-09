<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="./assets/css/student.css" rel="stylesheet" />

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.10/vue.min.js"></script>

<div id="user" class="container profile" style="display: none;">
    <div class="row">
        <div class="col text-center mt-3">
            <img alt="picture" v-bind:src="user.picture" class="img-lg rounded-circle border shadow" />
            <h2 class="mt-3">{{ user.name }}</h2>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">My Courses</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="address-tab" data-toggle="tab" href="#address" role="tab" aria-controls="address" aria-selected="false">Course Credits</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="links-tab" data-toggle="tab" href="#links" role="tab" aria-controls="links" aria-selected="false">My Groups</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <table class="table table-hover table-sm table-properties">
                            <c:forEach items="${usrs}" var="usr">
                                <tr v-show="user.sub">
                                    <th>Firstname</th>
                                    <td style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; max-width: 20rem;">{{usr.firstname}}</td>
                                </tr>
                                <tr v-show="user.uid">
                                    <th>Lastname</th>
                                    <td>{{usr.lastname}}</td>
                                </tr>
                                <tr v-show="user.nickname">
                                    <th>Username</th>
                                    <td>{{usr.username}}</td>
                                </tr>
                                <tr v-show="user.password">
                                    <th>password</th>
                                    <td>{{usr.password}}</td>
                                </tr>
                            </c:forEach>

                    </table>
                </div>

                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                    <table class="table table-hover table-sm table-properties">
                        <tr v-show="user.email">
                            <th>email</th>
                            <td>{{user.email}}</td>
                        </tr>
                        <tr v-show="user.email_verified">
                            <th>email verified</th>
                            <td>{{user.email_verified}}</td>
                        </tr>
                        <tr v-show="user.phone_number">
                            <th>phone number</th>
                            <td>{{user.phone_number}}</td>
                        </tr>
                        <tr v-show="user.phone_number_verified">
                            <th>phone number verified</th>
                            <td>{{user.phone_number_verified}}</td>
                        </tr>
                    </table>
                </div>

                <div class="tab-pane fade" id="address" role="tabpanel" aria-labelledby="address-tab">
                    <table class="table table-hover table-sm table-properties">
                        <tr v-show="user.address.country">
                            <th>country</th>
                            <td>{{user.address.country}}</td>
                        </tr>
                        <tr v-show="user.address.postal_code">
                            <th>postal code</th>
                            <td>{{user.address.postal_code}}</td>
                        </tr>
                        <tr v-show="user.address.locality">
                            <th>locality</th>
                            <td>{{user.address.locality}}</td>
                        </tr>
                        <tr v-show="user.address.region">
                            <th>region</th>
                            <td>{{user.address.region}}</td>
                        </tr>
                        <tr v-show="user.address.street_address">
                            <th>street address</th>
                            <td>{{user.address.street_address}}</td>
                        </tr>
                        <tr v-show="user.address.formatted">
                            <th>formatted</th>
                            <td>{{user.address.formatted}}</td>
                        </tr>
                    </table>
                </div>

                <div class="tab-pane fade" id="links" role="tabpanel" aria-labelledby="links-tab">
                    <table class="table table-hover table-sm table-properties">
                        <tr v-show="user['@id']">
                            <th>@id</th>
                            <td><a v-bind:href="user['@id']">{{user["@id"]}}</a></td>
                        </tr>
                        <tr v-show="user.me">
                            <th>me</th>
                            <td><a v-bind:href="user.me">{{user.me}}</a></td>
                        </tr>
                        <tr v-show="user.website">
                            <th>website</th>
                            <td><a v-bind:href="user.website">{{user.website}}</a></td>
                        </tr>
                        <tr v-show="user.profile">
                            <th>profile</th>
                            <td><a v-bind:href="user.profile">{{user.profile}}</a></td>
                        </tr>
                        <tr v-show="user.webmail">
                            <th>webmail</th>
                            <td><a v-bind:href="user.webmail">{{user.webmail}}</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="./assets/js/student.js"></script>
