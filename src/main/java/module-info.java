module org.opencejav.spadesuite {
    requires javafx.controls;
    requires javafx.fxml;

    // Driver for PostgreSQL
    requires java.sql;
    requires org.postgresql.jdbc;

    // Util Tooling
    requires org.apache.commons.lang3;
    requires javatuples;

    // HikariCP
    requires com.zaxxer.hikari;

    // Tinylog Logging
    requires org.tinylog.api;

    // MaterialFX
    requires MaterialFX;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    // FXML
    opens org.opencejav.spadesuite to javafx.fxml;
    opens org.opencejav.spadesuite.controllers to javafx.fxml;

    // Base
    opens org.opencejav.spadesuite.models to javafx.base;
    opens org.opencejav.spadesuite.dao to javafx.base;
    opens org.opencejav.spadesuite.enums to javafx.base;

    opens org.opencejav.spadesuite.dto to javafx.base;
    opens org.opencejav.spadesuite.exceptions to javafx.base;
    opens org.opencejav.spadesuite.annotations to javafx.base;

    // Utils
    opens org.opencejav.spadesuite.utils.common to javafx.base;
    opens org.opencejav.spadesuite.utils.db to javafx.base;
    opens org.opencejav.spadesuite.utils.helpers to javafx.base;

    exports org.opencejav.spadesuite;
    opens org.opencejav.spadesuite.models.mappers to javafx.base;
    opens org.opencejav.spadesuite.models.records to javafx.base;
}