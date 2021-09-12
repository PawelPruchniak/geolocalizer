package pp.geolocalizer.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import pp.geolocalizer.spring.converter.LocalizationConverter;
import pp.geolocalizer.spring.dto.LocalizationDto;
import pp.geolocalizer.spring.entity.Localization;
import pp.geolocalizer.spring.exception.LocalizationNotFoundException;
import pp.geolocalizer.spring.service.LocalizationService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class LocalizationController {

    @Autowired
    private LocalizationService localizationService;

    @Autowired
    private LocalizationConverter localizationConverter;

    /**
     * @return List of All Localizations
     */
    @GetMapping(value = "/localizations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Localization> listAll() {
        return localizationService.listAllLocalizations();
    }

    /**
     * @param aId - Id of getting Localization
     * @return obtained Localization
     * @throws LocalizationNotFoundException when there is no Localization with that Id
     */
    @GetMapping(value = "/localization/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Localization getById( @PathVariable("id") Long aId ) throws LocalizationNotFoundException {
        return localizationService
                .getLocalizationById( aId )
                .orElseThrow( () -> new LocalizationNotFoundException( aId ) );
    }

    /**
     * @param aLocalizationDto - creating Localization
     * @return http response
     */
    @PostMapping(value = "/localization")
    public ResponseEntity<LocalizationDto> create( @RequestBody @Valid @NotNull LocalizationDto aLocalizationDto ) {
        Localization localization = localizationConverter.convertToEntity( aLocalizationDto );
        localizationService.saveLocalization( localization );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( aLocalizationDto );
    }

    /**
     * @param aId - Id of deleting Localization
     * @return View of all Localizations after deleted one
     * @throws LocalizationNotFoundException when there is no Localization with that Id
     */
    @DeleteMapping(value = "/localization/{id}")
    public RedirectView delete( @PathVariable Long aId ) throws LocalizationNotFoundException {
        localizationService.deleteLocalizationById( aId );

        return new RedirectView( "/api/localizations", true );
    }

}
