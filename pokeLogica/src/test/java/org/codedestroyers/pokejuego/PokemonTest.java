package org.codedestroyers.pokejuego;

import me.sargunvohra.lib.pokekotlin.client.ClientConfig;
import okhttp3.HttpUrl;
import org.codedestroyers.pokejuego.excepciones.NoSeEncontroElPokemon;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    final ClientConfig configuracion = new ClientConfig(HttpUrl.parse("https://pokeapi.co/api/v2/"), builder -> {
        builder.retryOnConnectionFailure(false);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        return builder;
    });

    @ParameterizedTest
    @CsvSource({
            "Pikachu,35,55,40",
            "cHarmAnDer,39,52,43",
            "ditto,48,48,48",
    })
    void contsructor(String nombre, int vida, int dano, int defensa) throws NoSeEncontroElPokemon {
        Pokemon nuevoPokemon = new Pokemon(nombre,configuracion);
        assertEquals(vida,nuevoPokemon.getVida());
        assertEquals(dano,nuevoPokemon.getDanoGolpe());
        assertEquals(defensa,nuevoPokemon.getDefensa());
    }

    @ParameterizedTest
    @ValueSource(strings = {"papas","PoU","TESCHA"})
    void contsructorError(String nombre) {
        assertThrowsExactly(NoSeEncontroElPokemon.class,() -> new Pokemon(nombre,configuracion));
    }
}