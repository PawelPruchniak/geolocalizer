package pp.geolocalizer.spring.exception;

public class LocalizationNotFoundException extends RuntimeException {

    private static final String LOCALIZATION_NOT_FOUND_EXC = "Could not find localization with id=";

    public LocalizationNotFoundException( Long aId ) {
        super( LOCALIZATION_NOT_FOUND_EXC + aId );
    }
}
