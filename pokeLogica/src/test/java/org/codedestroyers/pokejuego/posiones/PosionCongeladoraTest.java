package org.codedestroyers.pokejuego.posiones;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PosionCongeladoraTest {

    @ParameterizedTest
    @CsvSource({"100.0,90.0,190.0", "50.0,50.0,75.0", "10.0,20.0,12.0"})
    void obtenerDanoNuevo(double danoNomral, double danoPosion, double danoEsperado) throws InterruptedException {
        PosionCongeladora po = new PosionCongeladora("Posion Ordinaria", 5, (int) danoPosion,30);
        assertEquals(po.obtenerDanoNuevo(danoNomral), danoEsperado);
    }
}