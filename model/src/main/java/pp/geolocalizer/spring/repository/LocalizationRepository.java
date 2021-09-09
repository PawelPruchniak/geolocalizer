package pp.geolocalizer.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pp.geolocalizer.spring.entity.Localization;

public interface LocalizationRepository extends JpaRepository<Localization, Long>, PagingAndSortingRepository<Localization, Long> {

}
