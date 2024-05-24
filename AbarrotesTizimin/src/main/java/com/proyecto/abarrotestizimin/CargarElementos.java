/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;

public class CargarElementos implements Interfaz1{

    /**
     * Metodo que se encarga de cargar unos cuantos articulos en la lista
     */
    public void cargarArticulos(){

        Articulo articulo = CreadorArticulo.crearArticulo("123","Pepsi","bebida",10,5,34);
        Articulo articulo2 = CreadorArticulo.crearArticulo("12","Coca","bebida",10,5,23);
        Articulo articulo3 = CreadorArticulo.crearArticulo("3","Chokis","galleta",12,8,26);

        listaArticulos.add(articulo);
        listaArticulos.add(articulo2);
        listaArticulos.add(articulo3);


    }

    /**
     * Metodo que se encarga de cargar un cliente en la lista
     */
    public void cargarClientes(){

        Direccion direccion1 = new Direccion("61A",400,"Santa Cruz",97700,"Tizimin","Yucatan","9861004491");

        Cliente cliente = CreadorCliente.crearCliente("17","Pedro","A","Bacab",direccion1);

        listaClientes.add(cliente);

    }


}
