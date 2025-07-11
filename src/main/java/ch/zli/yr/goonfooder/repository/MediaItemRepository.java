package ch.zli.yr.goonfooder.repository;

import ch.zli.yr.goonfooder.domain.MediaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaItemRepository extends JpaRepository<MediaItem, Long> {
}
