<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
      <form action="LoginServlet" method="post">
        <table cellpadding="10px" style="border-style:none;">
            <tr><th></th>                     
                <th></th></tr>    
            
                         <tr> <td> Имя пользователя: </td>
                <td><input type="text" name="username" value=""></td></tr>  
            
                         <tr> <td> Пароль: </td>
            <td><input type="password" name="password" value=""></td></tr>
                         <tr> <td> <input type = "submit" value = "login"> </td> </tr>
        </table>
      
    </form>
     
</body>
</html>