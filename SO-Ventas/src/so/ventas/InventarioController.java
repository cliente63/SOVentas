/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas;

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
public class InventarioController implements Initializable {
Productos pr= new Productos();
    @FXML
    private TableView<Datos2> tbInv;
    @FXML
    private TableColumn<Datos2, String> IProducto;
    @FXML
    private TableColumn<Datos2, String> IPrecio;
    @FXML
    private TableColumn<Datos2, String> ICantidad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pr.consultarInventario(IProducto, ICantidad, IPrecio, tbInv);
    }    

    @FXML
    private void handletbConsultaAction(MouseEvent event) {
    }
    
}
