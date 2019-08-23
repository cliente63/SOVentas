/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Soful
 */
public class Conexion {
    Connection cn;

    public Conexion() {
        Conectar();
    }
    
   // Conexion con =  new Conexion();
    public Statement statement = null;
    public ResultSet rs = null;
    public void Conectar(){
       try{
           try{
               Class.forName("org.postgresql.Driver");
           }catch (ClassNotFoundException ex){
               System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
           }
           cn = null;
             cn = DriverManager.getConnection("jdbc:postgresql://172.16.0.102:5432/sistemaventas","cl1","12345");
             boolean valid = cn.isValid(50000);
             System.out.println(valid ? "TEST OK" : "TEST FAIL");
       } catch ( java.sql.SQLException sqle){
           System.out.println("Error: " + sqle);
       }
    }
    
    public ResultSet consultar(String tabla, String cond){
        try {
            String inst = "select * from "+tabla+cond+";";
            
            statement = cn.createStatement();
            statement.executeQuery(inst);
            rs = statement.getResultSet();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }   
        return null;
    }
    
    public String consultarPrecio(String producto){
        String precio="";
        try {
            String inst = "select * from Inventario where Producto='"+producto+"';";
            
            statement = cn.createStatement();
            statement.executeQuery(inst);
            rs = statement.getResultSet();
            rs.next();
            precio=rs.getString(2);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }  
        return precio;
    }
    public void llenarTabla(ObservableList pro, ObservableList can, ObservableList pre, ObservableList tot){
        try {
            String inst = "select * from Ventas;";
            statement = cn.createStatement();
            statement.executeQuery(inst);
            rs = statement.getResultSet();
            while(rs.next()){
                pro.add(rs.getString(1));
                pre.add(rs.getString(2));
                can.add(rs.getString(3));
                tot.add(rs.getString(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }
    }
    public void llenarInve(ObservableList pro, ObservableList can, ObservableList pre){
        try {
            String inst = "select * from Inventario;";
            statement = cn.createStatement();
            statement.executeQuery(inst);
            rs = statement.getResultSet();
            while(rs.next()){
                pro.add(rs.getString(1));
                pre.add(rs.getString(2));
                can.add(rs.getString(3));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }
    }
     public void nuevaVenta(String pro, String can, String pre,String sub,String iva){
        try{
            statement=cn.createStatement();
                int nv=statement.executeUpdate("Insert into Ventas(Producto,Cantidad,Precio,Total,IVA) values('"+pro+"',"+can+",'"+pre+"','"+sub+"','"+iva+");");
                //JOptionPane.showMessageDialog(null, "Agregado");
            
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }
    }
     public void nuevoProducto(String pro, String can, String pre){
        try{
            statement=cn.createStatement();
                int nv=statement.executeUpdate("Insert into Inventario(Producto,Cantidad,Precio) values('"+pro+"',"+can+",'"+pre+"');");
                JOptionPane.showMessageDialog(null, "Registrado");
            
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }
    }
      public void eliminar(String nom){
        try{
            statement=cn.createStatement();
            int nv=statement.executeUpdate("delete from Inventario where Producto='"+nom+"';");
            JOptionPane.showMessageDialog(null, "Eliminado");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }
    }
      public void Descontar(String pro,String can){
        try{
            statement=cn.createStatement();
            int nv=statement.executeUpdate("Update Inventario set Cantidad=Cantidad-"+can+" where Producto='"+pro+"';");
            //JOptionPane.showMessageDialog(null, "Modificado");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }
    }
      public void modProd(String nom, String Precio, String Cantidad){
        try{
            statement=cn.createStatement();
            int nv=statement.executeUpdate("Update Inventario set Precio="+Precio+",Cantidad="+Cantidad+" where Producto='"+nom+"';");
            JOptionPane.showMessageDialog(null, "Modificado");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO Conectado ");
        }
    }
}
