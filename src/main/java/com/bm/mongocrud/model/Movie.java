package com.bm.mongocrud.model;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Value
@Document(collection = "Movie")
public class Movie {

    @Id
    private String id;

    private String name;

    private String genre;

    private LocalDate releaseDate;

}
