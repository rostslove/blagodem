package webproject.blagodem.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import webproject.blagodem.entities.Rating;

import java.util.stream.Stream;

@Repository
public interface RatingRepo extends PagingAndSortingRepository<Rating, Long> {
    Stream<Rating> findAllByVolunteer(Long id);
}
