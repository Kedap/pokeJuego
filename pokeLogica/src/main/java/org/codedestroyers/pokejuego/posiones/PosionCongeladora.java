package org.codedestroyers.pokejuego.posiones;

public class PosionCongeladora extends Posion {
    private int tiempoCongelacion;

    public PosionCongeladora(String nombre, int tiempoEfecto, int porcentajeDeDano, int tiempoCongelacion) {
        super(nombre, tiempoEfecto, porcentajeDeDano);
        this.tiempoCongelacion = tiempoCongelacion;
    }

    //TODO: Escribir este método
    @Override
    public double obtenerDanoNuevo(double danoGolpe) {
        return (danoGolpe + (danoGolpe * (double) porcentajeDeDano) / 100);
    }

    public int tiempoCongelacion() throws InterruptedException {
        Thread.sleep(tiempoCongelacion * 1000);
        System.out.println("La posion "+nombre+" congelo por "+ tiempoCongelacion);
        return 2;
    }
}
