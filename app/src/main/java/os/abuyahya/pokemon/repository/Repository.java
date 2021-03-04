package os.abuyahya.pokemon.repository;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import os.abuyahya.pokemon.db.PokemonDao;
import os.abuyahya.pokemon.model.Pokemon;
import os.abuyahya.pokemon.model.PokemonResponse;
import os.abuyahya.pokemon.network.PokemonApiService;

public class Repository {

    private PokemonApiService pokemonApiService;
    private PokemonDao pokemonDao;

    @Inject
    public Repository(PokemonApiService pokemonApiService, PokemonDao pokemonDao) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonDao = pokemonDao;
    }

    public Observable<PokemonResponse> getPokemons(){
        return pokemonApiService.getPokemons();
    }

    public void insertPokemon(Pokemon pokemon){
        pokemonDao.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName){
        pokemonDao.deletePokemon(pokemonName);
    }

    public LiveData<List<Pokemon>> getFavPokemon(){
        return pokemonDao.getPokemon();
    }
}
