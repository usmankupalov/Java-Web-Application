package mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");      
			response.setContentType("utf-8");          
			      
	                HttpSession session=request.getSession();
	                String username=request.getParameter("username").toString();
	                String password=request.getParameter("password").toString();
	                String login=(String)session.getAttribute("username");
			if(new UserDao().checkLogin(username,password)){
	                    if(login==null)
	                        session.setAttribute("username",username);
	                    List<MessageDao> msgs=new MessageDao().getAllMessage();
	                    session.setAttribute("msgs", msgs);
	                    response.sendRedirect("message.jsp");  
	                    }	
	                else
	                    response.sendRedirect("login.jsp");
	}

}
