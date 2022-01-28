package webproject.blagodem.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import webproject.blagodem.entities.Rating;
import webproject.blagodem.entities.Volunteer;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface RatingRepo extends PagingAndSortingRepository<Rating, Long> {
    List<Rating> findAllByVolunteer(Volunteer volunteer);
}
