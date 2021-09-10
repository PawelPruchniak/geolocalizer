package pp.geolocalizer.spring.service;

import javassist.NotFoundException;
import pp.geolocalizer.spring.entity.Device;

import java.util.Optional;

public interface DeviceService {

    Iterable<Device> listAllDevices();

    Optional<Device> getDeviceById( Long aId );

    Device saveDevice( Device aDevice );

    void deleteDeviceById( Long aId ) throws NotFoundException;
}
