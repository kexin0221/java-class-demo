package Test;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.List;

public class test extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建要移动的节点
        Rectangle rect = new Rectangle(50, 50);

// 创建路径（圆形路径）
        Circle path = new Circle(150, 150, 100);
        path.setFill(null);
        path.setStroke(Color.GRAY);

// 创建路径动画
        PathTransition pathTransition = new PathTransition();// 设置移动的节点
        pathTransition.setPath(path);      // 设置移动路径
        pathTransition.setDuration(Duration.seconds(5));  // 设置持续时间
        pathTransition.setCycleCount(PathTransition.INDEFINITE);  // 无限循环
        pathTransition.setAutoReverse(true);  // 自动倒转

// 开始动画
        pathTransition.play();

        Pane pane = new Pane();
        pane.getChildren().addAll(path);
        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
