package org.codedestroyers.pokejuego.posiones;

public class PosionAturdidora extends Posion {
    private int tiempoAturdicion;

    public PosionAturdidora(String nombre, int tiempoEfecto, int porcentajeDeDano, int tiempoAturdicion) {
        super(nombre, tiempoEfecto, porcentajeDeDano);
        this.tiempoAturdicion = tiempoAturdicion;
    }

    // TODO: Escribir este método
    @Override
    double obtenerDanoNuevo(double danoGolpe) {
        return 0;
    }
}
