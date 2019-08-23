/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Soful
 */
public class FXMLDocumentController implements Initializable {
Ventas vend = new Ventas();
Productos pr= new Productos();
Conexion con =  new Conexion();
    @FXML
    public Label label;
    @FXML
    public Button btnVender;
    @FXML
    public Button btnRegistrar,btnModificar,btnEliminar,btnBorrar,btnAñadir,btnConsulta;
    @FXML
    public TextField txtTotal;
    @FXML
    public AnchorPane lbProducto;
    @FXML
    public Label lbTitulo;
    public TextField txtProducto;
    @FXML
    public Label lbProductos;
    @FXML
    public TableView<Datos> tbVentas;
    @FXML
    public TableColumn<Datos, String>  cmProducto;
    @FXML
    public TableColumn<Datos, String> cmPrecio;
    @FXML
    public TableColumn<Datos, String> cmCantidad;
    @FXML
    public TableColumn<Datos, String> cmSubtotal;
    @FXML
    public Label lbTotal;
    @FXML
    public Label lbSubtitulo;
    @FXML
    public TextField txtCantidad;
    @FXML
    public Label lbProductos1;
    @FXML
    public ComboBox cbProductos;
    @FXML
    private Button btnIn;
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con.consultarProducto(cbProductos);
        pr.llenarTotal(txtTotal);
    }  
    public void actualizarTotal(){
        if(tbVentas.getItems().size()!=0){
            float suma=0;
            for (int i = 0; i < tbVentas.getItems().size(); i++) {
                    suma+=Float.valueOf((String)cmSubtotal.getCellData(i));
                }
            txtTotal.setText(String.valueOf(suma));
        }
        else{
           txtTotal.setText("0.0");
        }
    }
    
    private void enviarVenta(){
        //con.Conectar();
        if(tbVentas.getItems().size()!=0){
            for (int i = 0; i < tbVentas.getItems().size(); i++) {
                    String pro= (String) cmProducto.getCellData(i);
                    String can=(String) cmCantidad.getCellData(i);
                    String pre=(String) cmPrecio.getCellData(i);
                    String t=(String) cmSubtotal.getCellData(i);
                   // cn.enviarVenta(pro,can,pre,t);
                }
            JOptionPane.showMessageDialog(null, "Venta realizada");
          tbVentas.getItems().clear();
                   
          
        }
        else{
            JOptionPane.showMessageDialog(null, "Tabla vacia");
        }
    } 
    
    
    @FXML
    public void handlebtnVenderAction(MouseEvent event) {
        pr.vender(tbVentas,txtTotal);
    }

    @FXML
    public void handlebtnRegAction(MouseEvent event) throws IOException {
       vend.IrRegistro();
    }

    @FXML
    public void handlebtnModAction(MouseEvent event) throws IOException {
     vend.IrModificar();
    }

    @FXML
    public void handlebtnElimAction(MouseEvent event) throws IOException {
      vend.IrBorrar();
    }

    @FXML
    public void handlebtnBorrarAction(MouseEvent event) {
        pr.borrarTabla(tbVentas,txtTotal);
    }

    @FXML
    public void handlebtnAñadirAction(MouseEvent event) {
       pr.añadir(cmProducto,cmCantidad,cmPrecio,cmSubtotal,tbVentas,txtCantidad,cbProductos,txtTotal);
    }

    @FXML
    public void handletxtCantidadAction(MouseEvent event) {
    }

    @FXML
    private void handlecbProductosAction(MouseEvent event) {
    }

    @FXML
    private void handlebtnConsultaAction(MouseEvent event) throws IOException {
        vend.IrConsulta();
    }
    @FXML
    private void handlebtnInAction(MouseEvent event) throws IOException {
        vend.IrInv();
    }
    
}
