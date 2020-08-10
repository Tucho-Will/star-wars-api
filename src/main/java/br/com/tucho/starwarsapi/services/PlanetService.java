package br.com.tucho.starwarsapi.services;

import br.com.tucho.starwarsapi.data.SwapiData;
import br.com.tucho.starwarsapi.entities.Planet;
import br.com.tucho.starwarsapi.repositories.PlanetRepository;
import br.com.tucho.starwarsapi.viewModels.SwapiResultPlanetViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetService {

    private final PlanetRepository repository;
    private final SwapiData swapiData;

    @Autowired
    public PlanetService(PlanetRepository repository,
                         SwapiData swapiData) {
        this.repository = repository;
        this.swapiData = swapiData;
    }

    public Mono<Planet> getById(String uuid) {
        return this.repository.findById(uuid);
    }

    public Mono<Planet> save(Planet planet) {

        return getByName(planet.getName()).flatMap(Mono::just)
                .switchIfEmpty(getAllPlanetsFromSwapi(planet.getName(), 1)
                        .doOnSuccess(viewModel -> {
                            viewModel.getResults().stream().findFirst()
                                    .ifPresent(to -> planet.setFilms(to.getFilms().size()));
                        }).then(this.repository.save(planet))
                );
    }

    public Flux<Planet> getAll() {
        return this.repository.findAll();
    }

    public Mono<Planet> getByName(String name) {
        return this.repository.getByName(name);
    }

    public Mono<Void> delete(String uuid) {
        return this.repository.deleteById(uuid);
    }

    public Flux<Planet> getAllByName(String name) {
        return this.repository.findAll().filter(pl -> pl.getName().contains(name.toLowerCase()));
    }

    public Mono<SwapiResultPlanetViewModel> getAllPlanetsFromSwapi(String name, Integer page) {
        return this.swapiData.getAllPlanets(name, page);
    }
}
