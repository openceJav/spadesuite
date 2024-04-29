package org.opencejav.spadesuite.utils.db;

import com.zaxxer.hikari.HikariConfig;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.opencejav.spadesuite.annotations.UtilityClass;
import org.opencejav.spadesuite.utils.helpers.validator.Validator;
import org.tinylog.Logger;

import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

// TODO Fix PostGreConfig Utility Class

@UtilityClass(className = "PostGreConfig")
@SuppressWarnings("all")
public final class PostGreConfig implements Serializable {
    /* HikariConfig */
    private HikariConfig config = new HikariConfig();

    private String filePath;
    private Duration sessionTimeout;
    private Duration connectionTimeout;
    private int maxPoolingSize;
    private int leakDetectionThreshold;

    private PostGreConfig() {
        // Private Constructor to Prevent Instantiation.
    }

    private PostGreConfig(final PostGreConfigBuilder builder) {
        this.filePath = builder.filePath;
        this.sessionTimeout = builder.sessionTimeout;
        this.connectionTimeout = builder.connectionTimeout;
        this.maxPoolingSize = builder.maxPoolingSize;
        this.leakDetectionThreshold = builder.leakDetectionThreshold;
    }

    public static class PostGreConfigBuilder {
        //region DEFAULTS
        private static String DEFAULT_PATH;

        private static final Duration DEFUALT_SESSION_TIMEOUT = Duration.ofMinutes(30);

        private static final Duration DEFAULT_CONNECTION_TIMEOUT = Duration.ofMinutes(30);

        private static final int DEFAULT_POOL_SIZE = 10;

        private static final int DEFAULT_DETECTION_THRESHOLD = 2000;
        //endregion

        private HikariConfig config = new HikariConfig();
        private String filePath;
        private Duration sessionTimeout;
        private Duration connectionTimeout;
        private int maxPoolingSize;
        private int leakDetectionThreshold;

        static {
            URL resource = PostGreConfig.class.getClassLoader().getResource("secrets/secrets.properties");
            if (resource == null) {
                Logger.error("Could Not Load Default Properties File.");
                throw new RuntimeException("Could Not Load Default Properties File.");

            }

            DEFAULT_PATH = resource.getPath();
        }

        public PostGreConfigBuilder() {
            this.filePath = DEFAULT_PATH;
            this.sessionTimeout = DEFUALT_SESSION_TIMEOUT;
            this.connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
            this.maxPoolingSize = DEFAULT_POOL_SIZE;
            this.leakDetectionThreshold = DEFAULT_DETECTION_THRESHOLD;
        }

        public PostGreConfigBuilder withFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public PostGreConfigBuilder withSessionTimeout(Duration sessionTimeout) {
            this.sessionTimeout = sessionTimeout;
            return this;
        }

        public PostGreConfigBuilder withConnectionTimeout(Duration connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public PostGreConfigBuilder withMaxPoolingSize(int maxPoolingSize) {
            this.maxPoolingSize = maxPoolingSize;
            return this;
        }

        public PostGreConfigBuilder withLeakDetectionThreshold(int leakDetectionThreshold) {
            this.leakDetectionThreshold = leakDetectionThreshold;
            return this;
        }

        public PostGreConfigBuilder withConfig() {
            Properties prop = new Properties();

            try  (InputStream input = new FileInputStream(DEFAULT_PATH)) {
                prop.load(input);

                this.config.setJdbcUrl(prop.getProperty("jdbcUrl"));
                this.config.setUsername(prop.getProperty("username"));
                this.config.setPassword(prop.getProperty("password"));
                this.config.setDriverClassName(prop.getProperty("driverClassName"));

                this.config.setConnectionTimeout(Long.parseLong(prop.getProperty("connectionTimeout")) <= 0
                        ? this.connectionTimeout.toMillis() : Long.parseLong(prop.getProperty("connectionTimeout")));

                this.config.setMaximumPoolSize(Integer.parseInt(prop.getProperty("maxPoolingSize")) <= 0
                        ? this.maxPoolingSize : Integer.parseInt(prop.getProperty("maxPoolingSize")));

                this.config.setLeakDetectionThreshold(Integer.parseInt(prop.getProperty("leakDetectionThreshold")) <= 0
                        ? this.leakDetectionThreshold : Integer.parseInt(prop.getProperty("leakDetectionThreshold")));

            } catch (IOException e) {
                Logger.error("Could Not Load Properties File.");


            }

            return this;
        }

        public PostGreConfig build() {
            PostGreConfig postGreConfig = isValidPostGreConfigBuild(this);
            return postGreConfig;
        }


        // TODO Fix This Method and Validator Utility Class
        private PostGreConfig isValidPostGreConfigBuild(PostGreConfigBuilder postGreConfigBuilder) {
            Validator<PostGreConfig> validator = new Validator<>();

            List<String> errors = validator
                    .addRule(p -> p.filePath != null, "File Path is Required.")
                    .addRule(p -> p.sessionTimeout != null, "Session Timeout is Required.")
                    .addRule(p -> p.connectionTimeout != null, "Connection Timeout is Required.")
                    .addRule(p -> p.maxPoolingSize > 0, "Max Pooling Size is Required.")
                    .addRule(p -> p.leakDetectionThreshold > 0, "Leak Detection Threshold is Required.")
                    .validate(new PostGreConfig(postGreConfigBuilder));

            if (errors.size() > 0) {
                Logger.error("PostGreConfig Validation Failed.");
                throw new IllegalArgumentException("PostGreConfig Validation Failed.");
            }

            return new PostGreConfig(postGreConfigBuilder);
        }
    }

    //region Getters
    public String getFilePath() {
        return filePath;
    }

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public Duration getConnectionTimeout() {
        return connectionTimeout;
    }

    public int getMaxPoolingSize() {
        return maxPoolingSize;
    }

    public int getLeakDetectionThreshold() {
        return leakDetectionThreshold;
    }

    public HikariConfig getConfig() {
        return config;
    }
    //endregion

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);

        builder
                .append(this.filePath)
                .append(this.sessionTimeout)
                .append(this.connectionTimeout)
                .append(this.maxPoolingSize)
                .append(this.leakDetectionThreshold)
                .build();

        return builder.toHashCode();
    }

    @Override
    public String toString() {
        return null;
    }
}