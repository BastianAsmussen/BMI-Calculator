module tech.asmussen.bmi {
	
	requires javafx.controls;
	requires javafx.fxml;
	
	exports tech.asmussen.bmi.ui;
	opens tech.asmussen.bmi.ui to javafx.fxml;
}
