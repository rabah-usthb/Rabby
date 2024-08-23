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
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GamePaneController implements Initializable{
private Scene scene;
private Rectangle collisionArea = new Rectangle(0, 0, 27, 18);
private Rectangle colliedArea = new Rectangle(0, 0, 48, 48);
private String MCState = "IDLE";
private boolean collisionTop = false;
private boolean collisionDown = false;
private boolean collisionLeft = false;
private boolean collisionRight = false;
private static Duration frameDuration = Duration.millis(150);
private ArrayList<Image> Frame = new ArrayList<>();
private static Timeline timeline = new Timeline();
private ImageView McImageView = new ImageView(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/MC/ANIMATION/MOVEMENT/IDLE/IDLE_DOWN.png")));
static TileMap tileMap; 
@FXML
private Pane GamePane;

void UpdatingCollision() {
	int rowCollisionArea =(int) (collisionArea.getY()/48);
	int columnCollisionArea =(int) (collisionArea.getX()/48);
    switch(MCState) {
	case "TOP":
		columnCollisionArea =(int) ((collisionArea.getX()+collisionArea.getWidth())/48);
		System.out.println("row "+rowCollisionArea);
		System.out.println("column "+columnCollisionArea);
		collisionTop = false;
		for(CollisionCoordinate coordinate : tileMap.arrayCollision) {
			if(coordinate.column == columnCollisionArea) {
				Rectangle recSolid = new Rectangle(coordinate.column*48,coordinate.row*48 , 48, 48);
				   if (collisionArea.getBoundsInParent().intersects(recSolid.getBoundsInParent())) {
			            Bounds r1Bounds = collisionArea.getBoundsInParent();
			            Bounds r2Bounds = recSolid.getBoundsInParent();
			            double r1Top = r1Bounds.getMinY();
			            double r2Bottom = r2Bounds.getMaxY();
			            if(Math.abs(r1Top-r2Bottom)<=10) {
			            	collisionTop = true;
			            	break;
			            }
			}
				   
		}
		}
		break;
	case "LEFT":
		collisionLeft = false;
		for(CollisionCoordinate coordinate : tileMap.arrayCollision) {
			if(coordinate.row == rowCollisionArea) {
				Rectangle recSolid = new Rectangle(coordinate.column*48,coordinate.row*48 , 48, 48);
				   if (collisionArea.getBoundsInParent().intersects(recSolid.getBoundsInParent())) {
			        System.out.println("Intersect left");
					    Bounds r1Bounds = collisionArea.getBoundsInParent();
			            Bounds r2Bounds = recSolid.getBoundsInParent();
			            double r1Left = r1Bounds.getMinX();
			            double r2Right = r2Bounds.getMaxX();
			            System.out.println("LEFT COLLISION "+r1Left);
			            System.out.println("RIGHT TILE "+r2Right);
			            if(Math.abs(r1Left-r2Right)<=10) {
			            	
			            	collisionLeft = true;
			            	break;
			            	   }
			}
				   
				  
		}
		}
		break;
	case "RIGHT":
		for(CollisionCoordinate coordinate : tileMap.arrayCollision) {
			if(coordinate.row == rowCollisionArea) {
				System.out.println("enter if");
				Rectangle recSolid = new Rectangle(coordinate.column*48,coordinate.row*48 , 48, 48);
				   if (collisionArea.getBoundsInParent().intersects(recSolid.getBoundsInParent())) {
			         System.out.println("Intersection");
					   Bounds r1Bounds = collisionArea.getBoundsInParent();
			            Bounds r2Bounds = recSolid.getBoundsInParent();
			            double r1Right = r1Bounds.getMaxX();
			            double r2Left = r2Bounds.getMinX();
			            System.out.println("Collision Right "+r1Right);
			            System.out.println("Tile Left "+r2Left);
			            if(Math.abs(r1Right-r2Left) <= 10) {
			            	collisionRight = true;
			            	
			            }
			            
			}
				   else {
		            	collisionRight = false;
		            }
		}
		}
		break;
	case "DOWN":
		System.out.println("row "+rowCollisionArea);
		System.out.println("column "+columnCollisionArea);
		
		for(CollisionCoordinate coordinate : tileMap.arrayCollision) {
			if(coordinate.column == columnCollisionArea) {
				Rectangle recSolid = new Rectangle(coordinate.column*48,coordinate.row*48 , 48, 48);
				   if (collisionArea.getBoundsInParent().intersects(recSolid.getBoundsInParent())) {
			            Bounds r1Bounds = collisionArea.getBoundsInParent();
			            Bounds r2Bounds = recSolid.getBoundsInParent();
			            double r1Bottom = r1Bounds.getMaxY();
			            double r2Top = r2Bounds.getMinY();
			            if(Math.abs(r1Bottom - r2Top) <= 10) {
			            	collisionDown = true;
			            	
			            }
			            
			}
				   else {
		            	collisionDown = false;
		            }
		}
		}
		break;
		
	}
}

/*void UpdatingCollision() {
    colliedArea.setVisible(true);
	 int row  = 0;
     int column = 0;
     switch(MCState) {
     case "TOP":
    	 row  =   (int)  (collisionArea.getY()-colliedArea.getHeight())/48;
    	 column = (int)  (collisionArea.getX()-10)/48;
    	 System.out.println("TOP row \t" +row);
    	 System.out.println("TOP column \t"+column);
    	 colliedArea.setX(collisionArea.getX()-10);
		 colliedArea.setY(collisionArea.getY()-colliedArea.getHeight());
         collisionTop = tileMap.GridMap[row][column] ==1;
    	 break;
     case "LEFT":
    	 row = (int) (collisionArea.getY() - 20) / 48;
    	 column = (int) (collisionArea.getX() - colliedArea.getWidth()) / 48;
    	 System.out.println("CHAR ROW \t" +(McImageView.getY()/48));
    	 System.out.println("CHAR COLUMN \t"+(McImageView.getX()/48));
    	
    	 System.out.println("LEFT row \t" +row);
    	 System.out.println("LEFT column \t"+column);
    	
 		colliedArea.setX(collisionArea.getX()-colliedArea.getWidth());
 		colliedArea.setY(collisionArea.getY()-20);	
 		collisionLeft = tileMap.GridMap[row][column] ==1;
 	    
    	 break;
     case "DOWN":
    	 row  =   (int)  (collisionArea.getY()+collisionArea.getHeight())/48;
    	  
    	 column = (int)  (collisionArea.getX()-10)/48;
   	
    	 colliedArea.setX(collisionArea.getX()-10);
		 colliedArea.setY(collisionArea.getY()+collisionArea.getHeight());
		 collisionDown = tileMap.GridMap[row][column] ==1;
    	 break;
     case "RIGHT":
    	 row  =   (int)  (collisionArea.getY()-20)/48;
		 column = (int)  (collisionArea.getX()+collisionArea.getWidth())/48;
		
    	 colliedArea.setX(collisionArea.getX()+collisionArea.getWidth());
		 colliedArea.setY(collisionArea.getY()-20);
		 collisionRight = tileMap.GridMap[row][column] ==1;
    	 break;
     }
	
	
	
	
	colliedArea.setVisible(true);
	
	
}
*/
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
    colliedArea.setVisible(false);
	tileMap = new TileMap(GamePane);
    tileMap.fillMap();
    collisionArea.setFill(Color.rgb(255, 0, 0, 0.5)); // Semi-transparent red
    colliedArea.setFill(Color.rgb(0, 255, 0, 0.45));
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
	updateCollisionAreaXY();

	GamePane.getChildren().add(collisionArea);
    GamePane.getChildren().add(colliedArea);	
	GamePane.setMinHeight(PaneData.GetMinHeight());
	GamePane.setMinWidth(PaneData.GetMinWidth());
	
	startGameThread();
	
}
void updateCollisionAreaXY() {
	collisionArea.setX(McImageView.getX()+12-3);
	collisionArea.setY(McImageView.getY()+24-3);
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
	UpdatingCollision();
	if(event.getCode() == KeyCode.RIGHT ){
		
		NewState = "RIGHT";
		
		if(!collisionRight) {
			McImageView.setX(McImageView.getX()+PaneData.GetPix());
		}
		
	}
	else if (event.getCode() == KeyCode.LEFT) {
		NewState = "LEFT";
		//UpdatingCollision();
		
        
		if(!collisionLeft) {

		McImageView.setX(McImageView.getX()-PaneData.GetPix());		
		}

	}
	else if(event.getCode() == KeyCode.UP) {
				NewState = "TOP";
		//UpdatingCollision();
		if(!collisionTop) {

			McImageView.setY(McImageView.getY()-PaneData.GetPix());
			}

	}
	else if(event.getCode() == KeyCode.DOWN) {

		NewState = "DOWN";

		//UpdatingCollision();
	
		if(!collisionDown) {

		McImageView.setY(McImageView.getY()+PaneData.GetPix());
		}
	}
    updateCollisionAreaXY();
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
