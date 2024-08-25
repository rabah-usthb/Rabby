package application.FrontEnd;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BuildingPauseMenu {
Image BackgroundMenuImage;
Image ResumeButtonImage ;
Image SaveButtonImage ;
Image OptionButtonImage ;
Image LoadButtonImage ;
Image QuitButtonImage ;
ImageView ResumeImageView ;
ImageView SaveImageView ;
ImageView OptionImageView ;
ImageView LoadImageView ;
ImageView QuitImageView ;

Button ResumeButton;
Button SaveButton;
Button OptionButton;
Button LoadButton;
Button QuitButton;
Pane gamePane;
ImageView BackgroundImageView ;
int EscapeHit = 0;

BuildingPauseMenu(Pane gamePane){
	this.gamePane = gamePane;
}

void RemoveMenu() {
	gamePane.getChildren().remove(BackgroundImageView);
	gamePane.getChildren().remove(ResumeButton);
	gamePane.getChildren().remove(LoadButton);
	gamePane.getChildren().remove(SaveButton);
	gamePane.getChildren().remove(OptionButton);
	gamePane.getChildren().remove(QuitButton);

 }

void RemoveDefaultCss(Button button) {
	button.setStyle(
		    "-fx-background-color: transparent; " +
		    "-fx-border-color: transparent; " +
		    "-fx-focus-color: transparent; " +
		    "-fx-faint-focus-color: transparent;"
		);
}
void SetButtonMenu() {
	initialiseButton();
	double x = (BackgroundImageView.getX()+115);
	
	double yR = BackgroundImageView.getY() +25;
	double yL = yR+100;
	double yS = yL+100;
	double yO = yS+100;
	double yQ = yO+100; 
	ResumeButton.setLayoutX(x);
	ResumeButton.setLayoutY(yR);
	
	LoadButton.setLayoutX(x);
	LoadButton.setLayoutY(yL);
	
	SaveButton.setLayoutX(x);
	SaveButton.setLayoutY(yS);
	
	OptionButton.setLayoutX(x);
	OptionButton.setLayoutY(yO);
	
    QuitButton.setLayoutX(x);
	QuitButton.setLayoutY(yQ);
	
	gamePane.getChildren().add(ResumeButton);
	gamePane.getChildren().add(LoadButton);
	gamePane.getChildren().add(SaveButton);
	gamePane.getChildren().add(OptionButton);
	gamePane.getChildren().add(QuitButton);
}

void SetMenu() {
	SetBackgroundMenu();
	SetButtonMenu();
}

void SetBackgroundMenu() {
	BackgroundMenuImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/PauseMenuBackGround.png"));
     BackgroundImageView = new ImageView(BackgroundMenuImage);
    BackgroundImageView.setFitWidth(60*7);
    BackgroundImageView.setFitHeight(128*4);
     BackgroundImageView.setX((gamePane.getWidth() - BackgroundImageView.getFitWidth())/2);
    BackgroundImageView.setY((gamePane.getHeight()-BackgroundImageView.getFitHeight())/2);
    gamePane.getChildren().add(BackgroundImageView);
}

void setButtonDimension(ImageView button) {
	int width = 160;
    int height = 64;
    button.setFitWidth(width);
	button.setFitHeight(height);
	 
}

void initialiseButton() {
     ResumeButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/ResumeButton.png"));;
	 SaveButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/SaveButton.png"));;
	 OptionButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/OptionButton.png"));;
	 LoadButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/LoadButton.png"));;
	 QuitButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/QuitButton.png"));;
	 ResumeImageView = new ImageView();
	 ResumeImageView.setImage(ResumeButtonImage);
	 setButtonDimension(ResumeImageView);
	 
	 ResumeButton = new Button();
	 ResumeButton.setGraphic(ResumeImageView);
	 RemoveDefaultCss(ResumeButton);
	 
	 SaveImageView = new ImageView();
	 SaveImageView.setImage(SaveButtonImage);
	 setButtonDimension(SaveImageView);
	 
	 SaveButton = new Button();
	 SaveButton.setGraphic(SaveImageView);
	 RemoveDefaultCss(SaveButton);
	 
	 OptionImageView = new ImageView();
	 OptionImageView.setImage(OptionButtonImage);
	 setButtonDimension(OptionImageView);
	 
	 OptionButton = new Button();
	 OptionButton.setGraphic(OptionImageView);
	 RemoveDefaultCss(OptionButton);
	 
	 LoadImageView = new ImageView();
	 LoadImageView.setImage(LoadButtonImage);
	 setButtonDimension(LoadImageView);
	 
	 LoadButton = new Button();
	 LoadButton.setGraphic(LoadImageView);
	 RemoveDefaultCss(LoadButton);
	 
	 QuitImageView = new ImageView();
	 QuitImageView.setImage(QuitButtonImage);
	 setButtonDimension(QuitImageView);
	 
	 QuitButton = new Button();
	 QuitButton.setGraphic(QuitImageView);
	 RemoveDefaultCss(QuitButton);	 
}
}
