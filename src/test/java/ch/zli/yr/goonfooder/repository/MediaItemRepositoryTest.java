package ch.zli.yr.goonfooder.repository;

import ch.zli.yr.goonfooder.domain.MediaItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test") // nutzt test-Profile
class MediaItemRepositoryTest {

    @Autowired
    private MediaItemRepository mediaItemRepository;

    @Test
    void saveMediaItem_shouldPersistItem() {
        MediaItem item = new MediaItem();
        item.setTitle("Test");
        item.setDescription("Desc");

        MediaItem saved = mediaItemRepository.saveAndFlush(item);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("Test");
    }

    @Test
    void findById_shouldReturnItem() {
        MediaItem item = new MediaItem();
        item.setTitle("Test");
        item.setDescription("Desc");
        MediaItem saved = mediaItemRepository.saveAndFlush(item);

        Optional<MediaItem> found = mediaItemRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Test");
    }

    @Test
    void findById_shouldReturnEmptyOptional() {
        Optional<MediaItem> found = mediaItemRepository.findById(9999L);

        assertThat(found).isEmpty();
    }
}
