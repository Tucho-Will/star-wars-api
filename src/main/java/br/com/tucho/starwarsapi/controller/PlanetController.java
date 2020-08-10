package br.com.tucho.starwarsapi.controller;

import br.com.tucho.starwarsapi.entities.Planet;
import br.com.tucho.starwarsapi.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("planets")
public class PlanetController {

    private final PlanetService service;

    @Autowired
    public PlanetController(PlanetService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Planet> savePlanet(@Valid @RequestBody Planet planet) {
        return this.service.save(planet);
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Planet> getPlanetsById(@PathVariable(value = "uuid") String uuid) {
        return this.service.getById(uuid);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public Mono deletePlanet(@PathVariable(value = "uuid") String uuid) {
        return this.service.delete(uuid);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Planet> getAllPlanets() {
        return this.service.getAll();
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Planet> getAllPlanetsByName(@PathVariable(value = "name") String name) {
        return this.service.getAllByName(name);
    }


}
