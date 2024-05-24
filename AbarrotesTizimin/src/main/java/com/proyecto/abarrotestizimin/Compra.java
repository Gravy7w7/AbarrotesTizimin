/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;

public class Compra {

    private String nombreCliente;
    private int cantidadProducto;

    Articulo articulo;

    /**
     * Constructor de compra
     * @param nombreCliente recibe nombre de cliente obtenido de la lista de cliente
     * @param cantidadProducto recibe cantidad de una entrada del usuario
     * @param articulo encuentra un articulo en la lista de articulos
     */
    public Compra(String nombreCliente, int cantidadProducto, Articulo articulo){
        this.nombreCliente=nombreCliente;
        this.cantidadProducto=cantidadProducto;
        this.articulo=articulo;
    }


    //Getter y setter


    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
