module co.edu.uniquindio.poo.empresaalquilerautos {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.empresaalquilerautos to javafx.fxml;
    exports co.edu.uniquindio.poo.empresaalquilerautos;
}