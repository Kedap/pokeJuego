package org.codedestroyers.pokejuego.posiones;

public class PosionOrdinaria extends Posion{
    public PosionOrdinaria(String nombre, int tiempoEfecto, int porcentajeDeDano) {
        super(nombre, tiempoEfecto, porcentajeDeDano);
    }

    @Override
    double obtenerDanoNuevo(double danoGolpe) {
        return danoGolpe - (danoGolpe * ((double) porcentajeDeDano / 100));
    }
}
