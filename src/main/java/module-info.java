module org.opencejav.spadesuite {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.opencejav.spadesuite to javafx.fxml;
    exports org.opencejav.spadesuite;
}