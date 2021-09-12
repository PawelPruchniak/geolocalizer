package pp.geolocalizer.spring.service;

import pp.geolocalizer.spring.entity.Device;
import pp.geolocalizer.spring.exception.DeviceNotFoundException;

import java.util.Optional;

public interface DeviceService {

    Iterable<Device> listAllDevices();

    Optional<Device> getDeviceById( Long aId );

    Device saveDevice( Device aDevice );

    void deleteDeviceById( Long aId ) throws DeviceNotFoundException;
}
