package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	FXMLDocumentController dc;
	
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			//Carga el layout desde el fichero fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Portada.fxml"));			
			rootLayout = (BorderPane) loader.load();
			
			//Muestra la escena que contiene el rootlayout
			Scene scene = new Scene(rootLayout,400,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pings");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
