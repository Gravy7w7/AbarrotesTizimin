module com.proyecto.abarrotestizimin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proyecto.abarrotestizimin to javafx.fxml;
    exports com.proyecto.abarrotestizimin;
}