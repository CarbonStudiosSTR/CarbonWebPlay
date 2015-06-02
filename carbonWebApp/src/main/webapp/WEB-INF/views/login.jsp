<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Darkland</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>
<jsp:include page="navbar.jsp" />
    <div class="container">

        <h1>Login</h1>

         <c:if test="${not empty error}">
            <div class="alert alert-danger">
              ${error}.
            </div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="alert alert-info">
              ${msg}
            </div>
        </c:if>

        <div id="login-box">
            <form class="form-horizontal" role="form" name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
              <div class="form-group">
                <label class="control-label col-sm-2" for="username">Account name:</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="username" name="username" placeholder="Account name">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-2" for="password">Password:</label>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" name="submit" value="submit" class="btn btn-default">Login</button>
                </div>
              </div>
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>



            <!--h2>Login with Username and Password</h2>

            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                  ${error}.
                </div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="alert alert-info">
                  ${msg}
                </div>
            </c:if>

            <form name='loginForm'
              action="<c:url value='/j_spring_security_check' />" method='POST'>

            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='username'></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password' /></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit"
                      value="submit" /></td>
                </tr>
              </table>

              <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />

            </form-->

    </div>
</body>
</html>