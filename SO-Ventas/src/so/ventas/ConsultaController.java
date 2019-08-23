/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas;

import so.ventas.Model.Productos;
import so.ventas.Model.Datos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author pc-21
 */
public class ConsultaController implements Initializable {
Productos pr= new Productos();
    @FXML
    private Label lbTitulo;
@FXML
    private TableView<Datos> tbConsulta;
@FXML
    private TableColumn<Datos, String> cmProducto;
@FXML
    private TableColumn<Datos, String> cmPrecio;
@FXML
    private TableColumn<Datos, String> cmCantidad;
@FXML
    private TableColumn<Datos, String> cmSubtotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pr.consultarVentas(cmProducto, cmCantidad, cmPrecio, cmSubtotal, tbConsulta);
        
    }    

    @FXML
    private void handletbConsultaAction(MouseEvent event) {
    }
    
}
