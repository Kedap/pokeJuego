package org.codedestroyers.pokejuego.posiones;

import lombok.AccessLevel;
import lombok.Getter;

public abstract class Posion {
    protected @Getter(AccessLevel.PUBLIC)String nombre;
    protected @Getter(AccessLevel.PUBLIC) String descripcion;
    protected @Getter(AccessLevel.PUBLIC)int tiempoEfecto;
    protected @Getter(AccessLevel.PUBLIC)int porcentajeDeDano;
    protected int tiempoEfectuado;
    protected @Getter(AccessLevel.PUBLIC) boolean continuaEfecto;

    public Posion(String nombre, String descripcion,int tiempoEfecto, int porcentajeDeDano) {
        this.nombre = nombre;
        this.tiempoEfecto = tiempoEfecto;
        this.porcentajeDeDano = porcentajeDeDano;
        this.descripcion = descripcion;
        continuaEfecto = true;
    }

    protected void efectuarTurno() {
        tiempoEfectuado++;
        continuaEfecto = tiempoEfectuado <= tiempoEfecto;
    }

    public abstract double obtenerDanoNuevo(double danoGolpe) throws InterruptedException;

}
