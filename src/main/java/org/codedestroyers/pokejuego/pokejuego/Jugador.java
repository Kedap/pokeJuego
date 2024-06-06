package org.codedestroyers.pokejuego.pokejuego;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.codedestroyers.pokejuego.Pokemon;
import org.codedestroyers.pokejuego.posiones.Posion;

import java.util.List;

public class Jugador {
    @FXML
    Button botonPosion;
    @FXML
    Label nombrePokemon;
    @FXML
    Label vida;
    @FXML
    Label dano;
    @FXML
    Label defensa;
    @FXML
    Label lblPosion;
    List<Pokemon> pokemons;
    Posion posion;
    ImageView imagen;

    Jugador(Button botonPosion, Label nombrePokemon, Label vida, Label dano, Label defensa, Label lblPosion, Posion posion, List<Pokemon> pokemons, ImageView imagen) {
        this.botonPosion = botonPosion;
        this.nombrePokemon = nombrePokemon;
        this.vida = vida;
        this.dano = dano;
        this.defensa = defensa;
        this.lblPosion = lblPosion;
        this.posion = posion;
        this.pokemons = pokemons;
        this.imagen = imagen;
    }

    public void mostrarPantalla(int i) {
        nombrePokemon.setText("Pokemon: " + pokemons.get(i).getNombre());
        vida.setText("Vida: " + pokemons.get(i).getVida());
        dano.setText("Daño: " + pokemons.get(i).getDanoGolpe());
        defensa.setText("Defensa: " + pokemons.get(i).getDefensa());
        lblPosion.setText("Posion: " + posion.getNombre() + posion.getDescripcion());
        imagen.setImage(new Image(pokemons.get(i).getImagenBatalla()));
    }
}
