import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pp.geolocalizer.spring.converter.LocalizationConverter;
import pp.geolocalizer.spring.dto.LocalizationDto;
import pp.geolocalizer.spring.entity.Device;
import pp.geolocalizer.spring.entity.Localization;
import pp.geolocalizer.spring.service.LocalizationService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LocalizationDtoTest {
    private static final Long ID = 1L;
    private static final Long LATITUDE = 2L;
    private static final Long LONGITUDE = 3L;
    private static final Long DEVICE_ID = 4L;
    private static final Long OLD_LATITUDE = 5L;
    private static final Long OLD_LONGITUDE = 6L;

    private final ModelMapper modelMapper = new ModelMapper();
    private LocalizationConverter localizationConverter;

    @Test
    void shouldCorrectlyConvertLocalizationDtoToLocalizationEntity() {
        LocalizationDto localizationDto = new LocalizationDto.Builder()
                .id( ID )
                .latitude( LATITUDE )
                .longitude( LONGITUDE )
                .deviceId( DEVICE_ID )
                .build();

        Localization localization = modelMapper.map( localizationDto, Localization.class );

        assertEquals( localizationDto.getId(), localization.getId() );
        assertEquals( localizationDto.getLatitude(), localization.getLatitude() );
        assertEquals( localizationDto.getLongitude(), localization.getLongitude() );
        assertEquals( localizationDto.getDeviceId(), localization
                .getDevice()
                .getId() );
    }

    @Test
    void shouldCorrectlyConvertLocalizationDtoToLocalizationEntityUsingConverter() {
        prepareConverterMock();
        LocalizationDto localizationDto = new LocalizationDto.Builder()
                .id( ID )
                .latitude( LATITUDE )
                .longitude( LONGITUDE )
                .deviceId( DEVICE_ID )
                .build();

        Localization localization = localizationConverter.convertToEntity( localizationDto );

        assertEquals( localization.getId(), localizationDto.getId() );
        assertEquals( localization.getLatitude(), OLD_LATITUDE );
        assertEquals( localization.getLongitude(), OLD_LONGITUDE );
        assertEquals( localization
                .getDevice()
                .getId(), DEVICE_ID );
    }

    private void prepareConverterMock() {
        LocalizationService localizationService = mock( LocalizationService.class );
        var device = new Device.Builder()
                .id( DEVICE_ID )
                .build();
        var localization = new Localization.Builder()
                .id( ID )
                .latitude( OLD_LATITUDE )
                .longitude( OLD_LONGITUDE )
                .device( device )
                .build();

        when( localizationService.getLocalizationById( ID ) ).thenReturn( Optional.of( localization ) );
        localizationConverter = new LocalizationConverter( modelMapper, localizationService );
    }
}
