package com.taoai.automaticscript;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.robot.Robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.F8){
            if (!isRecording) {
                startRecording();
            } else {
                stopRecording();
            }
        }
    }

    private boolean isRecording = false;
    @FXML
    private TextField durationTextField; // 时长
    @FXML
    private TextField intervalTextField; // 间隔

    private Timer timer;
    private int remainingTime;

    private void startRecording() {
        // 开始逻辑
        isRecording = true;
        String durationText = durationTextField.getText();  // 获取输入时长的值
        String intervalText = intervalTextField.getText();  // 获取输入间隔的值
        int duration = Integer.parseInt(durationText);
        int interval = Integer.parseInt(intervalText);

        remainingTime = duration;

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    welcomeText.setText("开始点击，剩余时长：" + remainingTime + "秒，间隔：" + intervalText);
                    remainingTime--;
                    if (remainingTime < 0) {
                        stopRecording();
                    } else {
                        // 获取鼠标位置
                        // Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
                        // int mouseX = (int) mouseLocation.getX();
                        // int mouseY = (int) mouseLocation.getY();
                        // 模拟鼠标点击事件
                        try {
                            Robot robot = new Robot();
                            robot.mousePress(MouseButton.PRIMARY);
                            robot.mouseRelease(MouseButton.PRIMARY);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);  // 使用指定的间隔更新计时器

        // 在这里使用时长和间隔进行相应的处理
    }

    private void stopRecording() {
        // 结束逻辑
        isRecording = false;
        timer.cancel();
        welcomeText.setText("点击结束");
    }
}