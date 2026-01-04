package Test;

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

public class Test1624 extends Application {
    private static final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/sample.mp4";
    private int currentSecond = 0;
    @Override
    public void start (Stage primaryStage) throws Exception {
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

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));

        Label time = new Label("Time");
        Label time1 = new Label("00:00:00/00:05:03");
        Slider slHorizontal = new Slider();
        slHorizontal.setMax(303);
        slHorizontal.valueProperty().addListener(e -> {
            double t = slHorizontal.getValue();
            mediaPlayer.seek(Duration.seconds(t));
            updateTime(time1, (int)t);
            currentSecond = (int)t;
        });

        mediaPlayer.currentTimeProperty().addListener(e -> {
            double time2 = mediaPlayer.getCurrentTime().toSeconds();
            int time3 = (int)time2;

            if(currentSecond < time3) {
                currentSecond = time3;
                slHorizontal.setValue(currentSecond);
                updateTime(time1, time3);
            }
        });

        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(e -> {
            mediaPlayer.seek(Duration.ZERO);
            updateTime(time1, 0);
            currentSecond = 0;
            slHorizontal.setValue(0);
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton, time, slHorizontal,
                time1, new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("MediaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTime(Label time1, int time3) {
        String text;
        if(time3 < 60) {
            if(time3 < 10) {
                text = "00:00:0" + time3;
            } else {
                text = "00:00:" + time3;
            }
        } else {
            if(time3 % 60 < 10) {
                text = "00:0" + (time3/60) + ":0" + time3 % 60;
            } else {
                text = "00:0" + (time3/60) + ":" + time3 % 60;
            }
        }
        time1.setText(text + "/00:05:03");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
