/**
 * @author Pedro Jose Bacab Pech
 */
package com.proyecto.abarrotestizimin;

public class CreadorCliente {


    /**
     *
     * Método estatico que se define como el creador del cliente, forma parte de la aplicación del patron Factory
     *
     * @param identificador identificador del Cliente recibido de entrada de usuario
     * @param nombre nombre del Cliente recibido de entrada de usuario
     * @param tipo tipo de cliente
     * @param apellidoPaterno apellidoPaterno del Cliente recibido de entrada de usuario
     * @param direccion direccion del Cliente recibido de entrada de usuario
     * @return retorna un cliente nuevo de tipo "A"
     */
    public static Cliente crearCliente(String identificador, String nombre, String tipo, String apellidoPaterno, Direccion direccion){

        if(tipo==null){
            throw new IllegalArgumentException("El tipo no puede ser nulo");
        }

        switch (tipo){

            case "A":
                return new Cliente(identificador,nombre,tipo,apellidoPaterno,direccion);

            default:
                throw new IllegalArgumentException("Tipo de cliente desconocido" + tipo);
        }

    }

}
