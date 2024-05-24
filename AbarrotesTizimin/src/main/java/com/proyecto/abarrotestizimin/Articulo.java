/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */
package com.proyecto.abarrotestizimin;

public class Articulo extends Comun1{

    private String tipo="A";
    private int precio;
    private int precioProveedor;
    private int stock;

    /**
     *
     * @param identificador identificador del Articulo recibido de entrada de usuario
     * @param nombre nombre del Articulo recibido de entrada de usuario
     * @param tipo tipo de articulo
     * @param precio precio del Articulo recibido de entrada de usuario
     * @param precioProveedor precioProveedor del Articulo recibido de entrada de usuario
     * @param stock stock del Articulo recibido de entrada de usuario
     */
    public Articulo(String identificador, String nombre, String tipo, int precio, int precioProveedor, int stock){
        super(identificador,nombre);
        this.precio=precio;
        this.precioProveedor=precioProveedor;
        this.stock=stock;
    }

    /**
     * Getter y setter
     */

    public String getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPrecioProveedor() {
        return precioProveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPrecioProveedor(int precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
