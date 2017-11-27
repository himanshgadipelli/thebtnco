<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BTN Home</title>
</head>
<body>
<%@include file="../../resources/includes.jsp" %>
<%@include file="../../resources/header.jsp" %>
<%@include file="../../resources/footer.jsp" %>
<div data-ng-app="homePage" id="homePage">
    <div data-ng-controller="HomePageController">
        <h1>{{welcomeHeader}}</h1>
    </div>
    <%--<h2> Currently in the process of redesigning the site to use Angular4.</h2>--%>
    <%--<h4> Thank you for your patience.</h4>--%>
    <%--<h4> To know more about this application, please visit the "About this WebApp" tab.</h4>--%>
    <%--<h4> To get in touch with me, go to the "Contact Me" tab. </h4>--%>


</div>
<script type="text/javascript">
    <%@include file="../../resources/js/HomePageApp.js" %>
</script>
</body>
</html>