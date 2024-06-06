package org.codedestroyers.pokejuego.posiones;

public class PosionOrdinaria extends Posion {
    public PosionOrdinaria(String nombre, int tiempoEfecto, int porcentajeDeDano) {
        super(nombre, tiempoEfecto, porcentajeDeDano);
    }

    @Override
    public double obtenerDanoNuevo(double danoGolpe) {
        efectuarTurno();
        return danoGolpe + (danoGolpe * ((double) porcentajeDeDano / 100));
    }
}
