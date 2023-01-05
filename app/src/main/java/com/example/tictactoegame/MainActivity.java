
package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, restartButton;
    TextView textView;
    String[][] playingField = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    String cross = "X";
    String circle = "O";
    int index1, index2;
    boolean gameIsOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        restartButton = findViewById(R.id.restartButton);
        textView = findViewById(R.id.textView);
        setRandomButtonsBackgroundColor();
    }

    public void setRandomButtonsBackgroundColor() {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        Button[] allButtons = {button1, button2, button3,
                button4, button5, button6, button7, button8, button9};
        for(Button button : allButtons) {
            button.setBackgroundColor(color);
        }
    }

    public void touchButton1(View v){
        Button touchedButton = button1;
        if (v.getId() == button1.getId()) {
            playingField[0][0] = cross;
            touchedButton = button1;
        }
        else if (v.getId() == button2.getId()) {
            playingField[0][1] = cross;
            touchedButton = button2;
        }
        touchedButton.setEnabled(false);
        winnerCheck();
        updateField();
        computerMove();
    }

    public void touchButton3(View v){
        playingField[0][2] = cross;
        button3.setEnabled(false);
        winnerCheck();
        updateField();
        computerMove();
    }
    public void touchButton4(View v){
        playingField[1][0] = cross;
        button4.setEnabled(false);
        winnerCheck();
        computerMove();
    }
    public void touchButton5(View v){
        playingField[1][1] = cross;
        button5.setEnabled(false);
        winnerCheck();
        computerMove();
    }
    public void touchButton6(View v){
        playingField[1][2] = cross;
        button6.setEnabled(false);
        winnerCheck();
        computerMove();
    }
    public void touchButton7(View v){
        playingField[2][0] = cross;
        button7.setEnabled(false);
        winnerCheck();
        computerMove();
    }
    public void touchButton8(View v){
        playingField[2][1] = cross;
        button8.setEnabled(false);
        winnerCheck();
        computerMove();
    }
    public void touchButton9(View v){
        playingField[2][2] = cross;
        button9.setEnabled(false);
        winnerCheck();
        computerMove();
    }

    public void randomCordinates(){
        index1 = (int) (0 + (Math.random()) * 3);
        index2 = (int) (0 + (Math.random()) * 3);
    }

    public void computerMove(){
        winnerCheck();
        if (gameIsOn && !allButtonsTouched()) {
            randomCordinates();
            while (!playingField[index1][index2].equals("")) {
                randomCordinates();
            }
            playingField[index1][index2] = circle;
            disableComputerButton();
            updateField();
            winnerCheck();
        }
    }

    public void updateField(){
        button1.setText(playingField[0][0]);
        button2.setText(playingField[0][1]);
        button3.setText(playingField[0][2]);
        button4.setText(playingField[1][0]);
        button5.setText(playingField[1][1]);
        button6.setText(playingField[1][2]);
        button7.setText(playingField[2][0]);
        button8.setText(playingField[2][1]);
        button9.setText(playingField[2][2]);
    }

    public void winnerCheck(){
        if (buttonsTextEqualsX(button1, button2, button3)){
            setWinningScenario(button1, button2, button3);
        }
        else if (buttonsTextEqualsX(button4, button5, button6)) {
            setWinningScenario(button4, button5, button6);
        }
        else if (buttonsTextEqualsX(button7, button8, button9)) {
            setWinningScenario(button7, button8, button9);
        }
        else if (buttonsTextEqualsX(button1, button4, button7)) {
            setWinningScenario(button1, button4, button7);
        }
        else if (buttonsTextEqualsX(button2, button5, button8)) {
            setWinningScenario(button2, button5, button8);
        }
        else if (buttonsTextEqualsX(button3, button6, button9)) {
            setWinningScenario(button3, button6, button9);
        }
        else if (buttonsTextEqualsX(button1, button5, button9)) {
            setWinningScenario(button1, button5, button9);
        }
        else if (buttonsTextEqualsX(button3, button5, button7)) {
            setWinningScenario(button3, button5, button7);
        }

        else if (buttonsTextEqualsO(button1, button2, button3)){
            setLosingScenario(button1, button2, button3);
        }
        else if (buttonsTextEqualsO(button4, button5, button6)) {
            setLosingScenario(button4, button5, button6);
        }
        else if (buttonsTextEqualsO(button7, button8, button9)) {
            setLosingScenario(button7, button8, button9);
        }
        else if (buttonsTextEqualsO(button1, button4, button7)) {
            setLosingScenario(button1, button4, button7);
        }
        else if (buttonsTextEqualsO(button2, button5, button8)) {
            setLosingScenario(button2, button5, button8);
        }
        else if (buttonsTextEqualsO(button3, button6, button9)) {
            setLosingScenario(button3, button6, button9);
        }
        else if (buttonsTextEqualsO(button1, button5, button9)) {
            setLosingScenario(button1, button5, button9);
        }
        else if (buttonsTextEqualsO(button3, button5, button7)) {
            setLosingScenario(button3, button5, button7);
        }
    }

    public boolean buttonsTextEqualsX(Button btn1, Button btn2, Button btn3) {
        return btn1.getText().equals("X") && btn2.getText().equals("X") &&
                btn3.getText().equals("X");
    }

    public void setWinningScenario(Button btn1, Button btn2, Button btn3) {
        disableAllButtons();
        setButtonsGreen(btn1, btn2, btn3);
        textView.setText("you win");
        gameIsOn = false;
    }

    public boolean buttonsTextEqualsO(Button btn1, Button btn2, Button btn3) {
        return btn1.getText().equals("O") && btn2.getText().equals("O") &&
                btn3.getText().equals("O");
    }

    public void setLosingScenario(Button btn1, Button btn2, Button btn3) {
        disableAllButtons();
        setButtonsRed(btn1, btn2, btn3);
        textView.setText("game over");
        gameIsOn = false;
    }

    public void disableComputerButton(){
        if (index1 == 0 && index2 == 0) {
            button1.setEnabled(false);
        }
        else if (index1 == 0 && index2 == 1) {
            button2.setEnabled(false);
        }
        else if (index1 == 0 && index2 == 2) {
            button3.setEnabled(false);
        }

        else if (index1 == 1 && index2 == 0) {
            button4.setEnabled(false);
        }
        else if (index1 == 1 && index2 == 1) {
            button5.setEnabled(false);
        }
        else if (index1 == 1 && index2 == 2) {
            button6.setEnabled(false);
        }

        else if (index1 == 2 && index2 == 0) {
            button7.setEnabled(false);
        }
        else if (index1 == 2 && index2 == 1) {
            button8.setEnabled(false);
        }
        else if (index1 == 2 && index2 == 2) {
            button9.setEnabled(false);
        }
    }
    public void restart(View v){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        Button[] allButtons = {button1, button2, button3,
                button4, button5, button6, button7, button8, button9};

        for (Button button : allButtons) {
            button.setEnabled(true);
            button.setText("");
            button.setBackgroundColor(color);
        }

        for (int i = 0; i < playingField.length; i++){
            for (int j = 0; j < playingField[i].length; j++){
                playingField[i][j] = "";
            }
        }
        textView.setText("");
        gameIsOn = true;
    }

    public boolean allButtonsTouched(){
        if (playingField[0][0] != "" &&
            playingField[0][1]  != "" &&
            playingField[0][2] != "" &&

            playingField[1][0] != "" &&
            playingField[1][1] != "" &&
            playingField[1][2] != "" &&

            playingField[2][0] != "" &&
            playingField[2][1] != "" &&
            playingField[2][2] != "" ) {
            return true;
        } else {
            return false;
        }
    }

    public void disableAllButtons() {
        int color = Color.argb(255, 191, 191, 191);
        Button[] allButtons = {button1, button2, button3,
                button4, button5, button6, button7, button8, button9};
        for (Button button : allButtons) {
            button.setEnabled(false);
            button.setBackgroundColor(color);
        }
    }

    public void setButtonsGreen(Button button1, Button button2, Button button3) {
        button1.setBackgroundColor(Color.GREEN);
        button2.setBackgroundColor(Color.GREEN);
        button3.setBackgroundColor(Color.GREEN);
    }
    public void setButtonsRed(Button button1, Button button2, Button button3) {
        button1.setBackgroundColor(Color.RED);
        button2.setBackgroundColor(Color.RED);
        button3.setBackgroundColor(Color.RED);
    }
}
//TODO: задержка между ходами.
// два режима игры