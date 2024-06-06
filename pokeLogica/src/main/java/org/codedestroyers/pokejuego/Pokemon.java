package org.codedestroyers.pokejuego;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.sargunvohra.lib.pokekotlin.client.ClientConfig;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonStat;
import org.codedestroyers.pokejuego.excepciones.NoSeEncontroElPokemon;
import org.codedestroyers.pokejuego.posiones.Posion;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.HashMap;
import java.util.List;

public class Pokemon {
    private @Getter(AccessLevel.PUBLIC) String nombre;
    private @Getter(AccessLevel.PUBLIC) int vida;
    private @Setter(AccessLevel.PUBLIC) Posion posion;
    private boolean posionActiva;
    private @Getter(AccessLevel.PUBLIC) int danoGolpe;
    private @Getter(AccessLevel.PUBLIC) int defensa;
    private @Getter(AccessLevel.PUBLIC) String imagenSeleccionada;
    private @Getter(AccessLevel.PUBLIC) String imagenBatalla;

    public Pokemon(String nombre, ClientConfig configuracionPokeAPI) throws NoSeEncontroElPokemon {
        nombre = nombre.toLowerCase();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(configuracionPokeAPI.getRootUrl());
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        PeticionPokemon peticionPokemon = retrofit.create(PeticionPokemon.class);
        int id;
        try {
            id = (int) Double.parseDouble(peticionPokemon.datos(nombre).execute().body().get("id").toString());
        } catch (java.io.IOException e) {
            throw new NoSeEncontroElPokemon("No se encontro " + nombre + " o algo ocurrio en la base de datos");
        } catch (NullPointerException e) {
            throw new NoSeEncontroElPokemon("No se encontro " + nombre + " en la base de datos");
        }

        PokeApi pokeApi = new PokeApiClient(configuracionPokeAPI);
        me.sargunvohra.lib.pokekotlin.model.Pokemon pokemonRespuesta = pokeApi.getPokemon(id);
        this.nombre = nombre;
        List<PokemonStat> stats = pokemonRespuesta.getStats();
        vida = stats.getFirst().getBaseStat();
        danoGolpe = stats.get(1).getBaseStat();
        defensa = stats.get(2).getBaseStat();
    }

    public int golpear(Pokemon p) {
        //TODO
        return 0;
    }

    public int recibirGolpe(int dano) {
        //TODO
        return 0;
    }

    public void tomarPosion() {
        //TODO
    }

    public boolean haPerdido() {
        return vida <= 0;
    }
}

interface PeticionPokemon {
    @GET("pokemon/{nombre}")
    Call<HashMap<String, Object>> datos(@Path("nombre") String nombre);
}