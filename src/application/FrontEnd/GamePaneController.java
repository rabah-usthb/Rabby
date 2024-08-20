package application.FrontEnd;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.BackEnd.GameThread;
import application.BackEnd.PaneData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GamePaneController implements Initializable{
private Scene scene;
private String MCState = "IDLE";
private static Duration frameDuration = Duration.millis(150);
private ArrayList<Image> Frame = new ArrayList<>();
private static Timeline timeline = new Timeline();
private ImageView McImageView = new ImageView(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/MC/ANIMATION/MOVEMENT/IDLE/IDLE_DOWN.png")));
@FXML
private Pane GamePane;


void FillArray() {
	for(int i = 0 ; i<3 ; i++ ) {
		Frame.add(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/MC/ANIMATION/MOVEMENT/"+MCState+"/"+MCState+(i+1)+".png")));
	}
}

void FillFrame() {
	Frame.clear();
    if(!MCState.equals("IDLE")) {
    	FillArray();
    }
}

Timeline AddKeyFrame() {
	Timeline timeline = new Timeline();

	// Add key frames to the timeline
	for (int i = 1; i < 3; i++) {
	    int frameIndex = i;
	    KeyFrame keyFrame = new KeyFrame(frameDuration.multiply(i), e -> {
	        McImageView.setImage(Frame.get(frameIndex));
	    });
	    timeline.getKeyFrames().add(keyFrame);
	}

	// Set the timeline to loop
	timeline.setCycleCount(Timeline.INDEFINITE);
	return timeline;
}


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    TileMap tileMap = new TileMap(GamePane);
    tileMap.fillMap();
	Image image = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/MC/ANIMATION/MOVEMENT/IDLE/IDLE_DOWN.png"));
	McImageView.setImage(image);
	McImageView.setX(100);
	McImageView.setY(100);
	McImageView.setCache(true);
	McImageView.setPreserveRatio(true);
	McImageView.setSmooth(false);
	McImageView.setFitWidth(48); // Adjust to the scaled size
	McImageView.setFitHeight(48); // Adjust to the scaled size
	McImageView.setFocusTraversable(false);
	GamePane.getChildren().add(McImageView);
	
	GamePane.setMinHeight(PaneData.GetMinHeight());
	GamePane.setMinWidth(PaneData.GetMinWidth());
	
	startGameThread();
}

void AnimationToIDLE() {
	McImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/MC/ANIMATION/MOVEMENT/IDLE/IDLE_"+MCState+".png")));
    MCState="IDLE";
}
void StopAnimation(KeyEvent event) {
	System.out.println("StopAnimation");
	timeline.stop();
	AnimationToIDLE();
}


void MCMovement(KeyEvent event){
	String NewState = "";
	if(event.getCode() == KeyCode.RIGHT){
		McImageView.setX(McImageView.getX()+PaneData.GetPix());
		NewState = "RIGHT";
	}
	else if (event.getCode() == KeyCode.LEFT) {
		McImageView.setX(McImageView.getX()-PaneData.GetPix());		
		NewState = "LEFT";
		
	}
	else if(event.getCode() == KeyCode.UP) {
		McImageView.setY(McImageView.getY()-PaneData.GetPix());
		NewState = "TOP";
	}
	else if(event.getCode() == KeyCode.DOWN) {
		McImageView.setY(McImageView.getY()+PaneData.GetPix());
		NewState = "DOWN";
	}
	if(!NewState.equals(MCState)) {
	System.out.println(MCState);
	MCState = NewState;
	FillFrame();
	System.out.println(Frame);
	timeline.stop();
	timeline = AddKeyFrame();
	timeline.play();
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
       scene.setOnKeyReleased(this::StopAnimation);
    }
 }
}
