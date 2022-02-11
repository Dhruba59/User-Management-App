<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <style type="text/css">
        div {
            text-align: center;
        }

        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }

        input[type=text], select {
            width: 200px;
            height: 20px;
            margin: 10px;
        }

        h2 {
            text-align: center;
        }

        button {
            padding: 10px;
            margin: 25px;
            width: 120px;
            height: 40px;
        }

        .header {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            overflow: hidden;
            background-color: #f1f1f1;
            padding: 20px 10px;

        }

        .header a {
            float: left;
            color: black;
            text-align: center;
            padding: 12px;
            text-decoration: none;
            font-size: 18px;
            line-height: 25px;
            border-radius: 4px;
            margin-right: 10%;
            background-color: darkseagreen;

        }

        .header a.logo {
            font-size: 25px;
            font-weight: bold;
            text-align: center;
            color: darkblue;
            background-color: bisque;
        }

        .header a:hover {
            background-color: #ddd;
            color: darkcyan;
        }

        .header-right {
            float: right;
            display: flex;
            flex-direction: row;
            margin-right: 4%;
        }

        @media screen and (max-width: 500px) {
            .header a {
                float: none;
                display: block;
                text-align: left;
            }

            .header-right {
                float: none;
            }
        }
    </style>
    <title>User Registration Form</title>
</head>
<body>
<div class="header">
    <a href="#default" class="logo">User Management</a>
    <div class="header-right">
        <a class="active" href="/parent/create">Register</a>
        <a class="active" href="/user">Users</a>

    </div>
</div>
<div>
    <h2>User Registration</h2>
    <form:form action="/parent/create" method="post" modelAttribute="parentDTO">
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName"/><br/>

        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName"/><br/>

        <form:label path="street">street:</form:label>
        <form:input path="street"/><br/>

        <form:label path="city">City:</form:label>
        <form:input path="city"/><br/>

        <form:label path="state">State:</form:label>
        <form:input path="state"/><br/>

        <form:label path="zip">zip</form:label>
        <form:input path="zip"/><br/>

        <form:button>Register</form:button>
    </form:form>
    Are you a <b>child</b>!
    <a href="/child/create"> Click here</a>
    to register.
</div>
</body>
</html>