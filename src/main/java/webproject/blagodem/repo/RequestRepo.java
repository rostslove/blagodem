package webproject.blagodem.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import webproject.blagodem.entities.Request;

import java.util.List;

@Repository
public interface RequestRepo extends PagingAndSortingRepository<Request, Long> {
    List<Request> findAllByStatus(String status);
}
