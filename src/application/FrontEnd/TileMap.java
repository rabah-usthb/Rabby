package application.FrontEnd;

import javafx.scene.image.*;
import javafx.scene.layout.Pane;

public class TileMap {
Pane gamePane;
Image GrassTile;
Image WaterTile;
Image WallTile;

public TileMap(Pane gamePane){
	this.gamePane = gamePane;
	InitializeImages();
}
public void InitializeImages() {
	GrassTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/Grass.png"));
	WaterTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/Water.png"));
	WallTile = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/TILES/WALL.png"));
   
}
int[][] GridMap= {
		{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,2,2,1,1,1,1,1,0,1,1,1,1,1},
		{1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,1,2,2,1,1,1,2,2,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1},
		{1,0,1,1,1,1,1,1,2,1,1,1,0,1,1,1},
		{1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,1,1,1,2,2,1,1,2,1,1,1,1,1,1,1}
		
};

public void fillMap() {
	
	for(int i = 0 ; i<12;i++) {
		for(int j = 0 ; j<16;j++) {
			ImageView TileView = new ImageView();
			TileView.setFitHeight(48);
			TileView.setFitWidth(48);
			switch(GridMap[i][j]) {
			case 0:
				TileView.setImage(WallTile);
				break;
			case 1:
				TileView.setImage(GrassTile);
				break;
			case 2:
				TileView.setImage(WaterTile);
				break;
			}
			TileView.setLayoutX(j*48);
			TileView.setLayoutY(i*48);
			this.gamePane.getChildren().add(TileView);
		}
	}
}
}
