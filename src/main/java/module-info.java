module com.example.community {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.sql;
    requires mysql.connector.java;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.community to javafx.fxml;
    exports com.example.community;
}