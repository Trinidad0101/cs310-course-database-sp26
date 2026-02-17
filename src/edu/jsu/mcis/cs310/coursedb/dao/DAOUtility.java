package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_SP26 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
               
                
                while(rs.next()) {
                    JsonObject temp = new JsonObject();
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    
                    for(int i = 1; i <= columnCount; i++){
                        String columname = metaData.getColumnName(i);

                        Object tempValue = rs.getObject(i);
                        
                        if(tempValue instanceof Integer){
                            tempValue = rs.getInt(i);
                            
                        }else{
                            tempValue = rs.getString(i);
                
                        }
                        temp.put(columname, tempValue);
                    }
                    records.add(temp);
                }
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
