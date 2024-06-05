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
