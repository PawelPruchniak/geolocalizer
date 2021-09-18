package pp.geolocalizer.spring.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pp.geolocalizer.spring.dto.DeviceDto;
import pp.geolocalizer.spring.entity.Device;
import pp.geolocalizer.spring.service.DeviceService;

import java.util.Optional;

import static pp.geolocalizer.spring.config.ModelMapperConfig.getModelMapper;

@Component
public class DeviceConverter {

    private final ModelMapper modelMapper;

    @Autowired
    private DeviceService deviceService;

    public DeviceConverter() {
        modelMapper = getModelMapper();
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
