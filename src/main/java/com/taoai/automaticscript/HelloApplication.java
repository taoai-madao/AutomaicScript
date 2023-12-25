package com.taoai.automaticscript;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("index-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 660, 440);
        stage.setTitle("TaoAi-AutomaticScript");
        stage.setScene(scene);
        // 关闭缩放
        stage.setResizable(false);
        // 窗口置顶
        stage.setAlwaysOnTop(true);
        // 设置图标
        Image icon = new Image(getClass().getResourceAsStream("/image/icon.png"));
        stage.getIcons().add(icon);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}