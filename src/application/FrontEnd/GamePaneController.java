package application.FrontEnd;

import java.net.URL;
import java.util.ResourceBundle;

import application.BackEnd.GameThread;
import application.BackEnd.PaneData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GamePaneController implements Initializable{
private Scene scene;


@FXML
private Pane GamePane;
@FXML
private ImageView McImageView;



@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	Image image = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/MCIM.png"));
	McImageView.setImage(image);
	McImageView.setX(100);
	McImageView.setY(100);
	McImageView.setCache(true);
	McImageView.setPreserveRatio(true);
	McImageView.setSmooth(false);
	 McImageView.setFitWidth(48); // Adjust to the scaled size
	 McImageView.setFitHeight(48); // Adjust to the scaled size
	McImageView.setFocusTraversable(false);
	
	
	GamePane.setMinHeight(PaneData.GetMinHeight());
	GamePane.setMinWidth(PaneData.GetMinWidth());
	
	startGameThread();
}

void MCMovement(KeyEvent event){
	System.out.println("heyyiii");
	if(event.getCode() == KeyCode.RIGHT){
		McImageView.setX(McImageView.getX()+PaneData.GetPix());
	}
	else if (event.getCode() == KeyCode.LEFT) {
		McImageView.setX(McImageView.getX()-PaneData.GetPix());		
	}
	else if(event.getCode() == KeyCode.UP) {
		McImageView.setY(McImageView.getY()-PaneData.GetPix());
	}
	else if(event.getCode() == KeyCode.DOWN) {
		McImageView.setY(McImageView.getY()+PaneData.GetPix());
	}
}

  void startGameThread() {
	GameThread gameThread = new GameThread();
	gameThread.start();
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
        scene.setOnKeyPressed(this::MCMovement);
    }
 }
}
