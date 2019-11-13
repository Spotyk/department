<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/parts/libraries.jspf"%>

<html lang="en">

<head>
    <meta charset="UTF-8">
   // <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web_resources/css/tablestyle.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Asap:400" rel="stylesheet">
    <title>All products</title>
</head>

<body>

<div class="container-fluid">
    <h1><b>Product table</b></h1>
    <table class="table table-striped table-dark" >
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Country</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Samsung NOTE 10</td>
            <td>Vietnam</td>
            <td>6000</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Apple iMac Pro</td>
            <td>China</td>
            <td>18000</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Sony XPERIA Z1</td>
            <td>China</td>
            <td>8000</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
