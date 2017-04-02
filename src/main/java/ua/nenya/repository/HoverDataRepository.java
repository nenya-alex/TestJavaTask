package ua.nenya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nenya.domain.HoverData;

public interface HoverDataRepository extends JpaRepository<HoverData,Long> {
}
