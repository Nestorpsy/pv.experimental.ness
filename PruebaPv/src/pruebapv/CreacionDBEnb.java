/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebapv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Nsandovalc
 */
public class CreacionDBEnb {
    
    public void creaDB(){
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String dbName = "/DerbyDB/ExampleDB";
        String dbParam = "create=true"; //la base de datos se creará si no existe todavía
        String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
        Connection conn = null;
    
        try{
          Class.forName(driver);
        } catch(java.lang.ClassNotFoundException e) {
          e.printStackTrace();
        }

        try {
          conn = DriverManager.getConnection(connectionURL);

          Statement st = conn.createStatement();
          String sqlCreateTableUsers =
                 "CREATE TABLE users ( " +
                 "FirstName VARCHAR(20) NOT NULL, " +
                 "LastName VARCHAR(20) NOT NULL, " +
                 "idUser INTEGER NOT NULL CONSTRAINT idUser_PK PRIMARY KEY " +
                 ")";
          // la sentencia SQL crea una tabla con 3 campos
          st.execute(sqlCreateTableUsers);

          System.out.println("La base de datos '" + dbName + "' se ha creado correctamente");
        }  catch (Throwable e)  {
          System.out.println("Error al crear la base de datos '" + dbName + "'");
          e.printStackTrace();
        } finally {
          try { conn.close(); }
          catch (Throwable t){}
        }
    }
}
