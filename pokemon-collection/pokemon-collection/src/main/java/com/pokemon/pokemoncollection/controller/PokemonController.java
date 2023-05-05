package com.pokemon.pokemoncollection.controller;

import com.pokemon.pokemoncollection.exception.PokemonNotFoundException;
import com.pokemon.pokemoncollection.model.Pokemon;
import com.pokemon.pokemoncollection.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @PostMapping("/pokemon")
    Pokemon newPokemon(@RequestBody Pokemon newPokemon) {
        return pokemonRepository.save(newPokemon);
    }

    @GetMapping("/pokemons")
    List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @GetMapping("/pokemon/{id}")
    Pokemon getPokemonById(@PathVariable Long id) {
        return pokemonRepository.findById(id)
                .orElseThrow(()->new PokemonNotFoundException(id));
    }

    @PutMapping("/pokemon/{id}")
    Pokemon updatePokemon(@RequestBody Pokemon newPokemon, @PathVariable Long id) {
        return pokemonRepository.findById(id)
                .map(pokemon -> {
                    pokemon.setPokemonName(newPokemon.getPokemonName());
                    pokemon.setType(newPokemon.getType());
                    pokemon.setLevel(newPokemon.getLevel());
                    pokemon.setHp(newPokemon.getHp());
                    pokemon.setAttack(newPokemon.getAttack());
                    pokemon.setDefense(newPokemon.getDefense());
                    return pokemonRepository.save(pokemon);
                }).orElseThrow(()->new PokemonNotFoundException(id));
    }

    @DeleteMapping("/pokemon/{id}")
    String deletePokemon(@PathVariable Long id) {
        if (!pokemonRepository.existsById(id)) {
            throw new PokemonNotFoundException(id);
        }
        pokemonRepository.deleteById(id);
        return "Pokemon with ID: " + id + " has been deleted";
    }
}
