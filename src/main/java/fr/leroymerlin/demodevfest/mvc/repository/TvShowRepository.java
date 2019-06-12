package fr.leroymerlin.demodevfest.mvc.repository;

import fr.leroymerlin.demodevfest.mvc.model.TvShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends MongoRepository<TvShow, String> {
}
