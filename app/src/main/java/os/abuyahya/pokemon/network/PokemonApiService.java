package os.abuyahya.pokemon.network;

import io.reactivex.rxjava3.core.Observable;
import os.abuyahya.pokemon.model.PokemonResponse;
import retrofit2.http.GET;

public interface PokemonApiService {

    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}
