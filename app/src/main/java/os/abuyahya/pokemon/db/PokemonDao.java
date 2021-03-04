package os.abuyahya.pokemon.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import os.abuyahya.pokemon.model.Pokemon;

@Dao
public interface PokemonDao {

    @Insert
    void insertPokemon(Pokemon pokemon);

    @Query("delete from fav_table where  name = :pokemonName")
    void deletePokemon(String pokemonName);

    @Query("select * from fav_table")
    LiveData<List<Pokemon>> getPokemon();
}
