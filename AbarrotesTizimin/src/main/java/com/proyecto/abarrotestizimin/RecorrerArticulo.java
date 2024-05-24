/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;

public class RecorrerArticulo implements IteratorArticulo, Interfaz1{

    private int index;

    /**
     * Metodo hasNext implementado a partir de la interfaz IteratorArticulo
     * @return verdadero o falso hasta acabar la lista
     */
    @Override
    public boolean hasNext(){

        if(index < listaArticulos.size()){
            return true;
        }

        return false;

    }

    /**
     * Metodo next implementado a partir de la interfaz IteratorArticulo
     * @return null o el articulo(index)
     */
    public Articulo next(){

        if(this.hasNext()){
            return listaArticulos.get(index++);
        }

        return null;

    }

}
