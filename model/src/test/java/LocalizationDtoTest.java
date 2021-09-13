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
        LocalizationDto localizationDto = new LocalizationDto();
        localizationDto.setId( ID );
        localizationDto.setLatitude( LATITUDE );
        localizationDto.setLongitude( LONGITUDE );
        localizationDto.setDeviceId( DEVICE_ID );

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
        LocalizationDto localizationDto = new LocalizationDto();
        localizationDto.setId( ID );
        localizationDto.setLatitude( LATITUDE );
        localizationDto.setLongitude( LONGITUDE );

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
        var device = new Device();
        device.setId( DEVICE_ID );
        var localization = new Localization();
        localization.setId( ID );
        localization.setLatitude( OLD_LATITUDE );
        localization.setLongitude( OLD_LONGITUDE );
        localization.setDevice( device );
        when( localizationService.getLocalizationById( ID ) ).thenReturn( Optional.of( localization ) );
        localizationConverter = new LocalizationConverter( modelMapper, localizationService );
    }
}
