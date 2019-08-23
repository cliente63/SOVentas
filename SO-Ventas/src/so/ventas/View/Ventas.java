/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
JMeter
 */
package so.ventas.View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Soful
 */
public class Ventas {
//    
    public void IrRegistro()throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
          }catch(IOException ex){
              
          }
    }
    public void IrModificar()throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Modificacion.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
          }catch(IOException ex){
              
          }
    }
    public void IrConsulta()throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Consulta.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
          }catch(IOException ex){
              
          }
    }
    public void IrInv()throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Inventario.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
          }catch(IOException ex){
              
          }
    }
    public void IrBorrar()throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Borrar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
          }catch(IOException ex){
              
          }
    }
}