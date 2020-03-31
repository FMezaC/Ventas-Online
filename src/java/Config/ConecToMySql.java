/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 * port 3306
 * @author Meza
 */
public class ConecToMySql {
    Connection cnn;
    String url="jdbc:mysql://localhost:3306/ventasonline";
    String user ="root";
    String passw="123";
    public Connection ConecToMySql()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnn = (Connection) DriverManager.getConnection(url,user,passw);
            
        } catch (Exception e) {
        }
        return cnn;
    }
}
