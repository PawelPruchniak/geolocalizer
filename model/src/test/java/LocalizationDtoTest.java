import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pp.geolocalizer.spring.dto.LocalizationDto;
import pp.geolocalizer.spring.entity.Localization;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationDtoTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    void shouldCorrectlyConvertDeviceDtoToDeviceEntity() {
        LocalizationDto localizationDto = new LocalizationDto();
        localizationDto.setId( 1L );
        localizationDto.setLatitude( 2L );
        localizationDto.setLongitude( 3L );
        localizationDto.setDeviceId( 4L );

        Localization localization = modelMapper.map( localizationDto, Localization.class );

        assertEquals( localizationDto.getId(), localization.getId() );
        assertEquals( localizationDto.getLatitude(), localization.getLatitude() );
        assertEquals( localizationDto.getLongitude(), localization.getLongitude() );
        // assertEquals( localizationDto.getDeviceId(), localization.getDevice() );
    }
}
