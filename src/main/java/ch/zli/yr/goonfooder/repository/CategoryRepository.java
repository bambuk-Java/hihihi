package ch.zli.yr.goonfooder.repository;

import ch.zli.yr.goonfooder.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
