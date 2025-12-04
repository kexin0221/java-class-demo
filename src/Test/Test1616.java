package Test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Test1616 extends Application {

    private final String[] flagTitles = { "Canada", "China", "Denmark", "France",
            "Germany", "India", "Norway", "United Kingdom",
            "United States of America" };

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        BorderPane bp = new BorderPane();
        FlowPane fp = new FlowPane();
        Label la = new Label("");
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagTitles));
        lv.setPrefSize(400, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        ScrollPane sp = new ScrollPane(lv);
        bp.setTop(fp);
        bp.setCenter(sp);
        bp.setBottom(la);


        Label la1=new Label("Choose Selection Model: ");
        ComboBox<String> cbo = new ComboBox<>(FXCollections.observableArrayList("SINGLE","MULTIPLE"));
        cbo.setOnAction(e->{
            if(cbo.getValue().equals("SINGLE")) {
                lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {
                lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
        });
        fp.getChildren().addAll(la1,cbo);

        lv.getSelectionModel().selectedItemProperty().addListener(e->{
            StringBuilder sb = new StringBuilder();
            for(String select:lv.getSelectionModel().getSelectedItems()) {
                sb.append(select);
                sb.append(", ");
            }
            la.setText(sb.toString());
        });

        Scene scene = new Scene(bp, 450, 170);
        primaryStage.setTitle("ListViewDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

}
