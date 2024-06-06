package org.codedestroyers.pokejuego.posiones;

import lombok.AccessLevel;
import lombok.Getter;

public abstract class Posion {
    protected @Getter(AccessLevel.PUBLIC)String nombre;
    protected @Getter(AccessLevel.PUBLIC) String descripcion;
    protected @Getter(AccessLevel.PUBLIC)int tiempoEfecto;
    protected @Getter(AccessLevel.PUBLIC)int porcentajeDeDano;
    protected int tiempoEfectuado;
    protected @Getter(AccessLevel.PUBLIC) boolean terminoEfecto;

    public Posion(String nombre, int tiempoEfecto, int porcentajeDeDano) {
        this.nombre = nombre;
        this.tiempoEfecto = tiempoEfecto;
        this.porcentajeDeDano = porcentajeDeDano;
    }

    public abstract double obtenerDanoNuevo(double danoGolpe) throws InterruptedException;

}
