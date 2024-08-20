package application.FrontEnd;
	
import application.BackEnd.PaneData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	 public void start(Stage primaryStage) {
        try {
        	
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ressource/Fxml Folder/GamePane.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            GamePaneController controller  = loader.getController();
            controller.setScene(scene);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setMinHeight(PaneData.GetMinHeight());
            primaryStage.setMinWidth(PaneData.GetMinWidth());
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
}
