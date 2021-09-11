package pp.geolocalizer.spring.exception;

public class DeviceNotFoundException extends RuntimeException {

    private static final String DEVICE_NOT_FOUND_EXC = "Could not find device with id=";

    public DeviceNotFoundException( Long aId ) {
        super( DEVICE_NOT_FOUND_EXC + aId );
    }
}
