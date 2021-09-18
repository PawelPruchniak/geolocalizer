package pp.geolocalizer.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp.geolocalizer.spring.entity.Device;
import pp.geolocalizer.spring.exception.DeviceNotFoundException;
import pp.geolocalizer.spring.repository.DeviceRepository;

import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Iterable<Device> listAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> getDeviceById( Long aId ) {
        return deviceRepository.findById( aId );
    }

    @Override
    public Device saveDevice( Device aDevice ) {
        return deviceRepository.save( aDevice );
    }

    @Override
    public void deleteDeviceById( Long aId ) throws DeviceNotFoundException {
        if ( ifExists( aId ) ) {
            deviceRepository.deleteById( aId );
        }
        else {
            throw new DeviceNotFoundException( aId );
        }
    }

    private boolean ifExists( Long aId ) {
        var deviceOptional = deviceRepository.findById( aId );
        return deviceOptional.isPresent();
    }
}
