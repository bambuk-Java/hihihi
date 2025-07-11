package ch.zli.yr.goonfooder;

import ch.zli.yr.goonfooder.domain.MediaItem;
import ch.zli.yr.goonfooder.domain.Tag;
import ch.zli.yr.goonfooder.domain.Category;
import ch.zli.yr.goonfooder.repository.CategoryRepository;
import ch.zli.yr.goonfooder.repository.TagRepository;
import ch.zli.yr.goonfooder.repository.MediaItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDataConfig {

    CommandLineRunner loadTestData(
            CategoryRepository categoryRepo,
            TagRepository tagRepo,
            MediaItemRepository mediaItemRepo) {
        return args -> {
            // Kategorien
            Category movies = new Category();
            movies.setTitle("Movies");
            categoryRepo.save(movies);

            Category music = new Category();
            music.setTitle("Music");
            categoryRepo.save(music);

            // Tags
            Tag action = new Tag();
            action.setTitle("Action");
            tagRepo.save(action);

            Tag drama = new Tag();
            drama.setTitle("Drama");
            tagRepo.save(drama);

            // Media Items
            MediaItem item1 = new MediaItem();
            item1.setTitle("Inception");
            item1.setDescription("A mind-bending thriller.");
            item1.setCategory(movies);
            item1.getTags().add(action);
            mediaItemRepo.save(item1);

            MediaItem item2 = new MediaItem();
            item2.setTitle("Interstellar");
            item2.setDescription("A journey through space and time.");
            item2.setCategory(movies);
            item2.getTags().add(drama);
            mediaItemRepo.save(item2);
        };
    }
}
