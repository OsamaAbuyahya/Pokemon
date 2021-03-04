package os.abuyahya.pokemon.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import os.abuyahya.pokemon.model.Pokemon;

@Database(entities = Pokemon.class, version = 1, exportSchema = false)
public abstract class PokemonDB extends RoomDatabase {

    public abstract PokemonDao pokemonDao();
}
