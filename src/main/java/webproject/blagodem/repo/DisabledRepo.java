package webproject.blagodem.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import webproject.blagodem.entities.Disabled;

@Repository
public interface DisabledRepo extends PagingAndSortingRepository<Disabled, Long> {
    Disabled findByEmail(String email);
}
