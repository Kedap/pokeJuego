package org.codedestroyers.pokejuego.excepciones;

public class NoSeEncontroElPokemon extends Exception{
    public NoSeEncontroElPokemon() {}
    public NoSeEncontroElPokemon(String mensaje) {
        super(mensaje);
    }
}
