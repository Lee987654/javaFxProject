package view_pack;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
	
public class BoardController implements Initializable {
	Connection conn;
	
	
	
	@FXML 	TableView<Board> tableView;
	@FXML 	TextField txtTitle;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, "hr", "hr");
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	ObservableList<Board> boardList = FXCollections.observableArrayList();
	// boardList.add(e);
	
	TableColumn<Board, String> tcTitle = new TableColumn<Board, String>();
	tcTitle.setCellValueFactory(new Callback<CellDataFeatures<Board, String>, ObservableValue<String>>(){
		//첫번째는 인풋, 두번째는 리턴 타입
		@Override
		public ObservableValue<String> call(CellDataFeatures<Board, String> param) {
			return param.getValue().titleProperty();
		}
		
	});
	tcTitle.setText("제목");
	
	//exitDate
	TableColumn<Board, String> tcExitDate = new TableColumn<>();
	tcExitDate.setCellValueFactory(new PropertyValueFactory<Board, String>("exitDate"));
	tcExitDate.setText("종료일자");
	
	tableView.getColumns().add(tcTitle);
	tableView.getColumns().add(tcExitDate);
	
	
	tableView.setItems(boardList);
	}
	
	
	//TableColumn<Board, ?> tcTitle = tableView.getColumns()
	//Bindings.bindBidirectional(tableView.accessibleTextProperty(), txtTitle.textProperty());
	
public ObservableList<Board> getBoardList(){
	ObservableList<Board> list = FXCollections.observableArrayList();
	String sql = "select title, publicity, exit_date, content from board";
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();//resultset은 무슨 기능이지?
		while(rs.next()) {
			Board board = new Board(rs.getString("title"),null, rs.getString("publicity"), rs.getString("exit_date"), rs.getString("content"));
		list.add(board);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}//end of getBoardList();
}//end of class