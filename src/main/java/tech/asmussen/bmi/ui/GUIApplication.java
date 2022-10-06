package tech.asmussen.bmi.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIApplication extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(GUIApplication.class.getResource("view.fxml"));
		
		Scene scene = new Scene(fxmlLoader.load(), 600, 400);
		
		stage.setTitle("BMI Udregner");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	public static void main(String[] args) {
		
		launch();
	}
}
