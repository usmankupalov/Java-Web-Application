package mvc;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public messageServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
          response.setCharacterEncoding("utf-8");
          
//          String title=new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");            
//          String message=new String(request.getParameter("message").getBytes("iso-8859-1"),"utf-8");
          String title=request.getParameter("title");
          String message=request.getParameter("message");
          
          HttpSession session=request.getSession();
          String username= (String)session.getAttribute("username");
          
          Message msg=new Message();                
          Date date = new Date();
          SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String datetime = dateFormat.format(date);
          
          msg.setUsername(username);
          msg.setDatetimestamp(datetime);
          msg.setTitle(title);
          msg.setMessage(message);
          if(new MessageDao().addMessage(msg)){
          // Добавляем сообщение в сессию
              List<MessageDao> msgs=new MessageDao().getAllMessage();
              session.setAttribute("msgs", msgs);
              response.sendRedirect("message.jsp");
          }
          else
              response.sendRedirect("login.jsp");
	}

}
