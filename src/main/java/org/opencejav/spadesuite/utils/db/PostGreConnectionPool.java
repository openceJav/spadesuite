package org.opencejav.spadesuite.utils.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.opencejav.spadesuite.annotations.UtilityClass;

@UtilityClass(className = "PostGreConnectionPool")
public class PostGreConnectionPool {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource hikariDataSource;
}