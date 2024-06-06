package org.codedestroyers.pokejuego.pokejuego;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.codedestroyers.pokejuego.posiones.PosionAturdidora;
import org.codedestroyers.pokejuego.posiones.PosionCongeladora;
import org.codedestroyers.pokejuego.posiones.PosionOrdinaria;

public class ControladorPelea {
    Jugador jugador1;
    Jugador jugador2;

    @FXML
    private Button ejecutarPosion1;
    @FXML
    private Button ejecutarPosionDo;
    @FXML
    private Label j1NombrePokemon;
    @FXML
    private Label j2NombrePokemon;
    @FXML
    private Label j1Vida;
    @FXML
    private Label j2Vida;
    @FXML
    private Label j1Dano;
    @FXML
    private Label j2Dano;
    @FXML
    private Label j1Defensa;
    @FXML
    private Label j2Defensa;
    @FXML
    private Label j1Posion;
    @FXML
    private Label j2Posion;
    @FXML
    private Label marcador;
    @FXML
    private ImageView imgPrimerJugador;
    @FXML
    private ImageView imgSegundoJugador;

    @FXML
    protected void iniciarCombate1() throws InterruptedException {
        ListaPokemones lista = ListaPokemones.obtenerInstancia();
        jugador1 = new Jugador(ejecutarPosion1,
                j1NombrePokemon,
                j1Vida,
                j1Dano,
                j1Defensa,
                j1Posion,
                new PosionOrdinaria("Aumento poder", "Aumenta poder", 3, 2),
                lista.getJugadores(1),
                imgPrimerJugador);
        jugador2 = new Jugador(ejecutarPosionDo,
                j2NombrePokemon,
                j2Vida,
                j2Dano,
                j2Defensa,
                j2Posion,
                new PosionOrdinaria("Aumento poder", "Aumenta poder", 3, 2),
                lista.getJugadores(2),
                imgSegundoJugador);
        while (!jugador1.pokemons.get(0).haPerdido() && !jugador1.pokemons.get(0).haPerdido()) {
            jugador1.mostrarPantalla(0);
            jugador2.mostrarPantalla(0);
            jugador1.pokemons.get(0).golpear(jugador2.pokemons.get(0));
            jugador2.pokemons.get(0).golpear(jugador1.pokemons.get(0));
            jugador1.mostrarPantalla(0);
            jugador2.mostrarPantalla(0);
        }
    }

    @FXML
    protected void iniciarCombate2() throws InterruptedException {
        ListaPokemones lista = ListaPokemones.obtenerInstancia();
        jugador1 = new Jugador(ejecutarPosion1,
                j1NombrePokemon,
                j1Vida,
                j1Dano,
                j1Defensa,
                j1Posion,
                new PosionCongeladora("Congelamiento", "Congela", 3, 10, 0),
                lista.getJugadores(1),
                imgPrimerJugador);
        jugador2 = new Jugador(ejecutarPosionDo,
                j2NombrePokemon,
                j2Vida,
                j2Dano,
                j2Defensa,
                j2Posion,
                new PosionCongeladora("Congelamiento", "Congela", 3, 10, 0),
                lista.getJugadores(2),
                imgSegundoJugador);
        while (!jugador1.pokemons.get(1).haPerdido() && !jugador1.pokemons.get(1).haPerdido()) {
            jugador1.mostrarPantalla(1);
            jugador2.mostrarPantalla(1);
            jugador1.pokemons.get(1).golpear(jugador2.pokemons.get(1));
            jugador2.pokemons.get(1).golpear(jugador1.pokemons.get(1));
            jugador1.mostrarPantalla(1);
            jugador2.mostrarPantalla(1);
        }
    }

    @FXML
    protected void iniciarCombate3() throws InterruptedException {
        ListaPokemones lista = ListaPokemones.obtenerInstancia();
        jugador1 = new Jugador(ejecutarPosion1,
                j1NombrePokemon,
                j1Vida,
                j1Dano,
                j1Defensa,
                j1Posion,
                new PosionAturdidora("Aturdir", "Aturdidora", 5, 5, 0),
                lista.getJugadores(1),
                imgPrimerJugador);
        jugador2 = new Jugador(ejecutarPosionDo,
                j2NombrePokemon,
                j2Vida,
                j2Dano,
                j2Defensa,
                j2Posion,
                new PosionAturdidora("Aturdir", "Aturdidora", 5, 5, 0),
                lista.getJugadores(2),
                imgSegundoJugador);
        while (!jugador1.pokemons.get(2).haPerdido() && !jugador1.pokemons.get(2).haPerdido()) {
            jugador1.mostrarPantalla(2);
            jugador2.mostrarPantalla(2);
            jugador1.pokemons.get(2).golpear(jugador2.pokemons.get(2));
            jugador2.pokemons.get(2).golpear(jugador1.pokemons.get(2));
            jugador1.mostrarPantalla(2);
            jugador2.mostrarPantalla(2);
        }
    }
}
