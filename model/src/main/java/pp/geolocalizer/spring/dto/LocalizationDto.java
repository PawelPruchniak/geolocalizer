package pp.geolocalizer.spring.dto;

public class LocalizationDto {
    private Long id;
    private Long latitude;
    private Long longitude;
    private Long deviceId;

    public Long getId() {
        return id;
    }

    public void setId( Long aId ) {
        id = aId;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude( Long aLatitude ) {
        latitude = aLatitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude( Long aLongitude ) {
        longitude = aLongitude;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId( Long aDeviceId ) {
        deviceId = aDeviceId;
    }
}
