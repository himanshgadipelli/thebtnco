<%--
  Created by IntelliJ IDEA.
  User: bobby
  Date: 9/18/2017
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>BTN - Plex V1.0</title>
    <%@include file="../../static/includes.jsp" %>
    <style>
        <%@include file="../../css/plex-movies.css" %>
    </style>
</head>

<body>
<div id="header">
    <%@ include file="../../static/header.jsp" %>
</div>
<div data-ng-app="plexFormSubmit" id="plexFormSubmit">
    <div data-ng-controller="PlexFormController" data-ng-submit="submit()">
        <form class="row-md-10" id="requestForm">
            <div class="row" style="text-align: center"><h3>{{headerText}}</h3></div>
            <div class="row center-allign">
                <table class="center-allign">
                    <tr>
                        <td class="form-row make-bold">Name:</td>
                        <td class="form-row make-bold"><input class="form-control" type="text" data-ng-model="name"
                                                              data-ng-class="{danger:!movie.active}" required></td>
                    </tr>
                    <tr>
                        <td class="form-row make-bold">Language:</td>
                        <td class="form-row make-bold"><select class="form-control" name="language"
                                                               data-ng-model="language">
                            <option value="Telugu">Telugu</option>
                            <option value="Hindi">Hindi</option>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="form-row make-bold">Requested By:</td>
                        <td class="form-row make-bold"><input class="form-control" type="text"
                                                              data-ng-model="requestedBy"
                                                              data-ng-class="{danger:!movie.active}" required></td>
                    </tr>
                    <tr>
                        <td class="form-row make-bold">State:</td>
                        <td class="form-row make-bold"><select class="form-control" name="movieState"
                                                               data-ng-model="movieState">
                            <option value="Not on server">Not on server</option>
                            <option value="Uploaded">Uploaded</option>
                            <option value="Upload in progress">Upload in progress</option>
                            <option value="Movie not found">Movie not found</option>
                        </select></td>
                    </tr>
                </table>
            </div>
            <br>
            <div class="row center-allign" style="text-align: center">
                <button class="btn btn-submit submit" id="submit" type="submit">
                    Submit
                </button>
                <button class="btn btn-submit reset" id="resetForm" type="reset">Reset</button>
            </div>
        </form>
        <div ng-init="getReqMovies()" id="moviesInDb">
            <h3>{{lowerHeaderText}}</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <td>Name</td>
                    <td>Language</td>
                    <td>Requested By</td>
                    <td>Status</td>
                </tr>
                </thead>
                <tbody>
                <tr data-ng-repeat="movie in movieList">
                    <td><span data-ng-hide="editMode">{{movie.name}}</span>
                        <input class="form-control" type="text" data-ng-show="editMode" data-ng-model="newField.name"
                               data-ng-required/></td>
                    <td><span data-ng-hide="editMode">{{movie.language}}</span>
                        <select class="form-control" data-ng-show="editMode" name="newField.language"
                                data-ng-model="newField.language">
                            <option value="Telugu">Telugu</option>
                            <option value="Hindi">Hindi</option>
                        </select>
                    </td>
                    <td><span data-ng-hide="editMode">{{movie.requestedBy}}</span>
                        <input class="form-control" type="text" data-ng-show="editMode"
                               data-ng-model="newField.requestedBy"
                               data-ng-required/>
                    </td>
                    <td><span data-ng-hide="editMode">{{movie.movieState}}</span>
                        <input class="form-control" type="text" data-ng-show="editMode"
                               data-ng-model="newField.movieState"
                               data-ng-required/>
                    </td>
                    <td>
                        <button class="edit-icon" type="submit" data-ng-hide="editMode"
                                data-ng-click="editMode = true; editMovie(movie)">
                            <i class="glyphicon glyphicon-edit"></i></button>
                        <button class="btn btn-submit submit" type="submit" data-ng-show="editMode"
                                data-ng-click="editMode = false; saveField();">Save
                        </button>
                        <button class="btn btn-submit reset" type="submit" data-ng-show="editMode"
                                data-ng-click="editMode = false; cancel()">Cancel
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    <%@include file="../../js/thebtncoApp.js" %>
</script>
</body>
</html>
