package br.com.tucho.starwarsapi.viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwapiResultPlanetViewModel {

    private Integer count = 0;
    private String next;
    private String previous;
    private List<SwapiPlanetViewModel> results = Collections.emptyList();

}
