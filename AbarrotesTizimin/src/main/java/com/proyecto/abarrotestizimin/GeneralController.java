/**
 * @author Pedro Jose Bacab Pech
 * @author Anahi del Rosario Dzul Can
 */

package com.proyecto.abarrotestizimin;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class GeneralController  {
    @FXML
    private Button ButtonRegistrarCliente;
    @FXML
    private Button ButtonRegistrarArticulo;
    @FXML
    private Button ButtonRegistrarCompra;
    @FXML
    private Button ButtonSalir;

    /**
     * Método que incializa los elementos en las listas
     */
    public void InicialicarElementos(){

        CargarElementos obj1 = new CargarElementos();
        obj1.cargarArticulos();
        obj1.cargarClientes();

    }

    /**
     * Constructor que incializa los elementos cargados
     */
   // public GeneralController(){
  //      InicialicarElementos();
   // }


    /**
     * Método que se ejecuta cuando se presiona RegistrarCliente
     * @param event dar click
     * @throws IOException por si ocurre alguna excepcion
     */
    @FXML
    protected void presionarRegistrarCliente(ActionEvent event) throws IOException {
        Parent vistaCliente = FXMLLoader.load(getClass().getResource("/com/proyecto/abarrotestizimin/VistaCliente.fxml"));
        Scene vistaClienteScene = new Scene(vistaCliente);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Registro de Clientes");
        window.setScene(vistaClienteScene);
        window.show();
    }

    /**
     * Método que se ejecuta cuando se presiona RegistrarArticulo
     * @param event dar click
     * @throws IOException por si ocurre alguna excepcion
     */
    @FXML
    protected void presionarRegistrarArticulo(ActionEvent event) throws IOException {


        Parent vistaArticulo = FXMLLoader.load(getClass().getResource("/com/proyecto/abarrotestizimin/VistaArticulo.fxml"));
        Scene vistaArticuloScene = new Scene(vistaArticulo);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Registro de Articulo");
        window.setScene(vistaArticuloScene);
        window.show();

    }

    /**
     * Método que se ejecuta cuando se presiona RegistrarCompra
     * @param event dar click
     * @throws IOException por si ocurre alguna excepcion
     */
    @FXML
    protected void presionarRegistrarCompra(ActionEvent event) throws IOException {
        Parent vistaCompra = FXMLLoader.load(getClass().getResource("/com/proyecto/abarrotestizimin/VistaCompra.fxml"));
        Scene vistaCompraScene = new Scene(vistaCompra);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Registro de Compra");
        window.setScene(vistaCompraScene);
        window.show();
    }

    /**
     * Método que se ejecuta cuando se presiona Salir
     * @param event dar click
     * @throws IOException por si ocurre alguna excepcion
     */
    public void presionarSalir(ActionEvent event) {
        Platform.exit();
    }
}