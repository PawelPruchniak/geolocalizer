package pp.geolocalizer.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pp.geolocalizer.spring.dto.LocalizationDto;
import pp.geolocalizer.spring.entity.Localization;
import pp.geolocalizer.spring.service.LocalizationService;

import java.util.Optional;

import static pp.geolocalizer.spring.config.ModelMapperConfig.getModelMapper;

@Component
public class LocalizationConverter {

    private final ModelMapper modelMapper;

    @Autowired
    private LocalizationService localizationService;

    public LocalizationConverter() {
        modelMapper = getModelMapper();
    }

    public LocalizationConverter( ModelMapper aModelMapper, LocalizationService aLocalizationService ) {
        modelMapper = aModelMapper;
        localizationService = aLocalizationService;
    }

    public Localization convertToEntity( LocalizationDto aLocalizationDto ) {
        Localization localization = modelMapper.map( aLocalizationDto, Localization.class );

        // if localization with given id already exists convert it
        Optional<Localization> oldLocalizationOptional = localizationService.getLocalizationById(
                aLocalizationDto.getId() );
        if ( oldLocalizationOptional.isPresent() ) {
            var oldLocalization = oldLocalizationOptional.get();
            localization.setLatitude( oldLocalization.getLatitude() );
            localization.setLongitude( oldLocalization.getLongitude() );
            localization.setDevice( oldLocalization.getDevice() );
        }

        return localization;
    }

}
