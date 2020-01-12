

package com.mycompany.tomtensnyalista;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class TomtensLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
         //   Class.forName("com.mysql.jdbc.Driver");
            connectToAndQueryDatabase("root", "Hinsaringen39");
        }
        catch(Exception p){
            p.printStackTrace();
            System.out.println("Some thing whent wrong!");
        }
        
        
    }


    public static void connectToAndQueryDatabase(String username, String password){
        int x = 0;
        String s = null;
        boolean b = true;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tomtedatabasedemoiot?serverTimezone=UTC", "root", "Hinsaringen39");){
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, nice FROM child");
            
             while(rs.next()){
            x = rs.getInt("id");
            s = rs.getString("name");
            b = rs.getBoolean("nice");
            if(b == true){
                System.out.println(x + " " + s + " " + "Snäll");
            }
            else if(b == false){
                System.out.println(x + " " + s + " " + "Elak");
            }
            
            //System.out.println(x + " " + s + " " + b);
            
            
        }
            
        }
        catch(Exception e){
             e.printStackTrace();
            System.out.println("Cant Connect SomeThing Whent Wrong");
        }
        
       
        
    }
   

    
    
}
