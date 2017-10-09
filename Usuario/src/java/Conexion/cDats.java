/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Touchier
 */
public class cDats {
    String user;
    String password;
    String url;
    String driverClassName;
    
    Connection cont= null;
    CallableStatement stat= null;
    ResultSet resul= null;
    Statement estancia=null;
    
    public cDats(){
        this.user= "root";
        this.password= "n0m3l0";
        this.driverClassName= "com.mysql.jdbc.Driver";
        this.url= "jdbc:mysql://localhost/UsuarioBD";
    }
    
    public void conectar(){
        try{
            Class.forName(this.driverClassName).newInstance();
            cont= DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public ResultSet consulta(String consulta) throws SQLException {
        this.estancia = (Statement) cont.createStatement();
        return this.estancia.executeQuery(consulta);
    } 
    public void actualizar(String actualiza) throws SQLException {
        this.estancia = (Statement) cont.createStatement();
        estancia.executeUpdate(actualiza);
    } 
    
    public void cerrar() throws SQLException{
        cont.close();
    }
}
