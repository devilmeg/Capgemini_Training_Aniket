package annotation_configuration.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "annotation_configuration")
@PropertySource("classpath:app.properties")
public class AppConfig {

}