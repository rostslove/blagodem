package webproject.blagodem.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import webproject.blagodem.entities.Disabled;
import webproject.blagodem.entities.Request;
import webproject.blagodem.entities.Volunteer;

import java.util.List;

@Repository
public interface RequestRepo extends PagingAndSortingRepository<Request, Long> {
    List<Request> findAllByStatus(String status);

    List<Request> findAllByDisabled(Disabled volunteer);

    List<Request> findAllByVolunteer(Volunteer volunteer);
}
