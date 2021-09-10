package pp.geolocalizer.spring.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import pp.geolocalizer.spring.entity.Localization;
import pp.geolocalizer.spring.repository.LocalizationRepository;

import java.util.Optional;

public class LocalizationServiceImpl implements LocalizationService {

    @Autowired
    private LocalizationRepository localizationRepository;

    @Override
    public Iterable<Localization> listAllLocalizations() {
        return localizationRepository.findAll();
    }

    @Override
    public Optional<Localization> getLocalizationById( Long aId ) {
        return localizationRepository.findById( aId );
    }

    @Override
    public Localization saveLocalization( Localization aLocalization ) {
        return localizationRepository.save( aLocalization );
    }

    @Override
    public void deleteLocalizationById( Long aId ) throws NotFoundException {
        if ( ifExists( aId ) ) {
            localizationRepository.deleteById( aId );
        }
        else {
            throw new NotFoundException( "Device with id=[" + aId + "] do not exists" );
        }
    }

    private boolean ifExists( Long aId ) {
        var localizationOptional = localizationRepository.findById( aId );
        return localizationOptional.isPresent();
    }
}
