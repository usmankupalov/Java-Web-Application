<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
          <table cellpadding="10px" style="border-style:none;">
                                         <caption> <h2> Добро пожаловать на семейную доску сообщений </h2> </caption>
                                         <tr> <th> Человек в сообщении </th>                     
                                                 <th> Заголовок сообщения </th>
                                                 <th> Время сообщения </th>
                                                 <th> Содержание сообщения </th>
                                                 <th> Операция</th> </tr>
  		<%
  			List<Message> msgs=(List)session.getAttribute("msgs");
                       
  			if(msgs!=null){
  				Iterator iter=msgs.iterator();
  				while(iter.hasNext()){
                                    Message msg=(Message)iter.next();
                                    String nickname=new UserDao().selectUserByUsername(msg.getUsername()).getNickname();
                                    int age=new UserDao().selectUserByUsername(msg.getUsername()).getAge();
  		%>
                                         <tr style = "height: 30px;"> <td> <a href="#" style="text-decoration:none;" title="<%=nickname%> Возраст: <% = age%> "> <% = msg.getUsername ()%> </a> </td>
                            <td><%= msg.getTitle() %></td>
                            <td><%= msg.getDatetimestamp()%></td>                         
                            <td><%= msg.getMessage() %></td>
                            <td>
                                <% if(msg.getUsername().equals((String)session.getAttribute("username"))){%>
                                                                 <a href="DeleteMessageServlet?datetimestamp=<%= msg.getDatetimestamp() %> "> Удалить </a>
                            <%
                          ; }
                            %>
                            </td>
                        </tr>
  		<% 
                           
  			}
  			}
  		 %>
  		</table>
</body>
</html>