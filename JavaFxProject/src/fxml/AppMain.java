package fxml;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import oracle.net.aso.e;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		
		TextField textField = new TextField();
		
		Button button = new Button();
		button.setText("»Æ¿Œ");
		
		ObservableList<e> list = hbox.getChildren();
		list.add(textField);
		list.add(button);
		
		Scene scene = new Scene(hbox);
		
		primaryStage.setTittle("AppMain");
		primaryStage.setScene
	}

	
	
}
