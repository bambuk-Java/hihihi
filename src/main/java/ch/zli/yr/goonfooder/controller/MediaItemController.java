package ch.zli.yr.goonfooder.controller;

import ch.zli.yr.goonfooder.domain.MediaItem;
import ch.zli.yr.goonfooder.repository.MediaItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media-items")
public class MediaItemController {

    private final MediaItemRepository repository;

    public MediaItemController(MediaItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MediaItem> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaItem> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MediaItem create(@RequestBody MediaItem mediaItem) {
        return repository.save(mediaItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaItem> update(@PathVariable Long id, @RequestBody MediaItem updated) {
        return repository.findById(id).map(mediaItem -> {
            mediaItem.setTitle(updated.getTitle());
            mediaItem.setDescription(updated.getDescription());
            mediaItem.setCategory(updated.getCategory());
            mediaItem.setTags(updated.getTags());
            return ResponseEntity.ok(repository.save(mediaItem));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
