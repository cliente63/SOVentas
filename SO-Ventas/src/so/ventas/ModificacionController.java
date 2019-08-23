/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Soful
 */
public class ModificacionController implements Initializable {
Conexion con= new Conexion();
    @FXML
    private AnchorPane apMod;
    @FXML
    private ComboBox cbProd;
    @FXML
    private Label lbTituloElim;
    @FXML
    private Button btnEliminar;
    @FXML
    private Label lbProductocb;
    @FXML
    private TextField txtCRegistro,txtPreRegistro;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con.consultarProducto(cbProd);
    }    
    @FXML
    private void handlebtnActualizarAction(MouseEvent event) {
        con.modProd(cbProd.getSelectionModel().getSelectedItem().toString(), txtPreRegistro.getText(), txtCRegistro.getText());
        txtPreRegistro.setText("");
        txtCRegistro.setText("");
    }

    @FXML
    private void handlebtnEliminarAction(MouseEvent event) {
        con.eliminar(cbProd.getSelectionModel().getSelectedItem().toString());
    }

}
