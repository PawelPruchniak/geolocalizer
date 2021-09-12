package pp.geolocalizer.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pp.geolocalizer.spring.dto.LocalizationDto;
import pp.geolocalizer.spring.entity.Localization;
import pp.geolocalizer.spring.service.LocalizationService;

import java.util.Optional;

public class LocalizationConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LocalizationService localizationService;

    public Localization convertToEntity( LocalizationDto aLocalizationDto ) {
        Localization localization = modelMapper.map( aLocalizationDto, Localization.class );

        // if localization with given id already exists convert it
        Optional<Localization> oldLocalizationOptional = localizationService.getLocalizationById(
                aLocalizationDto.getId() );
        if ( oldLocalizationOptional.isPresent() ) {
            var oldLocalization = oldLocalizationOptional.get();
            localization.setId( oldLocalization.getId() );
            localization.setLatitude( oldLocalization.getLatitude() );
            localization.setLongitude( oldLocalization.getLongitude() );
        }

        return localization;
    }
}
