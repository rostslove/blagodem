package webproject.blagodem.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import webproject.blagodem.entities.Application;

import java.util.List;

@Repository
public interface ApplicationRepo extends PagingAndSortingRepository<Application, Long> {
    List<Application> findAllByStatus(String status);
}
