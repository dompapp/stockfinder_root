package at.papp.stockfinder.property;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

@Component
@Validated
@ConfigurationProperties(prefix = MigrationProperties.PREFIX)
public class MigrationProperties {
    public static final String PREFIX = "migration";
    public static final boolean DEFAULT_ENABLED = true;

    private boolean enabled = DEFAULT_ENABLED;

    @Getter
    private List<String> locations = Collections.singletonList("classpath:db/migration");

    @Getter
    private String fixture;

    @Getter
    private boolean cleanUp = false;
    @Getter
    private boolean repair = false;

    @NestedConfigurationProperty
    @Getter
    private Baseline baseline = new Baseline();

    public static @Data
    class Baseline {
        private boolean enabled = true;
        private String version;
        private String description;
    }

}
