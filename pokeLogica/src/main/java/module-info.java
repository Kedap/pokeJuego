module org.codedestroyers.pokejuego {
    requires kotlin.stdlib;
    requires static lombok;
    requires pokekotlin;
    requires retrofit2;
    requires retrofit2.converter.gson;

    exports org.codedestroyers.pokejuego;
    exports org.codedestroyers.pokejuego.posiones;
    exports org.codedestroyers.pokejuego.excepciones;
}