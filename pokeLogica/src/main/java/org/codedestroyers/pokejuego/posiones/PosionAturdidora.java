package org.codedestroyers.pokejuego.posiones;

public class PosionAturdidora extends Posion {
    private final int tiempoAturdicion;

    public PosionAturdidora(String nombre, int tiempoEfecto, int porcentajeDeDano, int tiempoAturdicion) {
        super(nombre, tiempoEfecto, porcentajeDeDano);
        this.tiempoAturdicion = tiempoAturdicion;
    }

    // TODO: Escribir este método
    @Override
    public double obtenerDanoNuevo(double danoGolpe) {
        return (danoGolpe + (danoGolpe * (double) porcentajeDeDano) / 100);
    }
    public void TiempoAturdicion() throws InterruptedException {
        Thread.sleep(tiempoAturdicion* 1000);
        System.out.println("La posion "+nombre+"aturdio por "+tiempoAturdicion+" Seg");
    }
}
