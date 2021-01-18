module sample {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires json.simple;
    requires javafx.media;
    requires java.desktop;
    requires javafx.swing;

    opens Plato.MainGraphical;
    opens Reversi;

}