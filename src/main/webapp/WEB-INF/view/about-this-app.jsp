<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About this WebApp</title>
</head>
<body>
<%@include file="../../resources/includes.jsp" %>
<%@include file="../../resources/header.jsp" %>
<%@include file="../../resources/footer.jsp" %>
<div data-ng-app="aboutThisApp" id="aboutThisApp">
    <div data-ng-controller="AboutThisAppController">
        <h3 class="make-bold">{{welcomeHeader}}</h3>

        <h4><span class="make-bold">Domain</span> : This domain has been purchased from <a
                href="https://domains.google.com">domains.google.com</a>.
        </h4>
        <h4><span class="make-bold">Routing</span> : Domain is routed to an aws instance using
            <a href="https://aws.amazon.com/route53/">AWS Route 53</a>.
        </h4>
        <h4><span class="make-bold">Server</span> : The server is <a href="http://tomcat.apache.org/">Apache Tomcat</a>,
            running on an <a href="https://aws.amazon.com/ec2/">AWS EC2</a> instance.
        </h4>
        <h4><span class="make-bold">Tech stack</span> : The web app has been developed using Java, Spring MVC, servlets,
            jQuery, AngularJS and bootstrap.</h4>
        <h4><span class="make-bold">Purpose</span> : To improve the skills I have and add new ones to the stack.
        </h4>
        <h4><span class="make-bold">Methodology</span>: TDD is currently being implemented.
        </h4>
        <h4><span class="make-bold">VCS</span> : Git is currently being used as the VCS. Code repository is stored on
            <a href="https://www.bitbucket.org" target="_blank">www.bitbucket.org</a>
        </h4>
    </div>
</div>
<script type="text/javascript">
    <%@include file="../../resources/js/HomePageApp.js" %>
</script>
</body>
</html>