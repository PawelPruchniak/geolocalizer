package pp.geolocalizer.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pp.geolocalizer.spring.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long>, PagingAndSortingRepository<Device, Long> {

}
