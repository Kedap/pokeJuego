package org.codedestroyers.pokejuego.pokejuego;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import me.sargunvohra.lib.pokekotlin.client.ClientConfig;
import okhttp3.HttpUrl;
import org.codedestroyers.pokejuego.Pokemon;
import org.codedestroyers.pokejuego.excepciones.NoSeEncontroElPokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloController {
    @FXML
    private TextField primerBuscador;
    @FXML
    private TextField segundoBuscador;
    @FXML
    private ImageView img1PrimerJugador;
    @FXML
    private ImageView img2PrimerJugador;
    @FXML
    private ImageView img3PrimerJugador;
    @FXML
    private ImageView img1SegundoJugador;
    @FXML
    private ImageView img2SegundoJugador;
    @FXML
    private ImageView img3SegundoJugador;
    @FXML
    private Button botonJugar;

    private List<Pokemon> pokemonesJugador1 = new ArrayList<>();
    private List<Pokemon> pokemonesJugador2 = new ArrayList<>();

    private void actualizarImagenesJugador1() {
        switch (pokemonesJugador1.size()) {
            case 1:
                img1PrimerJugador.setImage(new Image(pokemonesJugador1.getFirst().getImagenSeleccionada()));
                break;
            case 2:
                img2PrimerJugador.setImage(new Image(pokemonesJugador1.get(1).getImagenSeleccionada()));
                break;
            case 3:
                img3PrimerJugador.setImage(new Image(pokemonesJugador1.getLast().getImagenSeleccionada()));
                break;
        }
    }

    private void actualizarImagenesJugador2() {
        switch (pokemonesJugador2.size()) {
            case 1:
                img1SegundoJugador.setImage(new Image(pokemonesJugador2.getFirst().getImagenSeleccionada()));
                break;
            case 2:
                img2SegundoJugador.setImage(new Image(pokemonesJugador2.get(1).getImagenSeleccionada()));
                break;
            case 3:
                img3SegundoJugador.setImage(new Image(pokemonesJugador2.getLast().getImagenSeleccionada()));
                break;
        }
    }

    private ClientConfig obtenerConfiguracionc() {
        return new ClientConfig(HttpUrl.parse("https://pokeapi.co/api/v2/"), builder -> {
            builder.retryOnConnectionFailure(false);
            builder.connectTimeout(30, TimeUnit.SECONDS);
            builder.readTimeout(30, TimeUnit.SECONDS);
            builder.writeTimeout(30, TimeUnit.SECONDS);
            return builder;
        });
    }

    @FXML
    protected void onPrimerBotonClick() {
        try {
            if (pokemonesJugador1.size() < 3) {
                Pokemon nuevoPokemon = new Pokemon(primerBuscador.getText(), obtenerConfiguracionc());
                pokemonesJugador1.add(nuevoPokemon);
                actualizarImagenesJugador1();
                botonJugar.setDisable(!(pokemonesJugador1.size() == 3 && pokemonesJugador2.size() == 3));
            }
        } catch (NoSeEncontroElPokemon e) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error");
            alerta.setHeaderText("Pokemon no encontrado");
            alerta.setContentText("No se encontro " + primerBuscador.getText());
            alerta.show();
        }
    }

    @FXML
    protected void onSegundoBotonClick() {
        try {
            if (pokemonesJugador2.size() < 3) {
                Pokemon nuevoPokemon = new Pokemon(segundoBuscador.getText(), obtenerConfiguracionc());
                pokemonesJugador2.add(nuevoPokemon);
                actualizarImagenesJugador2();
                botonJugar.setDisable(!(pokemonesJugador1.size() == 3 && pokemonesJugador2.size() == 3));
            }
        } catch (NoSeEncontroElPokemon e) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error");
            alerta.setHeaderText("Pokemon no encontrado");
            alerta.setContentText("No se encontro " + segundoBuscador.getText());
            alerta.show();
        }
    }

    @FXML
    protected void salir() throws IOException {
        System.out.println("Si");
        Stage stage = (Stage) botonJugar.getScene().getWindow();
        stage.close();
        ListaPokemones lista = ListaPokemones.obtenerInstancia();
        lista.setJugadores(pokemonesJugador1, pokemonesJugador2);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("interfaz-pelea.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 940, 860);
        stage.setTitle("PokaJuego!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void porfavor() {
        System.out.println("Si");
    }
}