package pp.geolocalizer.spring.dto;

public class DeviceDto {
    private Long id;
    private String deviceName;

    public Long getId() {
        return id;
    }

    public void setId( Long aId ) {
        id = aId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName( String aDeviceName ) {
        deviceName = aDeviceName;
    }
}
