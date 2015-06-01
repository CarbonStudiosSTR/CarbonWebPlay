<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<jsp:include page="navbar.jsp" />

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



</body>