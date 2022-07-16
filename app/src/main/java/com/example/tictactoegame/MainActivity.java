
package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, restartButton;
    TextView textView;
    String[][] arrayTable = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    String cross, circle;
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
        cross = "X";
        circle = "O";
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        Button[] allButtons = {button1, button2, button3,
                button4, button5, button6, button7, button8, button9};
        for(Button button : allButtons) {
            button.setBackgroundColor(color);
        }
    }

    public void touchButton1(View v){
        arrayTable[0][0] = cross;
        button1.setText(cross);
        button1.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton2(View v){
        arrayTable[0][1] = cross;
        button2.setText(cross);
        button2.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton3(View v){
        arrayTable[0][2] = cross;
        button3.setText(cross);
        button3.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton4(View v){
        arrayTable[1][0] = cross;
        button4.setText(cross);
        button4.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton5(View v){
        arrayTable[1][1] = cross;
        button5.setText(cross);
        button5.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton6(View v){
        arrayTable[1][2] = cross;
        button6.setText(cross);
        button6.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton7(View v){
        arrayTable[2][0] = cross;
        button7.setText(cross);
        button7.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton8(View v){
        arrayTable[2][1] = cross;
        button8.setText(cross);
        button8.setEnabled(false);

        winnerCheck();
        computerMove();
    }
    public void touchButton9(View v){
        arrayTable[2][2] = cross;
        button9.setText(cross);
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
        if (gameIsOn == true && !allButtonsTouched()) {
            randomCordinates();
            while (arrayTable[index1][index2].equals("X") ||
                   arrayTable[index1][index2].equals("O")) {
                randomCordinates();
            }
            arrayTable[index1][index2] = circle;
            disableComputerButton();
            computerMoveView();
            winnerCheck();
        }
    }

    public void computerMoveView(){
        button1.setText(arrayTable[0][0]);
        button2.setText(arrayTable[0][1]);
        button3.setText(arrayTable[0][2]);
        button4.setText(arrayTable[1][0]);
        button5.setText(arrayTable[1][1]);
        button6.setText(arrayTable[1][2]);
        button7.setText(arrayTable[2][0]);
        button8.setText(arrayTable[2][1]);
        button9.setText(arrayTable[2][2]);
    }
    
    public void winnerCheck(){
        if (button1.getText().equals("X") &&
            button2.getText().equals("X") &&
            button3.getText().equals("X")){

            disableAllButtons();
            setButtonsGreen(button1, button2, button3);
            textView.setText("you win");
            gameIsOn = false;
        }
        else if (button4.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button6.getText().equals("X")) {

            disableAllButtons();
            setButtonsGreen(button4, button5, button6);
            textView.setText("you win");
            gameIsOn = false;
        }
        else if (button7.getText().equals("X") &&
                 button8.getText().equals("X") &&
                 button9.getText().equals("X")) {

            disableAllButtons();
            setButtonsGreen(button7, button8, button9);
            textView.setText("you win");
            gameIsOn = false;
        }

        else if (button1.getText().equals("X") &&
                 button4.getText().equals("X") &&
                 button7.getText().equals("X")) {

            disableAllButtons();
            setButtonsGreen(button1, button4, button7);
            textView.setText("you win");
            gameIsOn = false;
        }
        else if (button2.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button8.getText().equals("X")) {

            disableAllButtons();
            setButtonsGreen(button2, button5, button8);
            textView.setText("you win");
            gameIsOn = false;
        }
        else if (button3.getText().equals("X") &&
                 button6.getText().equals("X") &&
                 button9.getText().equals("X")) {

            disableAllButtons();
            setButtonsGreen(button3, button6, button9);
            textView.setText("you win");
            gameIsOn = false;
        }

        else if (button1.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button9.getText().equals("X")) {

            disableAllButtons();
            setButtonsGreen(button1, button5, button9);
            textView.setText("you win");
            gameIsOn = false;
        }
        else if (button3.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button7.getText().equals("X")) {

            disableAllButtons();
            setButtonsGreen(button3, button5, button7);
            textView.setText("you win");
            gameIsOn = false;
        }


        else if (button1.getText().equals("O") &&
                button2.getText().equals("O") &&
                button3.getText().equals("O")){

            disableAllButtons();
            setButtonsRed(button1, button2, button3);
            textView.setText("game over");
            gameIsOn = false;
        }
        else if (button4.getText().equals("O") &&
                button5.getText().equals("O") &&
                button6.getText().equals("O")) {

            disableAllButtons();
            setButtonsRed(button4, button5, button6);
            textView.setText("game over");
            gameIsOn = false;
        }
        else if (button7.getText().equals("O") &&
                button8.getText().equals("O") &&
                button9.getText().equals("O")) {

            disableAllButtons();
            setButtonsRed(button7, button8, button9);
            textView.setText("game over");
            gameIsOn = false;
        }

        else if (button1.getText().equals("O") &&
                button4.getText().equals("O") &&
                button7.getText().equals("O")) {

            disableAllButtons();
            setButtonsRed(button1, button4, button7);
            textView.setText("game over");
            gameIsOn = false;
        }
        else if (button2.getText().equals("O") &&
                button5.getText().equals("O") &&
                button8.getText().equals("O")) {

            disableAllButtons();
            setButtonsRed(button2, button5, button8);
            textView.setText("game over");
            gameIsOn = false;
        }
        else if (button3.getText().equals("O") &&
                button6.getText().equals("O") &&
                button9.getText().equals("O")) {

            disableAllButtons();
            setButtonsRed(button3, button6, button9);
            textView.setText("game over");
            gameIsOn = false;
        }

        else if (button1.getText().equals("O") &&
                button5.getText().equals("O") &&
                button9.getText().equals("O")) {

            disableAllButtons();
            setButtonsRed(button1, button5, button9);
            textView.setText("game over");
            gameIsOn = false;
        }
        else if (button3.getText().equals("O") &&
                button5.getText().equals("O") &&
                button7.getText().equals("O")) {

            disableAllButtons();
            setButtonsRed(button3, button5, button7);
            gameIsOn = false;
        }
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

        for (int i = 0; i < arrayTable.length; i++){
            for (int j = 0; j < arrayTable[i].length; j++){
                arrayTable[i][j] = "";
            }
        }
        textView.setText("");
        gameIsOn = true;
    }

    public boolean allButtonsTouched(){
        if (arrayTable[0][0] != "" &&
            arrayTable[0][1]  != "" &&
            arrayTable[0][2] != "" &&

            arrayTable[1][0] != "" &&
            arrayTable[1][1] != "" &&
            arrayTable[1][2] != "" &&

            arrayTable[2][0] != "" &&
            arrayTable[2][1] != "" &&
            arrayTable[2][2] != "" ) {
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
// оптимизация