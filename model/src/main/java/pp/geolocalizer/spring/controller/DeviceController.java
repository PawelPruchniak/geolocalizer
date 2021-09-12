package pp.geolocalizer.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;
import pp.geolocalizer.spring.entity.Device;
import pp.geolocalizer.spring.exception.DeviceNotFoundException;
import pp.geolocalizer.spring.service.DeviceService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * @return List of All Devices
     */
    @GetMapping(value = "/devices", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Device> listAll() {
        return deviceService.listAllDevices();
    }

    /**
     * @param aId - Id of getting Device
     * @return obtained Device
     * @throws DeviceNotFoundException when there is no Device with that Id
     */
    @GetMapping(value = "/device/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Device getById( @PathVariable("id") Long aId ) throws DeviceNotFoundException {
        return deviceService
                .getDeviceById( aId )
                .orElseThrow( () -> new DeviceNotFoundException( aId ) );
    }

    /**
     * @param aDevice - creating Device
     * @return http response
     */
    @PostMapping(value = "/device")
    public ResponseEntity<Device> create( @RequestBody @Valid @NotNull Device aDevice ) {
        deviceService.saveDevice( aDevice );
        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( aDevice );
    }

    /**
     * @param aId - Id of deleting Device
     * @return View of all Devices after deleted one
     * @throws DeviceNotFoundException when there is no Device with that Id
     */
    @DeleteMapping(value = "/device/{id}")
    public RedirectView delete( @PathVariable Long aId ) throws DeviceNotFoundException {
        deviceService.deleteDeviceById( aId );

        return new RedirectView( "/api/devices", true );
    }
}
