package webproject.blagodem.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webproject.blagodem.entities.File;

@Repository
@Transactional
public interface FileRepo extends CrudRepository<File, Long> {
}
