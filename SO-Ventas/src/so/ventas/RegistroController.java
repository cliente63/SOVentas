/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas;

import so.ventas.Model.Conexion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Soful
 */
public class RegistroController implements Initializable {
Conexion cn = new Conexion();
    @FXML
    private Label lbTituloReg;
    @FXML
    private Label lbProductoReg;
    @FXML
    private TextField txtProRegistro;
    @FXML
    private Label lbCantidadReg;
    @FXML
    private TextField txtCantidadReg;
    @FXML
    private Label lbPrecioReg;
    @FXML
    private TextField txtPrecioRegistro;
    @FXML
    private Button btnRegistrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void handlebtnRegistrarAction(MouseEvent event) {
        cn.nuevoProducto(txtProRegistro.getText(), txtCantidadReg.getText(), txtPrecioRegistro.getText());
        txtProRegistro.setText("");
        txtCantidadReg.setText("");
        txtPrecioRegistro.setText("");
    }

    
}
