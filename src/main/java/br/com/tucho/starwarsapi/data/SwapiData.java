package br.com.tucho.starwarsapi.data;

import br.com.tucho.starwarsapi.viewModels.SwapiResultPlanetViewModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SwapiData {

    private String swapiUrl = "https://swapi.dev/api/planets/?search=%1$s&page=%2$d";

    public Mono<SwapiResultPlanetViewModel> getAllPlanets(String name, Integer page) {

        WebClient.ResponseSpec retrieve = WebClient.create(String.format(swapiUrl, name, page))
                .get()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();

        return retrieve.bodyToMono(SwapiResultPlanetViewModel.class);

    }
}
