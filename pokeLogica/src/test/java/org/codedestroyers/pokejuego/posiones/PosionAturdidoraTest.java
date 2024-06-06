package org.codedestroyers.pokejuego.posiones;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PosionAturdidoraTest {

    @ParameterizedTest
    @CsvSource({"100.0,90.0,280.0", "50.0,50.0,100.0", "10.0,20.0,14.0"})
    void obtenerDanoNuevo(double danoNomral, double danoPosion, double danoEsperado) throws InterruptedException {
        PosionAturdidora po = new PosionAturdidora("Posion Ordinaria", "", 1, (int) danoPosion, 30);
        assertEquals(po.obtenerDanoNuevo(danoNomral), danoEsperado);
    }

    @ParameterizedTest
    @Timeout(5)
    @ValueSource(ints = {1, 2, 3})
    void checarTurnos(int tiempoEfecto) throws InterruptedException {
        PosionAturdidora pa = new PosionAturdidora("Posion Ordinaria", "", tiempoEfecto, 2, 1);
        int dano = 100;
        int i = 0;
        while (pa.isContinuaEfecto()) {
            double otro = pa.obtenerDanoNuevo(100);
            if (dano == otro) {
                fail("El daño no puede ser el mismo con la posion activada");
            }
            i++;
        }
        if (i != tiempoEfecto + 1) {
            fail("Se necesitaron mas del tiempo establecido de la duracion de la posion");
        }
    }
}