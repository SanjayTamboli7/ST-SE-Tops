<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Person Index JSP</title>
	</head>
    <body>
        <form action="MyServlet1" method="post">
            First Name      <input type="text" name="first_name" value="" /><br>
            Last Name       <input type="text" name="last_name" value="" /><br>
            Age             <select name="age">
                            <option>--Select Age--</option>
                            <option>10 to 20</option>
                            <option>20 to 30</option>
                            <option>30 to 40</option>
                            <option>40 to above</option>
                            </select><br>
            Profession      <select name="profession">
                            <option>--Select Profession--</option>
                            <option>Manager</option>
                            <option>Clerk</option>
                            <option>Teacher</option>
                            </select><br>
            <input type="submit" value="Sign In" />
        </form>
    </body>
</html>
