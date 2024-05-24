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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.io.IOException;

public class ControllerCompra implements Interfaz1{

    @FXML
    private Button Btn_continuar;
    @FXML
    private Button Btn_agregar;
    @FXML
    private Button Btn_finalizar;
    @FXML
    private Button Btn_salir;
    @FXML
    private TextField Id_cliente;
    @FXML
    private TextField Id_producto;
    @FXML
    private TextField Cantidad_productos;
    @FXML
    private Label cliente_Aviso;
    @FXML
    private Label articulo_Aviso;
    @FXML
    private Label compra_Aviso;

    private String codigoCliente;
    private String nombreComprador;
    private String codigoProducto;
    private int cantidadProductos;
    private int productoEncontrado;
    private int precioTotal=0;
    private boolean hayStock;
    GregorianCalendar calendario = new GregorianCalendar();

    int year = calendario.get(Calendar.YEAR);
    int month = calendario.get(Calendar.MONTH)+1;
    int day = calendario.get(Calendar.DAY_OF_MONTH);

    String fecha = "\nFecha: " + day + "/" + month + "/" + year;

    Articulo articulo;

    /**
     * Metodo que se encarga de ejecutar el boton salir
     * @param event dar click
     * @throws IOException por si ocurre una excepción
     */
    @FXML
    public void presionarSalir(ActionEvent event) throws IOException {

        Parent vistaInicio = FXMLLoader.load(getClass().getResource("/com/proyecto/abarrotestizimin/hello-view.fxml"));
        Scene vistaInicioScene = new Scene(vistaInicio);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Abarrotes Tizimín by Pedro & Anahi");
        window.setScene(vistaInicioScene);
        window.show();

        listaCompras.clear();

    }

    /**
     * Método que se ejecuta cuando se preosiona el boton continuar
     * @param event dar click
     */
    @FXML
    public void presionarContinuar(ActionEvent event) {

        if(Id_cliente.getText()==null || Id_cliente.getText().trim().isEmpty()){
            cliente_Aviso.setText("Ingrese un código por favor.");
        }else{

            ingresaCodigoCliente();

        }




    }

    /**
     * Método que se ejecuta cuando se presiona el boton agregar
     * @param event dar click
     */
    @FXML
    public void presionarAgregar(ActionEvent event) {

        if(Id_producto.getText()==null || Id_producto.getText().trim().isEmpty()){
            compra_Aviso.setText("No es posible hacer la compra con campos vacios.");
        }else if(Cantidad_productos.getText()==null || Cantidad_productos.getText().trim().isEmpty()){
            compra_Aviso.setText("No es posible hacer la compra con campos vacios.");
        }else{

            encontrarProducto();

            if(hayStock==false){

                crearCompra();

            }else{

                compra_Aviso.setText("No se pudo realizar la compra.");

            }



        }




    }

    /**
     * Método que se ejecuta cuando se presiona el boton Finalizar
     * @param event dar click
     */
    @FXML
    public void presionarFinalizar(ActionEvent event) {
        precioTotal=0;
        StringBuilder contenido = new StringBuilder();
        contenido.append(fecha);
        for(Compra compra : listaCompras){

            contenido.append("\nNombre: ").append(compra.getNombreCliente()).append("\nArticulo: ").append(compra.getArticulo().getNombre()).append("\nPrecio: ").append(compra.getArticulo().getPrecio()).append("\nCantidad: ").append(compra.getCantidadProducto());
            precioTotal=precioTotal + (compra.getArticulo().getPrecio() * compra.getCantidadProducto());

        }

        contenido.append("\n--------------------");
        contenido.append("\nTotal: ").append(precioTotal);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Compra");
        alert.setHeaderText("Lista de compras");
        alert.setContentText(contenido.toString());

        alert.showAndWait();

    }


    /**
     * Método que se encarga de crear la compra
     */
    public void crearCompra(){

        if(nombreComprador.equals("0") || productoEncontrado==0){
            compra_Aviso.setText("No se pudo realizar la compra, verifica los datos.");
        }else{

            Compra compra = new Compra(nombreComprador,cantidadProductos,articulo);
            listaCompras.add(compra);
            compra_Aviso.setText("Compra realizada.");

        }

    }

    /**
     * Método que se encarga de encontrar al cliente
     */
    public void ingresaCodigoCliente(){
        String identificadorlista;
        nombreComprador="0";

        codigoCliente = Id_cliente.getText();

        for(int i=0 ; i<listaClientes.size() ; i++){
            identificadorlista=listaClientes.get(i).getIdentificador();

            if(codigoCliente.equals(identificadorlista)){

                nombreComprador=listaClientes.get(i).getNombre();
                cliente_Aviso.setText("Cliente encontrado.");

            }

        }

        if (nombreComprador.equals("0")){
            cliente_Aviso.setText("Cliente no encontrado, intente de nuevo.");
        }

    }

    /**
     * Método que se encarga de encontrar el producto
     */
    public void encontrarProducto(){
        hayStock=false;
        String identificadorlista;
        productoEncontrado=0;
        int stockArticulo;

        codigoProducto = Id_producto.getText();
        cantidadProductos = Integer.parseInt(Cantidad_productos.getText());

        for(int i=0 ; i<listaArticulos.size() ; i++){
            identificadorlista=listaArticulos.get(i).getIdentificador();

            if(codigoProducto.equals(identificadorlista)){
                productoEncontrado=1;
                articulo_Aviso.setText("Articulo encontrado");

                if(listaArticulos.get(i).getStock() < cantidadProductos){

                    articulo_Aviso.setText("No hay stock suficiente");
                    hayStock=true;

                }else{

                    stockArticulo=listaArticulos.get(i).getStock();
                    stockArticulo=stockArticulo-cantidadProductos;
                    listaArticulos.get(i).setStock(stockArticulo);
                    articulo=listaArticulos.get(i);

                }


            }

        }

        if(productoEncontrado==0){
            articulo_Aviso.setText("Articulo no encontrado, intente de nuevo.");
        }

    }


}
