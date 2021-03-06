package pp.geolocalizer.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "localization")
public class Localization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "latitude")
    private Long latitude;

    @NotNull
    @Column(name = "longitude")
    private Long longitude;

    /*** Relations ***/
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;

    /*** Constructor ***/
    public Localization() {
        // Hibernate requires empty constructor
    }

    /*** Setters and Getters ***/
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

    public Device getDevice() {
        return device;
    }

    public void setDevice( Device aDevice ) {
        device = aDevice;
    }

    /*** Override Java Object methods ***/
    @Override
    public boolean equals( Object aO ) {
        if ( this == aO )
            return true;
        if ( aO == null || getClass() != aO.getClass() )
            return false;
        Localization that = (Localization) aO;
        return Objects.equals( id, that.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    @Override
    public String toString() {
        return "Localization{" + "id=" + id + ", latitiude=" + latitude + ", longitude=" + longitude + ", device=" + device + '}';
    }

    /*** Builder ***/
    public static class Builder {
        private Long id;
        private Long latitude;
        private Long longitude;
        private Device device;

        public Localization.Builder id( Long aId ) {
            this.id = aId;
            return this;
        }

        public Localization.Builder latitude( Long aLatitude ) {
            this.latitude = aLatitude;
            return this;
        }

        public Localization.Builder longitude( Long aLongitude ) {
            this.longitude = aLongitude;
            return this;
        }

        public Localization.Builder device( Device aDevice ) {
            this.device = aDevice;
            return this;
        }

        public Localization build() {
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
            if ( device != null ) {
                newLocalization.device = device;
            }
            return newLocalization;
        }

        Localization createInstance() {
            return new Localization();
        }
    }
}
