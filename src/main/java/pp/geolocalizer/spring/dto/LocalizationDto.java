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

    /*** Builder ***/
    public static class Builder {
        private Long id;
        private Long latitude;
        private Long longitude;
        private Long deviceId;

        public LocalizationDto.Builder id( Long aId ) {
            this.id = aId;
            return this;
        }

        public LocalizationDto.Builder latitude( Long aLatitude ) {
            this.latitude = aLatitude;
            return this;
        }

        public LocalizationDto.Builder longitude( Long aLongitude ) {
            this.longitude = aLongitude;
            return this;
        }

        public LocalizationDto.Builder deviceId( Long aDeviceId ) {
            this.deviceId = aDeviceId;
            return this;
        }

        public LocalizationDto build() {
            var newLocalization = createInstance();
            if ( id != null ) {
                newLocalization.id = id;
            }
            if ( latitude != null ) {
                newLocalization.latitude = latitude;
            }
            if ( longitude != null ) {
                newLocalization.longitude = longitude;
            }
            if ( deviceId != null ) {
                newLocalization.deviceId = deviceId;
            }
            return newLocalization;
        }

        LocalizationDto createInstance() {
            return new LocalizationDto();
        }
    }
}
