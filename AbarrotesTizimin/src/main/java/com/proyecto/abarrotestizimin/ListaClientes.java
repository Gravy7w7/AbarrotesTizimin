/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;



public class ListaClientes implements ContainerCliente {

    /**
     * Metodo getIterarCliente que es implementado a parti de la interfaz ContainerCliente
     * @return iterator de cliente en este caso llamado RecorrerCliente
     */
    @Override
    public IteratorCliente getIterator() {
        return new RecorrerCliente();
    }

}
