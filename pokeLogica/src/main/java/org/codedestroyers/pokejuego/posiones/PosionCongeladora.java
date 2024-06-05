package org.codedestroyers.pokejuego.posiones;

public class PosionCongeladora extends Posion {
    private int tiempoCongelacion;

    public PosionCongeladora(String nombre, int tiempoEfecto, int porcentajeDeDano, int tiempoCongelacion) {
        super(nombre, tiempoEfecto, porcentajeDeDano);
        this.tiempoCongelacion = tiempoCongelacion;
    }

    //TODO: Escribir este método
    @Override
    double obtenerDanoNuevo(double danoGolpe) {
        return 0;
    }
}
