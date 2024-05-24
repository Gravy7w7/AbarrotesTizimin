/**
 * @author Pedro Jose Bacab Pech
 */

package com.proyecto.abarrotestizimin;

/**
 * Clase Comun1 con el objetivo de heredad dos atributos
 */
public class Comun1 {

    protected String identificador;
    protected String nombre;

    /**
     * Cosntrcutor
     * @param identificador tanto de Cliente como articulo
     * @param nombre tanto de Cliente como articulo
     */
    public Comun1(String identificador, String nombre) {
        this.identificador=identificador;
        this.nombre=nombre;
    }

    //Getter y setter
    public String getNombre() {
        return nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
