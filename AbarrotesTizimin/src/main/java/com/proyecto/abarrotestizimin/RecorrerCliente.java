/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;

public class RecorrerCliente implements IteratorCliente, Interfaz1 {

    private int index;

    /**
     * Metodo hasNext implementado a partir de la interfaz IteratorCliente
     * @return verdadero o falso hasta acabar la lista
     */
    @Override
    public boolean hasNext() {

        if(index < listaClientes.size()){
            return true;
        }

        return false;

    }

    /**
     * Metodo next implementado a partir de la interfaz IteratorCliente
     * @return null o el cliente(index)
     */
    @Override
    public Cliente next(){

        if(this.hasNext()){
            return listaClientes.get(index++);
        }

        return null;

    }

}
