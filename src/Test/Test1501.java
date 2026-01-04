package Test;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test1501 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        HBox hb = new HBox(5);
        StackPane sp = new StackPane();
        bp.setCenter(hb);
        bp.setBottom(sp);

        addCard(hb);

        Button but = new Button("Refresh");
        but.setOnAction(e -> {
            hb.getChildren().clear();
            addCard(hb);
        });
        sp.getChildren().add(but);

        Scene scene = new Scene(bp,300,150);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addCard(HBox hb) {
        ArrayList<Integer> fileNames = new ArrayList<>();
        for(int i = 1; i <= 52; i++) {
            fileNames.add(i);
        }

        for(int i = 0; i < 4; i++) {
            int index = (int)(Math.random()*(52-i));
            int fileName = fileNames.get(index);
            fileNames.remove(index);
            Image image = new Image("file:card/" + fileName + ".png");
            hb.getChildren().add(new ImageView(image));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
