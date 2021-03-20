package at.papp.stockfinder.configuration;

import at.papp.stockfinder.property.MigrationProperties;
import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseMigrationConfig {

    private final static Logger logger = LoggerFactory.getLogger(DatabaseMigrationConfig.class);

    @Bean(name = "migration")
    public Flyway flyway(DataSource dataSource, MigrationProperties migrationProperties) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setPlaceholderPrefix("#fly{");

        final List<String> locations = new ArrayList<>(migrationProperties.getLocations());

        if (StringUtils.isNotBlank(migrationProperties.getFixture())) {
            locations.add(migrationProperties.getFixture());
        }

        flyway.setLocations(locations.toArray(new String[0]));

        flywayBanner();

        if (migrationProperties.isCleanUp()) {
            logger.info("Start cleanup");
            flyway.clean();
            logger.info("End cleanup");
        } else {
            logger.info("Skipped cleanup");
        }

        if (migrationProperties.isRepair()) {
            flyway.repair();
        }

        if (migrationProperties.getBaseline().isEnabled()) {
            logger.info("Start baseline");
            flyway.setBaselineVersionAsString(migrationProperties.getBaseline().getVersion());
            flyway.setBaselineDescription(migrationProperties.getBaseline().getDescription());
            flyway.setBaselineOnMigrate(true);
            logger.info("End baseline");
        } else {
            logger.info("Skipped baseline");
        }

        logger.info("Start migration");
        flyway.migrate();
        logger.info("End migration");

        return null;
    }

    private void flywayBanner() {
        logger.info("" +
                "                                                                                                                                                                                             \n" +
                "                                                                                                                                                                                             \n" +
                "FFFFFFFFFFFFFFFFFFFFFF     LLLLLLLLLLL                  YYYYYYY       YYYYYYY     WWWWWWWW                           WWWWWWWW                    AAA                    YYYYYYY       YYYYYYY\n" +
                "F::::::::::::::::::::F     L:::::::::L                  Y:::::Y       Y:::::Y     W::::::W                           W::::::W                   A:::A                   Y:::::Y       Y:::::Y\n" +
                "F::::::::::::::::::::F     L:::::::::L                  Y:::::Y       Y:::::Y     W::::::W                           W::::::W                  A:::::A                  Y:::::Y       Y:::::Y\n" +
                "FF::::::FFFFFFFFF::::F     LL:::::::LL                  Y::::::Y     Y::::::Y     W::::::W                           W::::::W                 A:::::::A                 Y::::::Y     Y::::::Y\n" +
                "  F:::::F       FFFFFF       L:::::L                    YYY:::::Y   Y:::::YYY      W:::::W           WWWWW           W:::::W                 A:::::::::A                YYY:::::Y   Y:::::YYY\n" +
                "  F:::::F                    L:::::L                       Y:::::Y Y:::::Y          W:::::W         W:::::W         W:::::W                 A:::::A:::::A                  Y:::::Y Y:::::Y   \n" +
                "  F::::::FFFFFFFFFF          L:::::L                        Y:::::Y:::::Y            W:::::W       W:::::::W       W:::::W                 A:::::A A:::::A                  Y:::::Y:::::Y    \n" +
                "  F:::::::::::::::F          L:::::L                         Y:::::::::Y              W:::::W     W:::::::::W     W:::::W                 A:::::A   A:::::A                  Y:::::::::Y     \n" +
                "  F:::::::::::::::F          L:::::L                          Y:::::::Y                W:::::W   W:::::W:::::W   W:::::W                 A:::::A     A:::::A                  Y:::::::Y      \n" +
                "  F::::::FFFFFFFFFF          L:::::L                           Y:::::Y                  W:::::W W:::::W W:::::W W:::::W                 A:::::AAAAAAAAA:::::A                  Y:::::Y       \n" +
                "  F:::::F                    L:::::L                           Y:::::Y                   W:::::W:::::W   W:::::W:::::W                 A:::::::::::::::::::::A                 Y:::::Y       \n" +
                "  F:::::F                    L:::::L         LLLLLL            Y:::::Y                    W:::::::::W     W:::::::::W                 A:::::AAAAAAAAAAAAA:::::A                Y:::::Y       \n" +
                "FF:::::::FF                LL:::::::LLLLLLLLL:::::L            Y:::::Y                     W:::::::W       W:::::::W                 A:::::A             A:::::A               Y:::::Y       \n" +
                "F::::::::FF                L::::::::::::::::::::::L         YYYY:::::YYYY                   W:::::W         W:::::W                 A:::::A               A:::::A           YYYY:::::YYYY    \n" +
                "F::::::::FF                L::::::::::::::::::::::L         Y:::::::::::Y                    W:::W           W:::W                 A:::::A                 A:::::A          Y:::::::::::Y    \n" +
                "FFFFFFFFFFF                LLLLLLLLLLLLLLLLLLLLLLLL         YYYYYYYYYYYYY                     WWW             WWW                 AAAAAAA                   AAAAAAA         YYYYYYYYYYYYY    \n" +
                "                                                                                                                                                                                             \n" +
                "                                                                                                                                                                                             \n" +
                "");
    }
}

