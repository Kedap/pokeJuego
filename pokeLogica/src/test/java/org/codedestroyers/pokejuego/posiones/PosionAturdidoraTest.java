package org.codedestroyers.pokejuego.posiones;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PosionAturdidoraTest {

    @ParameterizedTest
    @CsvSource({"100.0,90.0,10.0", "50.0,50.0,25.0", "10.0,20.0,8.0"})
    void obtenerDanoNuevo(double danoNomral, double danoPosion, double danoEsperado) {
        PosionAturdidora po = new PosionAturdidora("Posion Ordinaria", 5, (int) danoPosion,30);
        assertEquals(po.obtenerDanoNuevo(danoNomral), danoEsperado);
    }
}