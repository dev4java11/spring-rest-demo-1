package pe.com.alliance.storeapp.server.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import static pe.com.alliance.storeapp.server.util.Constantes.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {SCAN_PKG_ASSEMBLER})
@Import(ServiceConfiguration.class)
public class ApplicationConfiguration {

}
