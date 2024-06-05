package org.codedestroyers.pokejuego.posiones;

import lombok.AccessLevel;
import lombok.Getter;

public abstract class Posion {
    protected String nombre;
    protected @Getter(AccessLevel.PUBLIC) String descripcion;
    protected int tiempoEfecto;
    protected int porcentajeDeDano;
    protected int tiempoEfectuado;
    protected @Getter(AccessLevel.PUBLIC) boolean terminoEfecto;

    public Posion(String nombre, int tiempoEfecto, int porcentajeDeDano) {
        this.nombre = nombre;
        this.tiempoEfecto = tiempoEfecto;
        this.porcentajeDeDano = porcentajeDeDano;
    }

    abstract double obtenerDanoNuevo(double danoGolpe);
}
