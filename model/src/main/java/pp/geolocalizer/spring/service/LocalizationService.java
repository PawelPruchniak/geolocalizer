package pp.geolocalizer.spring.service;

import pp.geolocalizer.spring.entity.Localization;
import pp.geolocalizer.spring.exception.LocalizationNotFoundException;

import java.util.Optional;

public interface LocalizationService {

    Iterable<Localization> listAllLocalizations();

    Optional<Localization> getLocalizationById( Long aId );

    Localization saveLocalization( Localization aLocalization );

    void deleteLocalizationById( Long aId ) throws LocalizationNotFoundException;

}
