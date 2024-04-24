module org.opencejav.spadesuite {
    requires javafx.controls;
    requires javafx.fxml;

    // Driver for PostgreSQL
    requires java.sql;
    requires org.postgresql.jdbc;

    // Apache Commons
    requires org.apache.commons.lang3;

    // HikariCP
    requires com.zaxxer.hikari;

    // Tinylog Logging
    requires org.tinylog.api;

    // MaterialFX
    requires MaterialFX;

    // FXML
    opens org.opencejav.spadesuite to javafx.fxml;
    opens org.opencejav.spadesuite.controllers to javafx.fxml;

    // Base
    opens org.opencejav.spadesuite.models to javafx.base;
    opens org.opencejav.spadesuite.dao to javafx.base;
    opens org.opencejav.spadesuite.enums to javafx.base;
    opens org.opencejav.spadesuite.repository to javafx.base;
    opens org.opencejav.spadesuite.utils.common to javafx.base;
    opens org.opencejav.spadesuite.utils.helpers to javafx.base;
    // opens org.opencejav.spadesuite.utils to javafx.base; <-- Later

    exports org.opencejav.spadesuite;
}