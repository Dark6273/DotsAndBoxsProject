module com.project.example.dotsandboxsproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.example.dotsandboxsproject to javafx.fxml;
    exports com.project.example.dotsandboxsproject;
}