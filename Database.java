/* Emre BOZKURT */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Database extends Application{
	
	private Button viewButton = new Button("View");
	private Button insertButton = new Button("Insert");
	private Button clearButton = new Button("Clear");
	
	private TextField idField = new TextField();
	private TextField firstNameField = new TextField();
	private TextField lastNameField = new TextField();
	private TextField cityField = new TextField();
	private TextField birthyearField = new TextField();
	
	private Text statusText = new Text();
	
	public void actions() throws Exception{
		viewButton.setOnAction(e -> {
			try {
				String useDatabaseQuery = "USE javaca_db;";
				String viewQuery = "SELECT * FROM Persons WHERE ID = '"+idField.getText()+"'";
				
				Statement statement = getConnection().createStatement();
				statement.executeUpdate(useDatabaseQuery);
				
				ResultSet resultSet = statement.executeQuery(viewQuery);
				
				while(resultSet.next()){
					int ID = resultSet.getInt("ID");
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					String city = resultSet.getString("city");
					int birthyear = resultSet.getInt("birthyear");
					
					idField.setText(String.valueOf(ID));
					firstNameField.setText(firstName);
					lastNameField.setText(lastName);
					cityField.setText(city);
					birthyearField.setText(String.valueOf(birthyear));
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		});
		
		insertButton.setOnAction(e -> {
			try {
				String useDatabaseQuery = "USE javaca_db;";
				String insertQuery = "INSERT INTO Persons(ID, firstName, lastName, city, birthyear) "
						+ "VALUES('"+idField.getText()+"','"+firstNameField.getText()+"','"
						+ lastNameField.getText()+"','"+cityField.getText()+"',"+"'"+birthyearField.getText()+"');";
				Statement statement = getConnection().createStatement();
				statement.executeUpdate(useDatabaseQuery);
				statement.executeUpdate(insertQuery);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		});
		
		clearButton.setOnAction(e -> {
			idField.clear();
			firstNameField.clear();
			lastNameField.clear();
			cityField.clear();
			birthyearField.clear();
		});
	}
	
	public void SQLStart() throws Exception{
		try {
			String createDatabaseQuery = "CREATE DATABASE javaca_db;";
			String useDatabaseQuery = "USE javaca_db;";
			String createTableQuery = "CREATE TABLE Persons "
					+ "(ID int,firstName varchar(15),lastName varchar(15),city varchar(15),birthyear int)";
			
			Statement statement = getConnection().createStatement();
			statement.executeUpdate(createDatabaseQuery);
			statement.executeUpdate(useDatabaseQuery);
			statement.executeUpdate(createTableQuery);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection getConnection() throws Exception{
		try {
			String url = "jdbc:mysql://localhost:3307";
			String user = "admin";
			String pw = "admin";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, pw);
			return connection;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void GUI(Stage stage){
		BorderPane mainPane = new BorderPane();
		
		FlowPane fieldFlowPane = new FlowPane(5,5);
		fieldFlowPane.getChildren().addAll(new Text("ID"),idField,new Text("First Name"),firstNameField,new Text("Last Name"),
				lastNameField,new Text("City"),cityField,new Text("Birthyear"),birthyearField);
		fieldFlowPane.setAlignment(Pos.CENTER);
		mainPane.setCenter(fieldFlowPane);
		
		HBox buttonHBox = new HBox(10);
		buttonHBox.getChildren().add(viewButton);
		buttonHBox.getChildren().add(insertButton);
		buttonHBox.getChildren().add(clearButton);
		buttonHBox.setAlignment(Pos.CENTER);
		BorderPane.setMargin(buttonHBox, new Insets(15, 15, 15, 15));
		mainPane.setBottom(buttonHBox);
		
		BorderPane.setAlignment(statusText, Pos.CENTER);
		mainPane.setTop(statusText);
		
		Scene scene = new Scene(mainPane,400,400);
		stage.setScene(scene);
		stage.setTitle("Javaca Database");
		stage.show();
	}
	
	@Override
	public void start (Stage primaryStage) throws Exception {
		GUI(primaryStage);
		if(getConnection() == null) statusText.setText("Status: DATABASE NOT CONNECTED!");
		else statusText.setText("Status: DATABASE CONNECTED!");
		SQLStart();
		actions();
	}
	
	public static void main (String[] args) {
		Application.launch(args);
	}
}
