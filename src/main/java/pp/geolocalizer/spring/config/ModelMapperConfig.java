package pp.geolocalizer.spring.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ModelMapperConfig {

    @Bean(name = "modelMapper")
    public static ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
