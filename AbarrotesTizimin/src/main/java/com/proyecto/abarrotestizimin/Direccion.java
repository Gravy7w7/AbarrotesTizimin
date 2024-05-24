/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */
package com.proyecto.abarrotestizimin;

public class Direccion {

    private String calle;
    private int numeroCalle;
    private  String colonia;
    private int CP;
    private String ciudad;
    private String estado;
    private String telefono;

    /**
     * Constructor de Direccion que es usado por Cliente
     * @param calle recibido por entrada de usuario
     * @param numeroCalle recibido por entrada de usuario
     * @param colonia recibido por entrada de usuario
     * @param CP recibido por entrada de usuario
     * @param ciudad recibido por entrada de usuario
     * @param estado recibido por entrada de usuario
     * @param telefono recibido por entrada de usuario
     */
    public Direccion(String calle, int numeroCalle, String colonia, int CP, String ciudad, String estado ,String telefono){
        this.calle=calle;
        this.numeroCalle=numeroCalle;
        this.colonia=colonia;
        this.CP=CP;
        this.ciudad=ciudad;
        this.estado=estado;
        this.telefono=telefono;
    }

    /**
     * Getter y setter
     */


    public String getCalle() {
        return calle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public String getColonia() {
        return colonia;
    }

    public int getCP() {
        return CP;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}
