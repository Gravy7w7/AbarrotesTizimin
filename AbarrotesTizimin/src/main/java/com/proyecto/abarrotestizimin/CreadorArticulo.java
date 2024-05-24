/**
 * @author Pedro Jose Bacab Pech
 */
package com.proyecto.abarrotestizimin;

public class CreadorArticulo {

    /**
     *
     * Método estatico que se define como el creador del articulo, forma parte de la aplicación del patron Factory
     *
     * @param identificador identificador del Articulo recibido de entrada de usuario
     * @param nombre nombre del Articulo recibido de entrada de usuario
     * @param tipo tipo de articulo
     * @param precio precio del Articulo recibido de entrada de usuario
     * @param precioProveedor precioProveedor del Articulo recibido de entrada de usuario
     * @param stock stock del Articulo recibido de entrada de usuario
     * @return retorna un articulo nuevo segun el tipo
     */
    public static Articulo crearArticulo(String identificador, String nombre, String tipo, int precio, int precioProveedor, int stock){

        if(tipo==null){
            throw new IllegalArgumentException("El tipo no puede ser nulo");
        }

        switch (tipo){

            case "bebida":
                return new Articulo(identificador,nombre,tipo,precio,precioProveedor,stock);

            case "fritura":
                return new Articulo(identificador,nombre,tipo,precio,precioProveedor,stock);

            case "galleta":
                return new Articulo(identificador,nombre,tipo,precio,precioProveedor,stock);

            case "dulce":
                return new Articulo(identificador,nombre,tipo,precio,precioProveedor,stock);

            default:
                throw new IllegalArgumentException("Tipo de articulo desconocido" + tipo);
        }

    }

}
