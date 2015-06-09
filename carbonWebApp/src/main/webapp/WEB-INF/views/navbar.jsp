 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-default">
   <div class="container-fluid">
     <!-- Brand and toggle get grouped for better mobile display -->
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand">Darkland</a>
     </div>

     <!-- Collect the nav links, forms, and other content for toggling -->
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav">
         <!--li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li-->
		<li><a href="<c:url value='/news' />">News</a></li>
		<li><a href="<c:url value='/library' />">Library</a></li>
		<li><a href="<c:url value='/statistics' />">Statistics</a></li>    

         <!--li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
             <li><a href="#">Action</a></li>
             <li><a href="#">Another action</a></li>
             <li><a href="#">Something else here</a></li>
             <li class="divider"></li>
             <li><a href="#">Separated link</a></li>
             <li class="divider"></li>
             <li><a href="#">One more separated link</a></li>
           </ul>
         </li-->
       </ul>
       <!--form class="navbar-form navbar-left" role="search">
         <div class="form-group">
           <input type="text" class="form-control" placeholder="Search">
         </div>
         <button type="submit" class="btn btn-default">Submit</button>
       </form-->
       <ul class="nav navbar-nav navbar-right">
       	<sec:authorize access="isAnonymous()">
            <li><a href="<c:url value='/login' />">Login</a></li>
			<li><a href="<c:url value='/register' />">Register</a></li>
         </sec:authorize>
         <sec:authorize access="isAuthenticated()">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="<c:url value='/admin'/>" />Admin</a></li>
            </sec:authorize>
			<li><a href="<c:url value='/account'/>" />Account (<i>${pageContext.request.userPrincipal.name}</i>)</a> </li>
            <li><a href="<c:url value='/j_spring_security_logout'/>" />Logout</a></li>
         </sec:authorize>
         <!--li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
           <ul class="dropdown-menu" role="menu">
             <li><a href="#">Action</a></li>
             <li><a href="#">Another action</a></li>
             <li><a href="#">Something else here</a></li>
             <li class="divider"></li>
             <li><a href="#">Separated link</a></li>
           </ul>
         </li-->
       </ul>
     </div><!-- /.navbar-collapse -->
   </div><!-- /.container-fluid -->
 </nav>