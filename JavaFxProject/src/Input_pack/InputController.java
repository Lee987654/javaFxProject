package Input_pack;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InputController implements Initializable {
	// title, password, publicity, exitData, content;
	@FXML
	Button btnReg;
	@FXML
	TextField txtTitle;
	@FXML
	PasswordField txtPassword;
	@FXML
	ComboBox<String> comboPublic;

	@FXML
	DatePicker dateExit;
	@FXML
	TextArea txtContent;
	@FXML
	Button btnCancel;
	
	Connection conn;//import java.sql
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521";
		try {
			conn=DriverManager.getConnection(url, "hr", "hr");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

	
			
	


	
	public void handleBtnRegAction(ActionEvent e) {
		if (txtTitle.getText() == null || txtTitle.getText().contentEquals("")) {
			messagePopup("�����Է��ϼ���.");
		} else if (txtPassword.getText() == null || txtPassword.getText().equals("")) {
			messagePopup("����Է��ϼ���.");
		} else if (comboPublic.getValue() == null || comboPublic.getValue().equals("")) {
			messagePopup("�������� �Է��ϼ���");
		} else if (dateExit.getValue() == null || dateExit.getValue().equals("")) {
			messagePopup("������ �Է��ϼ���");
		} else if (txtContent.getText() == null || txtContent.getText().equals("")) {
			messagePopup("���� �Է��ϼ���.");
		} else {
			// DB �Է�...Connection, PreparedStatement, executeUpdate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy/MM/dd");
			String sql = "insert into board(title,password,publicity,exit_date,content)"
			+ "values(?,?,?,?,?)";
			
			try {
				PreparedStatement pstmt =conn.prepareStatement(sql);
				pstmt.setString(1, txtTitle.getText());
				pstmt.setString(2, txtPassword.getText());
				pstmt.setString(3, comboPublic.getValue());
				pstmt.setString(4, dateExit.getValue().format(formatter));
				pstmt.setString(5, txtContent.getText());
				
				int r = pstmt.executeUpdate();
				System.out.println(r + " �� �Էµ�.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				// �� �ʵ� �ʱ�ȭ.
				txtTitle.setText(null);
				txtPassword.setText(null);
				comboPublic.setValue(null);
				txtContent.setText(null);
	} // end of if..
	
	
	} // end of handleBtnRegAction()
	
	public void messageDialog(String message) {
		Stage customStage = new Stage(StageStyle.UTILITY);
		customStage.initModality(Modality.WINDOW_MODAL);
		customStage.initOwner(btnReg.getScene().getWindow());
		customStage.setTitle("Ȯ��");
		
		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);
		
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("/icons/dialog-info.png"));
		imageView.setFitHeight(50);
		imageView.setPreserveRatio(true);
		imageView.setLayoutX(15);
		imageView.setLayoutY(15);
		
		Button button = new Button("Ȯ��");
		button.setLayoutX(336);
		button.setLayoutY(104);
		button.setOnAction(e -> customStage.close());
		
		Label label = new Label(message);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefHeight(15);
		label.setPrefWidth(290);
	
		
		ap.getChildren().add(imageView);
		ap.getChildren().add(button);
		ap.getChildren().add(label);
		
		Scene scene = new Scene(ap);
		customStage.setScene(scene);
		customStage.show();
	}
	public void messagePopup(String message) {
		
		
		// �����̳�(HBox) ����.
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: black; -fx-background-radius: 20;");
		hbox.setAlignment(Pos.CENTER);
		// ��Ʈ��(ImageView)
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("icons/dialog-info.png"));
		imageView.setFitHeight(30);;
		imageView.setFitWidth(30);
		// ��Ʈ��(Label)
		Label label = new Label();
		HBox.setMargin(label, new Insets(0,5,0,5));
		label.setText(message);
		label.setStyle("-fx-text-fill: white; ");
		// �����̳ʿ� ��Ʈ�� ���.
		hbox.getChildren().add(imageView);
		hbox.getChildren().add(label);
		// �˾� ����. �����̳� ��Ƽ� �˾� ȣ��.
		Popup popup = new Popup();
		popup.getContent().add(hbox);
		popup.setAutoHide(true);
		popup.show(btnReg.getScene().getWindow());
	
	
	}

	


} // end of class
	
	