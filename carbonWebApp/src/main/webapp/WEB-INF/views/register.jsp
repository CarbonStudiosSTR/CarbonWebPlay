<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<title>Darkland</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>
    <jsp:include page="navbar.jsp" />

    <div class="container">
        <h1>
            Create account
        </h1>

        <c:url var="addAction" value="/register/create" ></c:url>

        <form:form action="${addAction}" commandName="account">
        <table>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">
                        <spring:message text="email"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="email" />
                </td>
            </tr>
                <tr>
                    <td>
                        <form:label path="password">
                            <spring:message text="password"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="password" />
                    </td>
                </tr>
                    <tr>
                        <td>
                            <form:label path="creationDate">
                                <spring:message text="creationDate"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="creationDate" />
                        </td>
                    </tr>
                <tr>
                <td colspan="2">
                        <input type="submit"
                            value="<spring:message text="Edit Person"/>" />
                </td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>