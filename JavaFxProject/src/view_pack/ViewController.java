package view_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class ViewController implements Initializable {
	@FXML 
	ListView<String> listView;
	@FXML
	TableView<Phone> tableView;
	@FXML
	ImageView imageView;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 초기화 지정. 
		ObservableList<String> list = FXCollections.observableArrayList(
				"GalaxyS1", "GalaxyS2", "GalaxyS3", "GalaxyS4");
		list.add("GalaxyS5");
		list.add("GalaxyS6");
		list.add("GalaxyS7");
		listView.setItems(list);
		
		listView.getSelectionModel().selectedIndexProperty()
		.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				tableView.getSelectionModel().select(newVal.intValue());
				tableView.scrollTo(newVal.intValue());
			}
			
			
		});
	
		tableView.setItems(FXCollections.observableArrayList(
				new Phone("GalaxyS1", "phone01.jpg"),
				new Phone("GalaxyS2", "pHONE02.Jpg"),
				new Phone("GalaxyS3", "pHONE03.Jpg"),
				new Phone("GalaxyS4", "pHONE04.Jpg"),
				new Phone("GalaxyS5", "pHONE05.Jpg"),
				new Phone("GalaxyS6", "pHONE06.Jpg"),
				new Phone("GalaxyS7", "pHONE07.Jpg")
				));
		TableColumn<Phone, ?> tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
	
		tableView.getColumns().get(0).setCellValueFactory(new ProperyValueFactory("smart"));
				 .addListener(new ChangeListener<Phone>()
		TableColumn<Phone, ?> tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		
		tableView.getSelectionModel().selectedItemProPerty().addListener(new ChangeListener)
		imageView.setImage
	}

	public void handleBtnRegAction() {
		
		
	}
	
	public void handleBtnRegAction() {

	}
	
	
	});
	tcTitle.setText("제목");
	// exitDate
	TableColumn<Boar, String> tcExitDate = new TableColumn<>;
	tcExitDate.setCellValueFactory(new PropertyValueFactory<Board, String>()
	
	
		// exitDate
	TableColumn<Board, String> tcExitDate = new TableColumn<>();
	tcExitDate.setCellValueFactory(new PropertyValueFactory<Board, String>()
			
			
			
			
			
			
