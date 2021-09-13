import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import pp.geolocalizer.spring.converter.DeviceConverter;
import pp.geolocalizer.spring.dto.DeviceDto;
import pp.geolocalizer.spring.entity.Device;
import pp.geolocalizer.spring.service.DeviceService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeviceDtoTest {
    private static final String DEVICE_NAME = "device test name";
    private static final String OLD_DEVICE_NAME = "old device test name";
    private static final Long ID = 1L;

    private final ModelMapper modelMapper = new ModelMapper();
    private DeviceConverter deviceConverter;

    @Test
    void shouldCorrectlyConvertDeviceDtoToDeviceEntity() {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId( ID );
        deviceDto.setDeviceName( DEVICE_NAME );

        Device device = modelMapper.map( deviceDto, Device.class );

        assertEquals( device.getId(), deviceDto.getId() );
        assertEquals( device.getDeviceName(), deviceDto.getDeviceName() );
    }

    @Test
    void shouldCorrectlyConvertDeviceDtoToDeviceEntityUsingConverter() {
        prepareConverterMock();
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId( ID );
        deviceDto.setDeviceName( DEVICE_NAME );

        Device device = deviceConverter.convertToEntity( deviceDto );

        assertEquals( device.getId(), deviceDto.getId() );
        assertEquals( device.getDeviceName(), OLD_DEVICE_NAME );
    }

    private void prepareConverterMock() {
        DeviceService deviceService = mock( DeviceService.class );
        var device = new Device();
        device.setId( ID );
        device.setDeviceName( OLD_DEVICE_NAME );
        when( deviceService.getDeviceById( 1L ) ).thenReturn( Optional.of( device ) );
        deviceConverter = new DeviceConverter( modelMapper, deviceService );
    }
}
