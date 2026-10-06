module org.example.craps {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.craps to javafx.fxml;
    exports org.example.craps;
    exports org.example.craps.controllers;
    opens org.example.craps.controllers to javafx.fxml;
}