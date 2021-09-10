package pp.geolocalizer.spring.exception;

import javassist.NotFoundException;

import java.util.Optional;

public final class RestPreconditions {

    public static final String CONSTRUCTOR_EXC = "Utility class";
    public static final String NOT_FOUND_EXC = "Resource not found";

    private RestPreconditions() {
        throw new IllegalStateException( CONSTRUCTOR_EXC );
    }

    public static <T> T returnIfExists( Optional<T> aObject ) throws NotFoundException {
        if ( aObject.isEmpty() ) {
            throw new NotFoundException( NOT_FOUND_EXC );
        }
        return aObject.get();
    }
}
