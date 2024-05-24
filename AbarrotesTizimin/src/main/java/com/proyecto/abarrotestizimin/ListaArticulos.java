/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;

public class ListaArticulos implements ContainerArticulo{

    /**
     * Metodo getIterarArticulo que es implementado a parti de la interfaz ContainerArticulo
     * @return iterator de articulo en este caso llamado RecorrerArticulo
     */
    public IteratorArticulo getIterator(){
        return new RecorrerArticulo();
    }

}
