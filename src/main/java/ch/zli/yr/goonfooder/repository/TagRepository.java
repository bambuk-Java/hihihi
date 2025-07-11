package ch.zli.yr.goonfooder.repository;

import ch.zli.yr.goonfooder.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
