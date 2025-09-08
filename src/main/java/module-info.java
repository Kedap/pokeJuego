module org.codedestroyers.pokejuego.pokejuego {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires kotlin.stdlib;
    requires java.sql;
    requires org.codedestroyers.pokejuego;
    requires pokekotlin;
    requires okhttp3;

    opens org.codedestroyers.pokejuego.pokejuego to javafx.fxml;
    exports org.codedestroyers.pokejuego.pokejuego;
}