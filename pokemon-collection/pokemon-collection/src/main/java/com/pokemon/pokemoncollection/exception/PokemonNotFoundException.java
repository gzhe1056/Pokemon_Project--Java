package com.pokemon.pokemoncollection.exception;

public class PokemonNotFoundException extends RuntimeException{
    public PokemonNotFoundException(Long id) {
        super("Could not find the pokemon with ID: " + id);
    }
}
