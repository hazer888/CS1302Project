package main;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Course: CS 1302
 * Section: 09
 * Professor: Carlos Cepeda Mora
 * Name: Hayes Roach & Eyosias Belay
 * Project: Matching Game
 */


public class Main extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage primaryStage) {


        // HBox is created for horizontal menu
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(20, 0, 20, 0));
        topMenu.setSpacing(20);
        topMenu.setAlignment(Pos.CENTER);
        topMenu.setStyle("-fx-background-color: #FFB84D");

        // Add 4 buttons to the HBox
        Button homeButton = new Button("Home");
        Button hayesButton = new Button("Hayes");
        Button belayButton = new Button("Eyosias");
        Button gameButton = new Button("Play Game");
        topMenu.getChildren().addAll(homeButton, hayesButton, belayButton, gameButton);

        // Border Pane is created and topMenu is set to top view
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);

        // Set title for stage
        primaryStage.setTitle("PROJECT");


        // VBox is created for welcome message view
        VBox welcomeView = new VBox();
        welcomeView.setAlignment(Pos.CENTER);
        welcomeView.setStyle("-fx-background-color: #FFFFFF");

        // Set borderPane's center window to welcome view
        borderPane.setCenter(welcomeView);

        // Create a VBox for hayes view
        VBox hayesView = new VBox();

        // Create a VBox for belay view
        VBox belayView = new VBox();

        // Create a transition for switching between different views
        FadeTransition viewTransition = new FadeTransition(Duration.millis(1000), borderPane);
        viewTransition.setFromValue(0.1);
        viewTransition.setToValue(1);
        viewTransition.setCycleCount(1);
        viewTransition.setAutoReverse(true);

        // Create a VBox to be used in right pane of borderPane
        VBox rightGamePane = new VBox();
        rightGamePane.setPadding(new Insets(50,5,0,5));
        rightGamePane.setSpacing(100);
        rightGamePane.setStyle("-fx-background-color: #FFFFFF");

        // Create play again button, and how to play label

        Button playAgainButton = new Button("Play Again");
        Label howToPlayLabel = new Label("How to Play:\n\nThere is a board full of" +
                                                          "\noverturned cards. There is" +
                                                          "\na pair for each card. The" +
                                                          "\nPlayer flips over two cards." +
                                                          "\nIf they match, then they stay" +
                                                          "\noverturned, otherwise they" +
                                                          "\nflip back. The game is over" +
                                                          "\nafter all the cards are turned.");

        rightGamePane.setMaxWidth(210);

        // Add score, play again button, and how to play label to rightGamePane
        rightGamePane.getChildren().addAll(playAgainButton, howToPlayLabel);

        // When home button is clicked, the center pane is switched to the home/welcome view
        homeButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(welcomeView);
            borderPane.setRight(null);

        });


        // When author button is clicked, the center pane is switched to the author view
        hayesButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(hayesView);
            borderPane.setRight(null);
        });

        belayButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(belayView);
            borderPane.setRight(null);
        });

        // When play game button is clicked, the center pane is switched to the game view
        gameButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(createGameContent());
            borderPane.setRight(rightGamePane);

        });

        // When play again button is clicked, the center pane is reset
        playAgainButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(createGameContent());
            borderPane.setRight(rightGamePane);
        });


        // Create welcome message using labels
        Label welcome = new Label("Welcome to our " + "\nproject CS 1302/09!");
        welcome.setAlignment(Pos.CENTER);
        welcome.setFont(Font.font("Trebuchet MS", 35));

        // Create alternating fade transition animation for welcome message
        FadeTransition ft = new FadeTransition(Duration.millis(2000), welcome);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        // Add image from URL using ImageView and Image
        ImageView owl = new ImageView(new Image("https://i.pinimg.com/originals/23/f3/e2/23f3e291cd7407176fd75d8c730cb277.png"));

        // Add welcome label and owl image to the welcome view
        welcomeView.getChildren().addAll(welcome, owl);

        welcomeView.setSpacing(10);
        owl.setFitWidth(150);
        owl.setFitWidth(300);


        // Create path transition that moves back and forth in a line for owl image
        PathTransition pt = new PathTransition(Duration.millis(2000), new Line(190, 200, 120, 100), owl);
        pt.setAutoReverse(true);
        pt.setCycleCount(9000);
        pt.play();



        // ************************ Hayes View Info ************************

        hayesView.setAlignment(Pos.TOP_CENTER);
        hayesView.setStyle("-fx-background-color: #FFFFFF");

        // Add picture, education status, hobbies using labels
        Label aboutHayes = new Label("About Hayes");

        ImageView hayes = new ImageView(new Image("https://scontent-atl3-1.xx.fbcdn.net/v/t1.0-9/18424040_10211518954742717_3045106215941621213_n.jpg?_nc_cat=0&oh=1076241d7d1dfd3fda720f065f048d75&oe=5B47A5F0"));
        hayes.setPreserveRatio(true);
        hayes.setFitWidth(200);

        aboutHayes.setPadding(new Insets(20, 0, 20, 0));
        aboutHayes.setFont(Font.font("Trebuchet MS", 35));
        Label educationStatus = new Label("Education Status: Sophomore");
        educationStatus.setFont(Font.font("Trebuchet MS", 20));
        educationStatus.setPadding(new Insets(10,0,0,0));
        Label major = new Label("Major: Software Engineering");
        major.setFont(Font.font("Trebuchet MS", 20));
        Label hobbies = new Label("Hobbies: Working out, and playing PS4");
        hobbies.setFont(Font.font("Trebuchet MS", 20));
        hobbies.setPadding(new Insets(0, 0, 20, 0));

        // Create media player for introduction
        Media media = new Media(new File("src/main/textures/intro.mp4").toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // Create media player play button
        Button playButton = new Button("Play >");

        // When play button is pressed, the video will play
        playButton.setOnAction(event -> {
            mediaPlayer.play();
        });

        // Create media player pause button
        Button pauseButton = new Button("Pause ||");

        // When play button is pressed, the video will pause
        pauseButton.setOnAction(event -> {
            mediaPlayer.pause();
        });

        mediaView.setFitWidth(300);

        // Put media player buttons into HBox
        HBox videoPlay = new HBox();
        videoPlay.getChildren().addAll(playButton, pauseButton);
        videoPlay.setPadding(new Insets(10, 0, 0, 0));
        videoPlay.setAlignment(Pos.CENTER);

        // Add all nodes to author view
        hayesView.getChildren().addAll(aboutHayes, hayes, educationStatus, major, hobbies, mediaView, videoPlay);

        // ************************ Belay View Info ************************

        belayView.setAlignment(Pos.TOP_CENTER);
        belayView.setStyle("-fx-background-color: #FFFFFF");

        // Add picture, education status, hobbies using labels
        Label aboutBelay = new Label("About Eyosias");

        ImageView belay = new ImageView(new Image("https://scontent-atl3-1.xx.fbcdn.net/v/t1.0-9/17861848_1414836878566980_4998784671682070873_n.jpg?oh=3a3be5b02f5d8fb286c894df74ec4db4&oe=5B46589C"));
        belay.setPreserveRatio(true);
        belay.setFitWidth(200);


        aboutBelay.setPadding(new Insets(20, 0, 20, 0));
        aboutBelay.setFont(Font.font("Trebuchet MS", 35));
        Label belayEducationStatus = new Label("Education Status: Sophomore");
        belayEducationStatus.setFont(Font.font("Trebuchet MS", 20));
        belayEducationStatus.setPadding(new Insets(10,0,0,0));
        Label belayMajor = new Label("Major: Software Engineering");
        belayMajor.setFont(Font.font("Trebuchet MS", 20));
        Label belayHobbies = new Label("Hobbies: Watch Netflix, play PS4");
        belayHobbies.setFont(Font.font("Trebuchet MS", 20));
        belayHobbies.setPadding(new Insets(0, 0, 20, 0));

        // Create media player for introduction
        Media belayMedia = new Media(new File("src/main/textures/belay.mp4").toURI().toString());

        MediaPlayer mediaPlayer2 = new MediaPlayer(belayMedia);
        MediaView mediaView2 = new MediaView(mediaPlayer2);

        // Create media player play button
        Button playButton2 = new Button("Play >");


        // When play button is pressed, the video will play
        playButton2.setOnAction(event -> {
            mediaPlayer2.play();
        });

        // Create media player pause button
        Button pauseButton2 = new Button("Pause ||");

        // When play button is pressed, the video will pause
        pauseButton2.setOnAction(event -> {
            mediaPlayer2.pause();
        });

        mediaView2.setFitWidth(300);

        // Put media player buttons into HBox
        HBox videoPlay2 = new HBox();
        videoPlay2.getChildren().addAll(playButton2, pauseButton2);
        videoPlay2.setPadding(new Insets(10, 0, 0, 0));
        videoPlay2.setAlignment(Pos.CENTER);

        // Add all nodes to author view
        belayView.getChildren().addAll(aboutBelay, belay, belayEducationStatus, belayMajor, belayHobbies, mediaView2, videoPlay2);

        ImageView belayImage = new ImageView(new Image("https://scontent-atl3-1.xx.fbcdn.net/v/t1.0-9/17861848_1414836878566980_4998784671682070873_n.jpg?oh=3a3be5b02f5d8fb286c894df74ec4db4&oe=5B46589C"));
        belayImage.setPreserveRatio(true);
        belayImage.setFitWidth(200);


        // Creates new scene
        Scene scene = new Scene(borderPane, 800, 675);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private static final int NUM_PER_ROW = 4;

    // Default selected value set to null
    private Tile selected = null;
    private int clickCount = 2;

    private Parent createGameContent() {
        Pane root = new Pane();

        // Create list of tiles and add images to them
        List<Tile> tiles = new ArrayList<>();

            Image spongebob = new Image("https://orig00.deviantart.net/1d75/f/2009/220/b/0/spongebob_4_150x150_png_by_somemilk.png");
            tiles.add(new Tile((spongebob)));
            tiles.add(new Tile((spongebob)));

            Image homer = new Image("http://www.blindfiveyearold.com/wp-content/uploads/2011/01/homer-simpson-150x150.jpg");
            tiles.add(new Tile((homer)));
            tiles.add(new Tile((homer)));

            Image nyon = new Image("https://dieckster.com/wp-content/uploads/2013/07/nyan-cat-150x150.gif");
            tiles.add(new Tile((nyon)));
            tiles.add(new Tile((nyon)));

            Image knight = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzlbhFz23MJMaQrb7Lda9F_AaCyF-fGJeiIlc-aPcM3u-uMFzK");
            tiles.add(new Tile((knight)));
            tiles.add(new Tile((knight)));

            Image fox = new Image("https://www.prri.org/wp-content/uploads/2016/04/538-150x150.jpg");
            tiles.add(new Tile((fox)));
            tiles.add(new Tile((fox)));

            Image happyFace = new Image("http://ellensdelight.com/images/happy-face-happyface-smiley-150x150.gif");
            tiles.add(new Tile((happyFace)));
            tiles.add(new Tile((happyFace)));

            Image bulldog = new Image("https://upload.wikimedia.org/wikipedia/commons/5/56/Buldog-150x150.jpg");
            tiles.add(new Tile((bulldog)));
            tiles.add(new Tile((bulldog)));

            Image playstation = new Image("http://ksassets.timeincuk.net/wp/uploads/sites/54/2013/10/PlayStation-1-1-150x150.jpg");
            tiles.add(new Tile((playstation)));
            tiles.add(new Tile((playstation)));


        // Shuffle tiles in list
        Collections.shuffle(tiles);


        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            tile.setTranslateX(150 * (i % NUM_PER_ROW));
            tile.setTranslateY(150 * (i / NUM_PER_ROW));
            root.getChildren().add(tile);
        }

        return root;
    }


    private class Tile extends StackPane {
        private ImageView imageView = new ImageView();

        // Creates tile using constructor
        public Tile(Image image) {
            Rectangle border = new Rectangle(150, 150);
            border.setFill(null);
            border.setStroke(Color.DARKBLUE);

            // Set Images to ImageViews
            imageView.setImage(image);

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, imageView);

            // When mouse is clicked the click is handled in the method handleMouseClick
            setOnMouseClicked(this::handleMouseClick);
            close();
        }


        // Handles the mouse click events
        public void handleMouseClick(MouseEvent event) {

            if (isOpen() || clickCount == 0)
                return;

            clickCount--;

            if (selected == null) {
                selected = this;
                open(() -> {});

            }
            else {
                open(() -> {
                    if (!hasSameValue(selected)) {
                        selected.close();
                        this.close();
                    }

                    selected = null;
                    clickCount = 2;
                });
            }
        }


        // Sets the open tiles opacity to 1 (fully visible)

        public boolean isOpen() {
            return imageView.getOpacity() == 1;
        }



        // Creates a open transition

        public void open(Runnable action) {

            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), imageView);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        // Creates a closing transition

        public void close() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), imageView);
            ft.setToValue(0);
            ft.play();
        }

        // Determines if the tiles selected are equal to each other

        public boolean hasSameValue(Tile other) {
            return imageView.getImage().equals(other.imageView.getImage());
        }

    }


}
