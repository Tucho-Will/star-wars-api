package br.com.tucho.starwarsapi.entities;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Data
@Table("Planets")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Planet extends AEntity {


    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String climate;
    @NotEmpty
    @NotNull
    private String terrain;

    private Integer films;
}
