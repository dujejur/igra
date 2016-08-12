package igra;

import java.sql.*;


public class DataAccessLayer {
    private String username = "";
    private String password = "";
    private String connectionURL = "jbdc:mysql://localhost/game";
    private Connection connection;
    private Statement statement;
    
    
    public DataAccessLayer(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public DataAccessLayer(String username, String password, String connectionURL) {
        this(username, password);
        this.connectionURL = connectionURL;
    }
    
    public ResultSet ExecuteQuery(String query) {
        ResultSet resultSet = null;
        
        try {
            resultSet = statement.executeQuery(query);
        }
        catch(Exception ex) {
            return null;
        }
        
        return resultSet;
    }
    
    public boolean Connect() {
         try {
            
            Class.forName("com.mysql.jbcd.Driver"); 
             
            connection = DriverManager.getConnection(connectionURL, username, password);
            statement = connection.createStatement();
         }
         catch(Exception ex)            
         {
            return false;
         }
        return true;
    }
} 
