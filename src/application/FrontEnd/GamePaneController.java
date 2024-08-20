package application.FrontEnd;

import java.net.URL;
import java.util.ResourceBundle;

import application.BackEnd.GameThread;
import application.BackEnd.PaneData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GamePaneController implements Initializable{
private Scene scene;
@FXML
private Pane GamePane;


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	GameThread gameThread  = new GameThread();
	gameThread.start();
	GamePane.setMinHeight(PaneData.GetMinHeight());
	GamePane.setMinWidth(PaneData.GetMinWidth());
	
}

private void updateScale(double width, double height) {
    double scale = PaneData.GetOptimizedScale(width, height);

    // Update your game layout or redraw elements based on the new scale
    updateGameLayout(scale);
}

private void updateGameLayout(double scale) {
    // Implement your logic to adjust tile sizes and positions
    System.out.println("New Scale: " + scale);
}
 void setScene(Scene scene){
	this.scene =scene;
	if (this.scene != null) {
        scene.widthProperty().addListener((obs, oldVal, newVal) -> updateScale(scene.getWidth(), scene.getHeight()));
        scene.heightProperty().addListener((obs, oldVal, newVal) -> updateScale(scene.getWidth(), scene.getHeight()));
    }
 }
}
