module com.csiiproject.m3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires junit;
    requires java.desktop;
    requires javafx.swing;

    opens com.csiiproject.javaFX to javafx.fxml;
    exports com.csiiproject.javaFX;
}