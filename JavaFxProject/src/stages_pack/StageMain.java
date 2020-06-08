package stages_pack;

import Input_pack.InputController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.applet.Main;
// Root.fxml
// AddForm.fxml
// ScoreChart.fxml
// StageController.java

public class StageMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		FXMLLoader loader = new FXMLLoader();
		Parent root = loader.load(getClass().getResource("Root.fxml"));
		
		// Controller 에 stage 값을 넘겨준다.
//		StageController cont = loader.getController();
//		cont.setPrimaryStage(stage);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
//		FXMLLoader loader = new FXMLLoader();
//		InputController cont = loader.getController();
//		cont.setPrimaryStage(stage);
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
