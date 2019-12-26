/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dersane.Connection;
/**
 *
 * @author Sukriye
 */
public class OracleDbConnection {
   
    public static final String driverName = "oracle.jdbc.driver.OracleDriver";
    //Class.forName(driverName);
     public static final String serverName ="localhost";
     public static final String portNumber ="1521";
     public static final String sid ="xe";
     public static final String URL ="jdbc:oracle:thin:@" + serverName +":"+portNumber+":"+sid;
     public static final String userName ="DERSHANE";
     public static final String password ="26";
     
}
