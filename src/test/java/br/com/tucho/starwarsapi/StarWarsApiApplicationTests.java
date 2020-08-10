package br.com.tucho.starwarsapi;

import br.com.tucho.starwarsapi.entities.Planet;
import br.com.tucho.starwarsapi.repositories.PlanetRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class StarWarsApiApplicationTests {

    @Autowired
    PlanetRepository repository;

    @Test
    @Order(1)
    public void insertAndCountData() {

        Flux<Planet> deleteAndInsert = repository.deleteAll() //
                .thenMany(repository.saveAll(
                        Flux.just(
                                Planet.builder().name("Dagobah").climate("temperate").terrain("forests").build(), //
                                Planet.builder().name("Bespin").climate("temperate").terrain("mountains").build(), //
                                Planet.builder().name("Endor").climate("temperate").terrain("lakes").build())));

        StepVerifier.create(deleteAndInsert).expectNextCount(3).verifyComplete();
    }

    @Test
    @Order(2)
    public void findAndCountData() {

        Mono<Planet> find = repository.getByName("Dagobah");
        StepVerifier.create(find).expectNextCount(1).verifyComplete();

    }

    @Test
    @Order(3)
    public void saveAndFindCountData() {

        Planet planet = Planet.builder().name("Coruscant").climate("temperate").terrain("forests").build();
        Mono<Planet> saveAndFind = repository.save(planet)
                .then(repository.findById(planet.getId()));
        StepVerifier.create(saveAndFind).expectNextCount(1).verifyComplete();

    }

    @Test
    @Order(4)
    public void deleteAllAndCount() {
        //Gostaria de ter feito um teste delete unico mais não funciono
        Mono<Void> deleteAndInsert = repository.deleteAll();
        StepVerifier.create(deleteAndInsert).verifyComplete();

    }


}
