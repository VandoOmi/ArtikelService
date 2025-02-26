package de.szut.artikelservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Artikel {

    private long id;
    private String bezeichnung;
    private String beschreibung;
    private double preisEK;
    private double preisVK;

}
