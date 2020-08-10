package br.com.tucho.starwarsapi.entities;

import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.LocalDate;
import java.util.UUID;

public abstract class AEntity {

    @Getter
    @PrimaryKey
    private String id;

    @Getter
    private String created;


    public AEntity() {
        this.id = UUID.randomUUID().toString();
        this.created = LocalDate.now().toString();
    }

}
