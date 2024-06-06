package org.codedestroyers.pokejuego;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.codedestroyers.pokejuego.posiones.Posion;

public class Pokemon {
    private String nombre;
    private int vida;
    private @Setter(AccessLevel.PUBLIC) Posion posion;
    private boolean posionActiva;
    private int danoGolpe;
    private int defensa;
    private @Getter(AccessLevel.PUBLIC) String imagenSeleccionada;
    private @Getter(AccessLevel.PUBLIC) String imagenBatalla;

    //TODO: Constructor
    public Pokemon() {
        // Este es solo un ejemplo del uso del cliente de la PokeAPI
//        ClientConfig configuracion = new ClientConfig(HttpUrl.parse("https://pokeapi.co/api/v2/"),builder -> {
//            builder.retryOnConnectionFailure(false);
//            builder.connectTimeout(30, TimeUnit.SECONDS);
//            builder.readTimeout(30, TimeUnit.SECONDS);
//            builder.writeTimeout(30, TimeUnit.SECONDS);
//        });
//        PokeApi cliente = new PokeApiClient(configuracion);
//        PokemonSpecies bulbasaur = cliente.getPokemonSpecies(1);
    }

    public double golpear(Pokemon p) {
        if (posionActiva) {
            return (posion.obtenerDanoNuevo(danoGolpe));
        } else {
            return danoGolpe;
        }
    }

    public int recibirGolpe(int dano) {
        if (posionActiva) {
                dano = (int) (posion.obtenerDanoNuevo(danoGolpe) - defensa);
            } else {
                dano = danoGolpe;
            }
            vida = -dano;
            return dano;
        }
        public void tomarPosion () {
            posionActiva = true;
        }

        public boolean haPerdido () {
            return vida <= 0;
        }
    }
