module com.project.example.dotsandboxsproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens com.project.example.dotsandboxsproject to javafx.fxml;
    exports com.project.example.dotsandboxsproject;
}