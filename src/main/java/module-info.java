module com.project.example.dotsandboxsproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.project.example.dotsandboxsproject to javafx.fxml;
    exports com.project.example.dotsandboxsproject;
}