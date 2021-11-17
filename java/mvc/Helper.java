package mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Helper {
	private static Connection conn = null;
    private Helper(){}
    
    public static Connection getConnection(){
        if(null == conn){
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                                 conn = DriverManager.getConnection ("jdbc: mysql: // localhost: 3306 / введите имя базы данных здесь? useUnicode = true & characterEncoding = utf-8», «root», «введите пароль здесь");
            } catch (Exception e) {
            System.out.println(e);
            }
        }
        return conn;
    }
}
