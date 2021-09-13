package pp.geolocalizer.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pp.geolocalizer.spring.dto.DeviceDto;
import pp.geolocalizer.spring.entity.Device;
import pp.geolocalizer.spring.service.DeviceService;

import java.util.Optional;

public class DeviceConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DeviceService deviceService;

    public DeviceConverter() {
    }

    public DeviceConverter( ModelMapper aModelMapper, DeviceService aDeviceService ) {
        modelMapper = aModelMapper;
        deviceService = aDeviceService;
    }

    public Device convertToEntity( DeviceDto aDeviceDto ) {
        Device device = modelMapper.map( aDeviceDto, Device.class );

        // if device with given id already exists convert it
        Optional<Device> oldDeviceOptional = deviceService.getDeviceById( aDeviceDto.getId() );
        if ( oldDeviceOptional.isPresent() ) {
            var oldDevice = oldDeviceOptional.get();
            device.setDeviceName( oldDevice.getDeviceName() );
        }

        return device;
    }
}
