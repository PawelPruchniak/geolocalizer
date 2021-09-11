package pp.geolocalizer.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "deviceName")
    private String deviceName;

    /*** Constructor ***/
    public Device() {
        // Hibernate requires empty constructor
    }

    /*** Setters and Getters ***/
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

    /*** Override Java Object methods ***/
    @Override
    public boolean equals( Object aO ) {
        if ( this == aO )
            return true;
        if ( aO == null || getClass() != aO.getClass() )
            return false;
        Device device = (Device) aO;
        return Objects.equals( id, device.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }

    @Override
    public String toString() {
        return "Device{" + "id=" + id + ", deviceName='" + deviceName + '\'' + '}';
    }
}
