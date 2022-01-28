package webproject.blagodem.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webproject.blagodem.entities.Image;

@Repository
@Transactional
public interface ImageRepo extends CrudRepository<Image, Long> {
}
