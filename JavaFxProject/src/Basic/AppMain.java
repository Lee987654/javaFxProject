package Basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {

	public AppMain() {
		System.out.println(Thread.currentThread().getName() + " :AppMain����.");

	}

	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : start");

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + " : start()");

		VBox root = new VBox();

		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);

		Label label = new Label();
		label.setText("Hello, JavaFx");
		label.setFont(new Font(50));

		Button button = new Button();
		button.setText("Ȯ��");
		button.setOnAction((event) -> Platform.exit());

//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//					Platform.exit();
//			}

//		});

		root.getChildren().add(label);
		root.getChildren().add(button);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : stop() ����.");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}


