<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <form action="MessageServlet" method="post">
            <table border="1">
                         <caption> Введите информацию о сообщении </caption>
                         <tr> <td> Заголовок сообщения </td>
                    <td><input type="text" name="title"/></td></tr>
                         <tr> <td> Содержание сообщения </td>
                    <td><textarea name="message" rows="5" cols="35"></textarea></td>
            </tr>
            </table>
  		   <input type = "submit" value = "Submit" />
  		   <input type = "reset" value = "clear" />
  	</form>
</body>
</html>