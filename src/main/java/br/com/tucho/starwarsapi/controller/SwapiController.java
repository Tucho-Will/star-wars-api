package br.com.tucho.starwarsapi.controller;

import br.com.tucho.starwarsapi.data.SwapiData;
import br.com.tucho.starwarsapi.viewModels.SwapiResultPlanetViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("swapi")
public class SwapiController {

    private final SwapiData swapiData;

    @Autowired
    public SwapiController(SwapiData swapiData) {
        this.swapiData = swapiData;
    }


    @GetMapping
    public Mono<SwapiResultPlanetViewModel> getAllPlanetsFromSwapi(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) {
        return this.swapiData.getAllPlanets(name, page);
    }

}
