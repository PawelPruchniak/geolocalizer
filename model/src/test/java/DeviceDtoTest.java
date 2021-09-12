import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pp.geolocalizer.spring.dto.DeviceDto;
import pp.geolocalizer.spring.entity.Device;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeviceDtoTest {
    private static final String TEST_NAME = "device test name";
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    void shouldCorrectlyConvertDeviceDtoToDeviceEntity() {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId( 1L );
        deviceDto.setDeviceName( TEST_NAME );

        Device device = modelMapper.map( deviceDto, Device.class );

        assertEquals( deviceDto.getId(), device.getId() );
        assertEquals( deviceDto.getDeviceName(), device.getDeviceName() );
    }
}
