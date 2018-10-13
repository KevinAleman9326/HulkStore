/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;


/**
 *
 * @author Kevin E. Alemán
 */
public class Conexion {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "prueba";
    private static final String CLASSNAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    
    public java.sql.Connection con;
    
    public Conexion(){
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(ClassNotFoundException e){
            System.out.println("Error de Clase");
        } catch(SQLException e){
            System.out.println("Revisar Base de datos");
        }
    }
    
   }
