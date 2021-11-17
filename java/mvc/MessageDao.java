package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
	 public List<MessageDao> getAllMessage(){  
         List<MessageDao> list = new ArrayList<MessageDao>();  
         Connection conn = Helper.getConnection();
         String sql  = "select * from message";  
         try {
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rst = pst.executeQuery();
             while (rst.next()) {
                 MessageDao userMessage = new MessageDao();
                 userMessage.setTitle(rst.getString("title"));
                 userMessage.setUsername(rst.getString("username"));
                 userMessage.setMessage(rst.getString("message"));
                 userMessage.setDatetimestamp(rst.getString("datetimestamp"));
                 list.add(userMessage);
             }
             rst.close();  
             pst.close();  
            
             
         } catch (SQLException e) {
             System.out.println(e);
         }
           return list;
     }

     public boolean addMessage(MessageDao message){ 
         String sql = "INSERT INTO message(message,username,title,datetimestamp) VALUES (?,?,?,?)";  
         Connection conn = Helper.getConnection();
         try {
             PreparedStatement pst = conn.prepareStatement(sql);
             pst.setString(1, message.getMessage());
             pst.setString(2, message.getUsername());
             pst.setString(3, message.getTitle());
             pst.setString(4, message.getDatetimestamp());
             int count = pst.executeUpdate();
             pst.close();
             
             return count>0; 
         } catch (SQLException e) {
             System.out.println(e);
         }
         return false;
     }

     public boolean deleteMessage(String username,String datetimestamp){  
         String sql = "delete from message where username = ? and datetimestamp=?"; 
         Connection conn = Helper.getConnection();
         try {
             PreparedStatement pst = conn.prepareStatement(sql);
             pst.setString(1, username);
             pst.setString(2, datetimestamp);
             int count = pst.executeUpdate();
             pst.close();
             return count>0;  
         } catch (SQLException e) {
             System.out.println(e);
         }
         return false;
     }
  
     public List<MessageDao> selectMessagesByUsername(String username ){ 
           List<MessageDao> list = new ArrayList<MessageDao>();  
         Connection conn = Helper.getConnection();
         String sql  = "select * from message where username = "+username;
         MessageDao message = null;
         try {
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rst = pst.executeQuery();
             while (rst.next()) {
                 message = new MessageDao();
                 message.setUsername(rst.getString("username"));
                 message.setTitle(rst.getString("title"));
                 message.setMessage(rst.getString("message"));
                 message.setDatetimestamp(rst.getString("datetimestamp"));
             }
             rst.close();
             pst.close();
         } catch (SQLException e) {
          System.out.println(e);
         }
         return list;  
     }
}
