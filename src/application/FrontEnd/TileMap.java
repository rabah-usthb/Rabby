package application.FrontEnd;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TileMap {
Pane gamePane;
Image GrassTile;
Image WaterTile;
Image WallTile;
Image FloorMiddleWoodTile;
Image FloorLeftWoodTile;
Image FloorRightWoodTile;
Image WallWoodTile;
ArrayList<CollisionCoordinate> arrayCollision = new ArrayList<>(); 

public void loadMap() {
	  Gson gson = new Gson();
      try (FileReader reader = new FileReader("C:\\Users\\DELL\\eclipse-workspace\\Rabby\\src\\Ressource\\PNG Folder\\MAP\\MAP1.json")) { // Update with your JSON file path
          Type gridMapType = new TypeToken<int[][]>() {}.getType();
          GridMap = gson.fromJson(reader, gridMapType); // Directly deserialize to int[][]
      } catch (IOException e) {
          e.printStackTrace(); // Handle the exception (log, show an error message, etc.)
      }
  }

public TileMap(Pane gamePane){
	loadMap();
	this.gamePane = gamePane;
	InitializeImages();
}
public void InitializeImages() {
	GrassTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/Grass.png"));
	WaterTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/Water.png"));
	WallTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/WALL.png"));
	FloorMiddleWoodTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/WOOD/FloormiddleWood.png"));
	FloorRightWoodTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/WOOD/FloorRightWood.png"));
	FloorLeftWoodTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/WOOD/FloorleftWood.png"));
	WallWoodTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/WOOD/WallWood.png"));
       

}
int[][] GridMap = new int [12][16]; 
		
		


public void fillMap() {
	int cmp = 0;
	for(int i = 0 ; i<12;i++) {
		for(int j = 0 ; j<16;j++) {
			ImageView TileView = new ImageView();
			TileView.setFitHeight(48);
			TileView.setFitWidth(48);
			switch(GridMap[i][j]) {
			
			case 1:
				TileView.setImage(WallWoodTile);
				arrayCollision.add(new CollisionCoordinate(i, j));
				break;
			case 2:
				TileView.setImage(FloorMiddleWoodTile);
				break;
			case 3:
				TileView.setImage(FloorRightWoodTile);
				break;
			case 4:
				TileView.setImage(FloorLeftWoodTile);
				break;
			}
			TileView.setLayoutX(j*48);
			TileView.setLayoutY(i*48);
			Rectangle rec = new Rectangle(j*48,i*48,48,48);
			if(cmp%2==0) {
				rec.setFill(Color.rgb(0, 0, 255, 0.45));
			}else {
				rec.setFill(Color.rgb(60, 0, 40, 0.45));
					
			}
			Text text = new Text(i+" , "+j);
	        text.setFont(new Font(16));
	        text.setFill(Color.BLACK);

	        // Position the text inside the rectangle
	        text.setX(rec.getX() + (rec.getWidth() - text.getBoundsInLocal().getWidth()) / 2);
	        text.setY(rec.getY() + (rec.getHeight() + text.getBoundsInLocal().getHeight()) / 2);

	        // Combine Rectangle and Text in a Group
	        Group group = new Group(rec, text);

			this.gamePane.getChildren().add(TileView);
			this.gamePane.getChildren().add(group);
		cmp++;
		}
		cmp++;
	}
}
}
