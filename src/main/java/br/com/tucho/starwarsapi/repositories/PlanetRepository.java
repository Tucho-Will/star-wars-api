package br.com.tucho.starwarsapi.repositories;

import br.com.tucho.starwarsapi.entities.Planet;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
@Transactional(readOnly = true)
public interface PlanetRepository extends ReactiveCassandraRepository<Planet, String> {

    @AllowFiltering
    Mono<Planet> getByName(String name);
}
