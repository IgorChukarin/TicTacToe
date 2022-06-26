
package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
TextView textView;
String[][] arrayTable = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
String cross, circle;
int index1, index2;


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
        textView = findViewById(R.id.textView);
        cross = "X";
        circle = "O";
    }
    ///человек
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
            textView.setText("Игрок победил");
        }
        else if (button4.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button6.getText().equals("X")) {
            textView.setText("Игрок победил");
        }
        else if (button7.getText().equals("X") &&
                 button8.getText().equals("X") &&
                 button9.getText().equals("X")) {
            textView.setText("Игрок победил");
        }

        else if (button1.getText().equals("X") &&
                 button4.getText().equals("X") &&
                 button7.getText().equals("X")) {
            textView.setText("Игрок победил");
        }
        else if (button2.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button8.getText().equals("X")) {
            textView.setText("Игрок победил");
        }
        else if (button3.getText().equals("X") &&
                 button6.getText().equals("X") &&
                 button9.getText().equals("X")) {
            textView.setText("Игрок победил");
        }

        else if (button1.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button9.getText().equals("X")) {
            textView.setText("Игрок победил");
        }
        else if (button3.getText().equals("X") &&
                 button5.getText().equals("X") &&
                 button7.getText().equals("X")) {
            textView.setText("Игрок победил");
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
}

//TODO: текст поставить посередине.
//TODO: случаи выигрыша бота.
//TODO: enable(false) всех кнопок в случае выигрыша.
//TODO: бот не должен ходить в случае выигрыша и игрок тоже.
