package pp.geolocalizer.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("pp.geolocalizer.spring.repository")
public class SpringApplication extends SpringBootServletInitializer {

    public static void main( String... args ) {
        org.springframework.boot.SpringApplication.run( SpringApplication.class, args );
    }

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
        return application.sources( SpringApplication.class );
    }
}
