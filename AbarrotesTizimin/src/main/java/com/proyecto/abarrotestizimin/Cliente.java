/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */
package com.proyecto.abarrotestizimin;

public class Cliente extends Comun1 {
    private String tipo="A";

    private String apellidoPaterno;

    private Direccion direccion;

    /**
     *
     * @param identificador identificador del Cliente recibido de entrada de usuario
     * @param nombre nombre del Cliente recibido de entrada de usuario
     * @param tipo tipo de cliente
     * @param apellidoPaterno apellidoPaterno del Cliente recibido de entrada de usuario
     * @param direccion direccion del Cliente recibido de entrada de usuario
     */
    public Cliente(String identificador, String nombre, String tipo, String apellidoPaterno, Direccion direccion){
        super(identificador, nombre);
        this.apellidoPaterno=apellidoPaterno;
        this.direccion=direccion;
        this.tipo=tipo;
    }
    /**
     * Getter y setter
     */

    public String getTipo() {
        return tipo;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
