package org.codedestroyers.pokejuego.posiones;

public class PosionAturdidora extends Posion {
    private final int tiempoAturdicion;

    public PosionAturdidora(String nombre, String descripcion, int tiempoEfecto, int porcentajeDeDano, int tiempoAturdicion) {
        super(nombre, descripcion, tiempoEfecto, porcentajeDeDano * 2);
        this.tiempoAturdicion = tiempoAturdicion;
    }

    @Override
    public double obtenerDanoNuevo(double danoGolpe) throws InterruptedException {
        Thread.sleep(tiempoAturdicion * 100);
        efectuarTurno();
        return (danoGolpe + (danoGolpe * (double) porcentajeDeDano) / 100);
    }
}
