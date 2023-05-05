package com.pokemon.pokemoncollection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;
    private String pokemonName;
    private String type;
    private int level;
    private int hp;
    private int attack;
    private int defense;
}
