package org.codedestroyers.pokejuego.posiones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PosionOrdinariaTest {

    @ParameterizedTest
    @CsvSource({"100.0,90.0,190.0", "50.0,50.0,75.0", "10.0,20.0,12.0"})
    void obtenerDanoNuevo(double danoNomral, double danoPosion, double danoEsperado) {
        PosionOrdinaria po = new PosionOrdinaria("Posion Ordinaria", 5, (int) danoPosion);
        assertEquals(po.obtenerDanoNuevo(danoNomral), danoEsperado);
    }
}