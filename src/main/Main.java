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
import javafx.scene.text.Text;
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
 * Name: Hayes Roach
 * Project: Matching Game
 */


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        // HBox is created for horizontal menu
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(20, 0, 20, 0));
        topMenu.setSpacing(20);
        topMenu.setAlignment(Pos.CENTER);
        topMenu.setStyle("-fx-background-color: #FFB84D");

        // Add 3 buttons to the HBox
        Button homeButton = new Button("Home");
        Button authorButton = new Button("Author1");
        Button gameButton = new Button("Play Game");
        topMenu.getChildren().addAll(homeButton, authorButton, gameButton);

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

        // Create a VBox for author view
        VBox authorView = new VBox();

        // Create a transition for switching between different views
        FadeTransition viewTransition = new FadeTransition(Duration.millis(1000), borderPane);
        viewTransition.setFromValue(0.1);
        viewTransition.setToValue(1);
        viewTransition.setCycleCount(1);
        viewTransition.setAutoReverse(true);

        // Create a VBox to be used in right pane of borderPane
        VBox rightGamePane = new VBox();
        rightGamePane.setPadding(new Insets(0,5,0,5));
        rightGamePane.setSpacing(100);
        rightGamePane.setStyle("-fx-background-color: #FFFFFF");

        // Create score, play again button, and how to play label
        Label score = new Label("Score: ");
        Button playAgainButton = new Button("Play Again");
        Label howToPlayLabel = new Label("How to Play:\n\nThere is a board full of" +
                                                          "\noverturned cards. There is" +
                                                          "\na pair for each card. The" +
                                                          "\nPlayer flips over two cards." +
                                                          "\nIf they match, then they stay" +
                                                          "\noverturned and the player " +
                                                          "\ngets 1 point, otherwise they " +
                                                          "\nflip back. The game is over" +
                                                          "\nafter all the cards are turned.");

        rightGamePane.setMaxWidth(210);

        // Add score, play again button, and how to play label to rightGamePane
        rightGamePane.getChildren().addAll(score, playAgainButton, howToPlayLabel);

        score.setPadding(new Insets(30,0,0,0));
        score.setFont(Font.font("Trebuchet MS", 35));



        // When home button is clicked, the center pane is switched to the home/welcome view
        homeButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(welcomeView);
            borderPane.setRight(null);

        });


        // When author button is clicked, the center pane is switched to the author view
        authorButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(authorView);
            borderPane.setRight(null);
        });

        // When play game button is clicked, the center pane is switched to the game view
        gameButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(createContent());
            borderPane.setRight(rightGamePane);

        });

        // When play again button is clicked, the center pane is reset
        playAgainButton.setOnAction(event -> {
            viewTransition.play();
            borderPane.setCenter(createContent());
            borderPane.setRight(rightGamePane);
        });


        // Create welcome message using labels
        Label welcome = new Label("Welcome to our " + "\nproject CS 1302/09!");
        welcome.setAlignment(Pos.CENTER);
        welcome.setFont(Font.font("Trebuchet MS", 35));

        // Create alternating fade transition animation for welcome message
        FadeTransition ft = new FadeTransition(Duration.millis(3000), welcome);
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



        // ************************ Author View Info ************************

        authorView.setAlignment(Pos.TOP_CENTER);
        authorView.setStyle("-fx-background-color: #FFFFFF");

        // Add picture, education status, hobbies using labels
        Label aboutMe = new Label("About Me");

        ImageView hayes = new ImageView(new Image("https://scontent-atl3-1.xx.fbcdn.net/v/t1.0-9/18424040_10211518954742717_3045106215941621213_n.jpg?_nc_cat=0&oh=1076241d7d1dfd3fda720f065f048d75&oe=5B47A5F0"));
        hayes.setPreserveRatio(true);
        hayes.setFitWidth(200);


        aboutMe.setPadding(new Insets(20, 0, 20, 0));
        aboutMe.setFont(Font.font("Trebuchet MS", 35));
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
        authorView.getChildren().addAll(aboutMe, hayes, educationStatus, major, hobbies, mediaView, videoPlay);


        Scene scene = new Scene(borderPane, 640, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static final int NUM_OF_PAIRS = 8;
    private static final int NUM_PER_ROW = 4;

    private Tile selected = null;
    private int clickCount = 2;

    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(400, 400);
        root.setPadding(new Insets(20,20,20,20));

        char c = 'A';
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < NUM_OF_PAIRS; i++) {
            tiles.add(new Tile(String.valueOf(c)));
            tiles.add(new Tile(String.valueOf(c)));
            c++;
        }

        Collections.shuffle(tiles);

        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            tile.setTranslateX(100 * (i % NUM_PER_ROW));
            tile.setTranslateY(100 * (i / NUM_PER_ROW));
            root.getChildren().add(tile);
        }

        return root;


    }

    private class Tile extends StackPane {
        private Text text = new Text();

        public Tile(String value) {
            Rectangle border = new Rectangle(100, 100);
            border.setFill(null);
            border.setStroke(Color.DARKBLUE);

            text.setText(value);
            text.setFont(Font.font(30));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(this::handleMouseClick);
            close();
        }



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



        public boolean isOpen() {
            return text.getOpacity() == 1;
        }


        public void open(Runnable action) {

            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        public void close() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0);
            ft.play();
        }

        public boolean hasSameValue(Tile other) {
            return text.getText().equals(other.text.getText());
        }



    }


}
