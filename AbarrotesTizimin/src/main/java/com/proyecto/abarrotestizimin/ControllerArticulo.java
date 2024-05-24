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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerArticulo implements Registro, Interfaz1{

    @FXML
    private Button BtnAgregar_articulo;
    @FXML
    private Button Btn_salir;
    @FXML
    private TextField TotaldeExistencia_productos;
    @FXML
    private TextField Precio_proveedor;
    @FXML
    private TextField Precio_publico;
    @FXML
    private TextField Name_articulo;
    @FXML
    private TextField Id_producto;
    @FXML
    private TextField tipo_Articulo;
    @FXML
    private Label articulo_Agregado;
    @FXML
    private Button buttonEliminar;
    @FXML
    private Label aviso_Articulo;

    private int totalProductos;
    private int precioProveedor;
    private int precioPublico;
    private String nombreArticulo;
    private String idProducto;
    private String tipoArticulo;

    /**
     *
     * @param event presionar al boton salir
     * @throws IOException en caso de que la ruta sea incorrecta o algun error inesperado
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
     * Metodo que es ejecutado cuando se presiona el boton agregar
     * @param event dar click
     */
    @FXML
    public void presionarAgregar(ActionEvent event){

        if(TotaldeExistencia_productos.getText()==null || TotaldeExistencia_productos.getText().trim().isEmpty()){

            articulo_Agregado.setText("Ingrese el total de existencias.");

        }else if(Precio_proveedor.getText()==null || Precio_proveedor.getText().trim().isEmpty()){

            articulo_Agregado.setText("Ingrese el precio del proveedor.");

        }else if(Precio_publico.getText()==null || Precio_publico.getText().trim().isEmpty()){

            articulo_Agregado.setText("Ingrese el precio publico.");

        }else if(Name_articulo.getText()==null || Name_articulo.getText().trim().isEmpty()){

            articulo_Agregado.setText("Ingrese el nombre del articulo.");

        }else if(Id_producto.getText()==null || Id_producto.getText().trim().isEmpty()){

            articulo_Agregado.setText("Ingrese el ID del articulo.");

        }else if(tipo_Articulo.getText()==null || tipo_Articulo.getText().trim().isEmpty()){

            articulo_Agregado.setText("Ingrese el tipo de articulo.");

        }else{

            totalProductos = Integer.parseInt(TotaldeExistencia_productos.getText());
            precioProveedor = Integer.parseInt(Precio_proveedor.getText());
            precioPublico = Integer.parseInt(Precio_publico.getText());
            nombreArticulo = Name_articulo.getText();
            idProducto = Id_producto.getText();
            tipoArticulo = tipo_Articulo.getText();

            verificarExistencia(idProducto);

        }



    }

    /**
     * Método encargado de crear un articulo
     */
    public void crear(){

        /**
         * Patron factory aplicado clase CreadorArticulo
         */
        Articulo articulo = CreadorArticulo.crearArticulo(idProducto,nombreArticulo,tipoArticulo,precioPublico,precioProveedor,totalProductos);

        listaArticulos.add(articulo);


        articulo_Agregado.setText("Articulo Agregado");

    }

    /**
     * Método encargado de verificar si ya existe un articulo
     */
    public void verificarExistencia(String idProducto){
        int existe=0;

        for(Articulo articulo : listaArticulos){

            if(idProducto.equals(articulo.getIdentificador())){
                existe=1;

                articulo_Agregado.setText("El articulo ya existe");

            }

        }

        if(existe==0){
            crear();
        }



    }

    /**
     * Método para borrar el articulo
     */
    public void borrar(){

        ListaArticulos lista1 = new ListaArticulos();

        for(IteratorArticulo iter = lista1.getIterator(); iter.hasNext();){

            Articulo articulo = iter.next();

            if(idProducto.equals(articulo.getIdentificador())){

                listaArticulos.remove(articulo);
                aviso_Articulo.setText("El articulo fue eliminado");

            }

        }

    }


    /**
     * Metodo que se ejecuta al presionar el boton eliminar
     * @param event hacer click
     */
    public void presionarEliminar(ActionEvent event) {

        if(Id_producto.getText()==null || Id_producto.getText().trim().isEmpty()) {
            aviso_Articulo.setText("Campos vacíos, intente de nuevo.");
        }else{

            idProducto = Id_producto.getText();

            borrar();

        }

    }
}
