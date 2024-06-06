package org.codedestroyers.pokejuego.pokejuego;

import org.codedestroyers.pokejuego.Pokemon;

import java.util.List;

public class ListaPokemones {
    private List<Pokemon> primerJugador;
    private List<Pokemon> segundoJugador;
    private final static ListaPokemones INSTANCE = new ListaPokemones();

    private ListaPokemones() {
    }

    public static ListaPokemones obtenerInstancia() {
        return INSTANCE;
    }

    public void setJugadores(List<Pokemon> primerJugador, List<Pokemon> segundoJugador) {
        this.primerJugador = primerJugador;
        this.segundoJugador = segundoJugador;
    }

    public List<Pokemon> getJugadores(int i) {
        if (i == 1) {
            return primerJugador;
        } else {
            return segundoJugador;
        }
    }
}
