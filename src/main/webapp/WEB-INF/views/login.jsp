      <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

      
                            <title>Login</title>    
                            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                           
</head>
	<body>
		  <div id="signin">

 <form action="/perform_login" method="post">
    <fieldset>
        <legend>Please Login</legend>
        <!-- use param.error assuming FormLoginConfigurer#failureUrl contains the query parameter error -->
        
        <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>
        </p>
        <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
        </p>
        <!-- if using RememberMeConfigurer make sure remember-me matches RememberMeConfigurer#rememberMeParameter -->
        <p>
        <label for="remember-me">Remember Me?</label>
        <input type="checkbox" id="remember-me" name="remember-me"/>
        </p>
        <div>
            <button type="submit" class="btn">Log in</button>
        </div>
    </fieldset>
 </form>
        
        </div>
        
	</body>
</html>
