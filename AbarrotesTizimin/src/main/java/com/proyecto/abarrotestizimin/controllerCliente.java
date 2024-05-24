/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class controllerCliente implements Registro, Interfaz1{

    @FXML
    private Button btnAgregarCliente;
    @FXML
    private Button btnSalir;
    @FXML
    private TextField Id_cliente;
    @FXML
    private TextField Name_cliente;
    @FXML
    private TextField Apellido_paterno;
    @FXML
    private TextField Calle;
    @FXML
    private TextField Num_calle;
    @FXML
    private TextField Colonia;
    @FXML
    private TextField CP;
    @FXML
    private TextField Ciudad_cliente;
    @FXML
    private TextField Estado_cliente;
    @FXML
    private TextField Telefono_cliente;
    @FXML
    private Label cliente_Agregado;
    @FXML
    private Button butttonEliminar;
    @FXML
    private Label aviso_Eliminar;

    //Atributos locales
    private String id_cliente;
    private String nombreCliente;
    private String apellidoPaterno;
    private Direccion direccion;
    private String calleCliente;
    private int numeroCalle;
    private  String coloniaCliente;
    private int codigoPostal;
    private String ciudadCliente;
    private String estadoCliente;
    private String telefonoCliente;
    private String tipo="A";


    /**
     * Metodo que se ejecuta cuando se presiona el boton salir
     * @param event dar click
     * @throws IOException en caso de que ocurra una excepcion
     */
    @FXML
    public void presionarSalir(ActionEvent event) throws IOException {

        Parent vistaInicio = FXMLLoader.load(getClass().getResource("/com/proyecto/abarrotestizimin/hello-view.fxml"));
        Scene vistaInicioScene = new Scene(vistaInicio);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Abarrotes Tizimín by Pedro & Anahi");
        window.setScene(vistaInicioScene);
        window.show();

    }

    /**
     * Metodo que se ejcuta cuando se presiona el boton agregar
     * @param event dar click
     */
    @FXML
    public void presionarAgregar(ActionEvent event) {

        //Para la direccion

        if(Calle.getText()==null || Calle.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(Num_calle.getText()==null || Num_calle.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(Colonia.getText()==null || Colonia.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(CP.getText()==null || CP.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(Ciudad_cliente.getText()==null || Ciudad_cliente.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(Estado_cliente.getText()==null || Estado_cliente.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(Telefono_cliente.getText()==null || Telefono_cliente.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else{

            calleCliente = Calle.getText();
            numeroCalle = Integer.parseInt(Num_calle.getText());
            coloniaCliente = Colonia.getText();
            codigoPostal = Integer.parseInt(CP.getText());
            ciudadCliente = Ciudad_cliente.getText();
            estadoCliente = Estado_cliente.getText();
            telefonoCliente = Telefono_cliente.getText();

        }



        //Para el cliente

        if(Id_cliente.getText()==null || Id_cliente.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(Name_cliente.getText()==null || Name_cliente.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else if(Apellido_paterno.getText()==null || Apellido_paterno.getText().trim().isEmpty()){
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else{

            id_cliente = Id_cliente.getText();
            nombreCliente = Name_cliente.getText();
            apellidoPaterno = Apellido_paterno.getText();

            verificarExistencia(id_cliente);

        }






    }

    /**
     * Método encargado de crear un nuevo cliente
     */
    public void crear(){

        Direccion direccion1 = new Direccion(calleCliente,numeroCalle,coloniaCliente,codigoPostal,ciudadCliente,estadoCliente,telefonoCliente);

        Cliente cliente = CreadorCliente.crearCliente(id_cliente,nombreCliente,tipo,apellidoPaterno,direccion1);

        cliente_Agregado.setText("Cliente Agregado");

        listaClientes.add(cliente);

    }

    /**
     * Método encargado de verificar si ya existe un cliente en la lista de clientes
     */
    public void verificarExistencia(String id_cliente){

        int existe=0;

        for(Cliente cliente : listaClientes){

            if(id_cliente.equals(cliente.getIdentificador())){
                existe=1;

                cliente_Agregado.setText("El Cliente ya existe");

            }

        }

        if(existe==0){
            crear();
        }

    }

    /**
     * Metodo encargado de borrar el cliente
     */
    public void borrar(){

        ListaClientes lista1 = new ListaClientes();

        for(IteratorCliente iter = lista1.getIterator(); iter.hasNext();){

            Cliente cliente = iter.next();

            if(id_cliente.equals(cliente.getIdentificador())){

                listaClientes.remove(cliente);
                cliente_Agregado.setText("El Cliente fue eliminado");

            }

        }


    }

    /**
     * Método que se ejecuta cuando se presiona el boton eliminar
     * @param event hacer click
     */
    public void presionarEliminar(ActionEvent event) {

        if(Id_cliente.getText()==null || Id_cliente.getText().trim().isEmpty()) {
            cliente_Agregado.setText("Campos vacíos, intente de nuevo.");
        }else{

            id_cliente = Id_cliente.getText();

            borrar();

        }





    }
}
