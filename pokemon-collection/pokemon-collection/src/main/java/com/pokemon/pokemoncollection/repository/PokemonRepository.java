package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
