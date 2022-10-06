package tech.asmussen.bmi.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {
	
	@FXML
	private TextField heightField;
	
	@FXML
	private TextField weightField;
	
	@FXML
	private ComboBox<String> genderBox;
	
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
		genderBox.getItems().setAll("Mand", "Kvinde");
		genderBox.setValue("Mand");
	}
	
	public void onCalculateButtonClicked() {
		
		double bmi;
		
		double height;
		double weight;
		
		String rawHeight = heightField.getText();
		String rawWeight = weightField.getText();
		
		boolean isMale = genderBox.getValue().equals("Mand");
		
		try {
			
			height = Double.parseDouble(rawHeight);
			weight = Double.parseDouble(rawWeight);
			
			bmi = weight / (height * height);
			
		} catch (NumberFormatException e) {
			
			Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			
			errorAlert.setTitle("Fejl!");
			errorAlert.setContentText("Du kan kun indtaste tal i højde og vægt felterne!");
			errorAlert.setResizable(false);
			errorAlert.show();
			
			return;
		}
		
		String state;
		
		if (isMale) {
		
			if (bmi < 20) {
				
				state = "undervægtig";
				
			} else if (bmi >= 20 && bmi <= 25) {
				
				state = "normalvægtig";
				
			} else if (bmi >= 25 && bmi <= 30) {
				
				state = "oervægtig";
				
			} else {
				
				state = "stærkt overvægtig";
			}
			
		} else {
			
			if (bmi < 18.6) {
				
				state = "undervægtig";
				
			} else if (bmi >= 18.6 && bmi <= 23.8) {
				
				state = "normalvægtig";
				
			} else if (bmi >= 23.8 && bmi <= 28.6) {
				
				state = "oervægtig";
				
			} else {
				
				state = "stærkt overvægtig";
			}
		}
		
		final String content = String.format("Du er en %s på %.2f meter, der vejer %.2f kg og har en BMI på %.2f, hvilket betyder at du er %s.",
				(isMale ? "Mand" : "Kvinde"), height, weight, bmi, state);
		
		Alert bmiAlert = new Alert(Alert.AlertType.INFORMATION);
		
		bmiAlert.setTitle("BMI");
		bmiAlert.setContentText(content);
		bmiAlert.setResizable(false);
		bmiAlert.show();
	}
}
