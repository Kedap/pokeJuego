module org.codedestroyers.pokejuego.pokejuego {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.codedestroyers.pokejuego.pokejuego to javafx.fxml;
    exports org.codedestroyers.pokejuego.pokejuego;
}