package os.abuyahya.pokemon.di;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import os.abuyahya.pokemon.db.PokemonDB;
import os.abuyahya.pokemon.db.PokemonDao;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static PokemonDB provideDB(Application application){

        return Room.databaseBuilder(application, PokemonDB.class, "fav_DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }


    @Provides
    @Singleton
    public static PokemonDao provideDao(PokemonDB pokemonDBl){

        return pokemonDBl.pokemonDao();
    }
}