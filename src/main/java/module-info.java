module com.project.example.dotsandboxsproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;
    requires ini4j;


    opens com.project.example.dotsandboxsproject to javafx.fxml;
    exports com.project.example.dotsandboxsproject;
}