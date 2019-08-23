/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Soful
 */
public class Productos {
    Conexion con= new Conexion();
ObservableList<String> pro=FXCollections.observableArrayList();
ObservableList<String> can=FXCollections.observableArrayList();
ObservableList<String> pre=FXCollections.observableArrayList();
ObservableList<String> sub=FXCollections.observableArrayList();
Conexion cn=new Conexion ();
    public void llenarTotal(TextField total) {
        total.setEditable(false);
        total.setText("0.0");
        
    }
    
   public void añadir(TableColumn Producto,TableColumn Cantidad,TableColumn Precio,TableColumn Subtotal, TableView tab, TextField tf, ComboBox cb, TextField total){
       
       Producto.setCellValueFactory(new PropertyValueFactory<>("producto"));
       Precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
       Cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
       Subtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
       
       String prod=cb.getSelectionModel().getSelectedItem().toString();
       String can=tf.getText();
       String t=total.getText();
        
        if(!can.equals("")){
            String pre=cn.consultarPrecio(prod);
            Float tot=Float.valueOf(can)*Float.valueOf(pre);
            total.setText(actualizarTotal(t,tot).toString());
            
            Datos p1 = new Datos(prod,pre,can,tot.toString());
            enviarLista(prod,pre,can,tot.toString());
            tab.getItems().addAll(p1);
        }
        tf.setText("");
    }
   
   public void consultarVentas(TableColumn Producto,TableColumn Cantidad,TableColumn Precio,TableColumn Subtotal, TableView tab){
       Producto.setCellValueFactory(new PropertyValueFactory<>("producto"));
       Precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
       Cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
       Subtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        ObservableList<String> prod=FXCollections.observableArrayList();
        ObservableList<String> cant=FXCollections.observableArrayList();
        ObservableList<String> pres=FXCollections.observableArrayList();
        ObservableList<String> subt=FXCollections.observableArrayList();
       con.llenarTabla(prod, cant, pres, subt);
       for (int i = 0; i < prod.size(); i++) {
           Datos p1 = new Datos(prod.get(i),pres.get(i),cant.get(i),subt.get(i));
           tab.getItems().addAll(p1);
       }
   }
   public void consultarInventario(TableColumn Producto,TableColumn Cantidad,TableColumn Precio, TableView tab){
       Producto.setCellValueFactory(new PropertyValueFactory<>("producto"));
       Precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
       Cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        ObservableList<String> prod=FXCollections.observableArrayList();
        ObservableList<String> cant=FXCollections.observableArrayList();
        ObservableList<String> pres=FXCollections.observableArrayList();
       con.llenarInve(prod, cant, pres);
       for (int i = 0; i < prod.size(); i++) {
           Datos2 p1 = new Datos2(prod.get(i),pres.get(i),cant.get(i));
           tab.getItems().addAll(p1);
       }
   }
   private Float actualizarTotal(String total,Float suma){
       Float T=Float.valueOf(total)+suma;
       return T;
   }
   
   public void borrarTabla(TableView tab,TextField total){
       tab.getItems().clear();
       total.setText("0.0");
   }
   public void vender(TableView taba,TextField t){
       for (int i = 0; i < pro.size(); i++) {
            con.nuevaVenta(pro.get(i),can.get(i),pre.get(i),sub.get(i));
            con.Descontar(pro.get(i), can.get(i));
       }
       JOptionPane.showMessageDialog(null, "Venta Realizada ");
       vaciarLista();
       borrarTabla(taba,t);
   }
   public void vaciarLista(){
       pro.clear();
        can.clear();
        pre.clear();
        sub.clear();
   }
   private void enviarLista(String Producto, String Precio,String Cantidad, String Sub){
       pro.add(Producto);
        can.add(Cantidad);
        pre.add(Precio);
        sub.add(Sub);
   }
}
