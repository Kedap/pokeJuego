package org.codedestroyers.pokejuego.posiones;

public class PosionCongeladora extends Posion {
    private int tiempoCongelacion;

    public PosionCongeladora(String nombre, String descripcion, int tiempoEfecto, int porcentajeDeDano, int tiempoCongelacion) {
        super(nombre, descripcion, tiempoEfecto, porcentajeDeDano);
        this.tiempoCongelacion = tiempoCongelacion;
    }

    @Override
    public double obtenerDanoNuevo(double danoGolpe) throws InterruptedException {
        Thread.sleep(tiempoCongelacion * 100);
        efectuarTurno();
        return (danoGolpe + (danoGolpe * (double) porcentajeDeDano) / 100);
    }
}
