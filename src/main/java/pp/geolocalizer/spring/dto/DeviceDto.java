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

    /*** Builder ***/
    public static class Builder {
        private Long id;
        private String deviceName;

        public DeviceDto.Builder id( Long aId ) {
            this.id = aId;
            return this;
        }

        public DeviceDto.Builder deviceName( String aDeviceName ) {
            this.deviceName = aDeviceName;
            return this;
        }

        public DeviceDto build() {
            var newDevice = createInstance();
            if ( id != null ) {
                newDevice.id = id;
            }
            if ( deviceName != null ) {
                newDevice.deviceName = deviceName;
            }
            return newDevice;
        }

        DeviceDto createInstance() {
            return new DeviceDto();
        }
    }
}
