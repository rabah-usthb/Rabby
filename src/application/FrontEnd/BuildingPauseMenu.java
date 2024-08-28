package application.FrontEnd;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BuildingPauseMenu {
Rectangle SeeThrough;
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

void SetRectangle() {
	SeeThrough = new Rectangle();
	SeeThrough.setHeight(gamePane.getHeight());
	SeeThrough.setWidth(gamePane.getWidth());
	Color color = Color.web("#6b6565", 207.0 / 255.0);  // Opacity is set as a value between 0.0 and 1.0
	SeeThrough.setFill(color);
	gamePane.getChildren().add(SeeThrough);
}

BuildingPauseMenu(Pane gamePane){
	this.gamePane = gamePane;
}

void RemoveMenu() {
	gamePane.getChildren().remove(SeeThrough);
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
	
	double yR = BackgroundImageView.getY() +20;
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
	SetRectangle();
	SetBackgroundMenu();
	SetButtonMenu();
	ResumeButton.setFocusTraversable(true);
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

void setHoverImage(Button button){
	switch(button.getId()) {
	case "Resume":
		ResumeImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"HoverButton.png")));
		break;
	case "Load":
		LoadImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"HoverButton.png")));
		break;
	case "Quit":
		QuitImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"HoverButton.png")));
		break;
	case "Save":
		SaveImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"HoverButton.png")));
		break;
	case "Option":
		OptionImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"HoverButton.png")));
		break;
		
	}
}

void SetClickedImage(Button button) {
	switch(button.getId()) {
	case "Resume":
		ResumeImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"ClickedButton.png")));
		break;
	case "Load":
		LoadImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"ClickedButton.png")));
		break;
	case "Quit":
		QuitImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"ClickedButton.png")));
		break;
	case "Save":
		SaveImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"ClickedButton.png")));
		break;
	case "Option":
		OptionImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"ClickedButton.png")));
		break;
		
	}
}

void SetNormalImage(Button button) {
	switch(button.getId()) {
	case "Resume":
		ResumeImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"Button.png")));
		break;
	case "Load":
		LoadImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"Button.png")));
		break;
	case "Quit":
		QuitImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"Button.png")));
		break;
	case "Save":
		SaveImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"Button.png")));
		break;
	case "Option":
		OptionImageView.setImage(new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/"+button.getId()+"/"+button.getId()+"Button.png")));
		break;
		
	}
}

void HitBottomTop(Button button) {
  button.setOnKeyPressed(e-> {
	  if(button.getId().equals("Resume")&&e.getCode() == KeyCode.UP) {
		 QuitButton.requestFocus();
	  }
	  else if(button.getId().equals("Quit")&&e.getCode() == KeyCode.DOWN) {
		  ResumeButton.requestFocus();
	  }
	  
	  else if (e.getCode() == KeyCode.ENTER) {
		  SetClickedImage(button);
	  }
  });
  
  button.setOnKeyReleased(e-> 
  { 
	  if(e.getCode() == KeyCode.ENTER) {
		  setHoverImage(button);
	  }
  } 
  );
  
  
}

void setHoverEffect(Button button) {
	 button.focusedProperty().addListener((obs, oldFocus, newFocus) -> {
         if (newFocus) {
            setHoverImage(button);
         } else {
             SetNormalImage(button);  
         }
     });}

void initialiseButton() {
     ResumeButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/Resume/ResumeButton.png"));;
	 SaveButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/Save/SaveButton.png"));;
	 OptionButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/Option/OptionButton.png"));;
	 LoadButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/Load/LoadButton.png"));;
	 QuitButtonImage = new Image(getClass().getResourceAsStream("/Ressource/PNG Folder/PAUSE_MENU/Quit/QuitButton.png"));;
	 ResumeImageView = new ImageView();
	 ResumeImageView.setImage(ResumeButtonImage);
	 setButtonDimension(ResumeImageView);
	 
	 ResumeButton = new Button();
	 ResumeButton.setGraphic(ResumeImageView);
	 ResumeButton.setId("Resume");
	 RemoveDefaultCss(ResumeButton);
	 HitBottomTop(ResumeButton);
	 setHoverEffect(ResumeButton);
	 
	 SaveImageView = new ImageView();
	 SaveImageView.setImage(SaveButtonImage);
	 setButtonDimension(SaveImageView);
	 
	 SaveButton = new Button();
	 SaveButton.setGraphic(SaveImageView);
	 SaveButton.setId("Save");
	 RemoveDefaultCss(SaveButton);
	 HitBottomTop(SaveButton);
	 setHoverEffect(SaveButton);
	 
	 OptionImageView = new ImageView();
	 OptionImageView.setImage(OptionButtonImage);
	 setButtonDimension(OptionImageView);
	 
	 OptionButton = new Button();
	 OptionButton.setGraphic(OptionImageView);
	 OptionButton.setId("Option");
	 RemoveDefaultCss(OptionButton);
	 HitBottomTop(OptionButton);
	 setHoverEffect(OptionButton);
	 
	 LoadImageView = new ImageView();
	 LoadImageView.setImage(LoadButtonImage);
	 setButtonDimension(LoadImageView);
	 
	 LoadButton = new Button();
	 LoadButton.setGraphic(LoadImageView);
	 LoadButton.setId("Load");
	 RemoveDefaultCss(LoadButton);
	 HitBottomTop(LoadButton);
	 setHoverEffect(LoadButton);
	 
	 QuitImageView = new ImageView();
	 QuitImageView.setImage(QuitButtonImage);
	 setButtonDimension(QuitImageView);
	 
	 QuitButton = new Button();
	 QuitButton.setGraphic(QuitImageView);
	 QuitButton.setId("Quit");
	 RemoveDefaultCss(QuitButton);
	 HitBottomTop(QuitButton);
	 setHoverEffect(QuitButton);
}
}
