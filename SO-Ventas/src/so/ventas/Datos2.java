/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ventas;

/**
 *
 * @author pc-22
 */
public class Datos2 {

    
    private String producto;
    private String cantidad;
    private String precio;

    public Datos2(String producto, String precio,String cantidad) {
        this.producto=producto;
        this.cantidad=cantidad;
        this.precio=precio;
    }
    
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    
}
