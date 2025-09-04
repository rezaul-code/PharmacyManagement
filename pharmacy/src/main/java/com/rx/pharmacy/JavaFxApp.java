package com.rx.pharmacy;

import java.io.IOException;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxApp extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        // Initialize Spring context
        springContext = new SpringApplicationBuilder(PharmacyApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Pharmacy Application");
        // Example: load FXML, set scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        loader.setControllerFactory(springContext::getBean);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void stop() {
        // Close Spring context on exit
        springContext.close();
    }
}
