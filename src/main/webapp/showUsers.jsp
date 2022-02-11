<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <style>
        div.abc {
            margin-top: 5%;
            text-align: center;
            width: max-content;
            height: 100%;
            margin-left: auto;
            margin-right: auto;
        }

        table, tr, th, td {
            margin-left: auto;
            margin-right: auto;
            border: 1px solid black;
            border-collapse: separate;
        }

        h3 {
            color: darkcyan;
        }

        td, tr, th {
            padding: 10px;

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

    <title>Hi</title>
</head>
<body>
<div class="header">
    <a href="#default" class="logo">User Management</a>
    <div class="header-right">
        <a href="/parent/create">Register</a>
        <a href="/user">Users</a>

    </div>
</div>
<div class="abc">

    <table>
        <h3>Users(Not child) Information</h3>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>Zip</th>
            <th>Delete Button</th>
            <th>Update Button</th>
        </tr>
        <c:forEach items="${parents}" var="element">
            <tr>
                <td>${element.id}</td>
                <td>${element.firstName}</td>
                <td>${element.lastName}</td>
                <td>${element.address.street}</td>
                <td>${element.address.city}</td>
                <td>${element.address.state}</td>
                <td>${element.address.zip}</td>

                <td>
                    <form action="parent/${element.id}/delete" method="post">
                        <input type="submit" value="delete"/>
                    </form>
                </td>
                <td>
                    <form action="parent/${element.id}/update" method="get">
                        <input type="submit" value="update"/>
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <br>
    <br>
    <br>
    <table>
        <h3>Child's Information</h3>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Parent Name</th>
            <th>Parent Id</th>
            <th>Delete Button</th>
            <th>Update Button</th>
        </tr>
        <c:forEach items="${childs}" var="element">
            <tr>
                <td>${element.id}</td>
                <td>${element.firstName}</td>
                <td>${element.lastName}</td>
                <td>${element.parent.firstName} ${element.parent.lastName}</td>
                <td>${element.parent.id}</td>

                <td>
                    <form action="child/${element.id}/delete" method="post">
                        <input type="submit" value="delete"/>
                    </form>
                </td>
                <td>
                    <form action="child/${element.id}/update" method="get">
                        <input type="submit" value="update"/>
                    </form>
                </td>
            </tr>
            <br>
        </c:forEach>

    </table>

</div>

</body>
</html>