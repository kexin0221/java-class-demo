package myCode;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class demo16_24 extends Application {
    private static final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/sample.mp4";
    @Override
    public void start(Stage primaryStage) throws Exception {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();
                playButton.setText("||");
            } else {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });

        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

        Slider slTime = new Slider();
        slTime.setPrefWidth(150);

        Label lblTime = new Label("00:00 / 00:00");

        mediaPlayer.currentTimeProperty().addListener(observable -> {
            Duration current = mediaPlayer.getCurrentTime();
            Duration total = mediaPlayer.getTotalDuration();
            if (total.greaterThan(Duration.ZERO)) {
                slTime.setValue(current.toMillis() / total.toMillis() * 100);
                lblTime.setText(formatTime(current) + " / " + formatTime(total));
            }
        });

        slTime.valueProperty().addListener(observable -> {
            if (slTime.isValueChanging()) {
                Duration total = mediaPlayer.getTotalDuration();
                if (total.greaterThan(Duration.ZERO)) {
                    mediaPlayer.seek(total.multiply(slTime.getValue() / 100));
                }
            }
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton, new Label("Time"), slTime, lblTime,
               new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("Exercise16_24");
        primaryStage.setScene(scene);
        primaryStage.show();

        slTime.requestFocus();
    }

    private String formatTime(Duration duration) {
        int minutes = (int) duration.toMinutes();
        int seconds = (int) duration.toSeconds() % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
