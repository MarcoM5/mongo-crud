package com.bm.mongocrud.model;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Value
@Document(collection = "Movie")
public class Movie {

    @Id
    String id;

    String name;

    String genre;

    LocalDate releaseDate;

}
