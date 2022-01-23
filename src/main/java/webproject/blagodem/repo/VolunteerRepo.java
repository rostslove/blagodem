package webproject.blagodem.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import webproject.blagodem.entities.Volunteer;

@Repository
public interface VolunteerRepo extends PagingAndSortingRepository<Volunteer, Long> {
    Volunteer findByEmail(String email);
}
