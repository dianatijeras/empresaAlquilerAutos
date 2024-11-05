module co.edu.uniquindio.poo.empresaalquilerautos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.empresaalquilerautos to javafx.fxml;
    exports co.edu.uniquindio.poo.empresaalquilerautos;

    opens co.edu.uniquindio.poo.empresaalquilerautos.viewController;
    exports co.edu.uniquindio.poo.empresaalquilerautos.viewController;
}