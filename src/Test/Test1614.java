package Test;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test1614 extends Application {
	Text text = new Text(100, 100, "Programming is fun");
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane bp = new BorderPane();
		Pane pane = new Pane();

		pane.getChildren().add(text);
		HBox hb = new HBox();
		hb.setAlignment(Pos.TOP_CENTER);
		hb.setSpacing(5);
		hb.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

		HBox hb1 = new HBox();
		hb1.setAlignment(Pos.TOP_CENTER);
		hb1.setSpacing(5);
		hb1.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

		bp.setTop(hb);
		bp.setCenter(new ScrollPane(pane));
		bp.setBottom(hb1);



		Label l1 = new Label("Font Name ");
		List<String> names = Font.getFamilies();
		ComboBox<String> cbo = new ComboBox<>();
		ObservableList<String> items = FXCollections.observableArrayList(names);
		cbo.getItems().addAll(items);
		cbo.setValue(names.get(3));
		Label l2 = new Label("Font Size ");
		ArrayList<String> sizes = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			sizes.add(Integer.toString(i));
		}
		ComboBox<String> cbo1 = new ComboBox<>();
		ObservableList<String> items1 = FXCollections.observableArrayList(sizes);
		cbo1.getItems().addAll(items1);
		cbo1.setValue(sizes.get(19));
		hb.getChildren().addAll(l1, cbo, l2, cbo1);




//		text.setFont(fontNormal);
		CheckBox chkBold = new CheckBox("Bold");
    CheckBox chkItalic = new CheckBox("Italic");
		hb1.getChildren().addAll(chkBold,chkItalic);
		EventHandler<ActionEvent> handler = e -> {
//			Font fontBoldItalic = Font.font(cbo.getValue(), FontWeight.BOLD,
//					FontPosture.ITALIC, Double.parseDouble(cbo1.getValue()));
//			Font fontBold = Font.font(cbo.getValue(), FontWeight.BOLD,
//					FontPosture.REGULAR, Double.parseDouble(cbo1.getValue()));
//			Font fontItalic = Font.font(cbo.getValue(), FontWeight.NORMAL,
//					FontPosture.ITALIC, Double.parseDouble(cbo1.getValue()));
//			Font fontNormal = Font.font(cbo.getValue(), FontWeight.NORMAL,
//					FontPosture.REGULAR, Double.parseDouble(cbo1.getValue()));


			if (chkBold.isSelected() && chkItalic.isSelected()) {
//				System.out.println(cbo.getValue());
//				fontBoldItalic = Font.font(cbo.getValue()+"Bold", Double.parseDouble(cbo1.getValue()));
//				System.out.println(fontBoldItalic.getName());
				text.setFont(Font.font(cbo.getValue(), FontWeight.BOLD,
						FontPosture.ITALIC, Double.parseDouble(cbo1.getValue()))); // Both check boxes checked
      }
      else if (chkBold.isSelected()) {
//      	System.out.println(cbo.getValue()+"fontBold"+fontBold);
        text.setFont(Font.font(cbo.getValue(), FontWeight.BOLD,
  					FontPosture.REGULAR, Double.parseDouble(cbo1.getValue()))); // The Bold check box checked
      }
      else if (chkItalic.isSelected()) {

//      	System.out.println(fontItalic);
      	text.setFont(Font.font(cbo.getValue(), FontWeight.NORMAL,
  					FontPosture.ITALIC, Double.parseDouble(cbo1.getValue()))); // The Italic check box checked
      }
      else {

//      	System.out.println(cbo.getValue()+"fontNormal"+fontNormal);

        text.setFont(Font.font(cbo.getValue(), FontWeight.NORMAL,
  					FontPosture.REGULAR, Double.parseDouble(cbo1.getValue()))); // Both check boxes unchecked
      }
    };

    chkBold.setOnAction(handler);
    chkItalic.setOnAction(handler);
    cbo1.setOnAction(handler);
    cbo.setOnAction(handler);

    text.setFont(Font.font(cbo.getValue(), FontWeight.NORMAL,
				FontPosture.REGULAR, Double.parseDouble(cbo1.getValue())));
    Scene scene = new Scene(bp, 600, 450);
		primaryStage.setTitle("ShowImage"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
