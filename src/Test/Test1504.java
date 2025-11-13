package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Test1504 extends Application{

    public void start(Stage primaryStage) throws Exception {
        GridPane gp=new GridPane();
        HBox hb1=new HBox();
        HBox hb2=new HBox();
        gp.add(hb1, 0, 0);
        gp.add(hb2, 0, 1);
        gp.setHgap(5.5);
        gp.setVgap(5.5);
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        hb2.setSpacing(5);

        Label l1=new Label(" Number1: ");
        Label l2=new Label(" Number2: ");
        Label l3=new Label(" Result: ");

        TextField tf1=new TextField();
        TextField tf2=new TextField();
        TextField tf3=new TextField();
        tf3.setEditable(false);
//		tf3.setPrefWidth(1);
        tf3.setPrefColumnCount(8);
//		Label l3=new Label(" Result: ",tf3);
//		l3.setContentDisplay(ContentDisplay.RIGHT);
        hb1.getChildren().addAll(l1,tf1,l2,tf2,l3,tf3);
//		hb1.getChildren().addAll(l1,tf1,l2,tf2,l3);
        Button b1=new Button("add");
        Button b2=new Button("subtract");
        Button b3=new Button("Multiply");
        Button b4=new Button("Divide");
        hb2.getChildren().addAll(b1,b2,b3,b4);
        hb2.setAlignment(Pos.TOP_CENTER);

        b1.setOnAction(e ->{
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty()){
                double num1=Double.parseDouble(tf1.getText());
                double num2=Double.parseDouble(tf2.getText());
                tf3.setText(String.valueOf(num1+num2));
            }
        });

        b2.setOnAction(e ->{
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty()){
                double num1=Double.parseDouble(tf1.getText());
                double num2=Double.parseDouble(tf2.getText());
                tf3.setText(String.valueOf(num1-num2));
            }});

        b3.setOnAction(e ->{
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty()){
                double num1=Double.parseDouble(tf1.getText());
                double num2=Double.parseDouble(tf2.getText());
                tf3.setText(String.valueOf(num1*num2));
            }});

        b4.setOnAction(e ->{
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty()){
                double num1=Double.parseDouble(tf1.getText());
                double num2=Double.parseDouble(tf2.getText());
                if(num2!=0) tf3.setText(String.valueOf(num1/num2));
            }});

        Scene scene = new Scene(gp,650,100);
        primaryStage.setTitle("ShowImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

}
